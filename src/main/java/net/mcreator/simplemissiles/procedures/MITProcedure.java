package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.simplemissiles.init.SimplemissilesModMobEffects;
import net.mcreator.simplemissiles.SimplemissilesMod;

public class MITProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SimplemissilesMod.queueServerWork(10, () -> {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(SimplemissilesModMobEffects.MILK_INTOLERANCE.get(), 18000, 0));
		});
	}
}
