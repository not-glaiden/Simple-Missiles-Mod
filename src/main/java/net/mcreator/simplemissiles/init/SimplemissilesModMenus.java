
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.mcreator.simplemissiles.revamp.gui.LaunchpadMenu;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.simplemissiles.world.inventory.OmegaMissileGuiMenu;
import net.mcreator.simplemissiles.world.inventory.MissilelocatorguiMenu;
import net.mcreator.simplemissiles.world.inventory.Manualpage3Menu;
import net.mcreator.simplemissiles.world.inventory.Manualp1Menu;
import net.mcreator.simplemissiles.world.inventory.ManualPage2Menu;
import net.mcreator.simplemissiles.world.inventory.LocatorGuiMenu;
import net.mcreator.simplemissiles.world.inventory.LaunchPadGuiMenuOld;
import net.mcreator.simplemissiles.world.inventory.GadgetGuiMenu;
import net.mcreator.simplemissiles.world.inventory.BMDMenu;
import net.mcreator.simplemissiles.SimplemissilesMod;

public class SimplemissilesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SimplemissilesMod.MODID);
	public static final RegistryObject<MenuType<LaunchPadGuiMenuOld>> LAUNCH_PAD_GUI = REGISTRY.register("launch_pad_gui", () -> IForgeMenuType.create(LaunchPadGuiMenuOld::new));
	public static final RegistryObject<MenuType<BMDMenu>> BMD = REGISTRY.register("bmd", () -> IForgeMenuType.create(BMDMenu::new));
	public static final RegistryObject<MenuType<LocatorGuiMenu>> LOCATOR_GUI = REGISTRY.register("locator_gui", () -> IForgeMenuType.create(LocatorGuiMenu::new));
	public static final RegistryObject<MenuType<GadgetGuiMenu>> GADGET_GUI = REGISTRY.register("gadget_gui", () -> IForgeMenuType.create(GadgetGuiMenu::new));
	public static final RegistryObject<MenuType<MissilelocatorguiMenu>> MISSILELOCATORGUI = REGISTRY.register("missilelocatorgui", () -> IForgeMenuType.create(MissilelocatorguiMenu::new));
	public static final RegistryObject<MenuType<Manualp1Menu>> MANUALP_1 = REGISTRY.register("manualp_1", () -> IForgeMenuType.create(Manualp1Menu::new));
	public static final RegistryObject<MenuType<ManualPage2Menu>> MANUAL_PAGE_2 = REGISTRY.register("manual_page_2", () -> IForgeMenuType.create(ManualPage2Menu::new));
	public static final RegistryObject<MenuType<Manualpage3Menu>> MANUALPAGE_3 = REGISTRY.register("manualpage_3", () -> IForgeMenuType.create(Manualpage3Menu::new));
	public static final RegistryObject<MenuType<OmegaMissileGuiMenu>> OMEGA_MISSILE_GUI = REGISTRY.register("omega_missile_gui", () -> IForgeMenuType.create(OmegaMissileGuiMenu::new));

	public static final RegistryObject<MenuType<LaunchpadMenu>> LAUNCHPAD_MENU = REGISTRY.register("launchpad_menu", () -> IForgeMenuType.create(LaunchpadMenu::new));

}
