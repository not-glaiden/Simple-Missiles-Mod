package net.mcreator.simplemissiles.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelturret<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("simplemissiles", "modelturret"), "main");
	public final ModelPart bone2;
	public final ModelPart bone3;

	public Modelturret(ModelPart root) {
		this.bone2 = root.getChild("bone2");
		this.bone3 = root.getChild("bone3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone2 = partdefinition
				.addOrReplaceChild(
						"bone2", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -17.0F, -5.0F, 10.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(48, 46).addBox(-2.0F, -15.0F, -17.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
								.texOffs(44, 16).addBox(-3.0F, -16.0F, -18.0F, 6.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(48, 31).addBox(-3.0F, -10.0F, -18.0F, 6.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 0).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.5236F, 0.0F, 0.0F));
		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 52).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.bone3.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bone2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bone2.xRot = headPitch / (180F / (float) Math.PI);
	}
}
