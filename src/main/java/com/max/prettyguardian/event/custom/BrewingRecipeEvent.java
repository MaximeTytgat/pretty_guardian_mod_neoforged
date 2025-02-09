package com.max.prettyguardian.event.custom;

import com.max.prettyguardian.item.ModItem;
import com.max.prettyguardian.potion.ModPotions;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber
public class BrewingRecipeEvent {
    private BrewingRecipeEvent() {}
    @SubscribeEvent
    public static void onBrewingRecipeEvent(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.WATER, ModItem.FAIRY_DUST.get(), ModPotions.LOVE_POTION);
    }
}