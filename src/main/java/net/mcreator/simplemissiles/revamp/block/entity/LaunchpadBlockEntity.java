package net.mcreator.simplemissiles.revamp.block.entity;

import net.mcreator.simplemissiles.init.SimplemissilesModBlockEntities;
import net.mcreator.simplemissiles.revamp.block.base.BaseMachineBlockEntity;
import net.mcreator.simplemissiles.revamp.gui.LaunchpadMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.jetbrains.annotations.Nullable;

public class LaunchpadBlockEntity extends BaseMachineBlockEntity {
    protected final ContainerData containerData;
    protected int targetX;
    protected int targetY;
    protected Integer prevTargetX;
    protected Integer prevTargetY;
    private int mapId;

    public LaunchpadBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(SimplemissilesModBlockEntities.LAUNCHPAD.get(), blockPos, blockState);
        this.containerData = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> LaunchpadBlockEntity.this.targetX;
                    case 1 -> LaunchpadBlockEntity.this.targetY;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> LaunchpadBlockEntity.this.targetX = value;
                    case 1 -> LaunchpadBlockEntity.this.targetY = value;
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
        tag.putInt("TargetY", this.targetY);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.targetX = tag.getInt("TargetX");
        this.targetY = tag.getInt("TargetY");
    }

    public static void tick(Level level, BlockPos pos, BlockState state, LaunchpadBlockEntity entity) {
        if (entity.prevTargetX == null || entity.prevTargetY == null
                || entity.targetX != entity.prevTargetX || entity.targetY != entity.prevTargetY) {
            entity.mapId = createNewSavedData(level, entity.targetX, entity.targetY, 0, true, false, level.dimension());
            entity.prevTargetX = entity.targetX;
            entity.prevTargetY = entity.targetY;
        }
        System.out.println(entity.targetX);
    }

    private static int createNewSavedData(Level pLevel, int pX, int pZ, int pScale, boolean pTrackingPosition, boolean pUnlimitedTracking, ResourceKey<Level> pDimension) {
        MapItemSavedData mapitemsaveddata = MapItemSavedData.createFresh(pX, pZ, (byte)pScale, pTrackingPosition, pUnlimitedTracking, pDimension);
        int i = pLevel.getFreeMapId();
        pLevel.setMapData(MapItem.makeKey(i), mapitemsaveddata);
        return i;
    }

    public int getTargetX() {
        return this.targetX;
    }

    public int getTargetY() {
        return this.targetY;
    }

    public int getMapId() {
        return this.mapId;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }
}
