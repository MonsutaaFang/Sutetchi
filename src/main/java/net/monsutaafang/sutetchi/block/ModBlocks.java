package net.monsutaafang.sutetchi.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.monsutaafang.sutetchi.Sutetchi;
import net.monsutaafang.sutetchi.block.custom.SlimelinPlushieBlock;
import net.monsutaafang.sutetchi.item.ModItemGroups;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.ItemGroup;


public class ModBlocks {

    public static final Block SLIMELINPLUSHIE = registerBlock("slimelinplushie",
            new SlimelinPlushieBlock(FabricBlockSettings.of(Material.WOOL).strength(0.8f).nonOpaque().sounds(BlockSoundGroup.WOOL)), ModItemGroups.SUTETCHIGROUP);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Sutetchi.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Sutetchi.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        Sutetchi.LOGGER.debug("Registering ModBlocks for " + Sutetchi.MOD_ID);
    }
}