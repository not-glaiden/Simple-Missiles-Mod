package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModBlocks;

public class BrokenLocatorAntOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == SimplemissilesModBlocks.PLAYER_LOCATOR_OVERLOADED.get())) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
