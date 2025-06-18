package com.glaib04kaden.simplemissiles.block.entity;

import com.glaib04kaden.simplemissiles.block.base.BaseMachineBlockEntity;
import com.glaib04kaden.simplemissiles.gui.LaunchpadMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LaunchpadBlockEntity extends BaseMachineBlockEntity {
    protected final ContainerData containerData;
    protected int targetX;
    protected int targetZ;

    public LaunchpadBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(SMBlockEntityRegistry.LAUNCHPAD_BE.get(), blockPos, blockState);
        this.containerData = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> LaunchpadBlockEntity.this.targetX;
                    case 1 -> LaunchpadBlockEntity.this.targetZ;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> LaunchpadBlockEntity.this.targetX = value;
                    case 1 -> LaunchpadBlockEntity.this.targetZ = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.simplemissiles.launchpad");
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new LaunchpadMenu(i, inventory, this, this.containerData, this);
    }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        return new int[0];
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
        return false;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("TargetX", this.targetX);
        tag.putInt("TargetZ", this.targetZ);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.targetX = tag.getInt("TargetX");
        this.targetZ = tag.getInt("TargetZ");
    }

    public static void tick(Level level, BlockPos pos, BlockState state, LaunchpadBlockEntity entity) {
    }

    public ContainerData getContainerData() {
        return containerData;
    }
}
