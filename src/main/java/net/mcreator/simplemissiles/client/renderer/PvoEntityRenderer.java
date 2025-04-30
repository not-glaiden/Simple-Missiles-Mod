
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.entity.PvoEntityEntity;
import net.mcreator.simplemissiles.client.model.ModelBmd2;

public class PvoEntityRenderer extends MobRenderer<PvoEntityEntity, ModelBmd2<PvoEntityEntity>> {
	public PvoEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBmd2(context.bakeLayer(ModelBmd2.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(PvoEntityEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/bmd2.png");
	}
}
