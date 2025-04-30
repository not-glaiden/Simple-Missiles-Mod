package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.simplemissiles.network.SimplemissilesModVariables;

public class LocatorguicountProcedure {
	public static String execute(LevelAccessor world) {
		if (0 != SimplemissilesModVariables.WorldVariables.get(world).Missiles_in_the_air) {
			if (1 == SimplemissilesModVariables.WorldVariables.get(world).Missiles_in_the_air) {
				return "\u00A74\u00A7l1 MISSILE IN THE AIR!";
			} else {
				return "\u00A74\u00A7l" + (Math.round(SimplemissilesModVariables.WorldVariables.get(world).Missiles_in_the_air) + " MISSILES IN THE AIR!");
			}
		}
		return "No missiles found";
	}
}
