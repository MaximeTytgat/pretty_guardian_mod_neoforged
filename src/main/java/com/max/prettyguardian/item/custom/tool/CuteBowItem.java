package com.max.prettyguardian.item.custom.tool;


import com.max.prettyguardian.item.ModItem;
import com.max.prettyguardian.item.custom.projectiles.CuteArrowItem;
import com.max.prettyguardian.util.EnchantmentUtils;
import com.max.prettyguardian.util.ModTags;
import com.max.prettyguardian.worldgen.entity.projectile.CuteArrowEntity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Predicate;

public class CuteBowItem extends BowItem  {

    public static final Predicate<ItemStack> HEART_ARROW_ONLY = itemStack -> itemStack.is(ModTags.Items.HEART_ARROWS);

    public CuteBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity, int i1) {
        if (livingEntity instanceof Player player) {
            Map<ResourceKey<Enchantment>, Integer> itemEnchantments = EnchantmentUtils.getEnchantments(itemStack);
            boolean flag = player.getAbilities().instabuild || itemEnchantments.getOrDefault(Enchantments.INFINITY, 0) > 0;
            ItemStack itemstack = player.getProjectile(itemStack);

            int i = this.getUseDuration(itemStack, livingEntity) - i1;
            i = EventHooks.onArrowLoose(itemStack, level, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (f >= 0.1D) {
                    boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof CuteArrowItem && ((CuteArrowItem)itemstack.getItem()).isInfinite(itemStack));
                    if (!level.isClientSide) {
                        CuteArrowItem arrowitem = (CuteArrowItem)(itemstack.getItem() instanceof CuteArrowItem ? itemstack.getItem() : ModItem.HEART_ARROW.get());
                        CuteArrowEntity abstractarrow = arrowitem.createArrow(level, player);
                        abstractarrow.setOwner(player);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            abstractarrow.setCritArrow(true);
                        }

                        int j = itemEnchantments.getOrDefault(Enchantments.POWER, 0);
                        if (j > 0) {
                            abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + j * 0.5D + 0.5D);
                        }

//                        int k = itemEnchantments.getOrDefault(Enchantments.PUNCH, 0);
//                        if (k > 0) {
//                            abstractarrow.setKnockback(k);
//                        }

                        if (itemEnchantments.getOrDefault(Enchantments.FLAME, 0) > 0) {
                            abstractarrow.setRemainingFireTicks(100);
                        }

                        itemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                            abstractarrow.pickup = CuteArrowEntity.Pickup.CREATIVE_ONLY;
                        }

                        level.addFreshEntity(abstractarrow);
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getPowerForTime(int i) {
        float f = i / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return HEART_ARROW_ONLY;
    }

    @Override
    public boolean isValidRepairItem(ItemStack bow, @NotNull ItemStack itemStack1) {
        return bow.is(ModItem.CUPIDON_BOW.get()) && itemStack1.is(ModItem.PINK_SAPPHIRE.get());
    }
}