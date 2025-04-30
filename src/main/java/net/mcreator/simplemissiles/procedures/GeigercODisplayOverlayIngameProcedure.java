package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.simplemissiles.init.SimplemissilesModItems;

public class GeigercODisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SimplemissilesModItems.GEIGER_COUNTER.get()) {
			return true;
		}
		return false;
	}
}
