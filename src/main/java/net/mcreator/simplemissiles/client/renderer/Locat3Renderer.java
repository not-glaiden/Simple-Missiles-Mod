
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.entity.Locat3Entity;
import net.mcreator.simplemissiles.client.model.ModelLocator_entity;

import com.mojang.blaze3d.vertex.PoseStack;

public class Locat3Renderer extends MobRenderer<Locat3Entity, ModelLocator_entity<Locat3Entity>> {
	public Locat3Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelLocator_entity(context.bakeLayer(ModelLocator_entity.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(Locat3Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(Locat3Entity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/dshchsfieshchk2.png");
	}
}
