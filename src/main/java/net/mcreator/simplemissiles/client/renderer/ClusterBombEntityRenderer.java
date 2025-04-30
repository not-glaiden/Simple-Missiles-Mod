
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.entity.ClusterBombEntityEntity;
import net.mcreator.simplemissiles.client.model.ModelBigBomb_Converted;

public class ClusterBombEntityRenderer extends MobRenderer<ClusterBombEntityEntity, ModelBigBomb_Converted<ClusterBombEntityEntity>> {
	public ClusterBombEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBigBomb_Converted(context.bakeLayer(ModelBigBomb_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ClusterBombEntityEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/clusterbomb.png");
	}
}
