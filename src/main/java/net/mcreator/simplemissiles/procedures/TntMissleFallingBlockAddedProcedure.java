package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.simplemissiles.SimplemissilesMod;

import java.util.List;
import java.util.Comparator;

public class TntMissleFallingBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(1 == Mth.nextInt(RandomSource.create(), 1, 100))) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 20, 1, 1, 1, 0.5);
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT_PATH
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.ROOTED_DIRT
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.PODZOL) {
				for (int index0 = 0; index0 < 5; index0++) {
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -3, 3), y, z + Mth.nextInt(RandomSource.create(), -3, 3)), Blocks.DIRT.defaultBlockState());
				}
			}
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.TNT);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8000 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					{
						Entity _ent = entityiterator;
						_ent.setYRot((float) (entityiterator.getYRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
						_ent.setXRot((float) (entityiterator.getXRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
					SimplemissilesMod.queueServerWork(5, () -> {
						{
							Entity _ent = entityiterator;
							_ent.setYRot((float) (entityiterator.getYRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
							_ent.setXRot((float) (entityiterator.getXRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						SimplemissilesMod.queueServerWork(5, () -> {
							{
								Entity _ent = entityiterator;
								_ent.setYRot((float) (entityiterator.getYRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
								_ent.setXRot((float) (entityiterator.getXRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
							SimplemissilesMod.queueServerWork(5, () -> {
								{
									Entity _ent = entityiterator;
									_ent.setYRot((float) (entityiterator.getYRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
									_ent.setXRot((float) (entityiterator.getXRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
									_ent.setYBodyRot(_ent.getYRot());
									_ent.setYHeadRot(_ent.getYRot());
									_ent.yRotO = _ent.getYRot();
									_ent.xRotO = _ent.getXRot();
									if (_ent instanceof LivingEntity _entity) {
										_entity.yBodyRotO = _entity.getYRot();
										_entity.yHeadRotO = _entity.getYRot();
									}
								}
								SimplemissilesMod.queueServerWork(5, () -> {
									{
										Entity _ent = entityiterator;
										_ent.setYRot((float) (entityiterator.getYRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
										_ent.setXRot((float) (entityiterator.getXRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
										_ent.setYBodyRot(_ent.getYRot());
										_ent.setYHeadRot(_ent.getYRot());
										_ent.yRotO = _ent.getYRot();
										_ent.xRotO = _ent.getXRot();
										if (_ent instanceof LivingEntity _entity) {
											_entity.yBodyRotO = _entity.getYRot();
											_entity.yHeadRotO = _entity.getYRot();
										}
									}
								});
							});
						});
					});
				}
			}
		}
	}
}
