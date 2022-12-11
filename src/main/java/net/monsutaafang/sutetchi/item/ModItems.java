package net.monsutaafang.sutetchi.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.monsutaafang.sutetchi.Sutetchi;
import net.monsutaafang.sutetchi.entity.ModEntities;
import net.minecraft.util.registry.Registry;

public class ModItems {

        public static final Item TAME_CRYSTAL = registerItem("tame_crystal",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item RAW_SLIME = registerItem("raw_slime",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item SEA_SLIME = registerItem("sea_slime",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item NETHER_SLIME = registerItem("nether_slime",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item END_SLIME = registerItem("end_slime",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item TANGO_MUSHROOM = registerItem("tango_mushroom",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item WITCHES_BREW = registerItem("witches_brew",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item SEA_WITCHES_BREW = registerItem("sea_witches_brew",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item NETHER_WITCHES_BREW = registerItem("nether_witches_brew",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

        public static final Item END_WITCHES_BREW = registerItem("end_witches_brew",
                new Item(new FabricItemSettings().group(ModItemGroups.SUTETCHIGROUP)));

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
