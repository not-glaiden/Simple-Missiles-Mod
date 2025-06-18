package com.glaib04kaden.simplemissiles.block;

import com.glaib04kaden.simplemissiles.SimpleMissiles;
import com.glaib04kaden.simplemissiles.item.SMItemRegistry;
import com.glaib04kaden.simplemissiles.util.what_a_core_secret_b04ka_lib.TaggedRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SMBlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, SimpleMissiles.MODID);

    public static final Supplier<LaunchpadBlock> LAUNCHPAD = registerBlock("launchpad", LaunchpadBlock::new, "tab");

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block, String tags) {
        return TaggedRegistry.taggedRegisterBlock(name, block, tags, BLOCKS, SMItemRegistry.ITEMS);
    }
}
