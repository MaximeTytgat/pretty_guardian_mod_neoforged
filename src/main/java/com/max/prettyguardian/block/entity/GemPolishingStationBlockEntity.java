package com.max.prettyguardian.block.entity;

import com.max.prettyguardian.recipe.ModRecipeType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class GemPolishingStationBlockEntity extends AbstractFurnaceBlockEntity {
    public GemPolishingStationBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.GEM_POLISHING_BE.get(), pos, blockState, ModRecipeType.POLISHING_RECIPE.get());
    }

    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.furnace");
    }

    protected @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory player) {
        return new FurnaceMenu(id, player, this, this.dataAccess);
    }
}