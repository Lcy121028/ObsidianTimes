package com.lcy.item;

import com.lcy.ObsidianTimes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        // Create the item key.
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ObsidianTimes.MOD_ID, name));
    }

    public static final ResourceKey<Item> OBSIDIAN_INGOT = create("obsidian_ingot");
    public static final ResourceKey<Item> OBSIDIAN_SWORD = create("obsidian_sword");
    public static final ResourceKey<Item> OBSIDIAN_PICKAXE = create("obsidian_pickaxe");
}
