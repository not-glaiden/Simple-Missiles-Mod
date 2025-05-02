
package net.mcreator.simplemissiles.block;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.world.inventory.LaunchPadGuiMenuOld;
import net.mcreator.simplemissiles.block.entity.ConsoleBlockEntity;

import io.netty.buffer.Unpooled;

public class ConsoleBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public ConsoleBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(0, 0, 0, 16, 10, 16), box(1, 8, 1, 15, 10, 14), box(0, 10, 0, 16, 11, 13), box(0, 11, 0, 16, 12, 12), box(0, 12, 0, 16, 13, 11), box(0, 13, 0, 16, 14, 10), box(0, 14, 0, 16, 15, 9), box(0, 15, 0, 16, 16, 8),
					box(0, 16, 0, 16, 18, 6), box(11, 13, 9, 13, 15, 11), box(11, 11, 11, 13, 13, 13), box(11, 15, 7, 13, 17, 9), box(3, 14, 8, 8, 18, 10));
			case NORTH -> Shapes.or(box(0, 0, 0, 16, 10, 16), box(1, 8, 2, 15, 10, 15), box(0, 10, 3, 16, 11, 16), box(0, 11, 4, 16, 12, 16), box(0, 12, 5, 16, 13, 16), box(0, 13, 6, 16, 14, 16), box(0, 14, 7, 16, 15, 16), box(0, 15, 8, 16, 16, 16),
					box(0, 16, 10, 16, 18, 16), box(3, 13, 5, 5, 15, 7), box(3, 11, 3, 5, 13, 5), box(3, 15, 7, 5, 17, 9), box(8, 14, 6, 13, 18, 8));
			case EAST -> Shapes.or(box(0, 0, 0, 16, 10, 16), box(1, 8, 1, 14, 10, 15), box(0, 10, 0, 13, 11, 16), box(0, 11, 0, 12, 12, 16), box(0, 12, 0, 11, 13, 16), box(0, 13, 0, 10, 14, 16), box(0, 14, 0, 9, 15, 16), box(0, 15, 0, 8, 16, 16),
					box(0, 16, 0, 6, 18, 16), box(9, 13, 3, 11, 15, 5), box(11, 11, 3, 13, 13, 5), box(7, 15, 3, 9, 17, 5), box(8, 14, 8, 10, 18, 13));
			case WEST -> Shapes.or(box(0, 0, 0, 16, 10, 16), box(2, 8, 1, 15, 10, 15), box(3, 10, 0, 16, 11, 16), box(4, 11, 0, 16, 12, 16), box(5, 12, 0, 16, 13, 16), box(6, 13, 0, 16, 14, 16), box(7, 14, 0, 16, 15, 16), box(8, 15, 0, 16, 16, 16),
					box(10, 16, 0, 16, 18, 16), box(5, 13, 11, 7, 15, 13), box(3, 11, 11, 5, 13, 13), box(7, 15, 11, 9, 17, 13), box(6, 14, 3, 8, 18, 8));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openScreen(player, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Console");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new LaunchPadGuiMenuOld(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ConsoleBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof ConsoleBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof ConsoleBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
