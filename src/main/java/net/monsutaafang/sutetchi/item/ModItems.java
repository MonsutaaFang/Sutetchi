package net.monsutaafang.sutetchi.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.monsutaafang.sutetchi.Sutetchi;
import net.monsutaafang.sutetchi.entity.ModEntities;
import net.minecraft.util.registry.Registry;

import static software.bernie.example.registry.RegistryUtils.registerItem;

public class ModItems {

        public static final Item SLIMELIN_SPAWN_EGG = registerItem("slimelin_spawn_egg",
                new SpawnEggItem(ModEntities.SLIMELIN, 0x948e8d, 0x3b3635,
                        new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));

        private static Item registerItem(String name, Item item) {
            return Registry.register(Registry.ITEM, new Identifier(Sutetchi.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Sutetchi.LOGGER.info("Registering Mod Items for " + Sutetchi.MOD_ID);
    }
}