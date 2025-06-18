package com.glaib04kaden.simplemissiles.rocket.base;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RocketRender extends EntityRenderer<RocketEntity> {
    protected RocketRender(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(RocketEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(RocketEntity rocketEntity) {
        return null;
    }
}
