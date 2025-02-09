package com.max.prettyguardian.item;

import com.max.prettyguardian.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    private ModToolTiers() {}

    public static final Tier SPACE_SWORD = new SimpleTier(
            ModTags.Blocks.INCORRECT_SPACE_SWORD_TOOL,
            2500,
            5f,
            2f,
            25,
            () -> Ingredient.of(ModItem.PINK_SAPPHIRE.get())
    );

    public static final Tier PINK_SAPPHIRE = new SimpleTier(
            ModTags.Blocks.INCORRECT_PINK_SAPPHIRE_TOOL,
            1500,
            8.0F,
            3.0F,
            25,
            () -> Ingredient.of(ModItem.PINK_SAPPHIRE.get())
    );

    public static final Tier RUBY = new SimpleTier(
            ModTags.Blocks.INCORRECT_RUBY_TOOL,
            3000,
            9.0F,
            4.0F,
            65,
            () -> Ingredient.of(ModItem.PINK_SAPPHIRE.get())
    );
}
