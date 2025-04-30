package net.mcreator.simplemissiles.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.simplemissiles.network.SimplemissilesModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ResetmissilesProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.minecraftforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		SimplemissilesModVariables.WorldVariables.get(world).Missiles_in_the_air = 0;
		SimplemissilesModVariables.WorldVariables.get(world).syncData(world);
	}
}
