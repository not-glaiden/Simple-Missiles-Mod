package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.simplemissiles.SimplemissilesMod;

public class MushroomExplosionEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getPersistentData().getDouble("size") > 40)) {
			entity.getPersistentData().putDouble("size", (entity.getPersistentData().getDouble("size") + 0.1));
		}
		SimplemissilesMod.queueServerWork(600, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
