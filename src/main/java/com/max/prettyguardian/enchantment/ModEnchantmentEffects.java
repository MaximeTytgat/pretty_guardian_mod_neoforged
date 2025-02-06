package com.max.prettyguardian.enchantment;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.enchantment.custom.SlowEnchantmentEffect;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEnchantmentEffects {
    private ModEnchantmentEffects() {}

    public static final DeferredRegister<DataComponentType<?>> ENCHANTMENT_COMPONENT_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, PrettyGuardian.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SlowEnchantmentEffect>> SLOW =
            ENCHANTMENT_COMPONENT_TYPES.register("slow",
                    () -> DataComponentType.<SlowEnchantmentEffect>builder()
                            .build());

    public static void register(IEventBus eventBus) {
        ENCHANTMENT_COMPONENT_TYPES.register(eventBus);
    }
}
