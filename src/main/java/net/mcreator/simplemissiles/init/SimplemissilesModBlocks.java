
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.simplemissiles.block.TrapdooropenBlock;
import net.mcreator.simplemissiles.block.TrapdoorclosedBlock;
import net.mcreator.simplemissiles.block.TntMissleFallingBlock;
import net.mcreator.simplemissiles.block.TntMissleBlock;
import net.mcreator.simplemissiles.block.TestPVOBlock;
import net.mcreator.simplemissiles.block.PlayerlocatorBlock;
import net.mcreator.simplemissiles.block.PlayerLocatorOverloadedBlock;
import net.mcreator.simplemissiles.block.PlasmaBlock;
import net.mcreator.simplemissiles.block.OverloadedRedstoneblockBlock;
import net.mcreator.simplemissiles.block.OverloadedBMDBlock;
import net.mcreator.simplemissiles.block.OrbitallasershootBlock;
import net.mcreator.simplemissiles.block.OrbitallasermissileBlock;
import net.mcreator.simplemissiles.block.OmegacoreBlock;
import net.mcreator.simplemissiles.block.OmegaMissleFallingBlock;
import net.mcreator.simplemissiles.block.OmegaMissleBlock;
import net.mcreator.simplemissiles.block.OmegaEntityMissileFaliingEmptyBlock;
import net.mcreator.simplemissiles.block.NapalmMissleBlock;
import net.mcreator.simplemissiles.block.MissilelocatorfoundBlock;
import net.mcreator.simplemissiles.block.MissilelocatorBlock;
import net.mcreator.simplemissiles.block.MissileLocatorburnedBlock;
import net.mcreator.simplemissiles.block.LaunchpadBlockOld;
import net.mcreator.simplemissiles.block.LasermissilebrokenBlock;
import net.mcreator.simplemissiles.block.FallingNapalmBlock;
import net.mcreator.simplemissiles.block.EmpMissileBlock;
import net.mcreator.simplemissiles.block.EffectMissileFallingBlock;
import net.mcreator.simplemissiles.block.EMPSTABLEBlock;
import net.mcreator.simplemissiles.block.DataTransferblockrecieveBlock;
import net.mcreator.simplemissiles.block.DataTransferblockBlock;
import net.mcreator.simplemissiles.block.ConsoleBlock;
import net.mcreator.simplemissiles.block.ClusterBombFallingBlock;
import net.mcreator.simplemissiles.block.ClusterBombBlock;
import net.mcreator.simplemissiles.block.BurnedRepeaterBlock;
import net.mcreator.simplemissiles.block.BurnedComparatorBlock;
import net.mcreator.simplemissiles.SimplemissilesMod;

