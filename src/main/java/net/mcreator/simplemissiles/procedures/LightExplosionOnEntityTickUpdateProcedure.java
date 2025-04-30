package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.simplemissiles.SimplemissilesMod;

public class LightExplosionOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("size", (entity.getPersistentData().getDouble("size") + 3));
		SimplemissilesMod.queueServerWork(100, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
