package com.glaib04kaden.simplemissiles.misc;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import java.util.HashMap;
import java.util.Map;

public class MapRenderer2 {
    private static final int PLAYER_COLOR = 0xFFFF0000;
    private static final int BACKGROUND_COLOR = 0xFF000000;
    private static final int DEFAULT_COLOR = 0xFF333333;
    private static final Map<String, DynamicTexture> EXISTING_TEXTURES = new HashMap<>();

    public static void render(GuiGraphics guiGraphics, Level level, int x, int z, int targetX, int targetZ, int radius, int scale) {
        if (level == null) return;

        final int diameter = radius * 2;
        final int mapSize = diameter * scale;

        guiGraphics.fill(x, z, mapSize, mapSize, BACKGROUND_COLOR);

        String id = generateTextureUniqueId(level, targetX, targetZ, radius, scale);

        final int arraySize = (diameter + 1) * (diameter + 1);

        ResourceLocation resourceLocation = Minecraft.getInstance().textureManager.register("tmap", getOrCreateTexture(id, level, targetX, targetZ, radius, diameter, scale, arraySize));

        guiGraphics.blit(resourceLocation, x, z, 0, 0, mapSize, mapSize, mapSize, mapSize);

        final int centerOffset = radius * scale;
        final int playerMarkerSize = 2;

        guiGraphics.fill(
                x + centerOffset - playerMarkerSize + 2,
                z + centerOffset - playerMarkerSize + 2,
                x + centerOffset + playerMarkerSize + 2,
                z + centerOffset + playerMarkerSize + 2,
                PLAYER_COLOR
        );
    }

    private static DynamicTexture getOrCreateTexture(String id, Level level, int centerX, int centerZ, int radius, int diameter, int scale, int arraySize) {
        DynamicTexture dynamicTexture = EXISTING_TEXTURES.get(id);
        if (dynamicTexture == null) {
            DynamicTexture create = generateTexture(level, centerX, centerZ, radius, diameter, scale, arraySize);
            EXISTING_TEXTURES.put(id, create);
            return create;
        }
        return dynamicTexture;
    }

    private static String generateTextureUniqueId(Level level, int x, int y, int radius, int scale) {
        return level.dimension().toString() + x + y + radius + scale;
    }

    private static DynamicTexture generateTexture(Level level, int centerX, int centerZ, int radius, int diameter1, int scale, int arraySize) {
        int diameter = radius * 2 + 1;
        final int minY = level.getMinBuildHeight();
        final int maxY = level.getMaxBuildHeight();
        final int heightRange = maxY - minY;
        final int[] heightMap = new int[arraySize];
        int index = 0;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int dz = -radius; dz <= radius; dz++) {
            for (int dx = -radius; dx <= radius; dx++) {
                mutablePos.set(centerX + dx, maxY, centerZ + dz);
                heightMap[index++] = findTopSolidBlockY(level, mutablePos, minY);
            }
        }
        index = 0;

        int imageSize = diameter * scale;

        NativeImage image = new NativeImage(NativeImage.Format.RGBA, imageSize, imageSize, false);

        for (int dz = -radius; dz <= radius; dz++) {
            for (int dx = -radius; dx <= radius; dx++) {
                int y = heightMap[index];
                mutablePos.set(centerX + dx, y, centerZ + dz);

                BlockState state = level.getBlockState(mutablePos);
                int color = getShadedColor(level, mutablePos, state, heightMap, index, radius, minY, heightRange);

                int px = (dx + radius) * scale;
                int pz = (dz + radius) * scale;

                for (int sy = 0; sy < scale; sy++) {
                    for (int sx = 0; sx < scale; sx++) {
                        image.setPixelRGBA(px + sx, pz + sy, toNativeColor(color));
                    }
                }
                index++;
            }
        }

        image.untrack();
        return new DynamicTexture(image);
    }

    private static int toNativeColor(int argb) {
        int a = (argb >> 24) & 0xFF;
        int r = (argb >> 16) & 0xFF;
        int g = (argb >> 8) & 0xFF;
        int b = argb & 0xFF;
        return (a << 24) | (b << 16) | (g << 8) | r; // ABGR
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