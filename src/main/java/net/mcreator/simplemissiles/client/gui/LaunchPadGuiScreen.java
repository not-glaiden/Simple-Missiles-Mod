package net.mcreator.simplemissiles.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.simplemissiles.world.inventory.LaunchPadGuiMenu;
import net.mcreator.simplemissiles.procedures.CurrentStrikeLocationProcedure;
import net.mcreator.simplemissiles.network.LaunchPadGuiButtonMessage;
import net.mcreator.simplemissiles.SimplemissilesMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LaunchPadGuiScreen extends AbstractContainerScreen<LaunchPadGuiMenu> {
	private final static HashMap<String, Object> guistate = LaunchPadGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	public static EditBox X;
	public static EditBox Z;
	Button button_launch;
	Button button_launch1;

	public LaunchPadGuiScreen(LaunchPadGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("simplemissiles:textures/screens/launch_pad_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		X.render(guiGraphics, mouseX, mouseY, partialTicks);
		Z.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (X.isFocused())
			return X.keyPressed(key, b, c);
		if (Z.isFocused())
			return Z.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		X.tick();
		Z.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String XValue = X.getValue();
		String ZValue = Z.getValue();
		super.resize(minecraft, width, height);
		X.setValue(XValue);
		Z.setValue(ZValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.launch_pad_gui.label_enter_coordinates"), 27, 21, -12829636, false);
		guiGraphics.drawString(this.font,

				CurrentStrikeLocationProcedure.execute(world, x, y, z), 27, 80, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		X = new EditBox(this.font, this.leftPos + 28, this.topPos + 34, 118, 18, Component.translatable("gui.simplemissiles.launch_pad_gui.X")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.simplemissiles.launch_pad_gui.X").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.simplemissiles.launch_pad_gui.X").getString());
				else
					setSuggestion(null);
			}
		};
		X.setSuggestion(Component.translatable("gui.simplemissiles.launch_pad_gui.X").getString());
		X.setMaxLength(32767);
		guistate.put("text:X", X);
		this.addWidget(this.X);
		Z = new EditBox(this.font, this.leftPos + 28, this.topPos + 55, 118, 18, Component.translatable("gui.simplemissiles.launch_pad_gui.Z")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.simplemissiles.launch_pad_gui.Z").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.simplemissiles.launch_pad_gui.Z").getString());
				else
					setSuggestion(null);
			}
		};
		Z.setSuggestion(Component.translatable("gui.simplemissiles.launch_pad_gui.Z").getString());
		Z.setMaxLength(32767);
		guistate.put("text:Z", Z);
		this.addWidget(this.Z);
		button_launch = Button.builder(Component.translatable("gui.simplemissiles.launch_pad_gui.button_launch"), e -> {
			if (true) {
				textstate.put("textin:X", X.getValue());
				textstate.put("textin:Z", Z.getValue());
				SimplemissilesMod.PACKET_HANDLER.sendToServer(new LaunchPadGuiButtonMessage(0, x, y, z, textstate));
				LaunchPadGuiButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 57, this.topPos + 100, 61, 20).build();
		guistate.put("button:button_launch", button_launch);
		this.addRenderableWidget(button_launch);
		button_launch1 = Button.builder(Component.translatable("gui.simplemissiles.launch_pad_gui.button_launch1"), e -> {
			if (true) {
				textstate.put("textin:X", X.getValue());
				textstate.put("textin:Z", Z.getValue());
				SimplemissilesMod.PACKET_HANDLER.sendToServer(new LaunchPadGuiButtonMessage(1, x, y, z, textstate));
				LaunchPadGuiButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 57, this.topPos + 125, 61, 20).build();
		guistate.put("button:button_launch1", button_launch1);
		this.addRenderableWidget(button_launch1);
	}
}
