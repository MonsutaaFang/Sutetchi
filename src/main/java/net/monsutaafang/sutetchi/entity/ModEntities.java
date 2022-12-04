package net.monsutaafang.sutetchi.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.monsutaafang.sutetchi.Sutetchi;
import net.monsutaafang.sutetchi.entity.custom.SlimelinEntity;

    public class ModEntities {
        public static final EntityType<SlimelinEntity> SLIMELIN = Registry.register(
                Registry.ENTITY_TYPE, new Identifier(Sutetchi.MOD_ID, "slimelin"),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SlimelinEntity::new)
                        .dimensions(EntityDimensions.fixed(0.4f, 1.7f)).build());
    }