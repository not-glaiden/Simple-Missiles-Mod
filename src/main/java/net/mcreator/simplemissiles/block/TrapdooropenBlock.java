
package net.mcreator.simplemissiles.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.procedures.TrapdooropenRedstoneOffProcedure;

public class TrapdooropenBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public TrapdooropenBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(14, 0, 2, 16, 2, 14), box(0, 0, 2, 2, 2, 14), box(0, 0, 0, 16, 2, 2), box(0, 0, 14, 16, 2, 16), box(2, 3, 0, 14, 15, 2), box(11, 2, 1, 13, 3, 2), box(3, 2, 1, 5, 3, 2));
			case NORTH -> Shapes.or(box(0, 0, 2, 2, 2, 14), box(14, 0, 2, 16, 2, 14), box(0, 0, 14, 16, 2, 16), box(0, 0, 0, 16, 2, 2), box(2, 3, 14, 14, 15, 16), box(3, 2, 14, 5, 3, 15), box(11, 2, 14, 13, 3, 15));
			case EAST -> Shapes.or(box(2, 0, 0, 14, 2, 2), box(2, 0, 14, 14, 2, 16), box(0, 0, 0, 2, 2, 16), box(14, 0, 0, 16, 2, 16), box(0, 3, 2, 2, 15, 14), box(1, 2, 3, 2, 3, 5), box(1, 2, 11, 2, 3, 13));
			case WEST -> Shapes.or(box(2, 0, 14, 14, 2, 16), box(2, 0, 0, 14, 2, 2), box(14, 0, 0, 16, 2, 16), box(0, 0, 0, 2, 2, 16), box(14, 3, 2, 16, 15, 14), box(14, 2, 11, 15, 3, 13), box(14, 2, 3, 15, 3, 5));
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
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
		} else {
			TrapdooropenRedstoneOffProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		TrapdooropenRedstoneOffProcedure.execute(world, x, y, z);
		return InteractionResult.SUCCESS;
	}
}
