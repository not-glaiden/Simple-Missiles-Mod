
package net.mcreator.simplemissiles.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ClusterBombBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public ClusterBombBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHERITE_BLOCK).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(7, 0, 1, 9, 2, 5), box(7, 0, 11, 9, 2, 15), box(1, 0, 7, 5, 2, 9), box(11, 0, 7, 15, 2, 9), box(3, 5, 3, 13, 18, 13), box(5, 0, 5, 11, 5, 11));
			case NORTH -> Shapes.or(box(7, 0, 11, 9, 2, 15), box(7, 0, 1, 9, 2, 5), box(11, 0, 7, 15, 2, 9), box(1, 0, 7, 5, 2, 9), box(3, 5, 3, 13, 18, 13), box(5, 0, 5, 11, 5, 11));
			case EAST -> Shapes.or(box(1, 0, 7, 5, 2, 9), box(11, 0, 7, 15, 2, 9), box(7, 0, 11, 9, 2, 15), box(7, 0, 1, 9, 2, 5), box(3, 5, 3, 13, 18, 13), box(5, 0, 5, 11, 5, 11));
			case WEST -> Shapes.or(box(11, 0, 7, 15, 2, 9), box(1, 0, 7, 5, 2, 9), box(7, 0, 1, 9, 2, 5), box(7, 0, 11, 9, 2, 15), box(3, 5, 3, 13, 18, 13), box(5, 0, 5, 11, 5, 11));
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
}
