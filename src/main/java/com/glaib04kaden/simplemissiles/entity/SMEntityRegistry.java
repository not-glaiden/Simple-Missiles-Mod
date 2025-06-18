package com.glaib04kaden.simplemissiles.entity;

import com.glaib04kaden.simplemissiles.SimpleMissiles;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;

public class SMEntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, SimpleMissiles.MODID);
}
