package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModBlocks;

public class LocatorentityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(SimplemissilesModBlocks.PLAYERLOCATOR.get() == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
