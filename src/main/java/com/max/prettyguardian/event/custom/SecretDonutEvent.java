package com.max.prettyguardian.event.custom;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.item.ModItem;
import com.max.prettyguardian.item.custom.food.ClassicDonut;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = PrettyGuardian.MOD_ID, value = Dist.CLIENT)
public class SecretDonutEvent {
    private SecretDonutEvent() {}

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        Player player = event.getEntity();
        ItemStack itemstack = player.getMainHandItem();

        if (itemstack.getItem() instanceof ClassicDonut && event.getTarget() instanceof Player) {
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItem.SECRET_DONUT.get()));
        }
    }
}