public class SimplemissilesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SimplemissilesMod.MODID);
	public static final RegistryObject<Block> LAUNCHPAD_OLD = REGISTRY.register("launchpad_old", () -> new LaunchpadBlockOld());
	public static final RegistryObject<Block> TNT_MISSLE = REGISTRY.register("tnt_missle", () -> new TntMissleBlock());
	public static final RegistryObject<Block> TNT_MISSLE_FALLING = REGISTRY.register("tnt_missle_falling", () -> new TntMissleFallingBlock());
	public static final RegistryObject<Block> NAPALM_MISSLE = REGISTRY.register("napalm_missle", () -> new NapalmMissleBlock());
	public static final RegistryObject<Block> FALLING_NAPALM = REGISTRY.register("falling_napalm", () -> new FallingNapalmBlock());
	public static final RegistryObject<Block> CLUSTER_BOMB = REGISTRY.register("cluster_bomb", () -> new ClusterBombBlock());
	public static final RegistryObject<Block> CLUSTER_BOMB_FALLING = REGISTRY.register("cluster_bomb_falling", () -> new ClusterBombFallingBlock());
	public static final RegistryObject<Block> TRAPDOORCLOSED = REGISTRY.register("trapdoorclosed", () -> new TrapdoorclosedBlock());
	public static final RegistryObject<Block> TRAPDOOROPEN = REGISTRY.register("trapdooropen", () -> new TrapdooropenBlock());
	public static final RegistryObject<Block> OMEGA_MISSLE = REGISTRY.register("omega_missle", () -> new OmegaMissleBlock());
	public static final RegistryObject<Block> OMEGA_MISSLE_FALLING = REGISTRY.register("omega_missle_falling", () -> new OmegaMissleFallingBlock());
	public static final RegistryObject<Block> OMEGACORE = REGISTRY.register("omegacore", () -> new OmegacoreBlock());
	public static final RegistryObject<Block> TEST_PVO = REGISTRY.register("test_pvo", () -> new TestPVOBlock());
	public static final RegistryObject<Block> PLAYERLOCATOR = REGISTRY.register("playerlocator", () -> new PlayerlocatorBlock());
	public static final RegistryObject<Block> ORBITALLASERMISSILE = REGISTRY.register("orbitallasermissile", () -> new OrbitallasermissileBlock());
	public static final RegistryObject<Block> ORBITALLASERSHOOT = REGISTRY.register("orbitallasershoot", () -> new OrbitallasershootBlock());
	public static final RegistryObject<Block> LASERMISSILEBROKEN = REGISTRY.register("lasermissilebroken", () -> new LasermissilebrokenBlock());
	public static final RegistryObject<Block> DATA_TRANSFERBLOCK = REGISTRY.register("data_transferblock", () -> new DataTransferblockBlock());
	public static final RegistryObject<Block> CONSOLE = REGISTRY.register("console", () -> new ConsoleBlock());
	public static final RegistryObject<Block> DATA_TRANSFERBLOCKRECIEVE = REGISTRY.register("data_transferblockrecieve", () -> new DataTransferblockrecieveBlock());
	public static final RegistryObject<Block> EFFECT_MISSILE_FALLING = REGISTRY.register("effect_missile_falling", () -> new EffectMissileFallingBlock());
	public static final RegistryObject<Block> MISSILELOCATOR = REGISTRY.register("missilelocator", () -> new MissilelocatorBlock());
	public static final RegistryObject<Block> MISSILELOCATORFOUND = REGISTRY.register("missilelocatorfound", () -> new MissilelocatorfoundBlock());
	public static final RegistryObject<Block> PLASMA = REGISTRY.register("plasma", () -> new PlasmaBlock());
	public static final RegistryObject<Block> OMEGA_ENTITY_MISSILE_FALIING_EMPTY = REGISTRY.register("omega_entity_missile_faliing_empty", () -> new OmegaEntityMissileFaliingEmptyBlock());
	public static final RegistryObject<Block> OVERLOADED_REDSTONEBLOCK = REGISTRY.register("overloaded_redstoneblock", () -> new OverloadedRedstoneblockBlock());
	public static final RegistryObject<Block> BURNED_REPEATER = REGISTRY.register("burned_repeater", () -> new BurnedRepeaterBlock());
	public static final RegistryObject<Block> EMP_MISSILE = REGISTRY.register("emp_missile", () -> new EmpMissileBlock());
	public static final RegistryObject<Block> BURNED_COMPARATOR = REGISTRY.register("burned_comparator", () -> new BurnedComparatorBlock());
	public static final RegistryObject<Block> MISSILE_LOCATORBURNED = REGISTRY.register("missile_locatorburned", () -> new MissileLocatorburnedBlock());
	public static final RegistryObject<Block> PLAYER_LOCATOR_OVERLOADED = REGISTRY.register("player_locator_overloaded", () -> new PlayerLocatorOverloadedBlock());
	public static final RegistryObject<Block> OVERLOADED_BMD = REGISTRY.register("overloaded_bmd", () -> new OverloadedBMDBlock());
	public static final RegistryObject<Block> EMPSTABLE = REGISTRY.register("empstable", () -> new EMPSTABLEBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks

	public static final RegistryObject<Block> LAUNCHPAD = REGISTRY.register("launchpad", () -> new net.mcreator.simplemissiles.revamp.block.LaunchpadBlock());
}
