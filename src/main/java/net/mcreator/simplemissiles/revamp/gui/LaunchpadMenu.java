package net.mcreator.simplemissiles.revamp.gui;

import net.mcreator.simplemissiles.SimplemissilesMod;
import net.mcreator.simplemissiles.init.SimplemissilesModMenus;
import net.mcreator.simplemissiles.revamp.gui.base.BaseMachineMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class LaunchpadMenu extends BaseMachineMenu {
    public LaunchpadMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(id, inventory, new SimpleContainer(1), new SimpleContainerData(2), inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()));
    }

    public LaunchpadMenu(int id, Inventory inventory, Container container, ContainerData data, BlockEntity blockEntity) {
        super(SimplemissilesModMenus.LAUNCHPAD_MENU.get(), id, inventory, data, container, blockEntity);
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot slot = slots.get(pIndex);
        if (slot == null || !slot.hasItem()) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStack = slot.getItem();
        ItemStack itemStack1 = itemStack.copy();
        int i = 0;
        if (pIndex < 36) {
            if (!moveItemStackTo(itemStack, 36, 36 + i, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < 36 + i) {
            if (!moveItemStackTo(itemStack, 0, 36, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            SimplemissilesMod.LOGGER.error("Invalid slot index: {}", pIndex);
            return ItemStack.EMPTY;
        }
        if (itemStack.getCount() == 0) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }
        slot.onTake(playerIn, itemStack);
        return itemStack1;
    }
}
