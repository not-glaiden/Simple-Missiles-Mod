package net.mcreator.simplemissiles.revamp.gui.widget;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class CoordinatesSetter extends EditBox {
    private final Direction.Axis axis;
    private final Font font;
    private Consumer<String> consumer;
    private String prefix;
    private int prefixWidth;

    public CoordinatesSetter(Font font, int x, int y, int width, int height, Direction.Axis axis, Consumer<String> consumer) {
        super(font, x, y, width, height, Component.empty());
        this.axis = axis;
        this.font = font;
        this.consumer = consumer;
        this.prefix = this.axis.toString().toUpperCase() + ": ";
        this.prefixWidth = font.width(this.prefix);
    }

    @Override
    public void renderWidget(GuiGraphics gui, int mouseX, int mouseY, float partialTick) {
        gui.drawString(this.font, this.prefix, getX(), getY() + 1, ChatFormatting.DARK_GREEN.getColor());
        this.setX(this.getX() + this.prefixWidth);
        this.setWidth(this.getWidth() - this.prefixWidth);
        super.renderWidget(gui, mouseX, mouseY, partialTick);
        this.setX(this.getX() - this.prefixWidth);
        this.setWidth(this.getWidth() + this.prefixWidth);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        double adjustedMouseX = mouseX - getX() - this.prefixWidth;
        return super.mouseClicked(adjustedMouseX + getX(), mouseY, button);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(String text) {
        super.setValue(text);
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (!this.canConsumeInput()) {
            return false;
        } else {
            if (pKeyCode == 257) {
                this.consumer.accept(this.getValue());
            }
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);

    }
}
