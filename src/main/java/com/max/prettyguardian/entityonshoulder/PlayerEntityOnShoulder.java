package com.max.prettyguardian.entityonshoulder;

import com.mojang.serialization.Codec;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;

public class PlayerEntityOnShoulder {
    public static final Codec<PlayerEntityOnShoulder> CODEC = Codec.unit(PlayerEntityOnShoulder::new);

    public final String id = null;
    public EntityType<?> entityType = null;
    public DyeColor collarColor = null;
    public Component name = null;
    public boolean isInSittingPose = false;

    public void setEntityOnShoulder(EntityType<?> entityType, DyeColor collarColor, Component name, boolean isInSittingPose) {
        this.entityType = entityType;
        this.collarColor = collarColor;
        this.name = name;
        this.isInSittingPose = isInSittingPose;
    }

    public void letGoEntity() {
        entityType = null;
        collarColor = null;
        name = null;
        isInSittingPose = false;
    }

    public String getId() {
        return ID;
    }
    public EntityType<?> getEntityType() {
        return entityType;
    }
    public DyeColor getCollarColor() {
        return collarColor;
    }
    public Component getName() {
        return name;
    }
    public boolean isInSittingPose() {
        return isInSittingPose;
    }

//    public void copyFrom(PlayerEntityOnShoulder source) {
//        entityType = source.entityType;
//        collarColor = source.collarColor;
//        name = source.name;
//        isInSittingPose = source.isInSittingPose;
//    }

//    public void saveNBTData(CompoundTag tag, HolderLookup.Provider provider) {
//        if (entityType != null) tag.putString(ENTITY_ON_SHOULDER, EntityType.getKey(entityType).toString());
//        if (collarColor != null) tag.putString(COLLAR_COLOR, collarColor.getName());
//        if (name != null) tag.putString("name", Component.Serializer.toJson(name, provider));
//        tag.putBoolean(IS_IN_SITTING_POSE, isInSittingPose);
//    }
//
//    public void loadNBTData(CompoundTag tag, HolderLookup.Provider provider) {
//        if (tag.contains(ENTITY_ON_SHOULDER)) entityType = EntityType.byString(tag.getString(ENTITY_ON_SHOULDER)).orElse(null);
//        if (tag.contains(COLLAR_COLOR)) collarColor = DyeColor.byName(tag.getString(COLLAR_COLOR), null);
//        if (tag.contains("name")) name = Component.Serializer.fromJson(tag.getString("name"), provider);
//        if (tag.contains(IS_IN_SITTING_POSE)) isInSittingPose = tag.getBoolean(IS_IN_SITTING_POSE);
//    }
}
