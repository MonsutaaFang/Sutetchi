package net.monsutaafang.sutetchi.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.monsutaafang.sutetchi.Sutetchi;
import net.monsutaafang.sutetchi.entity.ModEntities;
import net.minecraft.util.registry.Registry;
import net.monsutaafang.sutetchi.item.custom.appearance_change;
import net.monsutaafang.sutetchi.item.custom.heals;
import net.monsutaafang.sutetchi.item.custom.health_up;
import net.monsutaafang.sutetchi.item.custom.tamed;

public class ModItems {

        public static final Item TAME_CRYSTAL = registerItem("tame_crystal",
                new tamed(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).maxCount(1)));

        public static final Item SLIMECHOCOLATE = registerItem("slimechocolate",
                new heals(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).maxCount(16)));

        public static final Item SLIMESHARD = registerItem("slimeshard",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.UNCOMMON).maxCount(1)));

        public static final Item SLIMEHEART = registerItem("slimeheart",
                new health_up(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item RAW_SLIME = registerItem("raw_slime",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).maxCount(1)));

        public static final Item SEA_SLIME = registerItem("sea_slime",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item NETHER_SLIME = registerItem("nether_slime",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item END_SLIME = registerItem("end_slime",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item TANGO_MUSHROOM = registerItem("tango_mushroom",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item WITCHES_BREW = registerItem("witches_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item SEA_WITCHES_BREW = registerItem("sea_witches_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item NETHER_WITCHES_BREW = registerItem("nether_witches_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item END_WITCHES_BREW = registerItem("end_witches_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item SHARPSNOW = registerItem("sharpsnow",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item SNOW_BREW = registerItem("snow_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item SEA_SNOW_BREW = registerItem("sea_snow_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item NETHER_SNOW_BREW = registerItem("nether_snow_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item END_SNOW_BREW = registerItem("end_snow_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item ANCIENT_GEM = registerItem("ancient_gem",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item ANCIENT_BREW = registerItem("ancient_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.RARE).maxCount(1)));

        public static final Item SEA_ANCIENT_BREW = registerItem("sea_ancient_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item NETHER_ANCIENT_BREW = registerItem("nether_ancient_brew",
            new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item END_ANCIENT_BREW = registerItem("end_ancient_brew",
                new appearance_change(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).rarity(Rarity.EPIC).maxCount(1)));

        public static final Item SLIMELIN_SPAWN_EGG = registerItem("slimelin_spawn_egg",
                new SpawnEggItem(ModEntities.SLIMELIN, 0x48fA56, 0x1ad447,
                        new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP).maxCount(1)));

        private static Item registerItem(String name, Item item) {
            return Registry.register(Registry.ITEM, new Identifier(Sutetchi.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Sutetchi.LOGGER.info("Registering Mod Items for " + Sutetchi.MOD_ID);
    }
}
