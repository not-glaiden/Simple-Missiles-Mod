
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.simplemissiles.SimplemissilesMod;

public class SimplemissilesModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SimplemissilesMod.MODID);
	public static final RegistryObject<SimpleParticleType> EXPLOSION_PARTICLE = REGISTRY.register("explosion_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> MISSILESMOKE = REGISTRY.register("missilesmoke", () -> new SimpleParticleType(true));
}
