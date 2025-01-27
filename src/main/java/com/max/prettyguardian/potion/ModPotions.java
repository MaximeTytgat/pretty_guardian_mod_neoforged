package com.max.prettyguardian.potion;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    private ModPotions() {}
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, PrettyGuardian.MOD_ID);

    public static final RegistryObject<Potion> LOVE_POTION = POTIONS.register("love_potion", () -> new Potion(new MobEffectInstance(ModEffects.LOVE.getHolder().get(), 600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
