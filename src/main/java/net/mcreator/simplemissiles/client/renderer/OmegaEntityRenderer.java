
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.simplemissiles.entity.OmegaEntityEntity;

public class OmegaEntityRenderer extends HumanoidMobRenderer<OmegaEntityEntity, HumanoidModel<OmegaEntityEntity>> {
	public OmegaEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(OmegaEntityEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/blank.png");
	}

	@Override
	protected boolean isShaking(OmegaEntityEntity entity) {
		return true;
	}
}
