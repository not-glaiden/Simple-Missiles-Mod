package net.mcreator.simplemissiles.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModParticleTypes;
import net.mcreator.simplemissiles.init.SimplemissilesModEntities;
import net.mcreator.simplemissiles.SimplemissilesMod;

import java.util.ArrayList;

public class OmegaMissleFallingBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		for (int index0 = 0; index0 < 200; index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SimplemissilesModEntities.OMEGAEXPLOSION.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
		for (int index1 = 0; index1 < 40; index1++) {
			if (world instanceof ServerLevel _level)
				FallingBlockEntity.fall(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -3, 3), y + 4, z + Mth.nextInt(RandomSource.create(), -3, 3)), (world.getBlockState(BlockPos.containing(x, y - 1, z))));
		}
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 90, Level.ExplosionInteraction.TNT);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (SimplemissilesModParticleTypes.EXPLOSION_PARTICLE.get()), x, (y + 15), z, 250, 5, 2, 5, 2);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:omegaexplosion")), SoundSource.NEUTRAL, 3, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:omegaexplosion")), SoundSource.NEUTRAL, 3, 1, false);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = SimplemissilesModEntities.MUSHROOM_EXPLOSION_ENTITY.get().spawn(_level, BlockPos.containing(x, y - 10, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = SimplemissilesModEntities.LIGHT_EXPLOSION.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		SimplemissilesMod.queueServerWork(30, () -> {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:distant_explosion")),
								SoundSource.NEUTRAL, 10, 1);
					} else {
						_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("simplemissiles:distant_explosion")), SoundSource.NEUTRAL, 10, 1,
								false);
					}
				}
				entityiterator.getPersistentData().putDouble("radiation", (entityiterator.getPersistentData().getDouble("radiation") + 0.05));
			}
		});
	}
}
