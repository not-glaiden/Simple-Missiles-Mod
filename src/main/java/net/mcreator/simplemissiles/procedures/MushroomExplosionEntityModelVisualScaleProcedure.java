package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.entity.Entity;

public class MushroomExplosionEntityModelVisualScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDouble("size") + 1;
	}
}
