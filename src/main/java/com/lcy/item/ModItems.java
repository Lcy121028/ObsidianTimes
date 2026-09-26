package com.lcy.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ModItems {
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.OBSIDIAN_INGOT));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.OBSIDIAN_SWORD));
    }

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final Item OBSIDIAN_INGOT = register(ModItemIds.OBSIDIAN_INGOT, Item::new, new Item.Properties());

    public static final TagKey<Block> INCORRECT_FOR_OBSIDIAN_TOOL = TagKey.create(
            Registries.BLOCK,
            Identifier.fromNamespaceAndPath("obsidian", "incorrect_for_obsidian_tool")
    );

    public static final TagKey<Item> REPAIRS_OBSIDIAN_ARMOR = TagKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath("obsidian", "repairs_obsidian_tool")
    );

    public static final ToolMaterial OBSIDIAN_MATERIAL = new ToolMaterial(
            INCORRECT_FOR_OBSIDIAN_TOOL, 1800,7.0F,4.1F,8,REPAIRS_OBSIDIAN_ARMOR
    );

    public static final Item OBSIDIAN_SWORD = register(
            ModItemIds.OBSIDIAN_SWORD,
            Item::new,
            new Item.Properties().sword(OBSIDIAN_MATERIAL, 3.0f, -2.4f)
    );

    public static final Item OBSIDIAN_PICKAXE = register(
            ModItemIds.OBSIDIAN_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(OBSIDIAN_MATERIAL, 1.0f, -2.8f)
    );
}
