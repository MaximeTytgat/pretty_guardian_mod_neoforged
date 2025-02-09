package com.max.prettyguardian.entityonshoulder;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record PlayerEntityOnShoulder(String entityTypeDescriptionId, int collarDyeColorId, String name, boolean isInSittingPose) {
    public static final Codec<PlayerEntityOnShoulder> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("entityTypeDescriptionId").forGetter(PlayerEntityOnShoulder::entityTypeDescriptionId),
                    Codec.INT.fieldOf("collarDyeColorId").forGetter(PlayerEntityOnShoulder::collarDyeColorId),
                    Codec.STRING.fieldOf("name").forGetter(PlayerEntityOnShoulder::name),
                    Codec.BOOL.fieldOf("isInSittingPose").forGetter(PlayerEntityOnShoulder::isInSittingPose)
            ).apply(instance, PlayerEntityOnShoulder::new));
}