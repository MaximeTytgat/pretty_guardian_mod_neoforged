package com.max.prettyguardian.client.gui.sreens.inventory;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.block.entity.MoonAltarBlockEntity;
import com.max.prettyguardian.item.ModItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MoonAltarMenu extends AbstractContainerMenu {
    public final MoonAltarBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;
    public MoonAltarMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public MoonAltarMenu(int pContainerId, Inventory inv, BlockEntity blockEntity, ContainerData data) {
        super(ModMenuTypes.STAFF_MAGIC_TABLE_MENU.get(), pContainerId);
        checkContainerSize(inv, 4);
        this.data = data;
        this.blockEntity = (MoonAltarBlockEntity) blockEntity;
        this.level = inv.player.level();
        ItemStackHandler itemHandler = this.blockEntity.getItemHandler();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addSlot(new SlotItemHandler(itemHandler, 0, 56, -9) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return stack.is(ModItem.PLUTONS_KEY.get());
            }
        });
        addSlot(new SlotItemHandler(itemHandler, 1, 104, -9) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return stack.is(ModItem.SPACE_SWORD.get());
            }
        });
        addSlot(new SlotItemHandler(itemHandler, 2, 80, 7) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return stack.is(ModItem.NEPTUNES_MIRROR.get());
            }

        });
        addSlot(new SlotItemHandler(itemHandler, 3, 80, 55) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return false;
            }
        });

        addDataSlots(data);
    }


    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots and the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT; // 35
    private static final int TE_INVENTORY_SLOT_COUNT = 4;  // Moon Altar has 4 slots
    private static final int TE_INVENTORY_LAST_SLOT_INDEX = TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT - 1; // 39
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack itemToMove = sourceSlot.getItem();
        ItemStack copyOfItem = itemToMove.copy();

        if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX) {
            // Vanilla container slot
            ItemStack empty = checkItemAndMoveIt(itemToMove);
            if (empty != null) return empty;
        } else if (pIndex < TE_INVENTORY_LAST_SLOT_INDEX) {
            // Moon Altar slot
            if (!moveItemStackTo(itemToMove, VANILLA_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            PrettyGuardian.LOGGER.info("Invalid slotIndex: {}", pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (itemToMove.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, itemToMove);
        return copyOfItem;
    }

    private @Nullable ItemStack checkItemAndMoveIt(ItemStack itemToMove) {
        if (itemToMove.is(ModItem.PLUTONS_KEY.get())) {
            ItemStack itemInSlot = slots.get(TE_INVENTORY_FIRST_SLOT_INDEX).getItem();
            if (itemInSlot.is(ModItem.PLUTONS_KEY.get()) ||
                    !moveItemStackTo(itemToMove, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_LAST_SLOT_INDEX, false)) {
                return ItemStack.EMPTY;
            }
        } else if (itemToMove.is(ModItem.SPACE_SWORD.get())) {
            ItemStack itemInSlot = slots.get(TE_INVENTORY_FIRST_SLOT_INDEX+1).getItem();
            if (itemInSlot.is(ModItem.SPACE_SWORD.get()) ||
                    !moveItemStackTo(itemToMove, TE_INVENTORY_FIRST_SLOT_INDEX+1, TE_INVENTORY_LAST_SLOT_INDEX+1, false)) {
                return ItemStack.EMPTY;
            }
        } else if (itemToMove.is(ModItem.NEPTUNES_MIRROR.get())) {
            ItemStack itemInSlot = slots.get(TE_INVENTORY_FIRST_SLOT_INDEX+2).getItem();
            if (itemInSlot.is(ModItem.NEPTUNES_MIRROR.get()) ||
                    !moveItemStackTo(itemToMove, TE_INVENTORY_FIRST_SLOT_INDEX+2, TE_INVENTORY_LAST_SLOT_INDEX+2, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }
        return null;
    }


    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, ModBlock.MOON_ALTAR.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 104 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 162));
        }
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = data.get(0);
        int maxProgress = data.get(1);
        int progressArrowSize = 36;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }
}
