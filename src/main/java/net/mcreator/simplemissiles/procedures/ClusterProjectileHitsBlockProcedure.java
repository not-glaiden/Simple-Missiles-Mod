package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModEntities;

public class ClusterProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (1 == Mth.nextInt(RandomSource.create(), 1, 10)) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SimplemissilesModEntities.CLUSTER.get().spawn(_level, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), 1, -1), y + 1, z + Mth.nextDouble(RandomSource.create(), 1, -1)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		for (int index0 = 0; index0 < 2; index0++) {
			if (world instanceof ServerLevel _level)
				FallingBlockEntity.fall(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -3, 3), y + 3, z + Mth.nextInt(RandomSource.create(), -3, 3)), (world.getBlockState(BlockPos.containing(x, y - 1, z))));
		}
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 7, Level.ExplosionInteraction.TNT);
		world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
	}
}
