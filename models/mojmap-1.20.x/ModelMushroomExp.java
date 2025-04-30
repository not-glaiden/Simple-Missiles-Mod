// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelMushroomExp<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "mushroomexp"), "main");
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bb_main;

	public ModelMushroomExp(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(82, 60)
						.addBox(-10.0F, -2.0F, 9.0F, 21.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(82, 64)
						.addBox(-10.0F, -2.0F, -13.0F, 21.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(82, 0)
						.addBox(-11.0F, -2.0F, -12.0F, 4.0F, 0.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(82, 24)
						.addBox(8.0F, -2.0F, -12.0F, 4.0F, 0.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 25.0F, 0.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(64, 70)
						.addBox(-16.0F, -2.0F, 13.0F, 32.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(64, 76)
						.addBox(-16.0F, -2.0F, -20.0F, 32.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-18.0F, -2.0F, -18.0F, 6.0F, 0.0F, 35.0F, new CubeDeformation(0.0F)).texOffs(0, 35)
						.addBox(12.0F, -2.0F, -18.0F, 6.0F, 0.0F, 35.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(24, 92)
						.addBox(-3.0F, -2.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(48, 92)
						.addBox(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 92)
						.addBox(-3.0F, -11.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 70)
						.addBox(-8.0F, -17.0F, -8.0F, 16.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(82, 48)
						.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(64, 82)
						.addBox(-6.0F, -19.0F, -6.0F, 11.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(82, 96).addBox(-1.0F, -5.0F, -1.0F, 0.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, -12.0F, -8.0F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(76, 96).addBox(-1.0F, -5.0F, -1.0F, 0.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, -12.0F, 10.0F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(70, 96).addBox(-1.0F, -5.0F, -1.0F, 0.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, -12.0F, -8.0F, 0.0F, -1.0036F, 0.0F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(64, 96).addBox(-1.0F, -5.0F, -1.0F, 0.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -12.0F, 9.0F, 0.0F, -1.0036F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bone2.yRot = ageInTicks / 20.f;
		this.bone.yRot = ageInTicks / 20.f;
	}
}