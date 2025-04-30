package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.entity.Entity;

public class ConsumedradiationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Consumed radiation:" + (" " + (entity.getPersistentData().getDouble("radiation") + " Sv"));
	}
}
