package net.mcreator.simplemissiles.procedures;

import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;

public class CoordsBinocularsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Math.round(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(500)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX()) + ""
				+ (" " + (Math
						.round(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(500)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getY())
						+ "" + (" " + Math.round(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(500)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity))
								.getBlockPos().getZ()))));
	}
}
