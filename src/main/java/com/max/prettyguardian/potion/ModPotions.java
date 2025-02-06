package com.max.prettyguardian.potion;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    private ModPotions() {}
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, PrettyGuardian.MOD_ID);

    public static final Holder<Potion> LOVE_POTION = POTIONS.register("love_potion", () -> new Potion(new MobEffectInstance(ModEffects.LOVE, 600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
