package com.glaib04kaden.simplemissiles.util.what_a_core_secret_b04ka_lib;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TaggedRegistry {
    public static final Map<Supplier<?>, String> TAG_MAP = new HashMap<>();

    public static final RegisterTag test = new RegisterTag("test", supplier -> {
        if (supplier.get() instanceof Block block) {
            System.out.println("boroovv");
        }
    });

    public static <T extends Block> Supplier<T> taggedRegisterBlock(String name, Supplier<T> block, String tags, DeferredRegister<Block> blockDeferredRegister, DeferredRegister<Item> itemDeferredRegister) {
        Supplier<T> toReturn = blockDeferredRegister.register(name, block);
        itemDeferredRegister.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        if (!tags.isEmpty()) {
            TAG_MAP.put(toReturn, tags);
        }
        return toReturn;
    }

    public static <T extends Item> Supplier<T> taggedRegisterItem(String name, Supplier<T> item, String tags, DeferredRegister<Item> itemDeferredRegister) {
        Supplier<T> toReturn = itemDeferredRegister.register(name, item);
        if (!tags.isEmpty()) {
            TAG_MAP.put(toReturn, tags);
        }
        return toReturn;
    }

    public static void performTagActions() {
        TaggedRegistry.TAG_MAP.forEach((blockSupplier, tags) -> {
            for (String key : RegisterTag.UTIL_MAP.keySet()) {
                if (tags.contains(key)) {
                    RegisterTag.UTIL_MAP.get(key).performAction(blockSupplier);
                }
            }
        });
    }

    public static class RegisterTag {
        public static final Map<String, RegisterTag> UTIL_MAP = new HashMap<>();
        private final Consumer<Supplier<?>> action;

        public RegisterTag(String id, Consumer<Supplier<?>> action) {
            this.action = action;
            UTIL_MAP.put(id, this);
        }

        protected void performAction(Supplier<?> blockSupplier) {
            this.action.accept(blockSupplier);
        }
    }
}
