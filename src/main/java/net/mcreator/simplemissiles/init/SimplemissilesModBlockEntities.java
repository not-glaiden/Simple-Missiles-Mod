
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.mcreator.simplemissiles.SimplemissilesMod;
import net.mcreator.simplemissiles.block.entity.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SimplemissilesModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SimplemissilesMod.MODID);
    public static final RegistryObject<BlockEntityType<?>> LAUNCHPAD_OLD = register("launchpad_old", SimplemissilesModBlocks.LAUNCHPAD_OLD, LaunchpadBlockEntityOld::new);
    public static final RegistryObject<BlockEntityType<?>> TEST_PVO = register("test_pvo", SimplemissilesModBlocks.TEST_PVO, TestPVOBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> PLAYERLOCATOR = register("playerlocator", SimplemissilesModBlocks.PLAYERLOCATOR, PlayerlocatorBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> ORBITALLASERSHOOT = register("orbitallasershoot", SimplemissilesModBlocks.ORBITALLASERSHOOT, OrbitallasershootBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> DATA_TRANSFERBLOCK = register("data_transferblock", SimplemissilesModBlocks.DATA_TRANSFERBLOCK, DataTransferblockBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> CONSOLE = register("console", SimplemissilesModBlocks.CONSOLE, ConsoleBlockEntity::new);

    private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }

    public static final RegistryObject<BlockEntityType<net.mcreator.simplemissiles.revamp.block.entity.LaunchpadBlockEntity>> LAUNCHPAD = REGISTRY.register("launchpad", () -> BlockEntityType.Builder.of(net.mcreator.simplemissiles.revamp.block.entity.LaunchpadBlockEntity::new, SimplemissilesModBlocks.LAUNCHPAD.get()).build(null));

}
