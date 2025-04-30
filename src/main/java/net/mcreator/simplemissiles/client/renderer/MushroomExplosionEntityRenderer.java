
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.procedures.MushroomExplosionEntityModelVisualScaleProcedure;
import net.mcreator.simplemissiles.entity.MushroomExplosionEntityEntity;
import net.mcreator.simplemissiles.client.model.ModelMushroomExp;

import com.mojang.blaze3d.vertex.PoseStack;

public class MushroomExplosionEntityRenderer extends MobRenderer<MushroomExplosionEntityEntity, ModelMushroomExp<MushroomExplosionEntityEntity>> {
	public MushroomExplosionEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMushroomExp(context.bakeLayer(ModelMushroomExp.LAYER_LOCATION)), 5f);
	}

	@Override
	protected void scale(MushroomExplosionEntityEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) MushroomExplosionEntityModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(MushroomExplosionEntityEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/mushroomexptext4.png");
	}

	@Override
	protected boolean isShaking(MushroomExplosionEntityEntity entity) {
		return true;
	}
}
