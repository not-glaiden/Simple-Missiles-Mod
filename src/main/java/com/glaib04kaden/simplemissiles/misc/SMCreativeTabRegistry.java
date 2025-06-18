package com.glaib04kaden.simplemissiles.misc;

import com.glaib04kaden.simplemissiles.SimpleMissiles;
import com.glaib04kaden.simplemissiles.block.SMBlockRegistry;
import com.glaib04kaden.simplemissiles.util.what_a_core_secret_b04ka_lib.TaggedRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SMCreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleMissiles.MODID);
    public static final List<Item> ITEM_LIST = new ArrayList<>();
    public static final List<Block> BLOCK_LIST = new ArrayList<>();

    public static final TaggedRegistry.RegisterTag CREATIVE_TAB_TAG = new TaggedRegistry.RegisterTag("tab", supplier -> {
        if (supplier.get() instanceof Item item) {
            ITEM_LIST.add(item);
        } else if (supplier.get() instanceof Block block) {
            BLOCK_LIST.add(block);
        }
    });

    public static final Supplier<CreativeModeTab> SIMPLE_MISSILES = CREATIVE_MODE_TAB.register("simple_missiles_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SMBlockRegistry.LAUNCHPAD.get()))
                    .title(Component.translatable("item_group.simplenukes.simple_nukes"))
                    .displayItems(((parameters, output) -> {
                        ITEM_LIST.forEach(output::accept);
                        BLOCK_LIST.forEach(output::accept);
                    }))
                    .build());
}
