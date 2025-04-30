
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.simplemissiles.SimplemissilesMod;

public class SimplemissilesModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, SimplemissilesMod.MODID);
	public static final RegistryObject<Potion> RAD_AWAYP = REGISTRY.register("rad_awayp", () -> new Potion(new MobEffectInstance(SimplemissilesModMobEffects.RADAWAY.get(), 200, 0, false, true)));
}
