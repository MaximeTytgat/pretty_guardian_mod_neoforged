package com.max.prettyguardian.block.entity;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.block.custom.table.MoonAltarBlock;
import com.max.prettyguardian.client.gui.sreens.inventory.MoonAltarMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MoonAltarBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        public void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            if (level != null && !level.isClientSide) {
                //If an item got added via the item handler, then rerender the block
                BlockState state = getBlockState();
                level.sendBlockUpdated(worldPosition, state, state, Block.UPDATE_IMMEDIATE);
            }
        }
    };
    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;
    private static final int OUTPUT_SLOT = 3;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 200;

    public MoonAltarBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.MOON_ALTAR_BE.get(), blockPos, blockState);

        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> MoonAltarBlockEntity.this.progress;
                    case 1 -> MoonAltarBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> MoonAltarBlockEntity.this.progress = value;
                    case 1 -> MoonAltarBlockEntity.this.maxProgress = value;
                    default -> PrettyGuardian.LOGGER.warn("Invalid index: {}", index);
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public void setChanged() {
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
        super.setChanged();
    }

    public void drops() {
        if (this.level == null) return;
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.prettyguardian.moon_altar");
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        tag.put("inventory", itemHandler.serializeNBT(provider));
        tag.putInt("moon_altar.progress", progress);

        super.saveAdditional(tag, provider);
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);

        itemHandler.deserializeNBT(provider, tag.getCompound("inventory"));
        progress = tag.getInt("moon_altar.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private void craftItem() {
        ItemStack result = new ItemStack(ModBlock.SILVER_CRYSTAL.get(), 1);
        this.itemHandler.extractItem(INPUT_SLOT_1, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT_2, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT_3, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasRecipe() {
        ItemStack item1 = this.itemHandler.getStackInSlot(INPUT_SLOT_1);
        ItemStack item2 = this.itemHandler.getStackInSlot(INPUT_SLOT_2);
        ItemStack item3 = this.itemHandler.getStackInSlot(INPUT_SLOT_3);

        if (item1.isEmpty() || item2.isEmpty() || item3.isEmpty()) {
            return false;
        }

        ItemStack result = new ItemStack(ModBlock.SILVER_CRYSTAL.get());
        return (!item1.isEmpty() && !item2.isEmpty() && !item3.isEmpty()) && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    public @Nullable ItemStack getRenderStack(int slot) {
        return itemHandler.getStackInSlot(slot);
    }

    public Direction getFacingProperty() {
        return this.getBlockState().getValue(MoonAltarBlock.FACING);
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player player) {
        return new MoonAltarMenu(id, playerInventory, this, data);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }
}
