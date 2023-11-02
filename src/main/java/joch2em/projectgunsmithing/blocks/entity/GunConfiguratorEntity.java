package joch2em.projectgunsmithing.blocks.entity;

import joch2em.projectgunsmithing.ProjectGunSmithing;
import joch2em.projectgunsmithing.blocks.Gun_configurator;
import joch2em.projectgunsmithing.items.inventory.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

public class Gun_Configurator_Entity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3, ItemStack.EMPTY);

    public Gun_Configurator_Entity(BlockPos pos, BlockState state) {
        super(ProjectGunSmithing.GUN_CONFIGURATOR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return new Text("Lightning Channeler");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new GunConfiguratorScreenHandler(syncId, inv, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, LightningChannelerBlockEntity entity) {
        if(hasRecipe(entity) && world.isThundering() && hasNotReachedStackLimit(entity)) {
            craftItem(entity);

            if(!world.isClient()) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }
    }

    private static void craftItem(LightningChannelerBlockEntity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);

        entity.setStack(2, new ItemStack(ProjectGunSmithing.REFINED_IRON_INGOT, entity.getStack(2).getCount() + 1));
    }

    private static boolean hasRecipe(LightningChannelerBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == ProjectGunSmithing.REFINED_IRON_INGOT;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == ProjectGunSmithing.FULL_AUTO_RIFLE;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static boolean hasNotReachedStackLimit(Gun_CONFIGURATOR_BLOCK_ENTITY entity) {
        return entity.getStack(2).getCount() < entity.getStack(2).getMaxCount();
    }
}