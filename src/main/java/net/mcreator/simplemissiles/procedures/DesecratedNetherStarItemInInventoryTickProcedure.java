package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.entity.Entity;

public class DesecratedNetherStarItemInInventoryTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") + 0.0003));
	}
}
