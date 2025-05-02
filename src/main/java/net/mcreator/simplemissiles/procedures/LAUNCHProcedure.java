package net.mcreator.simplemissiles.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModEntities;
import net.mcreator.simplemissiles.init.SimplemissilesModBlocks;
import net.mcreator.simplemissiles.SimplemissilesMod;

public class LAUNCHProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (SimplemissilesModBlocks.LAUNCHPAD_OLD.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (SimplemissilesModBlocks.TNT_MISSLE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = SimplemissilesModEntities.TNT_MISSLE_ENTITY.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, 2);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, 2, false);
					}
				}
			}
			if (SimplemissilesModBlocks.NAPALM_MISSLE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = SimplemissilesModEntities.NAPALM_ENTITY.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, 1, false);
					}
				}
			}
			if (SimplemissilesModBlocks.CLUSTER_BOMB.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = SimplemissilesModEntities.CLUSTER_BOMB_ENTITY.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, -1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, -1, false);
					}
				}
			}
			if (SimplemissilesModBlocks.OMEGA_MISSLE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = SimplemissilesModEntities.OMEGA_ENTITY.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, -5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, -5, false);
					}
				}
			}
			if (SimplemissilesModBlocks.ORBITALLASERMISSILE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = SimplemissilesModEntities.ORBITALSTRIKEMISSILEENTITY.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, -2);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, -2, false);
					}
				}
			}
			if (SimplemissilesModBlocks.EMPSTABLE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = SimplemissilesModEntities.EMPM_INAIR.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:startingmissle")), SoundSource.NEUTRAL, 3, 1, false);
					}
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("launch", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			SimplemissilesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("launch", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			});
		}
	}
}
