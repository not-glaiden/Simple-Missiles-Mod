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

import net.mcreator.simplemissiles.world.inventory.LocatorGuiMenu;
import net.mcreator.simplemissiles.procedures.SecondsleftfindingProcedure;
import net.mcreator.simplemissiles.procedures.LocatorcoordsProcedure;
import net.mcreator.simplemissiles.network.LocatorGuiButtonMessage;
import net.mcreator.simplemissiles.SimplemissilesMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LocatorGuiScreen extends AbstractContainerScreen<LocatorGuiMenu> {
	private final static HashMap<String, Object> guistate = LocatorGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	public static EditBox Nickname;
	Button button_get_location;
	Button button_transfer_data;

	public LocatorGuiScreen(LocatorGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("simplemissiles:textures/screens/locator_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Nickname.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (Nickname.isFocused())
			return Nickname.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Nickname.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String NicknameValue = Nickname.getValue();
		super.resize(minecraft, width, height);
		Nickname.setValue(NicknameValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				SecondsleftfindingProcedure.execute(world, x, y, z), 5, 70, -12829636, false);
		guiGraphics.drawString(this.font,

				LocatorcoordsProcedure.execute(world, x, y, z), 5, 37, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.simplemissiles.locator_gui.label_player_locator"), 6, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		Nickname = new EditBox(this.font, this.leftPos + 28, this.topPos + 93, 118, 18, Component.translatable("gui.simplemissiles.locator_gui.Nickname")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.simplemissiles.locator_gui.Nickname").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.simplemissiles.locator_gui.Nickname").getString());
				else
					setSuggestion(null);
			}
		};
		Nickname.setSuggestion(Component.translatable("gui.simplemissiles.locator_gui.Nickname").getString());
		Nickname.setMaxLength(32767);
		guistate.put("text:Nickname", Nickname);
		this.addWidget(this.Nickname);
		button_get_location = Button.builder(Component.translatable("gui.simplemissiles.locator_gui.button_get_location"), e -> {
			if (true) {
				textstate.put("textin:Nickname", Nickname.getValue());
				SimplemissilesMod.PACKET_HANDLER.sendToServer(new LocatorGuiButtonMessage(0, x, y, z, textstate));
				LocatorGuiButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 41, this.topPos + 114, 87, 20).build();
		guistate.put("button:button_get_location", button_get_location);
		this.addRenderableWidget(button_get_location);
		button_transfer_data = Button.builder(Component.translatable("gui.simplemissiles.locator_gui.button_transfer_data"), e -> {
			if (true) {
				textstate.put("textin:Nickname", Nickname.getValue());
				SimplemissilesMod.PACKET_HANDLER.sendToServer(new LocatorGuiButtonMessage(1, x, y, z, textstate));
				LocatorGuiButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 38, this.topPos + 139, 93, 20).build();
		guistate.put("button:button_transfer_data", button_transfer_data);
		this.addRenderableWidget(button_transfer_data);
	}
}
