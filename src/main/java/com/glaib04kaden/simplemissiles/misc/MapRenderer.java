package com.glaib04kaden.simplemissiles.misc;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class MapRenderer {
    private static final int PLAYER_COLOR = 0xFFFF0000;
    private static final int BACKGROUND_COLOR = 0xFF000000;
    private static final int DEFAULT_COLOR = 0xFF333333;

    public static void render(GuiGraphics guiGraphics, Level level, int x, int z, int targetX, int targetZ, int radius, int scale) {
        if (level == null) return;

        final int diameter = radius * 2;
        final int mapSize = diameter * scale;
        final int arraySize = (diameter + 1) * (diameter + 1);

        guiGraphics.fill(x, z, mapSize, mapSize, BACKGROUND_COLOR);

        final int minY = level.getMinBuildHeight();
        final int maxY = level.getMaxBuildHeight();
        final int heightRange = maxY - minY;
        final int[] heightMap = new int[arraySize];
        int index = 0;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int dz = -radius; dz <= radius; dz++) {
            for (int dx = -radius; dx <= radius; dx++) {
                mutablePos.set(targetX + dx, maxY, targetZ + dz);
                heightMap[index++] = findTopSolidBlockY(level, mutablePos, minY);
            }
        }
        index = 0;
        final int centerOffset = radius * scale;
        final int playerMarkerSize = 2;

        for (int dz = -radius; dz <= radius; dz++) {
            for (int dx = -radius; dx <= radius; dx++) {
                int y = heightMap[index];
                mutablePos.set(targetX + dx, y, targetZ + dz);

                BlockState state = level.getBlockState(mutablePos);
                int color = getShadedColor(level, mutablePos, state, heightMap, index, radius, minY, heightRange);

                int screenX = x + centerOffset + dx * scale;
                int screenZ = z + centerOffset + dz * scale;
                guiGraphics.fill(screenX, screenZ, screenX + scale, screenZ + scale, color);
                index++;
            }
        }
        guiGraphics.fill(
                x + centerOffset - playerMarkerSize + 2,
                z + centerOffset - playerMarkerSize + 2,
                x + centerOffset + playerMarkerSize + 2,
                z + centerOffset + playerMarkerSize + 2,
                PLAYER_COLOR
        );
    }

    private static int findTopSolidBlockY(Level level, BlockPos.MutableBlockPos pos, int minY) {
        for (int y = pos.getY(); y > minY; y--) {
            pos.setY(y);
            BlockState state = level.getBlockState(pos);
            if (!state.isAir() && state.getMapColor(level, pos) != MapColor.NONE) {
                return y;
            }
        }
        return minY;
    }

    private static int getShadedColor(Level level, BlockPos pos, BlockState state,
                                      int[] heightMap, int index, int radius,
                                      int minY, int heightRange) {
        MapColor mapColor = state.getMapColor(level, pos);
        if (mapColor == null || mapColor == MapColor.NONE) {
            return DEFAULT_COLOR;
        }
        int rgb = mapColor.col;
        float brightness = 0.5f + 0.5f * ((float) (pos.getY() - minY) / heightRange);
        int currentHeight = heightMap[index];
        int gridSize = radius * 2 + 1;
        if ((index - 1 >= 0 && heightMap[index - 1] > currentHeight) ||
                (index + 1 < heightMap.length && heightMap[index + 1] > currentHeight) ||
                (index - gridSize >= 0 && heightMap[index - gridSize] > currentHeight) ||
                (index + gridSize < heightMap.length && heightMap[index + gridSize] > currentHeight)) {
            brightness *= 0.8f;
        }
        int r = (int) ((rgb >> 16 & 0xFF) * brightness);
        int g = (int) ((rgb >> 8 & 0xFF) * brightness);
        int b = (int) ((rgb & 0xFF) * brightness);

        return 0xFF000000 | (r << 16) | (g << 8) | b;
    }
}