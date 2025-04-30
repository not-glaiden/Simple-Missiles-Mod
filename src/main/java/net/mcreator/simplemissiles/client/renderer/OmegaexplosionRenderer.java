
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CodModel;

import net.mcreator.simplemissiles.entity.OmegaexplosionEntity;

public class OmegaexplosionRenderer extends MobRenderer<OmegaexplosionEntity, CodModel<OmegaexplosionEntity>> {
	public OmegaexplosionRenderer(EntityRendererProvider.Context context) {
		super(context, new CodModel(context.bakeLayer(ModelLayers.COD)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(OmegaexplosionEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/blank.png");
	}
}
