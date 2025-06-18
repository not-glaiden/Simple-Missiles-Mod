package com.glaib04kaden.simplemissiles.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry.ChannelBuilder;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class SMPacketRegistry {
    private static SimpleChannel INSTANCE;
    public static int packetId = 0;
    public static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = ChannelBuilder.named(new ResourceLocation("simple_missiles", "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions((s) -> true)
                .serverAcceptedVersions((s) -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(UpdateLaunchpadDataPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(UpdateLaunchpadDataPacket::decode)
                .encoder(UpdateLaunchpadDataPacket::encode)
                .consumerMainThread(UpdateLaunchpadDataPacket::handle)
                .add();
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }
}
