package joch2em.projectgunsmithing;

import joch2em.projectgunsmithing.blocks.Refined_iron_block;
import joch2em.projectgunsmithing.items.Refined_iron_ingot;
import joch2em.projectgunsmithing.items.Refined_iron_nugget;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// to run the project go in the terminal and run:
//./gradlew run --info


public class ProjectGunSmithing implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("projectgunsmithing");

	public static final String MOD_ID = "gunsmithing";

	//INITIATE BLOCK/ITEM/ENTITIES HERE

	//ITEMS
	public static final Item REFINED_IRON = new Refined_iron_ingot(new Item.Settings());
	public static final Item REFINED_IRON_NUGGET = new Refined_iron_nugget(new Item.Settings());

	//BLOCKS

	public static final Block REFINED_IRON_BLOCK = new Refined_iron_block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "gunsmithing"))
			.icon(() -> new ItemStack(REFINED_IRON_BLOCK))
			.appendItems(((itemStacks, itemGroup) -> {
				itemStacks.add(new ItemStack(REFINED_IRON_BLOCK));
				itemStacks.add(new ItemStack(REFINED_IRON));
				itemStacks.add(new ItemStack(REFINED_IRON_NUGGET));
			}))
			.build();

	@Override
	public void onInitialize() {
		LOGGER.info("Guns Guns Guns!");
		registerItems();
	}

	private void registerItems() {
		// REGISTER THE ITEMS/BLOCKS/ENTITIES HERE
		try {
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, "refined_iron_ingot"), REFINED_IRON);
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, "refined_iron_nugget"), REFINED_IRON_NUGGET);
			Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "refined_iron_block"), REFINED_IRON_BLOCK);
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, "refined_iron_block"), new BlockItem(REFINED_IRON_BLOCK, new FabricItemSettings()));

			LOGGER.info("Registered items!");
		} catch (Exception e) {
			LOGGER.error("Could not register item!");
		}
	}
}