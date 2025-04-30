
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.simplemissiles.SimplemissilesMod;

public class SimplemissilesModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SimplemissilesMod.MODID);
	public static final RegistryObject<SoundEvent> STARTINGMISSLE = REGISTRY.register("startingmissle", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("simplemissiles", "startingmissle")));
	public static final RegistryObject<SoundEvent> LOCATOR_BEEP = REGISTRY.register("locator_beep", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("simplemissiles", "locator_beep")));
	public static final RegistryObject<SoundEvent> GATGETOPEN = REGISTRY.register("gatgetopen", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("simplemissiles", "gatgetopen")));
	public static final RegistryObject<SoundEvent> DISTANT_EXPLOSION = REGISTRY.register("distant_explosion", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("simplemissiles", "distant_explosion")));
	public static final RegistryObject<SoundEvent> OMEGAEXPLOSION = REGISTRY.register("omegaexplosion", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("simplemissiles", "omegaexplosion")));
	public static final RegistryObject<SoundEvent> GEIGER_COUNTER = REGISTRY.register("geiger_counter", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("simplemissiles", "geiger_counter")));
	public static final RegistryObject<SoundEvent> EMP_BLAST = REGISTRY.register("emp_blast", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("simplemissiles", "emp_blast")));
}
