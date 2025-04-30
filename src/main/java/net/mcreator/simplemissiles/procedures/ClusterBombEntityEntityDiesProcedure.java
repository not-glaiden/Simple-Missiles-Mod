package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModEntities;

public class ClusterBombEntityEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
		for (int index0 = 0; index0 < 15; index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SimplemissilesModEntities.CLUSTER.get().spawn(_level,
						BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -1, 1), y + Mth.nextDouble(RandomSource.create(), -1, 1), z + Mth.nextDouble(RandomSource.create(), -1, 1)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
		}
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.TNT);
	}
}
