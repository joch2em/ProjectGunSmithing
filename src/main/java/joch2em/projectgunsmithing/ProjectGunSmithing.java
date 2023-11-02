package joch2em.projectgunsmithing;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectGunSmithing implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("projectgunsmithing");

	public static final Item modItem = new Items(new Item.Settings().group(ItemGroup.MISC));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello Fabric world!");

		// registering an item called refined_iron with the id test.refined_iron
		Registry.register(Registry.ITEM, new Identifier("gunsmithing", "refined_iron"), modItem);
		LOGGER.info("Registered item!");
	}
}