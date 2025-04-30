package net.mcreator.simplemissiles.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.simplemissiles.init.SimplemissilesModMobEffects;
import net.mcreator.simplemissiles.init.SimplemissilesModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RadiationonplayertickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (0 > entity.getPersistentData().getDouble("radiation")) {
			entity.getPersistentData().putDouble("radiation", 0);
		}
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (1 <= entity.getPersistentData().getDouble("radiation")) {
				if (1 == Mth.nextInt(RandomSource.create(), 1, 1200)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 2, false, false));
				}
				if (1 == Mth.nextInt(RandomSource.create(), 1, 1200)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 1, false, false));
				}
				if (1 == Mth.nextInt(RandomSource.create(), 1, 1200)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1, false, false));
				}
				if (2.5 <= entity.getPersistentData().getDouble("radiation")) {
					if (1 == Mth.nextInt(RandomSource.create(), 1, 1200)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 2, false, false));
					}
					if (1 == Mth.nextInt(RandomSource.create(), 1, 1200)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400, 2, false, false));
					}
					if (1 == Mth.nextInt(RandomSource.create(), 1, 1200)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 2, false, false));
					}
					if (1 == Mth.nextInt(RandomSource.create(), 1, 1200)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1, false, false));
					}
					if (1 == Mth.nextInt(RandomSource.create(), 1, 200)) {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("simplemissiles:radiationdamagr")))), 1);
					}
					if (6 <= entity.getPersistentData().getDouble("radiation")) {
						if (1 == Mth.nextInt(RandomSource.create(), 1, 2400)) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(SimplemissilesModMobEffects.MILK_INTOLERANCE.get(), 200, 1, false, false));
						}
					}
					if (7 <= entity.getPersistentData().getDouble("radiation")) {
						if (1 == Mth.nextInt(RandomSource.create(), 1, 100)) {
							entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("simplemissiles:radiationdamagr")))), 1);
						}
						if (10 <= entity.getPersistentData().getDouble("radiation")) {
							if (1 == Mth.nextInt(RandomSource.create(), 1, 10)) {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("simplemissiles:radiationdamagr")))), 1);
							}
						}
					}
				}
			}
			if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == SimplemissilesModItems.HAZMAT_ARMOR_ARMOR_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == SimplemissilesModItems.HAZMAT_ARMOR_ARMOR_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == SimplemissilesModItems.HAZMAT_ARMOR_ARMOR_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == SimplemissilesModItems.HAZMAT_ARMOR_ARMOR_BOOTS.get())) {
				if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("simplemissiles:deadlands"))) {
					entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") + 0.001));
					if (Blocks.WATER == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() || Blocks.BUBBLE_COLUMN == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
							|| Blocks.WATER == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
						entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") + 0.004));
					}
				}
				if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("simplemissiles:strong_deadlands"))) {
					entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") + 0.004));
					if (Blocks.WATER == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() || Blocks.BUBBLE_COLUMN == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
							|| Blocks.WATER == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
						entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") + 0.012));
					}
				}
				if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("simplemissiles:weak_deadlands"))) {
					entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") + 0.0001));
					if (Blocks.WATER == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() || Blocks.BUBBLE_COLUMN == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
							|| Blocks.WATER == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
						entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") + 0.001));
					}
				}
				entity.getPersistentData().putDouble("radiation", (entity.getPersistentData().getDouble("radiation") - 0.00005));
			}
		}
	}
}
