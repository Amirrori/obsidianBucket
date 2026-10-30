package com.amirrori.obsidianbucket;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObsidianBucket implements ModInitializer {
    public static final String MOD_ID = "obsidianbucket";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final int MOLTEN_OBSIDIAN_LIGHT_LEVEL = 10;
    private static final float MOLTEN_OBSIDIAN_HARDNESS = 40f;

    public static final Item OBSIDIAN_BUCKET = registerItem("obsidian_bucket",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item MOLTEN_OBSIDIAN = registerItem("molten_obsidian",
            new Item(new FabricItemSettings()));
    public static final Block MOLTEN_OBSIDIAN_BLOCK = registerBlockWithItem("molten_obsidian_block",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
                    .luminance(MOLTEN_OBSIDIAN_LIGHT_LEVEL)
                    .hardness(MOLTEN_OBSIDIAN_HARDNESS)));

    @Override
    public void onInitialize() {
        addToItemGroups();
        LOGGER.info("Obsidian Bucket loaded");
    }

    private static void addToItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.addAfter(Items.MILK_BUCKET, OBSIDIAN_BUCKET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> entries.addAfter(Items.CRYING_OBSIDIAN, MOLTEN_OBSIDIAN_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> entries.addAfter(Items.IRON_INGOT, MOLTEN_OBSIDIAN));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, id(name), item);
    }

    private static Block registerBlockWithItem(String name, Block block) {
        Registry.register(Registries.BLOCK, id(name), block);
        Registry.register(Registries.ITEM, id(name), new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    private static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }
}
