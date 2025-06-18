package com.glaib04kaden.simplemissiles.network;

import com.glaib04kaden.simplemissiles.block.entity.LaunchpadBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateLaunchpadDataPacket {
    private final BlockPos pos;
    private final int index;
    private final int value;

    public UpdateLaunchpadDataPacket(BlockPos pos, int index, int value) {
        this.pos = pos;
        this.index = index;
        this.value = value;
    }

    public static void encode(UpdateLaunchpadDataPacket msg, FriendlyByteBuf buffer) {
        buffer.writeBlockPos(msg.pos);
        buffer.writeVarInt(msg.index);
        buffer.writeVarInt(msg.value);
    }

    public static UpdateLaunchpadDataPacket decode(FriendlyByteBuf buffer) {
        return new UpdateLaunchpadDataPacket(
                buffer.readBlockPos(),
                buffer.readVarInt(),
                buffer.readVarInt()
        );
    }

    public static void handle(UpdateLaunchpadDataPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;
            ServerLevel level = player.server.getLevel(player.level().dimension());
            if (level != null && level.getBlockEntity(msg.pos) instanceof LaunchpadBlockEntity launchpadBlockEntity) {
                launchpadBlockEntity.getContainerData().set(msg.index, msg.value);
                launchpadBlockEntity.setChanged();
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
