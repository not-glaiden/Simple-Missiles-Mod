
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.entity.NapalmEntityEntity;
import net.mcreator.simplemissiles.client.model.ModelNapalmMissle3_Converted;

public class NapalmEntityRenderer extends MobRenderer<NapalmEntityEntity, ModelNapalmMissle3_Converted<NapalmEntityEntity>> {
	public NapalmEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNapalmMissle3_Converted(context.bakeLayer(ModelNapalmMissle3_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(NapalmEntityEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/napalmentity.png");
	}
}
