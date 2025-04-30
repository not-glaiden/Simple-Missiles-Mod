
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.simplemissiles.potion.RadawayMobEffect;
import net.mcreator.simplemissiles.potion.MilkIntoleranceMobEffect;
import net.mcreator.simplemissiles.SimplemissilesMod;

public class SimplemissilesModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SimplemissilesMod.MODID);
	public static final RegistryObject<MobEffect> RADAWAY = REGISTRY.register("radaway", () -> new RadawayMobEffect());
	public static final RegistryObject<MobEffect> MILK_INTOLERANCE = REGISTRY.register("milk_intolerance", () -> new MilkIntoleranceMobEffect());
}
