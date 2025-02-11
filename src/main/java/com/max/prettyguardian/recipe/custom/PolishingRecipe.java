package com.max.prettyguardian.recipe.custom;

import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.recipe.ModRecipeSerializer;
import com.max.prettyguardian.recipe.ModRecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

public class PolishingRecipe extends AbstractCookingRecipe {
    public PolishingRecipe(String s, CookingBookCategory cookingBookCategory, Ingredient ingredient, ItemStack itemStack, float v, int i) {
        super(ModRecipeType.POLISHING_RECIPE.get(), s, cookingBookCategory, ingredient, itemStack, v, i);
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(ModBlock.GEM_POLISHING_STATION.get());
    }

    public @NotNull RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.POLISHING_RECIPE_SERIALIZER.get();
    }
}
