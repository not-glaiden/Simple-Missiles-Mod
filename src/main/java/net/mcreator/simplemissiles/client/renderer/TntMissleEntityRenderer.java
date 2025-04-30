
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.entity.TntMissleEntityEntity;
import net.mcreator.simplemissiles.client.model.Modeltnt_missle_falling_Converted;

public class TntMissleEntityRenderer extends MobRenderer<TntMissleEntityEntity, Modeltnt_missle_falling_Converted<TntMissleEntityEntity>> {
	public TntMissleEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltnt_missle_falling_Converted(context.bakeLayer(Modeltnt_missle_falling_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TntMissleEntityEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/tntmissleenntity.png");
	}

	@Override
	protected boolean isShaking(TntMissleEntityEntity entity) {
		return true;
	}
}
