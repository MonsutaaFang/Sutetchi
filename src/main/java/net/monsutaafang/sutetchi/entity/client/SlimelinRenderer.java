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
            });

    public SlimelinRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SlimelinModel());
    }

    @Override
    public Identifier getTextureResource(SlimelinEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }
}