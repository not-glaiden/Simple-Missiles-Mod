
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simplemissiles.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.simplemissiles.SimplemissilesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SimplemissilesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimplemissilesMod.MODID);
	public static final RegistryObject<CreativeModeTab> SIMPLE_NUKES = REGISTRY.register("simple_nukes",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.simplemissiles.simple_nukes")).icon(() -> new ItemStack(SimplemissilesModBlocks.TNT_MISSLE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SimplemissilesModBlocks.LAUNCHPAD_OLD.get().asItem());
				tabData.accept(SimplemissilesModBlocks.TNT_MISSLE.get().asItem());
				tabData.accept(SimplemissilesModItems.COORDINATES_FAST_CHANGER.get());
				tabData.accept(SimplemissilesModBlocks.NAPALM_MISSLE.get().asItem());
				tabData.accept(SimplemissilesModBlocks.CLUSTER_BOMB.get().asItem());
				tabData.accept(SimplemissilesModBlocks.TRAPDOORCLOSED.get().asItem());
				tabData.accept(SimplemissilesModBlocks.OMEGA_MISSLE.get().asItem());
				tabData.accept(SimplemissilesModBlocks.OMEGACORE.get().asItem());
				tabData.accept(SimplemissilesModBlocks.TEST_PVO.get().asItem());
				tabData.accept(SimplemissilesModItems.BINOCULARS.get());
				tabData.accept(SimplemissilesModItems.LEENS.get());
				tabData.accept(SimplemissilesModItems.NIGHT_VISIONLEENS.get());
				tabData.accept(SimplemissilesModBlocks.PLAYERLOCATOR.get().asItem());
				tabData.accept(SimplemissilesModItems.DESECRATED_NETHER_STAR.get());
				tabData.accept(SimplemissilesModBlocks.DATA_TRANSFERBLOCK.get().asItem());
				tabData.accept(SimplemissilesModBlocks.CONSOLE.get().asItem());
				tabData.accept(SimplemissilesModItems.OMEGAEXPLOSION_SPAWN_EGG.get());
				tabData.accept(SimplemissilesModItems.GEIGER_COUNTER.get());
				tabData.accept(SimplemissilesModItems.THRUSTER.get());
				tabData.accept(SimplemissilesModItems.NAVIGATION_SYSTEM.get());
				tabData.accept(SimplemissilesModBlocks.MISSILELOCATOR.get().asItem());
				tabData.accept(SimplemissilesModBlocks.MISSILELOCATORFOUND.get().asItem());
				tabData.accept(SimplemissilesModItems.MANUAL.get());
				tabData.accept(SimplemissilesModItems.BULLET.get());
				tabData.accept(SimplemissilesModBlocks.OVERLOADED_REDSTONEBLOCK.get().asItem());
				tabData.accept(SimplemissilesModBlocks.BURNED_REPEATER.get().asItem());
				tabData.accept(SimplemissilesModBlocks.BURNED_COMPARATOR.get().asItem());
				tabData.accept(SimplemissilesModItems.HAZMAT_ARMOR_ARMOR_HELMET.get());
				tabData.accept(SimplemissilesModItems.HAZMAT_ARMOR_ARMOR_CHESTPLATE.get());
				tabData.accept(SimplemissilesModItems.HAZMAT_ARMOR_ARMOR_LEGGINGS.get());
				tabData.accept(SimplemissilesModItems.HAZMAT_ARMOR_ARMOR_BOOTS.get());
				tabData.accept(SimplemissilesModBlocks.MISSILE_LOCATORBURNED.get().asItem());
				tabData.accept(SimplemissilesModBlocks.PLAYER_LOCATOR_OVERLOADED.get().asItem());
				tabData.accept(SimplemissilesModBlocks.OVERLOADED_BMD.get().asItem());
				tabData.accept(SimplemissilesModBlocks.EMPSTABLE.get().asItem());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(SimplemissilesModItems.TNT_MISSLE_ENTITY_SPAWN_EGG.get());
			tabData.accept(SimplemissilesModItems.NAPALM_ENTITY_SPAWN_EGG.get());
			tabData.accept(SimplemissilesModItems.CLUSTER_BOMB_ENTITY_SPAWN_EGG.get());
			tabData.accept(SimplemissilesModItems.OMEGA_ENTITY_SPAWN_EGG.get());
			tabData.accept(SimplemissilesModItems.OMEGA_EMPTY_ENTITY_SPAWN_EGG.get());
			tabData.accept(SimplemissilesModItems.MUSHROOM_EXPLOSION_ENTITY_SPAWN_EGG.get());
			tabData.accept(SimplemissilesModItems.LIGHT_EXPLOSION_SPAWN_EGG.get());
		}
	}
}
