
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.simplemissiles.item.ThrusterItem;
import net.mcreator.simplemissiles.item.NightVisionleensItem;
import net.mcreator.simplemissiles.item.NavigationSystemItem;
import net.mcreator.simplemissiles.item.ManualItem;
import net.mcreator.simplemissiles.item.LeensItem;
import net.mcreator.simplemissiles.item.HazmatArmorArmorItem;
import net.mcreator.simplemissiles.item.GeigerCounterItem;
import net.mcreator.simplemissiles.item.DesecratedNetherStarItem;
import net.mcreator.simplemissiles.item.CoordinatesFastChangerItem;
import net.mcreator.simplemissiles.item.BulletItem;
import net.mcreator.simplemissiles.item.BinocularsItem;
import net.mcreator.simplemissiles.SimplemissilesMod;

public class SimplemissilesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SimplemissilesMod.MODID);
	public static final RegistryObject<Item> LAUNCHPAD = block(SimplemissilesModBlocks.LAUNCHPAD);
	public static final RegistryObject<Item> TNT_MISSLE = block(SimplemissilesModBlocks.TNT_MISSLE);
	public static final RegistryObject<Item> TNT_MISSLE_FALLING = block(SimplemissilesModBlocks.TNT_MISSLE_FALLING);
	public static final RegistryObject<Item> TNT_MISSLE_ENTITY_SPAWN_EGG = REGISTRY.register("tnt_missle_entity_spawn_egg", () -> new ForgeSpawnEggItem(SimplemissilesModEntities.TNT_MISSLE_ENTITY, -1, -6750208, new Item.Properties()));
	public static final RegistryObject<Item> COORDINATES_FAST_CHANGER = REGISTRY.register("coordinates_fast_changer", () -> new CoordinatesFastChangerItem());
	public static final RegistryObject<Item> NAPALM_MISSLE = block(SimplemissilesModBlocks.NAPALM_MISSLE);
	public static final RegistryObject<Item> NAPALM_ENTITY_SPAWN_EGG = REGISTRY.register("napalm_entity_spawn_egg", () -> new ForgeSpawnEggItem(SimplemissilesModEntities.NAPALM_ENTITY, -39424, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> FALLING_NAPALM = block(SimplemissilesModBlocks.FALLING_NAPALM);
	public static final RegistryObject<Item> CLUSTER_BOMB_ENTITY_SPAWN_EGG = REGISTRY.register("cluster_bomb_entity_spawn_egg", () -> new ForgeSpawnEggItem(SimplemissilesModEntities.CLUSTER_BOMB_ENTITY, -16777216, -1, new Item.Properties()));
	public static final RegistryObject<Item> CLUSTER_BOMB = block(SimplemissilesModBlocks.CLUSTER_BOMB);
	public static final RegistryObject<Item> CLUSTER_BOMB_FALLING = block(SimplemissilesModBlocks.CLUSTER_BOMB_FALLING);
	public static final RegistryObject<Item> TRAPDOORCLOSED = block(SimplemissilesModBlocks.TRAPDOORCLOSED);
	public static final RegistryObject<Item> TRAPDOOROPEN = block(SimplemissilesModBlocks.TRAPDOOROPEN);
	public static final RegistryObject<Item> OMEGA_MISSLE = block(SimplemissilesModBlocks.OMEGA_MISSLE);
	public static final RegistryObject<Item> OMEGA_MISSLE_FALLING = block(SimplemissilesModBlocks.OMEGA_MISSLE_FALLING);
	public static final RegistryObject<Item> OMEGA_ENTITY_SPAWN_EGG = REGISTRY.register("omega_entity_spawn_egg", () -> new ForgeSpawnEggItem(SimplemissilesModEntities.OMEGA_ENTITY, -16777216, -6711040, new Item.Properties()));
	public static final RegistryObject<Item> OMEGACORE = block(SimplemissilesModBlocks.OMEGACORE);
	public static final RegistryObject<Item> TEST_PVO = block(SimplemissilesModBlocks.TEST_PVO);
	public static final RegistryObject<Item> BINOCULARS = REGISTRY.register("binoculars", () -> new BinocularsItem());
	public static final RegistryObject<Item> LEENS = REGISTRY.register("leens", () -> new LeensItem());
	public static final RegistryObject<Item> NIGHT_VISIONLEENS = REGISTRY.register("night_visionleens", () -> new NightVisionleensItem());
	public static final RegistryObject<Item> PLAYERLOCATOR = block(SimplemissilesModBlocks.PLAYERLOCATOR);
	public static final RegistryObject<Item> ORBITALLASERMISSILE = block(SimplemissilesModBlocks.ORBITALLASERMISSILE);
	public static final RegistryObject<Item> ORBITALLASERSHOOT = block(SimplemissilesModBlocks.ORBITALLASERSHOOT);
	public static final RegistryObject<Item> LASERMISSILEBROKEN = block(SimplemissilesModBlocks.LASERMISSILEBROKEN);
	public static final RegistryObject<Item> DESECRATED_NETHER_STAR = REGISTRY.register("desecrated_nether_star", () -> new DesecratedNetherStarItem());
	public static final RegistryObject<Item> DATA_TRANSFERBLOCK = block(SimplemissilesModBlocks.DATA_TRANSFERBLOCK);
	public static final RegistryObject<Item> CONSOLE = block(SimplemissilesModBlocks.CONSOLE);
	public static final RegistryObject<Item> DATA_TRANSFERBLOCKRECIEVE = block(SimplemissilesModBlocks.DATA_TRANSFERBLOCKRECIEVE);
	public static final RegistryObject<Item> OMEGAEXPLOSION_SPAWN_EGG = REGISTRY.register("omegaexplosion_spawn_egg", () -> new ForgeSpawnEggItem(SimplemissilesModEntities.OMEGAEXPLOSION, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> GEIGER_COUNTER = REGISTRY.register("geiger_counter", () -> new GeigerCounterItem());
	public static final RegistryObject<Item> EFFECT_MISSILE_FALLING = block(SimplemissilesModBlocks.EFFECT_MISSILE_FALLING);
	public static final RegistryObject<Item> THRUSTER = REGISTRY.register("thruster", () -> new ThrusterItem());
	public static final RegistryObject<Item> NAVIGATION_SYSTEM = REGISTRY.register("navigation_system", () -> new NavigationSystemItem());
	public static final RegistryObject<Item> MISSILELOCATOR = block(SimplemissilesModBlocks.MISSILELOCATOR);
	public static final RegistryObject<Item> MISSILELOCATORFOUND = block(SimplemissilesModBlocks.MISSILELOCATORFOUND);
	public static final RegistryObject<Item> MANUAL = REGISTRY.register("manual", () -> new ManualItem());
	public static final RegistryObject<Item> PLASMA = block(SimplemissilesModBlocks.PLASMA);
	public static final RegistryObject<Item> OMEGA_EMPTY_ENTITY_SPAWN_EGG = REGISTRY.register("omega_empty_entity_spawn_egg", () -> new ForgeSpawnEggItem(SimplemissilesModEntities.OMEGA_EMPTY_ENTITY, -16777216, -6711040, new Item.Properties()));
	public static final RegistryObject<Item> OMEGA_ENTITY_MISSILE_FALIING_EMPTY = block(SimplemissilesModBlocks.OMEGA_ENTITY_MISSILE_FALIING_EMPTY);
	public static final RegistryObject<Item> MUSHROOM_EXPLOSION_ENTITY_SPAWN_EGG = REGISTRY.register("mushroom_explosion_entity_spawn_egg",
			() -> new ForgeSpawnEggItem(SimplemissilesModEntities.MUSHROOM_EXPLOSION_ENTITY, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> LIGHT_EXPLOSION_SPAWN_EGG = REGISTRY.register("light_explosion_spawn_egg", () -> new ForgeSpawnEggItem(SimplemissilesModEntities.LIGHT_EXPLOSION, -256, -13312, new Item.Properties()));
	public static final RegistryObject<Item> BULLET = REGISTRY.register("bullet", () -> new BulletItem());
	public static final RegistryObject<Item> OVERLOADED_REDSTONEBLOCK = block(SimplemissilesModBlocks.OVERLOADED_REDSTONEBLOCK);
	public static final RegistryObject<Item> BURNED_REPEATER = block(SimplemissilesModBlocks.BURNED_REPEATER);
	public static final RegistryObject<Item> EMP_MISSILE = block(SimplemissilesModBlocks.EMP_MISSILE);
	public static final RegistryObject<Item> BURNED_COMPARATOR = block(SimplemissilesModBlocks.BURNED_COMPARATOR);
	public static final RegistryObject<Item> HAZMAT_ARMOR_ARMOR_HELMET = REGISTRY.register("hazmat_armor_armor_helmet", () -> new HazmatArmorArmorItem.Helmet());
	public static final RegistryObject<Item> HAZMAT_ARMOR_ARMOR_CHESTPLATE = REGISTRY.register("hazmat_armor_armor_chestplate", () -> new HazmatArmorArmorItem.Chestplate());
	public static final RegistryObject<Item> HAZMAT_ARMOR_ARMOR_LEGGINGS = REGISTRY.register("hazmat_armor_armor_leggings", () -> new HazmatArmorArmorItem.Leggings());
	public static final RegistryObject<Item> HAZMAT_ARMOR_ARMOR_BOOTS = REGISTRY.register("hazmat_armor_armor_boots", () -> new HazmatArmorArmorItem.Boots());
	public static final RegistryObject<Item> MISSILE_LOCATORBURNED = block(SimplemissilesModBlocks.MISSILE_LOCATORBURNED);
	public static final RegistryObject<Item> PLAYER_LOCATOR_OVERLOADED = block(SimplemissilesModBlocks.PLAYER_LOCATOR_OVERLOADED);
	public static final RegistryObject<Item> OVERLOADED_BMD = block(SimplemissilesModBlocks.OVERLOADED_BMD);
	public static final RegistryObject<Item> EMPSTABLE = block(SimplemissilesModBlocks.EMPSTABLE);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
