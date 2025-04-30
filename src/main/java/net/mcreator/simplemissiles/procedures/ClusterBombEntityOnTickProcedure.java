package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.init.SimplemissilesModBlocks;

public class ClusterBombEntityOnTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.addParticle(ParticleTypes.FLASH, x, (y - 1), z, 0, 0, 0);
		world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0, 0, 0);
		entity.getPersistentData().putDouble("speed", (entity.getPersistentData().getDouble("speed") + 0.1));
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y + entity.getPersistentData().getDouble("speed")), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y + entity.getPersistentData().getDouble("speed")), z, _ent.getYRot(), _ent.getXRot());
		}
		if (!(Blocks.VOID_AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() || Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
				|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() || SimplemissilesModBlocks.TRAPDOOROPEN.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock())) {
			ClusterBombEntityEntityDiesProcedure.execute(world, x, y, z, entity);
		}
	}
}
