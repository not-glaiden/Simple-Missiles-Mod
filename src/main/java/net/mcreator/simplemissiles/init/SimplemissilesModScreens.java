
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.mcreator.simplemissiles.revamp.gui.LaunchpadScreen;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.simplemissiles.client.gui.OmegaMissileGuiScreen;
import net.mcreator.simplemissiles.client.gui.MissilelocatorguiScreen;
import net.mcreator.simplemissiles.client.gui.Manualpage3Screen;
import net.mcreator.simplemissiles.client.gui.Manualp1Screen;
import net.mcreator.simplemissiles.client.gui.ManualPage2Screen;
import net.mcreator.simplemissiles.client.gui.LocatorGuiScreen;
import net.mcreator.simplemissiles.client.gui.LaunchPadGuiScreen;
import net.mcreator.simplemissiles.client.gui.GadgetGuiScreen;
import net.mcreator.simplemissiles.client.gui.BMDScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SimplemissilesModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SimplemissilesModMenus.LAUNCH_PAD_GUI.get(), LaunchPadGuiScreen::new);
			MenuScreens.register(SimplemissilesModMenus.BMD.get(), BMDScreen::new);
			MenuScreens.register(SimplemissilesModMenus.LOCATOR_GUI.get(), LocatorGuiScreen::new);
			MenuScreens.register(SimplemissilesModMenus.GADGET_GUI.get(), GadgetGuiScreen::new);
			MenuScreens.register(SimplemissilesModMenus.MISSILELOCATORGUI.get(), MissilelocatorguiScreen::new);
			MenuScreens.register(SimplemissilesModMenus.MANUALP_1.get(), Manualp1Screen::new);
			MenuScreens.register(SimplemissilesModMenus.MANUAL_PAGE_2.get(), ManualPage2Screen::new);
			MenuScreens.register(SimplemissilesModMenus.MANUALPAGE_3.get(), Manualpage3Screen::new);
			MenuScreens.register(SimplemissilesModMenus.OMEGA_MISSILE_GUI.get(), OmegaMissileGuiScreen::new);

			MenuScreens.register(SimplemissilesModMenus.LAUNCHPAD_MENU.get(), LaunchpadScreen::new);
		});
	}
}
