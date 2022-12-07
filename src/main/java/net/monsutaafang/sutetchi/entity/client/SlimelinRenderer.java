package net.monsutaafang.sutetchi.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.monsutaafang.sutetchi.Sutetchi;
import net.monsutaafang.sutetchi.entity.custom.SlimelinEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SlimelinRenderer extends GeoEntityRenderer<SlimelinEntity> {
    public SlimelinRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SlimelinModel());
    }

    @Override
    public Identifier getTextureResource(SlimelinEntity instance) {
        return new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/slimelin.png");
    }
}