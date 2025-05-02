package net.mcreator.simplemissiles.revamp.gui;

import net.mcreator.simplemissiles.SimplemissilesMod;
import net.mcreator.simplemissiles.revamp.block.entity.LaunchpadBlockEntity;
import net.mcreator.simplemissiles.revamp.gui.base.BaseMachineScreen;
import net.mcreator.simplemissiles.revamp.gui.widget.CoordinatesSetter;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.apache.commons.lang3.math.NumberUtils;

public class LaunchpadScreen extends BaseMachineScreen<LaunchpadMenu> {
    public LaunchpadScreen(LaunchpadMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component, new ResourceLocation(SimplemissilesMod.MODID, "textures/screens/launchpad_gui.png"));
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = 85;
        this.inventoryLabelX = 85;
        LaunchpadBlockEntity blockEntity = ((LaunchpadBlockEntity) this.menu.blockEntity);
        this.addRenderableWidget(new CoordinatesSetter(this.font, this.leftPos + 85, this.topPos + 16, 84, 10, Direction.Axis.X, value -> {
            if (NumberUtils.isDigits(value)) {
            }
        }));
        this.addRenderableWidget(new CoordinatesSetter(this.font, this.leftPos + 85, this.topPos + 31, 84, 10, Direction.Axis.Y, value -> {
            if (NumberUtils.isDigits(value)) {
                blockEntity.setTargetY(Integer.valueOf(value));
            } else {

            }
        }));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        Minecraft mc = Minecraft.getInstance();
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
//        mc.gameRenderer.getMapRenderer().render(guiGraphics.pose(), mc.renderBuffers().bufferSource(), , , false, 231132);
        LaunchpadBlockEntity blockEntity = ((LaunchpadBlockEntity) this.menu.blockEntity);
        guiGraphics.drawString(this.font, "X: " + this.menu.data.get(0), this.leftPos + 8, this.topPos + 6, ChatFormatting.DARK_GREEN.getColor());
        guiGraphics.drawString(this.font, "Y: " + blockEntity.getTargetY(), this.leftPos + 8, this.topPos + 16, ChatFormatting.DARK_GREEN.getColor());
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
