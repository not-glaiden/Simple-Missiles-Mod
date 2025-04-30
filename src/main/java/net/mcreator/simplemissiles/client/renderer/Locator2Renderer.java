
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.entity.Locator2Entity;
import net.mcreator.simplemissiles.client.model.ModelLocator_entity;

import com.mojang.blaze3d.vertex.PoseStack;

public class Locator2Renderer extends MobRenderer<Locator2Entity, ModelLocator_entity<Locator2Entity>> {
	public Locator2Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelLocator_entity(context.bakeLayer(ModelLocator_entity.LAYER_LOCATION)), 0.1f);
	}

	@Override
	protected void scale(Locator2Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(Locator2Entity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/dshchsfieshchk2.png");
	}
}
