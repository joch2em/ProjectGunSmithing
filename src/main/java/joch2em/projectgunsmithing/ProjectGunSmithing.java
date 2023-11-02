package joch2em.projectgunsmithing;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

	public static final Item modItem = new Items(new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		LOGGER.info("Guns Guns Guns!");
		registerItems();
	}

	private void registerItems() {
		try {
			// refined_iron	items
			Registry.register(Registry.ITEM, new Identifier("gunsmithing", "refined_iron_ingot"), modItem);
			//for some reason it doesnt wanna register these??!?
			Registry.register(Registry.ITEM, new Identifier("gunsmithing", "refined_iron_nugget"), modItem);
			Registry.register(Registry.ITEM, new Identifier("gunsmithing", "refined_iron_block"), modItem);


			LOGGER.info("Registered item!");
		} catch (Exception e) {

			LOGGER.error("Could not register item!");
		}
	}
}


