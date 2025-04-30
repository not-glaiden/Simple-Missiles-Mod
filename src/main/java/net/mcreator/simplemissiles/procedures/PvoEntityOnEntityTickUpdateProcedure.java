package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModBlocks;

public class PvoEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(SimplemissilesModBlocks.TEST_PVO.get() == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() || SimplemissilesModBlocks.OVERLOADED_BMD.get() == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
