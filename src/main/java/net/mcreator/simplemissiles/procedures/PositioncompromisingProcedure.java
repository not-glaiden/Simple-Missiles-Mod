package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.entity.Entity;

public class PositioncompromisingProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getBoolean("Finded") == true) {
			return "\u00A7c\u00A7lSomeone started to compromise your position in last 3m!";
		}
		return "Your position is safe.";
	}
}
