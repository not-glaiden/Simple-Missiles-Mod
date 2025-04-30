package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.simplemissiles.SimplemissilesMod;

public class OmegaexplosionOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((0.5 * Math.cos(entity.getYRot())), 0, (0.5 * Math.sin(entity.getYRot()))));
		SimplemissilesMod.queueServerWork(200, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
		if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("simplemissiles:deadlands"))) {
			if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fillbiome ~-4 ~-20 ~-4 ~4 ~20 ~4 simplemissiles:strong_deadlands");
			} else {
				if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fillbiome ~-4 ~-20 ~-4 ~4 ~20 ~4 simplemissiles:weak_deadlands");
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fillbiome ~-4 ~-20 ~-4 ~4 ~20 ~4 simplemissiles:deadlands");
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~6 ~6 ~6 ~-6 ~-6 ~-6 minecraft:fire replace minecraft:air");
			if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, (y + 10), z, 6, Level.ExplosionInteraction.TNT);
			}
		}
		entity.getPersistentData().putDouble("count", (1 + entity.getPersistentData().getDouble("count")));
		if (26 == entity.getPersistentData().getDouble("count")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 8, Level.ExplosionInteraction.TNT);
			entity.getPersistentData().putDouble("count", 0);
		}
	}
}
