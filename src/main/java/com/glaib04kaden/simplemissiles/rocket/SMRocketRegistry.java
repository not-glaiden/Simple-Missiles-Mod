package com.glaib04kaden.simplemissiles.rocket;

import com.glaib04kaden.simplemissiles.SimpleMissiles;
import com.glaib04kaden.simplemissiles.block.SMBlockRegistry;
import com.glaib04kaden.simplemissiles.entity.SMEntityRegistry;
import com.glaib04kaden.simplemissiles.rocket.base.BaseRocket;
import com.glaib04kaden.simplemissiles.rocket.base.RocketBlock;
import com.glaib04kaden.simplemissiles.rocket.base.RocketEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class SMRocketRegistry {
//    private static <T extends BaseRocket> T register(String name) {
//        Supplier<? extends RocketBlock> block = SMBlockRegistry.registerBlock(name, RocketBlock::new, "");
//        Supplier<EntityType<? extends RocketEntity>> entity = SMEntityRegistry.ENTITY_TYPES.register(name, ()-> EntityType.Builder.of(RocketEntity::new, MobCategory.MISC)
//                .sized(1F, 1F).build(new ResourceLocation(SimpleMissiles.MODID, name).toString()));
//        T toReturn;
//        return toReturn;
//    }
}
