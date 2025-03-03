package com.max.prettyguardian.item.custom.tool;

import com.max.prettyguardian.enchantment.ModEnchantments;
import com.max.prettyguardian.item.ModItem;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class SpaceSwordItem extends SwordItem {
    public SpaceSwordItem(Tier tier, Properties properties) {
        super(tier, properties.rarity(Rarity.EPIC));
    }

    @Override
    public @NotNull ItemEnchantments getAllEnchantments(
            @NotNull ItemStack stack,
            @NotNull HolderLookup.RegistryLookup<Enchantment> lookup
    ) {
        ItemEnchantments enchantments = super.getAllEnchantments(stack, lookup);
        Optional<Reference<Enchantment>> enchantment = lookup.get(ModEnchantments.SLOW);
        if (enchantment.isPresent()) {
            Holder<Enchantment> slow = enchantment.get();
            if (enchantments.getLevel(slow) == 0){
                ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(enchantments);
                mutable.set(slow, 1);
                stack.set(DataComponents.ENCHANTMENTS, mutable.toImmutable());
                return mutable.toImmutable();
            }
        }

        return enchantments;
    }

    public static void addToMainCreativeTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        var enchantmentRegistry = parameters.holders().lookupOrThrow(Registries.ENCHANTMENT);

        var enchantments = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
        enchantments.set(enchantmentRegistry.getOrThrow(ModEnchantments.SLOW), 1);

        var silkTouch = new ItemStack(ModItem.SPACE_SWORD.get());
        silkTouch.set(DataComponents.ENCHANTMENTS, enchantments.toImmutable());
        output.accept(silkTouch);
    }


    // TODO: REPAIR TEMPLE PLACEMENT AND LOOT TABLE TO TEST THIS CODE


//    @Override
//    public boolean isFoil(@NotNull ItemStack itemStack) {
//        return true;
//    }
//
//    @Override
//    public boolean isEnchantable(@NotNull ItemStack itemStack) {
//        return false;
//    }
//
//    @Override
//    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
//        return false;
//    }
}
