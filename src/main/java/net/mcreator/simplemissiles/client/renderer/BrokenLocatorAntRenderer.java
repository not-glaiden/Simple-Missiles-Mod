
package net.mcreator.simplemissiles.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.simplemissiles.entity.BrokenLocatorAntEntity;
import net.mcreator.simplemissiles.client.model.ModelLocator_entityy;

import com.mojang.blaze3d.vertex.PoseStack;

public class BrokenLocatorAntRenderer extends MobRenderer<BrokenLocatorAntEntity, ModelLocator_entityy<BrokenLocatorAntEntity>> {
	public BrokenLocatorAntRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLocator_entityy(context.bakeLayer(ModelLocator_entityy.LAYER_LOCATION)), 0.1f);
	}

	@Override
	protected void scale(BrokenLocatorAntEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(BrokenLocatorAntEntity entity) {
		return new ResourceLocation("simplemissiles:textures/entities/dshchsfieshchk2.png");
	}
}
