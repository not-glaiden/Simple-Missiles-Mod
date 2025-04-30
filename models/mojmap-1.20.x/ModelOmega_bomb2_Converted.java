// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelOmega_bomb2_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "omega_bomb2_converted"), "main");
	private final ModelPart bone;

	public ModelOmega_bomb2_Converted(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-13.0F, -24.0F, 3.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
						.addBox(-12.0F, -27.0F, 4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(40, 25)
						.addBox(-12.0F, -32.0F, 8.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(40, 11)
						.addBox(-8.0F, -32.0F, 4.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 34)
						.addBox(-15.0F, -2.0F, 1.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, 24.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}