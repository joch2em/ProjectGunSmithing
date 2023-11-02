package joch2em.projectgunsmithing.blocks.entity;


import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModblockEntities {

    public static final String MOD_ID = "projectgunsmithing";
    public static BlockEntityType<GunConfiguratorEntity> Gun_Configurator_Block_Entity =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "gun_configurator"),
                    FabricBlockEntityTypeBuilder.create(GunConfiguratorEntity::new,
                            ModBlock.BLUEBELLS).build(null));
}
