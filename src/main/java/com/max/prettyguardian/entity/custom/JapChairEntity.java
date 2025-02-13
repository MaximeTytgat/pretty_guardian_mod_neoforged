package com.max.prettyguardian.entity.custom;

import com.max.prettyguardian.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class JapChairEntity extends Entity {

    public JapChairEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    // TODO: Test pos spawn ^^
//    public JapChairEntity(Level level, BlockPos pos) {
//        this(ModEntities.JAP_CHAIR.get(), level);
//        setPos(pos.getX() + 0.5D, pos.getY() + 0.35D, pos.getZ() + 0.5D);
//    }

    @Override
    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {}

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {}

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {}

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        this.kill();
    }
}