package com.glaib04kaden.simplemissiles;

import com.glaib04kaden.simplemissiles.block.SMBlockRegistry;
import com.glaib04kaden.simplemissiles.block.entity.SMBlockEntityRegistry;
import com.glaib04kaden.simplemissiles.gui.LaunchpadScreen;
import com.glaib04kaden.simplemissiles.gui.SMMenuRegistry;
import com.glaib04kaden.simplemissiles.item.SMItemRegistry;
import com.glaib04kaden.simplemissiles.misc.SMCreativeTabRegistry;
import com.glaib04kaden.simplemissiles.network.SMPacketRegistry;
import com.glaib04kaden.simplemissiles.util.what_a_core_secret_b04ka_lib.TaggedRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("simplemissiles")
public class SimpleMissiles {
    public static final Logger LOGGER = LogManager.getLogger(SimpleMissiles.class);
    public static final String MODID = "simplemissiles";

    public SimpleMissiles() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        SMItemRegistry.ITEMS.register(bus);
        SMBlockRegistry.BLOCKS.register(bus);
        SMCreativeTabRegistry.CREATIVE_MODE_TAB.register(bus);
        SMMenuRegistry.MENU.register(bus);
        SMBlockEntityRegistry.BLOCK_ENTITIES.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        SMPacketRegistry.register();
        event.enqueueWork(() -> {
            TaggedRegistry.performTagActions();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(SMMenuRegistry.LAUNCHPAD_MENU.get(), LaunchpadScreen::new);
        });
    }
}
