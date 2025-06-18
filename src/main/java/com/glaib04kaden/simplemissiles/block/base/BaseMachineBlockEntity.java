package com.glaib04kaden.simplemissiles.block.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;

public abstract class BaseMachineBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
    LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);


    protected BaseMachineBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public int getContainerSize() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.getContainerSize(); i++) {
            if (!this.getItem(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int i) {
        return this.items.get(i);
    }

    @Override
    public ItemStack removeItem(int i, int i1) {
        return ContainerHelper.removeItem(this.items, i, i1);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return ContainerHelper.takeItem(this.items, i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        boolean flag = !itemStack.isEmpty() && ItemStack.isSameItemSameTags(this.items.get(i), itemStack);
        this.items.set(i, itemStack);
        if (itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }
        if (i == 0 && !flag) {
            this.setChanged();
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
            if (facing == Direction.UP) {
                return this.handlers[0].cast();
            } else {
                return facing == Direction.DOWN ? this.handlers[1].cast() : this.handlers[2].cast();
            }
        } else {
            return super.getCapability(capability, facing);
        }
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        for (int x = 0; x < this.handlers.length; ++x) {
            this.handlers[x].invalidate();
        }
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.items);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, this.items);
    }


    public void setState(BlockState state) {
        this.level.setBlock(this.worldPosition, state, 11);
    }
}
