package com.glaib04kaden.simplemissiles.gui;

import com.glaib04kaden.simplemissiles.SimpleMissiles;
import com.glaib04kaden.simplemissiles.gui.base.BaseMachineScreen;
import com.glaib04kaden.simplemissiles.gui.widget.CoordinatesSetter;
import com.glaib04kaden.simplemissiles.misc.MapRenderer;
import com.glaib04kaden.simplemissiles.misc.MapRenderer2;
import com.glaib04kaden.simplemissiles.network.SMPacketRegistry;
import com.glaib04kaden.simplemissiles.network.UpdateLaunchpadDataPacket;
import com.glaib04kaden.simplemissiles.util.SMUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LaunchpadScreen extends BaseMachineScreen<LaunchpadMenu> {
    private final MapRenderer2 mapRenderer = new MapRenderer2(20, 4);

    public LaunchpadScreen(LaunchpadMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component, new ResourceLocation(SimpleMissiles.MODID, "textures/screens/launchpad_gui.png"));
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = 85;
        this.inventoryLabelX = 85;
        this.addRenderableWidget(new CoordinatesSetter(this.font, this.leftPos + 85, this.topPos + 16, 84, 10, Direction.Axis.X, this::tryToSendValue));
        this.addRenderableWidget(new CoordinatesSetter(this.font, this.leftPos + 85, this.topPos + 31, 84, 10, Direction.Axis.Y, this::tryToSendValue));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        Minecraft mc = Minecraft.getInstance();
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);

        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.translate(this.leftPos + 7, this.topPos + 6, 0);
        float scale = 0.45F;
        poseStack.scale(scale, scale, scale);
        this.mapRenderer.render(guiGraphics, mc.level, 0, 0, this.menu.data.get(0), this.menu.data.get(1));

        final int centerOffset = this.mapRenderer.getRadius() * this.mapRenderer.getScale();
        final int markerSize = 2;

        guiGraphics.fill(
                centerOffset - markerSize,
                centerOffset - markerSize,
                centerOffset + markerSize,
                centerOffset + markerSize,
                0xFFFF0000
        );

        poseStack.popPose();

        guiGraphics.drawString(this.font, "X: " + this.menu.data.get(0), this.leftPos + 8, this.topPos + 7, ChatFormatting.DARK_GREEN.getColor());
        guiGraphics.drawString(this.font, "Y: " + this.menu.data.get(1), this.leftPos + 8, this.topPos + 17, ChatFormatting.DARK_GREEN.getColor());
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    public void onClose() {
        super.onClose();
        this.mapRenderer.clearExistingTextures();
    }

    private void tryToSendValue(CoordinatesSetter coordinatesSetter) {
        String value = coordinatesSetter.getValue();
        Direction.Axis axis = coordinatesSetter.getAxis();
        if (SMUtils.isInteger(value)) {
            coordinatesSetter.removeError();
            SMPacketRegistry.sendToServer(
                    new UpdateLaunchpadDataPacket(this.menu.blockEntity.getBlockPos(), axis.equals(Direction.Axis.X) ? 0 : 1, Integer.parseInt(value)));
        } else {
            coordinatesSetter.throwError();
        }
    }
}
