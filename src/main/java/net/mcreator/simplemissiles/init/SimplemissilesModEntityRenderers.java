
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.simplemissiles.client.renderer.TntMissleEntityRenderer;
import net.mcreator.simplemissiles.client.renderer.PvoEntityRenderer;
import net.mcreator.simplemissiles.client.renderer.OrbitalstrikemissileentityRenderer;
import net.mcreator.simplemissiles.client.renderer.OmegaexplosionRenderer;
import net.mcreator.simplemissiles.client.renderer.OmegaEntityRenderer;
import net.mcreator.simplemissiles.client.renderer.OmegaEmptyEntityRenderer;
import net.mcreator.simplemissiles.client.renderer.NapalmEntityRenderer;
import net.mcreator.simplemissiles.client.renderer.MushroomExplosionEntityRenderer;
import net.mcreator.simplemissiles.client.renderer.LocatorentityRenderer;
import net.mcreator.simplemissiles.client.renderer.Locator2Renderer;
import net.mcreator.simplemissiles.client.renderer.Locat3Renderer;
import net.mcreator.simplemissiles.client.renderer.LightExplosionRenderer;
import net.mcreator.simplemissiles.client.renderer.EMPMInairRenderer;
import net.mcreator.simplemissiles.client.renderer.ClusterRenderer;
import net.mcreator.simplemissiles.client.renderer.ClusterBombEntityRenderer;
import net.mcreator.simplemissiles.client.renderer.BrokenLocatorAntRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SimplemissilesModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SimplemissilesModEntities.TNT_MISSLE_ENTITY.get(), TntMissleEntityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.NAPALM_ENTITY.get(), NapalmEntityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.CLUSTER.get(), ClusterRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.CLUSTER_BOMB_ENTITY.get(), ClusterBombEntityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.OMEGA_ENTITY.get(), OmegaEntityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.LOCATORENTITY.get(), LocatorentityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.ORBITALSTRIKEMISSILEENTITY.get(), OrbitalstrikemissileentityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.OMEGAEXPLOSION.get(), OmegaexplosionRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.PVO_ENTITY.get(), PvoEntityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.LOCATOR_2.get(), Locator2Renderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.LOCAT_3.get(), Locat3Renderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.OMEGA_EMPTY_ENTITY.get(), OmegaEmptyEntityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.MUSHROOM_EXPLOSION_ENTITY.get(), MushroomExplosionEntityRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.LIGHT_EXPLOSION.get(), LightExplosionRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.BROKEN_LOCATOR_ANT.get(), BrokenLocatorAntRenderer::new);
		event.registerEntityRenderer(SimplemissilesModEntities.EMPM_INAIR.get(), EMPMInairRenderer::new);
	}
}
