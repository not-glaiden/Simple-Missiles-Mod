package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModEntities;
import net.mcreator.simplemissiles.entity.BrokenLocatorAntEntity;

public class PlayerLocatorOverloadedOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(BrokenLocatorAntEntity.class, AABB.ofSize(new Vec3(x, (y + 1), z), 1, 1, 1), e -> true).isEmpty())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SimplemissilesModEntities.BROKEN_LOCATOR_ANT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
