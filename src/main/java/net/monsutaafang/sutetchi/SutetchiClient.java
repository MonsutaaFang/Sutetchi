package net.monsutaafang.sutetchi;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.monsutaafang.sutetchi.entity.ModEntities;
import net.monsutaafang.sutetchi.entity.client.SlimelinRenderer;

public class SutetchiClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.SLIMELIN, SlimelinRenderer::new);
    }
}