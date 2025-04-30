
package net.mcreator.simplemissiles.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.simplemissiles.procedures.MilkIntoleranceEffectExpiresProcedure;

public class MilkIntoleranceMobEffect extends MobEffect {
	public MilkIntoleranceMobEffect() {
		super(MobEffectCategory.HARMFUL, -26215);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		MilkIntoleranceEffectExpiresProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
