
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.entity.LocatorentityEntity;
import net.mcreator.simplemissiles.client.model.ModelLocator_entity;

import com.mojang.blaze3d.vertex.PoseStack;

public class LocatorentityRenderer extends MobRenderer<LocatorentityEntity, ModelLocator_entity<LocatorentityEntity>> {
	public LocatorentityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLocator_entity(context.bakeLayer(ModelLocator_entity.LAYER_LOCATION)), 0.1f);
	}

	@Override
	protected void scale(LocatorentityEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(LocatorentityEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/dshchsfieshchk2.png");
	}
}
