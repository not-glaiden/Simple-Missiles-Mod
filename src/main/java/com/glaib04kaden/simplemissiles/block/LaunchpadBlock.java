package com.glaib04kaden.simplemissiles.block;

import com.glaib04kaden.simplemissiles.block.base.BaseMachineBlock;
import com.glaib04kaden.simplemissiles.block.entity.LaunchpadBlockEntity;
import com.glaib04kaden.simplemissiles.block.entity.SMBlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class LaunchpadBlock extends BaseMachineBlock {
    public LaunchpadBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK));
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof LaunchpadBlockEntity) {
            NetworkHooks.openScreen((ServerPlayer) player, (MenuProvider) blockEntity, friendlyByteBuf -> {
                friendlyByteBuf.writeBlockPos(blockEntity.getBlockPos());
            });
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LaunchpadBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, SMBlockEntityRegistry.LAUNCHPAD_BE.get(), LaunchpadBlockEntity::tick);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
        if (pLevel.getBlockEntity(pPos) instanceof LaunchpadBlockEntity launchpadBlockEntity) {
            launchpadBlockEntity.getContainerData().set(0, pPos.getX());
            launchpadBlockEntity.getContainerData().set(1, pPos.getZ());
            launchpadBlockEntity.setChanged();
        }
    }
}
