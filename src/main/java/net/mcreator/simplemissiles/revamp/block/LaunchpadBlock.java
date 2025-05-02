package net.mcreator.simplemissiles.revamp.block;

import net.mcreator.simplemissiles.init.SimplemissilesModBlockEntities;
import net.mcreator.simplemissiles.revamp.block.base.BaseMachineBlock;
import net.mcreator.simplemissiles.revamp.block.entity.LaunchpadBlockEntity;
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
            NetworkHooks.openScreen((ServerPlayer) player, (MenuProvider) blockEntity, pos);
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
        return createTickerHelper(type, SimplemissilesModBlockEntities.LAUNCHPAD.get(), LaunchpadBlockEntity::tick);
    }
}
