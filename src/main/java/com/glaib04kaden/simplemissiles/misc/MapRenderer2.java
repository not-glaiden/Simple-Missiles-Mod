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
    private static final int BACKGROUND_COLOR = 0xFF000000;
    private static final int DEFAULT_COLOR = 0xFF333333;
    private final int radius;
    private final int diameter;
    private final int scale;
    private final int imageSize;
    private final Map<String, DynamicTexture> existingTextures = new HashMap<>();
    private int updateTicker;

    public MapRenderer2(int radius, int scale) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.scale = scale;
        this.imageSize = (this.diameter + 1) * this.scale;
        this.updateTicker = 0;
    }

    public void render(GuiGraphics guiGraphics, Level level, int x, int z, int targetX, int targetZ) {
        if (level == null) return;

        final int mapSize = this.diameter * this.scale;

        guiGraphics.fill(x, z, mapSize, mapSize, BACKGROUND_COLOR);

        String id = generateTextureUniqueId(level, targetX, targetZ);

        final int arraySize = (this.diameter + 1) * (this.diameter + 1);

        updateTicker--;
        if (this.updateTicker <= 0) {
            this.updateTicker = 20;
            this.existingTextures.replace(id, generateTexture(level, targetX, targetZ, arraySize));
        }

        ResourceLocation resourceLocation = Minecraft.getInstance().textureManager.register("map", getOrCreateTexture(level, id, targetX, targetZ, arraySize));

        guiGraphics.blit(resourceLocation, x, z, 0, 0, mapSize, mapSize, mapSize, mapSize);
    }

    private DynamicTexture getOrCreateTexture(Level level, String id, int centerX, int centerZ, int arraySize) {
        DynamicTexture dynamicTexture = this.existingTextures.get(id);
        if (dynamicTexture == null) {
            DynamicTexture create = generateTexture(level, centerX, centerZ, arraySize);
            this.existingTextures.put(id, create);
            return create;
        }
        return dynamicTexture;
    }

    private String generateTextureUniqueId(Level level, int x, int y) {
        return level.dimension().toString() + x + y + this.radius + this.scale;
    }

    private DynamicTexture generateTexture(Level level, int centerX, int centerZ, int arraySize) {
        final int minY = level.getMinBuildHeight();
        final int maxY = level.getMaxBuildHeight();
        final int heightRange = maxY - minY;
        final int[] heightMap = new int[arraySize];
        int index = 0;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int dz = -this.radius; dz <= this.radius; dz++) {
            for (int dx = -this.radius; dx <= this.radius; dx++) {
                mutablePos.set(centerX + dx, maxY, centerZ + dz);
                heightMap[index++] = findTopSolidBlockY(level, mutablePos, minY);
            }
        }

        index = 0;

        NativeImage image = new NativeImage(NativeImage.Format.RGBA, this.imageSize, this.imageSize, false);

        for (int dz = -this.radius; dz <= this.radius; dz++) {
            for (int dx = -this.radius; dx <= this.radius; dx++) {
                int y = heightMap[index];
                mutablePos.set(centerX + dx, y, centerZ + dz);

                BlockState state = level.getBlockState(mutablePos);
                int color = getShadedColor(level, mutablePos, state, heightMap, index, minY, heightRange);

                int px = (dx + this.radius) * this.scale;
                int pz = (dz + this.radius) * this.scale;

                for (int sy = 0; sy < this.scale; sy++) {
                    for (int sx = 0; sx < this.scale; sx++) {
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

    private int findTopSolidBlockY(Level level, BlockPos.MutableBlockPos pos, int minY) {
        for (int y = pos.getY(); y > minY; y--) {
            pos.setY(y);
            BlockState state = level.getBlockState(pos);
            if (!state.isAir() && state.getMapColor(level, pos) != MapColor.NONE) {
                return y;
            }
        }
        return minY;
    }

    private int getShadedColor(Level level, BlockPos pos, BlockState state, int[] heightMap, int index, int minY, int heightRange) {
        MapColor mapColor = state.getMapColor(level, pos);
        if (mapColor == null || mapColor == MapColor.NONE) {
            return DEFAULT_COLOR;
        }
        int rgb = mapColor.col;
        float brightness = 0.5f + 0.5f * ((float) (pos.getY() - minY) / heightRange);
        int currentHeight = heightMap[index];
        int gridSize = this.radius * 2 + 1;
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

    public void clearExistingTextures() {
        this.existingTextures.clear();
    }

    public int getRadius() {
        return this.radius;
    }

    public int getScale() {
        return this.scale;
    }
}