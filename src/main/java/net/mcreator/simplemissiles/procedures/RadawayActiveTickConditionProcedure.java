package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.entity.Entity;

public class RadawayActiveTickConditionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("radiation") > 0) {
			entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") - 0.007));
		}
	}
}
