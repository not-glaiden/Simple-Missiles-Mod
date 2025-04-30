
package net.mcreator.simplemissiles.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.simplemissiles.procedures.RadawayActiveTickConditionProcedure;

public class RadawayMobEffect extends MobEffect {
	public RadawayMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13369345);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RadawayActiveTickConditionProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
