package com.glaib04kaden.simplemissiles.block.entity;

import com.glaib04kaden.simplemissiles.SimpleMissiles;
import com.glaib04kaden.simplemissiles.block.SMBlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SMBlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, SimpleMissiles.MODID);

    public static final Supplier<BlockEntityType<LaunchpadBlockEntity>> LAUNCHPAD_BE =
            BLOCK_ENTITIES.register("launchpad_be", () ->
                    BlockEntityType.Builder.of(LaunchpadBlockEntity::new,
                            SMBlockRegistry.LAUNCHPAD.get()).build(null));
}
