
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.simplemissiles.block.entity.TestPVOBlockEntity;
import net.mcreator.simplemissiles.block.entity.PlayerlocatorBlockEntity;
import net.mcreator.simplemissiles.block.entity.OrbitallasershootBlockEntity;
import net.mcreator.simplemissiles.block.entity.LaunchpadBlockEntity;
import net.mcreator.simplemissiles.block.entity.DataTransferblockBlockEntity;
import net.mcreator.simplemissiles.block.entity.ConsoleBlockEntity;
import net.mcreator.simplemissiles.SimplemissilesMod;

public class SimplemissilesModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SimplemissilesMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> LAUNCHPAD = register("launchpad", SimplemissilesModBlocks.LAUNCHPAD, LaunchpadBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TEST_PVO = register("test_pvo", SimplemissilesModBlocks.TEST_PVO, TestPVOBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PLAYERLOCATOR = register("playerlocator", SimplemissilesModBlocks.PLAYERLOCATOR, PlayerlocatorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ORBITALLASERSHOOT = register("orbitallasershoot", SimplemissilesModBlocks.ORBITALLASERSHOOT, OrbitallasershootBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DATA_TRANSFERBLOCK = register("data_transferblock", SimplemissilesModBlocks.DATA_TRANSFERBLOCK, DataTransferblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CONSOLE = register("console", SimplemissilesModBlocks.CONSOLE, ConsoleBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
