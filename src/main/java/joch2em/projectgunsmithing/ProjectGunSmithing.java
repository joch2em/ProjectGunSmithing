package joch2em.projectgunsmithing;

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


	//ITEMS


	//BLOCKS

	public static final Block REFINED_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "gunsmithing"))
			.icon(() -> new ItemStack(REFINED_IRON_BLOCK))
			.appendItems(((itemStacks, itemGroup) -> {
				itemStacks.add(new ItemStack(REFINED_IRON_BLOCK));
				// ADD ITEMS AND BLOCKS HERE
			}))
			.build();

	@Override
	public void onInitialize() {
		LOGGER.info("Guns Guns Guns!");
		registerItems();
	}


	private void registerItems() {
		try {
			// TODO: Fix this shit
			//Registry.register(Registry.ITEM, new Identifier(MOD_ID, "refined_iron"), new Item(Items));
			//Registry.register(Registry.ITEM, new Identifier(MOD_ID, "refined_iron_nugget"), new Item(Items));
			// working
			Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "refined_iron_block"), REFINED_IRON_BLOCK);
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, "refined_iron_block"), new BlockItem(REFINED_IRON_BLOCK, new FabricItemSettings()));

			LOGGER.info("Registered items!");
		} catch (Exception e) {
			LOGGER.error("Could not register item!");
		}
	}
}
