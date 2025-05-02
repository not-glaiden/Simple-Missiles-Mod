package net.mcreator.simplemissiles.revamp.gui.base;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public abstract class BaseMachineMenu extends AbstractContainerMenu {
    public final Level level;
    public final ContainerData data;
    public final Container container;
    public final BlockEntity blockEntity;

    public BaseMachineMenu(MenuType<?> menuType, int id, Inventory inventory, ContainerData data, Container container, BlockEntity blockEntity) {
        super(menuType, id);
        this.level = inventory.player.level();
        this.data = data;
        this.container = container;
        this.blockEntity = blockEntity;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(data);
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    public ItemStack getItemInSlot(int id) {
        return this.container.getItem(id);
    }
}
