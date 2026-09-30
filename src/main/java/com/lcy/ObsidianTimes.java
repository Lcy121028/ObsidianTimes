package com.lcy;

import com.lcy.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
* Obsidian Times
* --with Fabric
*
* written by Lcy
*
* version 1.0
*
* > add obsidian ingot.
* > add obsidian sword.
* > add obsidian axe.
* > add obsidian pickaxe.
* > add obsidian shovel.
* > add obsidian hoe.
* */

public class ObsidianTimes implements ModInitializer {
	public static final String MOD_ID = "obsidian";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
			BuiltInRegistries.CREATIVE_MODE_TAB.key(), ObsidianTimes.id("creative_tab")
	);
	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
			.icon(() -> new ItemStack(ModItems.OBSIDIAN_INGOT))
			.title(Component.translatable("creativeTab.obsidian"))
			.displayItems((params, output) -> {
				output.accept(ModItems.OBSIDIAN_INGOT);

				output.accept(ModItems.OBSIDIAN_SWORD);
				output.accept(ModItems.OBSIDIAN_AXE);
				output.accept(ModItems.OBSIDIAN_PICKAXE);
				output.accept(ModItems.OBSIDIAN_SHOVEL);
				output.accept(ModItems.OBSIDIAN_HOE);
			})
			.build();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.initialize();

		// Register the group.
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);

		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
