package com.max.prettyguardian.recipe;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.recipe.custom.PolishingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModRecipeType {
    private ModRecipeType() {}

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE =
            DeferredRegister.create(Registries.RECIPE_TYPE, PrettyGuardian.MOD_ID);

    public static final Supplier<RecipeType<PolishingRecipe>> POLISHING_RECIPE =
            RECIPE_TYPE.register("polishing_recipe", () -> RecipeType.simple(PrettyGuardian.prefix("polishing_recipe")));

    public static void register(IEventBus eventBus){
        RECIPE_TYPE.register(eventBus);
    }
}
