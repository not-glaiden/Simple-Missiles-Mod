
package net.mcreator.simplemissiles.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.procedures.OmegaMissleFallingBlockAddedProcedure;

public class OmegaMissleFallingBlock extends FallingBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public OmegaMissleFallingBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK).strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(3, 6, 3, 13, 32, 13), box(4, 0, 4, 12, 6, 12), box(6, 0, 14, 10, 13, 18), box(6, 0, -2, 10, 13, 2), box(-2, 0, 6, 2, 13, 10), box(14, 0, 6, 18, 13, 10), box(12, 7, 7, 14, 12, 9), box(2, 7, 7, 4, 12, 9),
					box(7, 7, 12, 9, 12, 14), box(7, 7, 2, 9, 12, 4));
			case NORTH -> Shapes.or(box(3, 6, 3, 13, 32, 13), box(4, 0, 4, 12, 6, 12), box(6, 0, -2, 10, 13, 2), box(6, 0, 14, 10, 13, 18), box(14, 0, 6, 18, 13, 10), box(-2, 0, 6, 2, 13, 10), box(2, 7, 7, 4, 12, 9), box(12, 7, 7, 14, 12, 9),
					box(7, 7, 2, 9, 12, 4), box(7, 7, 12, 9, 12, 14));
			case EAST -> Shapes.or(box(3, 6, 3, 13, 32, 13), box(4, 0, 4, 12, 6, 12), box(14, 0, 6, 18, 13, 10), box(-2, 0, 6, 2, 13, 10), box(6, 0, 14, 10, 13, 18), box(6, 0, -2, 10, 13, 2), box(7, 7, 2, 9, 12, 4), box(7, 7, 12, 9, 12, 14),
					box(12, 7, 7, 14, 12, 9), box(2, 7, 7, 4, 12, 9));
			case WEST -> Shapes.or(box(3, 6, 3, 13, 32, 13), box(4, 0, 4, 12, 6, 12), box(-2, 0, 6, 2, 13, 10), box(14, 0, 6, 18, 13, 10), box(6, 0, -2, 10, 13, 2), box(6, 0, 14, 10, 13, 18), box(7, 7, 12, 9, 12, 14), box(7, 7, 2, 9, 12, 4),
					box(2, 7, 7, 4, 12, 9), box(12, 7, 7, 14, 12, 9));
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
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		OmegaMissleFallingBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void wasExploded(Level world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		OmegaMissleFallingBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
