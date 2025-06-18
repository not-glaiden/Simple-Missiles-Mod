package com.glaib04kaden.simplemissiles.item;

import com.glaib04kaden.simplemissiles.SimpleMissiles;
import com.glaib04kaden.simplemissiles.util.what_a_core_secret_b04ka_lib.TaggedRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SMItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, SimpleMissiles.MODID);

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item, String tags) {
        return TaggedRegistry.taggedRegisterItem(name, item, tags, ITEMS);
    }
}
