package net.mcreator.simplemissiles.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.simplemissiles.world.inventory.ManualPage2Menu;
import net.mcreator.simplemissiles.network.ManualPage2ButtonMessage;
import net.mcreator.simplemissiles.SimplemissilesMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ManualPage2Screen extends AbstractContainerScreen<ManualPage2Menu> {
	private final static HashMap<String, Object> guistate = ManualPage2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	Button button_empty;
	Button button_empty1;

	public ManualPage2Screen(ManualPage2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("simplemissiles:textures/screens/manualpage.png"), this.leftPos + -71, this.topPos + -10, 0, 0, 512, 256, 512, 256);

		guiGraphics.blit(new ResourceLocation("simplemissiles:textures/screens/page_backward.png"), this.leftPos + -103, this.topPos + 151, 0, 0, 23, 13, 23, 13);

		guiGraphics.blit(new ResourceLocation("simplemissiles:textures/screens/page_forward.png"), this.leftPos + 252, this.topPos + 151, 0, 0, 23, 13, 23, 13);

		guiGraphics.blit(new ResourceLocation("simplemissiles:textures/screens/launchpad_downscaled.png"), this.leftPos + -27, this.topPos + 21, 0, 0, 50, 50, 50, 50);

		guiGraphics.blit(new ResourceLocation("simplemissiles:textures/screens/craft1.png"), this.leftPos + -26, this.topPos + 102, 0, 0, 100, 50, 100, 50);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_launch_pad"), -6, 4, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_crafting"), -24, 87, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_how_to_use"), 124, 5, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_1_place_missile_on_top"), 90, 24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_2enter_coordinates"), 90, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_3press_set_coords_button"), 90, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_if_you_changed_target"), 100, 72, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_4launch_it_with_button_or"), 90, 96, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_or_with_redstone_signal"), 101, 108, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.manual_page_2.label_signal"), 101, 120, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + -104, this.topPos + 148, 25, 20, Component.translatable("gui.simplemissiles.manual_page_2.button_empty"), e -> {
			if (true) {
				SimplemissilesMod.PACKET_HANDLER.sendToServer(new ManualPage2ButtonMessage(0, x, y, z, textstate));
				ManualPage2ButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		}, this.font);
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 252, this.topPos + 148, 25, 20, Component.translatable("gui.simplemissiles.manual_page_2.button_empty1"), e -> {
			if (true) {
				SimplemissilesMod.PACKET_HANDLER.sendToServer(new ManualPage2ButtonMessage(1, x, y, z, textstate));
				ManualPage2ButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		}, this.font);
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
