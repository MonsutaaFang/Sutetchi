package net.monsutaafang.sutetchi.entity.client;

import net.minecraft.util.Identifier;
import net.monsutaafang.sutetchi.Sutetchi;
import net.monsutaafang.sutetchi.entity.custom.SlimelinEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;


public class SlimelinModel extends AnimatedGeoModel<SlimelinEntity> {
    @Override
    public Identifier getAnimationResource(SlimelinEntity entity) {
        return new Identifier(Sutetchi.MOD_ID, "animations/slimelin.animation.json");
    }

    @Override
    public Identifier getModelResource(SlimelinEntity entity) {
        return new Identifier(Sutetchi.MOD_ID, "geo/slimelin.geo.json");
    }

    @Override
    public Identifier getTextureResource(SlimelinEntity entity) {
        return new Identifier(Sutetchi.MOD_ID, "textures/entity/slimelin/slimelin.png");

    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void setLivingAnimations(SlimelinEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}