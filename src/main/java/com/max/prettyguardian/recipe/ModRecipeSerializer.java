package com.max.prettyguardian.recipe;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.recipe.custom.PolishingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeSerializer {
    private ModRecipeSerializer() {}

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, PrettyGuardian.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PolishingRecipe>> POLISHING_RECIPE_SERIALIZER =
            RECIPE_SERIALIZER.register("polishing_recipe", () -> new SimpleCookingSerializer<>(PolishingRecipe::new, 200));


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);
    }
}
