package net.mcreator.simplemissiles.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.simplemissiles.init.SimplemissilesModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AfddshtpishchiykushchmuProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SimplemissilesModBlocks.TNT_MISSLE_FALLING.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SimplemissilesModBlocks.TNT_MISSLE_FALLING.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 100, _player.inventoryMenu.getCraftSlots());
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SimplemissilesModBlocks.OMEGA_MISSLE_FALLING.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SimplemissilesModBlocks.OMEGA_MISSLE_FALLING.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 100, _player.inventoryMenu.getCraftSlots());
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SimplemissilesModBlocks.FALLING_NAPALM.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SimplemissilesModBlocks.FALLING_NAPALM.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 100, _player.inventoryMenu.getCraftSlots());
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SimplemissilesModBlocks.CLUSTER_BOMB_FALLING.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SimplemissilesModBlocks.CLUSTER_BOMB_FALLING.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 100, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
