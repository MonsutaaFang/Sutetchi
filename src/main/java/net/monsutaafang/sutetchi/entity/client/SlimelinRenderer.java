package net.monsutaafang.sutetchi.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.monsutaafang.sutetchi.Sutetchi;
import net.monsutaafang.sutetchi.entity.Variant.SlimelinVariant;
import net.monsutaafang.sutetchi.entity.custom.SlimelinEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class SlimelinRenderer extends GeoEntityRenderer<SlimelinEntity> {
    public static final Map<SlimelinVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SlimelinVariant.class), (map) -> {
                map.put(SlimelinVariant.DEFAULT,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/slimelin.png"));
                map.put(SlimelinVariant.SEA,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/seaslimelin.png"));
                map.put(SlimelinVariant.NETHER,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/netherslimelin.png"));
                map.put(SlimelinVariant.END,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/endslimelin.png"));
                map.put(SlimelinVariant.WITCH,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/slimelinwitch.png"));
                map.put(SlimelinVariant.SEAWITCH,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/seaslimelinwitch.png"));
                map.put(SlimelinVariant.NETHERWITCH,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/netherslimelinwitch.png"));
                map.put(SlimelinVariant.ENDWITCH,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/endslimelinwitch.png"));
                map.put(SlimelinVariant.SNOW,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/slimelinsnow.png"));
                map.put(SlimelinVariant.SEASNOW,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/seaslimelinsnow.png"));
                map.put(SlimelinVariant.NETHERSNOW,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/netherslimelinsnow.png"));
                map.put(SlimelinVariant.ENDSNOW,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/endslimelinsnow.png"));
                map.put(SlimelinVariant.ANCIENT,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/slimelinancient.png"));
                map.put(SlimelinVariant.SEAANCIENT,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/seaslimelinancient.png"));
                map.put(SlimelinVariant.NETHERANCIENT,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/netherslimelinancient.png"));
                map.put(SlimelinVariant.ENDANCIENT,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/endslimelinancient.png"));
                map.put(SlimelinVariant.EXPLORERS,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/slimelinexplorers.png"));
                map.put(SlimelinVariant.SEAEXPLORERS,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/seaslimelinexplorers.png"));
                map.put(SlimelinVariant.NETHEREXPLORERS,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/netherslimelinexplorers.png"));
                map.put(SlimelinVariant.ENDEXPLORERS,
                        new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/endslimelinexplorers.png"));
            });

    public SlimelinRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SlimelinModel());
    }

    @Override
    public Identifier getTextureResource(SlimelinEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }
}