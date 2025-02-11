package com.max.prettyguardian.entityonshoulder;

import com.max.prettyguardian.PrettyGuardian;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record PlayerEntityOnShoulder(String playerId, String entityTypeDescriptionId, int collarDyeColorId, String name, boolean isInSittingPose) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<PlayerEntityOnShoulder> TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "player_entity_on_shoulder"));

    public static final Codec<PlayerEntityOnShoulder> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("playerId").forGetter(PlayerEntityOnShoulder::playerId),
                    Codec.STRING.fieldOf("entityTypeDescriptionId").forGetter(PlayerEntityOnShoulder::entityTypeDescriptionId),
                    Codec.INT.fieldOf("collarDyeColorId").forGetter(PlayerEntityOnShoulder::collarDyeColorId),
                    Codec.STRING.fieldOf("name").forGetter(PlayerEntityOnShoulder::name),
                    Codec.BOOL.fieldOf("isInSittingPose").forGetter(PlayerEntityOnShoulder::isInSittingPose)
            ).apply(instance, PlayerEntityOnShoulder::new));

    public static final StreamCodec<ByteBuf, PlayerEntityOnShoulder> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            PlayerEntityOnShoulder::playerId,
            ByteBufCodecs.STRING_UTF8,
            PlayerEntityOnShoulder::entityTypeDescriptionId,
            ByteBufCodecs.VAR_INT,
            PlayerEntityOnShoulder::collarDyeColorId,
            ByteBufCodecs.STRING_UTF8,
            PlayerEntityOnShoulder::name,
            ByteBufCodecs.BOOL,
            PlayerEntityOnShoulder::isInSittingPose,
            PlayerEntityOnShoulder::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}