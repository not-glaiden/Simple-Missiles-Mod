package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.entity.Entity;

public class RadiationPerTickGeigerProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getPersistentData().getDouble("mSvt") + " ") + "mSv/t";
	}
}
