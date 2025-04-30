
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.simplemissiles.client.particle.MissilesmokeParticle;
import net.mcreator.simplemissiles.client.particle.ExplosionParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SimplemissilesModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(SimplemissilesModParticleTypes.EXPLOSION_PARTICLE.get(), ExplosionParticleParticle::provider);
		event.registerSpriteSet(SimplemissilesModParticleTypes.MISSILESMOKE.get(), MissilesmokeParticle::provider);
	}
}
