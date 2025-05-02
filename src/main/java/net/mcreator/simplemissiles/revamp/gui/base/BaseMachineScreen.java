package net.mcreator.simplemissiles.revamp.gui.base;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public abstract class BaseMachineScreen<M extends BaseMachineMenu> extends AbstractContainerScreen<M> {
    protected final ResourceLocation texture;
    protected int tick;

    public BaseMachineScreen(M menu, Inventory inventory, Component component, ResourceLocation texture) {
        super(menu, inventory, component);
        this.texture = texture;
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        guiGraphics.blit(this.texture, this.leftPos, this.topPos, 0, 0, 256, 256);
    }

    @Override
    protected void containerTick() {
        this.tick++;
        super.containerTick();
    }
}
