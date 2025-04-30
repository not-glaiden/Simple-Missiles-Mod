
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.simplemissiles.client.model.Modelturret;
import net.mcreator.simplemissiles.client.model.Modeltnt_missle_falling_Converted;
import net.mcreator.simplemissiles.client.model.Modellught;
import net.mcreator.simplemissiles.client.model.Modelhazmat_torso;
import net.mcreator.simplemissiles.client.model.Modelhazmat_legs;
import net.mcreator.simplemissiles.client.model.Modelhazmat_boots;
import net.mcreator.simplemissiles.client.model.Modelhazmat;
import net.mcreator.simplemissiles.client.model.ModelOmega_bomb2_Converted;
import net.mcreator.simplemissiles.client.model.ModelNapalmMissle3_Converted;
import net.mcreator.simplemissiles.client.model.ModelMushroomExp;
import net.mcreator.simplemissiles.client.model.ModelLocator_entityy;
import net.mcreator.simplemissiles.client.model.ModelLocator_entity;
import net.mcreator.simplemissiles.client.model.ModelCluster;
import net.mcreator.simplemissiles.client.model.ModelBmd2;
import net.mcreator.simplemissiles.client.model.ModelBigBomb_Converted;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SimplemissilesModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelhazmat_legs.LAYER_LOCATION, Modelhazmat_legs::createBodyLayer);
		event.registerLayerDefinition(Modellught.LAYER_LOCATION, Modellught::createBodyLayer);
		event.registerLayerDefinition(Modelhazmat.LAYER_LOCATION, Modelhazmat::createBodyLayer);
		event.registerLayerDefinition(Modelhazmat_torso.LAYER_LOCATION, Modelhazmat_torso::createBodyLayer);
		event.registerLayerDefinition(ModelOmega_bomb2_Converted.LAYER_LOCATION, ModelOmega_bomb2_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelhazmat_boots.LAYER_LOCATION, Modelhazmat_boots::createBodyLayer);
		event.registerLayerDefinition(ModelLocator_entityy.LAYER_LOCATION, ModelLocator_entityy::createBodyLayer);
		event.registerLayerDefinition(ModelBmd2.LAYER_LOCATION, ModelBmd2::createBodyLayer);
		event.registerLayerDefinition(ModelMushroomExp.LAYER_LOCATION, ModelMushroomExp::createBodyLayer);
		event.registerLayerDefinition(ModelCluster.LAYER_LOCATION, ModelCluster::createBodyLayer);
		event.registerLayerDefinition(ModelLocator_entity.LAYER_LOCATION, ModelLocator_entity::createBodyLayer);
		event.registerLayerDefinition(Modeltnt_missle_falling_Converted.LAYER_LOCATION, Modeltnt_missle_falling_Converted::createBodyLayer);
		event.registerLayerDefinition(ModelNapalmMissle3_Converted.LAYER_LOCATION, ModelNapalmMissle3_Converted::createBodyLayer);
		event.registerLayerDefinition(ModelBigBomb_Converted.LAYER_LOCATION, ModelBigBomb_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelturret.LAYER_LOCATION, Modelturret::createBodyLayer);
	}
}
