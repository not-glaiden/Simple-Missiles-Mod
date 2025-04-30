
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.simplemissiles.entity.TntMissleEntityEntity;
import net.mcreator.simplemissiles.entity.PvoEntityEntity;
import net.mcreator.simplemissiles.entity.OrbitalstrikemissileentityEntity;
import net.mcreator.simplemissiles.entity.OmegaexplosionEntity;
import net.mcreator.simplemissiles.entity.OmegaEntityEntity;
import net.mcreator.simplemissiles.entity.OmegaEmptyEntityEntity;
import net.mcreator.simplemissiles.entity.NapalmEntityEntity;
import net.mcreator.simplemissiles.entity.MushroomExplosionEntityEntity;
import net.mcreator.simplemissiles.entity.LocatorentityEntity;
import net.mcreator.simplemissiles.entity.Locator2Entity;
import net.mcreator.simplemissiles.entity.Locat3Entity;
import net.mcreator.simplemissiles.entity.LightExplosionEntity;
import net.mcreator.simplemissiles.entity.EMPMInairEntity;
import net.mcreator.simplemissiles.entity.ClusterEntity;
import net.mcreator.simplemissiles.entity.ClusterBombEntityEntity;
import net.mcreator.simplemissiles.entity.BrokenLocatorAntEntity;
import net.mcreator.simplemissiles.SimplemissilesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SimplemissilesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SimplemissilesMod.MODID);
	public static final RegistryObject<EntityType<TntMissleEntityEntity>> TNT_MISSLE_ENTITY = register("tnt_missle_entity",
			EntityType.Builder.<TntMissleEntityEntity>of(TntMissleEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TntMissleEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NapalmEntityEntity>> NAPALM_ENTITY = register("napalm_entity",
			EntityType.Builder.<NapalmEntityEntity>of(NapalmEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NapalmEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ClusterEntity>> CLUSTER = register("cluster",
			EntityType.Builder.<ClusterEntity>of(ClusterEntity::new, MobCategory.MISC).setCustomClientFactory(ClusterEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ClusterBombEntityEntity>> CLUSTER_BOMB_ENTITY = register("cluster_bomb_entity",
			EntityType.Builder.<ClusterBombEntityEntity>of(ClusterBombEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ClusterBombEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OmegaEntityEntity>> OMEGA_ENTITY = register("omega_entity",
			EntityType.Builder.<OmegaEntityEntity>of(OmegaEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OmegaEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LocatorentityEntity>> LOCATORENTITY = register("locatorentity", EntityType.Builder.<LocatorentityEntity>of(LocatorentityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LocatorentityEntity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<OrbitalstrikemissileentityEntity>> ORBITALSTRIKEMISSILEENTITY = register("orbitalstrikemissileentity",
			EntityType.Builder.<OrbitalstrikemissileentityEntity>of(OrbitalstrikemissileentityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(OrbitalstrikemissileentityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OmegaexplosionEntity>> OMEGAEXPLOSION = register("omegaexplosion", EntityType.Builder.<OmegaexplosionEntity>of(OmegaexplosionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OmegaexplosionEntity::new).fireImmune().sized(0.5f, 0.3f));
	public static final RegistryObject<EntityType<PvoEntityEntity>> PVO_ENTITY = register("pvo_entity", EntityType.Builder.<PvoEntityEntity>of(PvoEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(PvoEntityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Locator2Entity>> LOCATOR_2 = register("locator_2",
			EntityType.Builder.<Locator2Entity>of(Locator2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Locator2Entity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<Locat3Entity>> LOCAT_3 = register("locat_3",
			EntityType.Builder.<Locat3Entity>of(Locat3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Locat3Entity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<OmegaEmptyEntityEntity>> OMEGA_EMPTY_ENTITY = register("omega_empty_entity",
			EntityType.Builder.<OmegaEmptyEntityEntity>of(OmegaEmptyEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OmegaEmptyEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MushroomExplosionEntityEntity>> MUSHROOM_EXPLOSION_ENTITY = register("mushroom_explosion_entity",
			EntityType.Builder.<MushroomExplosionEntityEntity>of(MushroomExplosionEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(10000).setUpdateInterval(3)
					.setCustomClientFactory(MushroomExplosionEntityEntity::new).fireImmune().sized(5f, 5f));
	public static final RegistryObject<EntityType<LightExplosionEntity>> LIGHT_EXPLOSION = register("light_explosion", EntityType.Builder.<LightExplosionEntity>of(LightExplosionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(300).setUpdateInterval(3).setCustomClientFactory(LightExplosionEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BrokenLocatorAntEntity>> BROKEN_LOCATOR_ANT = register("broken_locator_ant", EntityType.Builder.<BrokenLocatorAntEntity>of(BrokenLocatorAntEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BrokenLocatorAntEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EMPMInairEntity>> EMPM_INAIR = register("empm_inair",
			EntityType.Builder.<EMPMInairEntity>of(EMPMInairEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EMPMInairEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TntMissleEntityEntity.init();
			NapalmEntityEntity.init();
			ClusterBombEntityEntity.init();
			OmegaEntityEntity.init();
			LocatorentityEntity.init();
			OrbitalstrikemissileentityEntity.init();
			OmegaexplosionEntity.init();
			PvoEntityEntity.init();
			Locator2Entity.init();
			Locat3Entity.init();
			OmegaEmptyEntityEntity.init();
			MushroomExplosionEntityEntity.init();
			LightExplosionEntity.init();
			BrokenLocatorAntEntity.init();
			EMPMInairEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TNT_MISSLE_ENTITY.get(), TntMissleEntityEntity.createAttributes().build());
		event.put(NAPALM_ENTITY.get(), NapalmEntityEntity.createAttributes().build());
		event.put(CLUSTER_BOMB_ENTITY.get(), ClusterBombEntityEntity.createAttributes().build());
		event.put(OMEGA_ENTITY.get(), OmegaEntityEntity.createAttributes().build());
		event.put(LOCATORENTITY.get(), LocatorentityEntity.createAttributes().build());
		event.put(ORBITALSTRIKEMISSILEENTITY.get(), OrbitalstrikemissileentityEntity.createAttributes().build());
		event.put(OMEGAEXPLOSION.get(), OmegaexplosionEntity.createAttributes().build());
		event.put(PVO_ENTITY.get(), PvoEntityEntity.createAttributes().build());
		event.put(LOCATOR_2.get(), Locator2Entity.createAttributes().build());
		event.put(LOCAT_3.get(), Locat3Entity.createAttributes().build());
		event.put(OMEGA_EMPTY_ENTITY.get(), OmegaEmptyEntityEntity.createAttributes().build());
		event.put(MUSHROOM_EXPLOSION_ENTITY.get(), MushroomExplosionEntityEntity.createAttributes().build());
		event.put(LIGHT_EXPLOSION.get(), LightExplosionEntity.createAttributes().build());
		event.put(BROKEN_LOCATOR_ANT.get(), BrokenLocatorAntEntity.createAttributes().build());
		event.put(EMPM_INAIR.get(), EMPMInairEntity.createAttributes().build());
	}
}
