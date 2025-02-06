package com.max.prettyguardian.effect;

import com.max.prettyguardian.PrettyGuardian;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    private ModEffects() {}
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, PrettyGuardian.MOD_ID);

    public static final Holder<MobEffect> LOVE = EFFECTS.register("love",
            () -> new LoveEffect(
                    MobEffectCategory.NEUTRAL,
                    50293172
            ));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
