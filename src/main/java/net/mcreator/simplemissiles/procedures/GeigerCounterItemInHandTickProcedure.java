package net.mcreator.simplemissiles.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModItems;

import java.util.concurrent.atomic.AtomicReference;

public class GeigerCounterItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double diamonds = 0;
		diamonds = 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (SimplemissilesModItems.DESECRATED_NETHER_STAR.get() == itemstackiterator.getItem()) {
						diamonds = diamonds + itemstackiterator.getCount();
					}
				}
			}
		}
		entity.getPersistentData().putDouble("mSvt", 0);
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SimplemissilesModItems.DESECRATED_NETHER_STAR.get())) : false) {
			for (int index0 = 0; index0 < (int) diamonds; index0++) {
				if (1 == Mth.nextInt(RandomSource.create(), 1, 10)) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				entity.getPersistentData().putDouble("mSvt", (entity.getPersistentData().getDouble("mSvt") + 0.3));
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("simplemissiles:deadlands"))) {
			if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			entity.getPersistentData().putDouble("mSvt", (entity.getPersistentData().getDouble("mSvt") + 1));
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BUBBLE_COLUMN) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				entity.getPersistentData().putDouble("mSvt", (entity.getPersistentData().getDouble("mSvt") + 4));
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("simplemissiles:strong_deadlands"))) {
			if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			entity.getPersistentData().putDouble("mSvt", (entity.getPersistentData().getDouble("mSvt") + 4));
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BUBBLE_COLUMN) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				entity.getPersistentData().putDouble("mSvt", (entity.getPersistentData().getDouble("mSvt") + 12));
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("simplemissiles:weak_deadlands"))) {
			if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			entity.getPersistentData().putDouble("mSvt", (entity.getPersistentData().getDouble("mSvt") + 0.1));
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BUBBLE_COLUMN) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				entity.getPersistentData().putDouble("mSvt", (entity.getPersistentData().getDouble("mSvt") + 1));
			}
		}
		if (1 == Mth.nextInt(RandomSource.create(), 1, 200)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:geiger_counter")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
