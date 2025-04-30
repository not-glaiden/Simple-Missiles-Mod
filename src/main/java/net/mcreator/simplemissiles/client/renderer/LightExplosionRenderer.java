
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.simplemissiles.procedures.MushroomExplosionEntityModelVisualScaleProcedure;
import net.mcreator.simplemissiles.entity.LightExplosionEntity;
import net.mcreator.simplemissiles.client.model.Modellught;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class LightExplosionRenderer extends MobRenderer<LightExplosionEntity, Modellught<LightExplosionEntity>> {
	public LightExplosionRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellught(context.bakeLayer(Modellught.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<LightExplosionEntity, Modellught<LightExplosionEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("simplemissiles:textures/entities/lighttexture.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, LightExplosionEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modellught(Minecraft.getInstance().getEntityModels().bakeLayer(Modellught.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	protected void scale(LightExplosionEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) MushroomExplosionEntityModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(LightExplosionEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/lighttexture.png");
	}
}
