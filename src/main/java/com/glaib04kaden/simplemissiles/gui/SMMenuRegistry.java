package com.glaib04kaden.simplemissiles.gui;

import com.glaib04kaden.simplemissiles.SimpleMissiles;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SMMenuRegistry {
    public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(Registries.MENU, SimpleMissiles.MODID);

    public static final Supplier<MenuType<LaunchpadMenu>> LAUNCHPAD_MENU = registerMenuType("launchpad", LaunchpadMenu::new);

    private static <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENU.register(name, () -> IForgeMenuType.create(factory));
    }
}
