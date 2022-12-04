package net.monsutaafang.sutetchi.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.monsutaafang.sutetchi.entity.ModEntities;
import net.monsutaafang.sutetchi.entity.custom.SlimelinEntity;

public class ModRegistries {
    public static void registerModStuffs() {

        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.SLIMELIN, SlimelinEntity.setAttributes());
    }
}