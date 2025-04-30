package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModBlocks;

public class OrbitalentontickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < 20; index0++) {
			world.addParticle(ParticleTypes.FLAME, x, y, z, 0, (-0.5), 0);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLASH, x, y, z, 1, 0, 0, 0, 0);
		world.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0, (-1), 0);
		world.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0, (-0.5), 0);
		world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0, (-0.5), 0);
		entity.getPersistentData().putDouble("speed", (entity.getPersistentData().getDouble("speed") + 0.01));
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y + entity.getPersistentData().getDouble("speed")), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y + entity.getPersistentData().getDouble("speed")), z, _ent.getYRot(), _ent.getXRot());
		}
		if (!(Blocks.VOID_AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() || Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
				|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() || SimplemissilesModBlocks.TRAPDOOROPEN.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock())) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.TNT);
		}
	}
}
