package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.entity.Entity;

public class YourlocationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Your location: " + (Math.round(Math.round(entity.getX())) + "" + (" " + (Math.round(Math.round(entity.getY())) + "" + (" " + Math.round(Math.round(entity.getZ()))))));
	}
}
