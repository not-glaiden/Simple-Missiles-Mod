package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.network.SimplemissilesModVariables;
import net.mcreator.simplemissiles.init.SimplemissilesModBlocks;
import net.mcreator.simplemissiles.SimplemissilesMod;

public class OmegaMissileEmptyOnSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("x", (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y - 1, z), "x")));
		entity.getPersistentData().putDouble("z", (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y - 1, z), "z")));
		SimplemissilesMod.queueServerWork(200, () -> {
			if (entity.isAlive()) {
				if (world instanceof ServerLevel _level)
					FallingBlockEntity.fall(_level, BlockPos.containing(entity.getPersistentData().getDouble("x"), 300, entity.getPersistentData().getDouble("z")), SimplemissilesModBlocks.OMEGA_ENTITY_MISSILE_FALIING_EMPTY.get().defaultBlockState());
				if (!entity.level().isClientSide())
					entity.discard();
			}
		});
		if (!(Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() || Blocks.VOID_AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
				|| Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock())) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.TNT);
		}
		SimplemissilesModVariables.WorldVariables.get(world).Missiles_in_the_air = SimplemissilesModVariables.WorldVariables.get(world).Missiles_in_the_air + 1;
		SimplemissilesModVariables.WorldVariables.get(world).syncData(world);
		SimplemissilesMod.queueServerWork(400, () -> {
			SimplemissilesModVariables.WorldVariables.get(world).Missiles_in_the_air = SimplemissilesModVariables.WorldVariables.get(world).Missiles_in_the_air - 1;
			SimplemissilesModVariables.WorldVariables.get(world).syncData(world);
		});
	}
}
