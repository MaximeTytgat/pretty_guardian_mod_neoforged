package com.max.prettyguardian.datagen;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(Items.SUGAR), RecipeCategory.MISC, ModItem.CARAMEL.get(), 0.35F, 200, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .group("caramel_from_sugar")
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(recipeOutput);

        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(ModBlock.PINK_SAPPHIRE_ORE.get()), RecipeCategory.MISC, ModItem.PINK_SAPPHIRE.get(), 0.35F, 200, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .unlockedBy(getHasName(ModBlock.PINK_SAPPHIRE_ORE.get()), has(ModBlock.PINK_SAPPHIRE_ORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "pink_sapphire_from_ore"));

        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE.get()), RecipeCategory.MISC, ModItem.PINK_SAPPHIRE.get(), 0.35F, 200, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .unlockedBy(getHasName(ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE.get()), has(ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "pink_sapphire_from_deepsalte_ore"));

        blockIngotRecipes(recipeOutput,
                ModBlock.PINK_SAPPHIRE_BLOCK.get(),
                ModItem.PINK_SAPPHIRE.get()
        );

        toolRecipes(recipeOutput,
                ModItem.PINK_SAPPHIRE_SWORD.get(),
                ModItem.PINK_SAPPHIRE_PICKAXE.get(),
                ModItem.PINK_SAPPHIRE_AXE.get(),
                ModItem.PINK_SAPPHIRE_SHOVEL.get(),
                ModItem.PINK_SAPPHIRE_HOE.get(),
                ModItem.PINK_SAPPHIRE.get()
        );

        armorRecipes(recipeOutput,
                ModItem.PINK_SAPPHIRE_HELMET.get(),
                ModItem.PINK_SAPPHIRE_CHESTPLATE.get(),
                ModItem.PINK_SAPPHIRE_LEGGINGS.get(),
                ModItem.PINK_SAPPHIRE_BOOTS.get(),
                ModItem.PINK_SAPPHIRE.get()
        );

        blockIngotRecipes(recipeOutput,
                ModBlock.RUBY_BLOCK.get(),
                ModItem.RUBY.get()
        );

        toolRecipes(recipeOutput,
                ModItem.RUBY_SWORD.get(),
                ModItem.RUBY_PICKAXE.get(),
                ModItem.RUBY_AXE.get(),
                ModItem.RUBY_SHOVEL.get(),
                ModItem.RUBY_HOE.get(),
                ModItem.RUBY.get()
        );

        armorRecipes(recipeOutput,
                ModItem.RUBY_HELMET.get(),
                ModItem.RUBY_CHESTPLATE.get(),
                ModItem.RUBY_LEGGINGS.get(),
                ModItem.RUBY_BOOTS.get(),
                ModItem.RUBY.get()
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.CHOCOLATE.get())
                .pattern("AB")
                .pattern("BA")
                .pattern("AB")
                .define('A', Items.COCOA_BEANS)
                .define('B', Items.SUGAR)
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .save(recipeOutput);

        blockIngotRecipes(recipeOutput,
                ModBlock.CHOCOLATE_BLOCK.get(),
                ModItem.CHOCOLATE.get()
        );

        simpleShapeless(recipeOutput, RecipeCategory.FOOD, ModItem.AGARAGAR.get(), 2, Items.KELP);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.CREAM.get(), 3)
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .define('A', ModItem.VANILLA.get())
                .define('B', Items.SUGAR)
                .define('C', Items.MILK_BUCKET)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.MARSHMALLOW.get(), 4)
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A', ModItem.AGARAGAR.get())
                .define('B', Items.SUGAR)
                .define('C', Items.WATER_BUCKET)
                .unlockedBy(getHasName(ModItem.AGARAGAR.get()), has(ModItem.AGARAGAR.get()))
                .save(recipeOutput);

        doubleSimpleShapeless(recipeOutput, ModItem.MARSHMALLOW_STICK.get(), 1,
                ModItem.MARSHMALLOW.get(), Items.STICK);

        String roastedMarshmallowStick = "roasted_marshmallow_stick";

        SimpleCookingRecipeBuilder.generic(
                Ingredient.of(ModItem.MARSHMALLOW_STICK.get()), RecipeCategory.FOOD, ModItem.ROASTED_MARSHMALLOW_STICK.get(), 0.35F, 200, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new)
                .group(roastedMarshmallowStick)
                .unlockedBy(getHasName(ModItem.MARSHMALLOW_STICK.get()), has(ModItem.MARSHMALLOW_STICK.get()))
                .save(recipeOutput);

        blockIngotRecipes(recipeOutput,
                ModBlock.MARSHMELLO_BLOCK.get(),
                ModItem.MARSHMALLOW.get()
        );

        SimpleCookingRecipeBuilder.generic(
                Ingredient.of(ModBlock.MARSHMELLO_BLOCK.get()), RecipeCategory.FOOD, ModBlock.ROASTED_MARSHMELLO_BLOCK.get(), 0.35F, 200, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .group("roasted_marshmello_block")
                .unlockedBy(getHasName(ModBlock.MARSHMELLO_BLOCK.get()), has(ModBlock.MARSHMELLO_BLOCK.get()))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.DONUT.get(), 4)
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A', Items.SUGAR)
                .define('B', Items.WHEAT)
                .define('C', Items.EGG)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(recipeOutput);

        doubleSimpleShapeless(recipeOutput, ModItem.CHOCOLATE_DONUT.get(), 1,
                ModItem.DONUT.get(), ModItem.CHOCOLATE.get());
        doubleSimpleShapeless(recipeOutput, ModItem.STRAWBERRY_DONUT.get(), 1,
                ModItem.DONUT.get(), ModItem.STRAWBERRY.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.MOCHI_DONUT.get())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A', ModItem.AGARAGAR.get())
                .define('B', Items.WHEAT)
                .define('C', Items.EGG)
                .unlockedBy(getHasName(ModItem.AGARAGAR.get()), has(ModItem.AGARAGAR.get()))
                .save(recipeOutput);

        doubleSimpleShapeless(recipeOutput, ModItem.CHOCOLATE_MOCHI_DONUT.get(), 1,
                ModItem.MOCHI_DONUT.get(), ModItem.CHOCOLATE.get());
        doubleSimpleShapeless(recipeOutput, ModItem.STRAWBERRY_MOCHI_DONUT.get(), 1,
                ModItem.MOCHI_DONUT.get(), ModItem.STRAWBERRY.get());
        doubleSimpleShapeless(recipeOutput, ModItem.CHOCOLATE_STRAWBERRY.get(), 1,
                ModItem.CHOCOLATE.get(), ModItem.STRAWBERRY.get());

        simpleMilkBucket(recipeOutput, ModItem.VANILLA.get(), ModItem.VANILLA_MILK_BUCKET.get());
        simpleMilkBucket(recipeOutput, ModItem.STRAWBERRY.get(), ModItem.STRAWBERRY_MILK_BUCKET.get());
        simpleMilkBucket(recipeOutput, ModItem.CHOCOLATE.get(), ModItem.CHOCOLATE_MILK_BUCKET.get());

        simpleShapeless(recipeOutput, RecipeCategory.FOOD, ModItem.VANILLA_MILK_CARTON.get(), 3, ModItem.VANILLA_MILK_BUCKET.get());
        simpleShapeless(recipeOutput, RecipeCategory.FOOD, ModItem.STRAWBERRY_MILK_CARTON.get(), 3, ModItem.STRAWBERRY_MILK_BUCKET.get());
        simpleShapeless(recipeOutput, RecipeCategory.FOOD, ModItem.CHOCOLATE_MILK_CARTON.get(), 3, ModItem.CHOCOLATE_MILK_BUCKET.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.ICE_CREAM_CUP.get(), 3)
                .pattern("AAA")
                .pattern(" A ")
                .define('A', Items.GLASS_PANE)
                .unlockedBy(getHasName(Items.GLASS_PANE), has(Items.GLASS_PANE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.JUICE_GLASS.get(), 6)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .define('A', Items.GLASS_PANE)
                .unlockedBy(getHasName(Items.GLASS_PANE), has(Items.GLASS_PANE))
                .save(recipeOutput);

        mojinRecipes(recipeOutput, ModItem.APPLE_MOJITO.get(), Items.APPLE);
        mojinRecipes(recipeOutput, ModItem.STRAWBERRY_MOJITO.get(), ModItem.STRAWBERRY.get());
        mojinRecipes(recipeOutput, ModItem.MINT_MOJITO.get(), ModItem.MINT.get());

        simpleBubbleTea(recipeOutput, ModItem.BUBBLETEA_MELON.get(), Items.MELON_SLICE);
        simpleBubbleTea(recipeOutput, ModItem.BUBBLETEA_CARAMEL.get(), ModItem.CARAMEL.get());
        simpleBubbleTea(recipeOutput, ModItem.BUBBLETEA_STRAWBERRY.get(), ModItem.STRAWBERRY.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.RHUM_BOTTLE.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" C ")
                .define('A', Items.SUGAR_CANE)
                .define('B', Items.WATER_BUCKET)
                .define('C', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(Items.SUGAR_CANE), has(Items.SUGAR_CANE))
                .save(recipeOutput);

        iceCreamRecipes(recipeOutput, ModItem.STRAWBERRY_ICE_CREAM.get(), ModItem.STRAWBERRY.get());
        iceCreamRecipes(recipeOutput, ModItem.VANILLA_ICE_CREAM.get(), ModItem.VANILLA.get());
        iceCreamRecipes(recipeOutput, ModItem.PISTACHIO_ICE_CREAM.get(), ModItem.PISTACHIO.get());
        iceCreamRecipes(recipeOutput, ModItem.CHOCOLATE_ICE_CREAM.get(), ModItem.CHOCOLATE.get());

        waffleIceCreamRecipes(recipeOutput, ModItem.ICE_CREAM_WAFFLE_STRAWBERRY.get(), ModItem.STRAWBERRY.get());
        waffleIceCreamRecipes(recipeOutput, ModItem.ICE_CREAM_WAFFLE_VANILLA.get(), ModItem.VANILLA.get());
        waffleIceCreamRecipes(recipeOutput, ModItem.ICE_CREAM_WAFFLE_PISTACHIO.get(), ModItem.PISTACHIO.get());
        waffleIceCreamRecipes(recipeOutput, ModItem.ICE_CREAM_WAFFLE_CHOCOLATE.get(), ModItem.CHOCOLATE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.POKKY_ICE_CREAM.get())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GGG")
                .define('A', ModItem.WAFFLE.get())
                .define('B', ModItem.CREAM.get())
                .define('C', ModItem.CHOCOLATE_POCKY.get())
                .define('D', ModItem.CHOCOLATE.get())
                .define('E', ModItem.VANILLA_ICE_CREAM.get())
                .define('F', ModItem.STRAWBERRY.get())
                .define('G', Items.SNOWBALL)
                .unlockedBy(getHasName(ModItem.VANILLA_ICE_CREAM.get()), has(ModItem.VANILLA_ICE_CREAM.get()))
                .unlockedBy(getHasName(ModItem.CHOCOLATE_POCKY.get()), has(ModItem.CHOCOLATE_POCKY.get()))
                .unlockedBy(getHasName(ModItem.WAFFLE.get()), has(ModItem.WAFFLE.get()))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.WAFFLE.get(), 3)
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EEE")
                .define('A', Items.SUGAR)
                .define('B', ModItem.VANILLA.get())
                .define('C', Items.EGG)
                .define('D', Items.MILK_BUCKET)
                .define('E', Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.FISH_WAFFLE.get(), 3)
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EEE")
                .define('A', Items.SUGAR)
                .define('B', Items.SWEET_BERRIES)
                .define('C', Items.EGG)
                .define('D', Items.MILK_BUCKET)
                .define('E', Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(recipeOutput);

        doubleSimpleShapeless(recipeOutput, ModItem.CHOCOLATE_WAFFLE.get(), 1,
                ModItem.WAFFLE.get(), ModItem.CHOCOLATE.get());

        doubleSimpleShapeless(recipeOutput, ModItem.CHOCOLATE_POCKY.get(), 4,
                ModItem.CHOCOLATE.get(), Items.WHEAT);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.STRAWBERRY_POCKY.get(), 4)
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .define('A', ModItem.CHOCOLATE.get())
                .define('B', ModItem.STRAWBERRY.get())
                .define('C', Items.WHEAT)
                .unlockedBy(getHasName(ModItem.CHOCOLATE.get()), has(ModItem.CHOCOLATE.get()))
                .unlockedBy(getHasName(ModItem.STRAWBERRY.get()), has(ModItem.STRAWBERRY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.TAKOYAKI.get(), 3)
                .pattern(" A ")
                .pattern("BCB")
                .pattern("DDD")
                .define('A', Items.KELP)
                .define('B', Items.EGG)
                .define('C', ModItem.SQUID_COOKED.get())
                .define('D', Items.WHEAT)
                .unlockedBy(getHasName(Items.KELP), has(Items.KELP))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(ModItem.SQUID_COOKED.get()), has(ModItem.SQUID_COOKED.get()))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.DANGO_CARAMEL.get(), 3)
                .pattern("ABA")
                .pattern("CCC")
                .pattern("DDD")
                .define('A', ModItem.VANILLA.get())
                .define('B', ModItem.CARAMEL.get())
                .define('C', ModItem.AGARAGAR.get())
                .define('D', Items.STICK)
                .unlockedBy(getHasName(ModItem.VANILLA.get()), has(ModItem.VANILLA.get()))
                .unlockedBy(getHasName(ModItem.CARAMEL.get()), has(ModItem.CARAMEL.get()))
                .unlockedBy(getHasName(ModItem.AGARAGAR.get()), has(ModItem.AGARAGAR.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.TRICOLOR_DANGO.get(), 3)
                .pattern("ABC")
                .pattern("DDD")
                .pattern("EEE")
                .define('A', ModItem.VANILLA.get())
                .define('B', ModItem.STRAWBERRY.get())
                .define('C', Items.MELON_SLICE)
                .define('D', ModItem.AGARAGAR.get())
                .define('E', Items.STICK)
                .unlockedBy(getHasName(ModItem.VANILLA.get()), has(ModItem.VANILLA.get()))
                .unlockedBy(getHasName(ModItem.STRAWBERRY.get()), has(ModItem.STRAWBERRY.get()))
                .unlockedBy(getHasName(ModItem.AGARAGAR.get()), has(ModItem.AGARAGAR.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.POPSICLE.get(), 1)
                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .define('A', Items.SNOWBALL)
                .define('B', Items.SUGAR)
                .define('C', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.CREAM_POPSICLE.get(), 1)
                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .define('A', ModItem.VANILLA.get())
                .define('B', ModItem.CREAM.get())
                .define('C', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(ModItem.CREAM.get()), has(ModItem.CREAM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.CHOCOLATE_POPSICLE.get(), 1)
                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .define('A', ModItem.CHOCOLATE.get())
                .define('B', ModItem.CREAM.get())
                .define('C', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(ModItem.CHOCOLATE.get()), has(ModItem.CHOCOLATE.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.STRAWBERRY_POPSICLE.get(), 1)
                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .define('A', ModItem.STRAWBERRY.get())
                .define('B', ModItem.CREAM.get())
                .define('C', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(ModItem.STRAWBERRY.get()), has(ModItem.STRAWBERRY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlock.RHUM_CAKE.get())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EEE")
                .define('A', ModItem.CARAMEL.get())
                .define('B', ModItem.RHUM_BOTTLE.get())
                .define('C', Items.EGG)
                .define('D', Items.MILK_BUCKET)
                .define('E', Items.WHEAT)
                .unlockedBy(getHasName(ModItem.CARAMEL.get()), has(ModItem.CARAMEL.get()))
                .unlockedBy(getHasName(ModItem.RHUM_BOTTLE.get()), has(ModItem.RHUM_BOTTLE.get()))
                .save(recipeOutput);

        simpleCake(recipeOutput, ModBlock.STRAWBERRY_CAKE.get(), ModItem.STRAWBERRY.get(), ModItem.CREAM.get());
        simpleCake(recipeOutput, ModBlock.VELVET_CAKE.get(), Items.RED_DYE, ModItem.CHOCOLATE.get());
        simpleCake(recipeOutput, ModBlock.CREAM_CAKE.get(), ModItem.VANILLA.get(), ModItem.CREAM.get());
        simpleCake(recipeOutput, ModBlock.CHOCOLATE_CAKE.get(), ModItem.CHOCOLATE.get(), ModItem.CREAM.get());
        simpleCake(recipeOutput, ModBlock.BERRY_STRAWBERRY_CAKE.get(), ModItem.STRAWBERRY.get(), Items.SWEET_BERRIES);
        simpleCake(recipeOutput, ModBlock.CREAM_STRAWBERRY_CAKE.get(), ModItem.CREAM.get(), ModItem.STRAWBERRY.get());
        simpleCake(recipeOutput, ModBlock.STRAWBERRY_CHOCO_CAKE.get(), ModItem.STRAWBERRY.get(), ModItem.CHOCOLATE.get());

        simpleThreeCake(recipeOutput, ModBlock.THREE_VELVET_CAKE.get(), ModBlock.VELVET_CAKE.get());
        simpleThreeCake(recipeOutput, ModBlock.THREE_STRAWBERRY_CAKE.get(), ModBlock.CREAM_STRAWBERRY_CAKE.get());
        simpleThreeCake(recipeOutput, ModBlock.THREE_CHOCO_CAKE.get(), ModBlock.CHOCOLATE_CAKE.get());
        simpleThreeCake(recipeOutput, ModBlock.THREE_STRAWBERRY_CHOCO_CAKE.get(), ModBlock.STRAWBERRY_CHOCO_CAKE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.MARSHMELLOW_STRAWBERRY_BURGER.get(), 2)
                .pattern("ABA")
                .pattern(" C ")
                .define('A', ModItem.STRAWBERRY.get())
                .define('B', ModItem.CREAM.get())
                .define('C', Items.BREAD)
                .unlockedBy(getHasName(ModItem.STRAWBERRY.get()), has(ModItem.STRAWBERRY.get()))
                .unlockedBy(getHasName(ModItem.CREAM.get()), has(ModItem.CREAM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.SMORE.get(), 4)
                .pattern("AA")
                .pattern("BC")
                .pattern("AA")
                .define('A', Items.WHEAT)
                .define('B', ModItem.CHOCOLATE.get())
                .define('C', ModItem.MARSHMALLOW.get())
                .unlockedBy(getHasName(ModItem.CHOCOLATE.get()), has(ModItem.CHOCOLATE.get()))
                .unlockedBy(getHasName(ModItem.MARSHMALLOW.get()), has(ModItem.MARSHMALLOW.get()))
                .save(recipeOutput);

        simplePudding(recipeOutput, ModItem.CARAMEL_PUDDING.get(), ModItem.CARAMEL.get());
        simplePudding(recipeOutput, ModItem.CHOCOLATE_PUDDING.get(), ModItem.CHOCOLATE.get());
        simplePudding(recipeOutput, ModItem.STRAWBERRY_PUDDING.get(), ModItem.STRAWBERRY.get());
        simplePudding(recipeOutput, ModItem.PISTACHIO_PUDDING.get(), ModItem.PISTACHIO.get());

        simpleCroissant(recipeOutput, ModItem.CHOCOLATE_CROISSANT.get(), ModItem.CHOCOLATE.get());
        simpleCroissant(recipeOutput, ModItem.STRAWBERRY_CROISSANT.get(), ModItem.STRAWBERRY.get());
        simpleCroissant(recipeOutput, ModItem.VANILLA_CROISSANT.get(), ModItem.VANILLA.get());
        simpleCroissant(recipeOutput, ModItem.PISTACHIO_CROISSANT.get(), ModItem.PISTACHIO.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.CANDY_APPLE.get(), 1)
                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .define('A', ModItem.CARAMEL.get())
                .define('B', Items.APPLE)
                .define('C', Items.STICK)
                .unlockedBy(getHasName(ModItem.CARAMEL.get()), has(ModItem.CARAMEL.get()))
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .save(recipeOutput);

        simplePie(recipeOutput, ModBlock.STRAWBERRY_PIE.get(), ModItem.STRAWBERRY.get());
        simplePie(recipeOutput, ModBlock.CHOCOLATE_PIE.get(), ModItem.CHOCOLATE.get());
        simplePie(recipeOutput, ModBlock.APPLE_PIE.get(), Items.APPLE);
        simplePie(recipeOutput, ModBlock.LEMON_PIE.get(), ModItem.LEMON.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlock.MAGIC_PIE.get(), 1)
                .pattern("ABA")
                .pattern("CDC")
                .pattern("FFF")
                .define('A', Items.SUGAR)
                .define('B', ModItem.FAIRY_DUST.get())
                .define('C', Items.SWEET_BERRIES)
                .define('D', ModItem.STRAWBERRY.get())
                .define('F', Items.WHEAT)
                .unlockedBy(getHasName(ModItem.FAIRY_DUST.get()), has(ModItem.FAIRY_DUST.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BUTTERFLY_NET.get(), 1)
                .pattern(" AA")
                .pattern("BAA")
                .define('A', Items.STRING)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(recipeOutput);


        simpleScreen(recipeOutput, ModBlock.SCREEN_JAPANESE_BIRCH.get(), Blocks.BIRCH_PLANKS);
        simpleScreen(recipeOutput, ModBlock.SCREEN_JAPANESE_CHERRY_LOG.get(), Blocks.CHERRY_LOG);
        simpleScreen(recipeOutput, ModBlock.SCREEN_JAPANESE_CHERRY_PLANK.get(), Blocks.CHERRY_PLANKS);

        simpleScrool(recipeOutput, ModBlock.SCROLL_JAPANESE_MUSHROOM.get(), Items.RED_MUSHROOM);
        simpleScrool(recipeOutput, ModBlock.SCROLL_JAPANESE_BEE.get(), Items.HONEYCOMB);
        simpleScrool(recipeOutput, ModBlock.SCROLL_JAPANESE_AXOLOTL.get(), Items.AXOLOTL_BUCKET);
        simpleScrool(recipeOutput, ModBlock.SCROLL_JAPANESE_CINNAMON_ROLL.get(), Items.WHEAT);
        simpleScrool(recipeOutput, ModBlock.SCROLL_JAPANESE_DAY.get(), Items.ORANGE_WOOL);
        simpleScrool(recipeOutput, ModBlock.SCROLL_JAPANESE_NIGHT.get(), Items.BLUE_WOOL);
        simpleScrool(recipeOutput, ModBlock.SCROLL_JAPANESE_SUNFLOWER.get(), Items.SUNFLOWER);
        simpleScrool(recipeOutput, ModBlock.SCROLL_JAPANESE_DAY_2.get(), Items.PINK_WOOL);

        simpleLamp(recipeOutput, ModBlock.LAMP_JAPANESE_BIRCH.get(), Blocks.BIRCH_LOG);
        simpleLamp(recipeOutput, ModBlock.LAMP_JAPANESE_CHERRY.get(), Blocks.CHERRY_LOG);
        simpleLamp(recipeOutput, ModBlock.LAMP_JAPANESE_JUNGLE.get(), Blocks.JUNGLE_LOG);
        simpleLamp(recipeOutput, ModBlock.LAMP_JAPANESE_OAK.get(), Blocks.OAK_LOG);
        simpleLamp(recipeOutput, ModBlock.LAMP_JAPANESE_SPRUCE.get(), Blocks.SPRUCE_LOG);
        simpleLamp(recipeOutput, ModBlock.LAMP_JAPANESE_ACACIA.get(), Blocks.ACACIA_LOG);
        simpleLamp(recipeOutput, ModBlock.LAMP_JAPANESE_DARK_OAK.get(), Blocks.DARK_OAK_LOG);
        simpleLamp(recipeOutput, ModBlock.LAMP_JAPANESE_MANGROVE.get(), Blocks.MANGROVE_LOG);

        simpleLantern(recipeOutput, ModBlock.LANTERN_JAPANESE.get(), Items.PAPER);
        simpleLantern(recipeOutput, ModBlock.LANTERN_JAPANESE_SAKURA.get(), Items.PINK_DYE);
        simpleLantern(recipeOutput, ModBlock.LANTERN_JAPANESE_FESTIVAL.get(), Items.RED_DYE);
        doubleSimpleShapelessOneUnlockedBy(recipeOutput, ModBlock.LANTERN_JAPANESE_BIG.get(), ModBlock.LANTERN_JAPANESE.get(), ModBlock.LANTERN_JAPANESE.get());
        doubleSimpleShapelessOneUnlockedBy(recipeOutput, ModBlock.LANTERN_JAPANESE_SAKURA_BIG.get(), ModBlock.LANTERN_JAPANESE_SAKURA.get(), ModBlock.LANTERN_JAPANESE_SAKURA.get());
        doubleSimpleShapelessOneUnlockedBy(recipeOutput, ModBlock.LANTERN_JAPANESE_FESTIVAL_BIG.get(), ModBlock.LANTERN_JAPANESE_FESTIVAL.get(), ModBlock.LANTERN_JAPANESE_FESTIVAL.get());
        simpleThreeCake(recipeOutput, ModBlock.LANTERN_HUGE_JAPANESE.get(), ModBlock.LANTERN_JAPANESE.get());
        simpleThreeCake(recipeOutput, ModBlock.LANTERN_SAKURA_HUGE_JAPANESE.get(), ModBlock.LANTERN_JAPANESE_SAKURA.get());
        simpleThreeCake(recipeOutput, ModBlock.LANTERN_FESTIVAL_HUGE_JAPANESE.get(), ModBlock.LANTERN_JAPANESE_FESTIVAL.get());

        simpleDoor(recipeOutput, ModBlock.DOOR_SHOJI_BIRCH.get(), Blocks.BIRCH_PLANKS);
        simpleDoor2(recipeOutput, ModBlock.DOOR_SHOJI_BIRCH_SMALL.get(), Blocks.BIRCH_PLANKS);
        simpleDoor(recipeOutput, ModBlock.DOOR_SHOJI_BLOSSOM.get(), Blocks.CHERRY_PLANKS);
        simpleDoor2(recipeOutput, ModBlock.DOOR_SHOJI_BLOSSOM_SMALL.get(), Blocks.CHERRY_PLANKS);
        simpleDoor(recipeOutput, ModBlock.DOOR_SHOJI_CHERRY.get(), Blocks.CHERRY_LOG);
        simpleDoor2(recipeOutput, ModBlock.DOOR_SHOJI_CHERRY_SMALL.get(), Blocks.CHERRY_LOG);

        simpleShoji(recipeOutput, ModBlock.SHOJI_BIRCH.get(), Blocks.BIRCH_PLANKS);
        simpleShoji2(recipeOutput, ModBlock.SHOJI_BIRCH_SMALL.get(), Blocks.BIRCH_PLANKS);
        simpleShojiBase(recipeOutput, ModBlock.SHOJI_BIRCH_BOTTOM.get(), Blocks.BIRCH_PLANKS);
        simpleShojiBase2(recipeOutput, ModBlock.SHOJI_BIRCH_SMALL_BOTTOM.get(), Blocks.BIRCH_PLANKS);
        simpleShoji(recipeOutput, ModBlock.SHOJI_BLOSSOM.get(), Blocks.CHERRY_PLANKS);
        simpleShoji2(recipeOutput, ModBlock.SHOJI_BLOSSOM_SMALL.get(), Blocks.CHERRY_PLANKS);
        simpleShojiBase(recipeOutput, ModBlock.SHOJI_BLOSSOM_BOTTOM.get(), Blocks.CHERRY_PLANKS);
        simpleShojiBase2(recipeOutput, ModBlock.SHOJI_BLOSSOM_SMALL_BOTTOM.get(), Blocks.CHERRY_PLANKS);
        simpleShoji(recipeOutput, ModBlock.SHOJI_CHERRY.get(), Blocks.CHERRY_LOG);
        simpleShoji2(recipeOutput, ModBlock.SHOJI_CHERRY_SMALL.get(), Blocks.CHERRY_LOG);
        simpleShojiBase(recipeOutput, ModBlock.SHOJI_CHERRY_BOTTOM.get(), Blocks.CHERRY_LOG);
        simpleShojiBase2(recipeOutput, ModBlock.SHOJI_CHERRY_SMALL_BOTTOM.get(), Blocks.CHERRY_LOG);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.PICNIC_BASKET.get(), 1)
                .pattern(" A ")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Blocks.BAMBOO)
                .define('B', Items.PINK_WOOL)
                .unlockedBy(getHasName(Blocks.OAK_PLANKS), has(Blocks.OAK_PLANKS))
                .unlockedBy(getHasName(Items.CHEST), has(Items.CHEST))
                .save(recipeOutput);

        simpleTable(recipeOutput, ModBlock.TABLE_JAPANESE_BIRCH.get(), Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_SLAB);
        simpleTable(recipeOutput, ModBlock.TABLE_JAPANESE_CHERRY_PLANK.get(), Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_SLAB);
        simpleTable(recipeOutput, ModBlock.TABLE_JAPANESE_CHERRY_LOG.get(), Blocks.CHERRY_LOG, Blocks.CHERRY_WOOD);
        simpleTable(recipeOutput, ModBlock.TABLE_JAPANESE_OAK.get(), Blocks.STRIPPED_OAK_LOG, Blocks.OAK_SLAB);
        simpleTable(recipeOutput, ModBlock.TABLE_JAPANESE_SPRUCE.get(), Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_SLAB);

        simpleChair(recipeOutput, ModBlock.CHAIR_JAPANESE_BIRCH.get(), Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_SLAB);
        simpleChair(recipeOutput, ModBlock.CHAIR_JAPANESE_CHERRY_PLANK.get(), Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_SLAB);
        simpleChair(recipeOutput, ModBlock.CHAIR_JAPANESE_CHERRY_LOG.get(), Blocks.CHERRY_LOG, Blocks.CHERRY_WOOD);
        simpleChair(recipeOutput, ModBlock.CHAIR_JAPANESE_OAK.get(), Blocks.STRIPPED_OAK_LOG, Blocks.OAK_SLAB);
        simpleChair(recipeOutput, ModBlock.CHAIR_JAPANESE_SPRUCE.get(), Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_SLAB);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlock.BONZAI_CHERRY.get(), 1)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" C ")
                .define('A', Blocks.CHERRY_LEAVES)
                .define('B', Blocks.CHERRY_SAPLING)
                .define('C', Blocks.FLOWER_POT)
                .unlockedBy(getHasName(Blocks.CHERRY_LEAVES), has(Blocks.CHERRY_LEAVES))
                .unlockedBy(getHasName(Blocks.CHERRY_SAPLING), has(Blocks.CHERRY_SAPLING))
                .unlockedBy(getHasName(Blocks.FLOWER_POT), has(Blocks.FLOWER_POT))
                .save(recipeOutput);

        simpleFruitSapling(recipeOutput, ModBlock.BOBA_SAPLING.get(), ModItem.RAW_BOBA.get());
        simpleFruitSapling(recipeOutput, ModBlock.LEMON_SAPLING.get(), ModItem.LEMON.get());
        simpleFruitSapling(recipeOutput, ModBlock.PISTACHIO_SAPLING.get(), ModItem.PISTACHIO.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.RANDOM_PLUSH_BOX.get(), 1)
                .pattern("ABA")
                .pattern("CDC")
                .pattern("ABA")
                .define('A', Items.STICK)
                .define('B', Items.PINK_WOOL)
                .define('C', Items.WHITE_WOOL)
                .define('D', Items.STRING)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(Items.PINK_WOOL), has(Items.PINK_WOOL))
                .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(recipeOutput);

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItem.RAW_BOBA.get()), RecipeCategory.FOOD, ModItem.BOBA.get(), 0.35F, 200, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .group(roastedMarshmallowStick)
                .unlockedBy(getHasName(ModItem.RAW_BOBA.get()), has(ModItem.RAW_BOBA.get()))
                .save(recipeOutput);

        doubleSimpleShapeless(recipeOutput, ModItem.SQUID_STICK.get(), 1, ModItem.RAW_SQUID.get(), Items.STICK);

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItem.SQUID_STICK.get()), RecipeCategory.FOOD, ModItem.SQUID_COOKED.get(), 0.35F, 200, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .group(roastedMarshmallowStick)
                .unlockedBy(getHasName(ModItem.SQUID_STICK.get()), has(ModItem.SQUID_STICK.get()))
                .unlockedBy(getHasName(ModItem.RAW_SQUID.get()), has(ModItem.RAW_SQUID.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.GIFT_BOX.get(), 1)
                .pattern("ABA")
                .pattern("ACA")
                .pattern("AAA")
                .define('A', Items.PAPER)
                .define('B', Items.STRING)
                .define('C', Items.PINK_DYE)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .unlockedBy(getHasName(Items.PINK_DYE), has(Items.PINK_DYE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.LUCKY_NEKO.get(), 1)
                .pattern("A A")
                .pattern("BCB")
                .pattern("DDD")
                .define('A', Items.GOLD_INGOT)
                .define('B', Items.STRING)
                .define('C', Items.RED_DYE)
                .define('D', Blocks.GOLD_BLOCK)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                .unlockedBy(getHasName(Items.GOLD_BLOCK), has(Items.GOLD_BLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.LOVE_LETTER.get(), 1)
                .requires(Items.PAPER)
                .requires(Items.FEATHER)
                .requires(ModItem.FAIRY_DUST.get())
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .unlockedBy(getHasName(Items.FEATHER), has(Items.FEATHER))
                .unlockedBy(getHasName(ModItem.FAIRY_DUST.get()), has(ModItem.FAIRY_DUST.get()))
                .save(recipeOutput);

        simpleMoonStick(recipeOutput, ModItem.CUTIE_MOON_ROD.get());
        simpleMoonStick(recipeOutput, ModItem.ETERNAL_TIARE.get());
        simpleMoonStick(recipeOutput, ModItem.MOON_KALEIDOSCOPE.get());
        simpleMoonStick(recipeOutput, ModItem.MOON_STICK.get());
        simpleMoonStick(recipeOutput, ModItem.MOON_STICK_PEARL.get());
        simpleMoonStick(recipeOutput, ModItem.SPIRAL_HEART_MOON_ROD.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.CUPIDON_BOW.get(), 1)
                .pattern("ABB")
                .pattern("BCD")
                .pattern("BDD")
                .define('A', ModItem.PINK_SAPPHIRE.get())
                .define('B', Items.FEATHER)
                .define('C', Items.BOW)
                .define('D', ModItem.FAIRY_DUST.get())
                .unlockedBy(getHasName(ModItem.PINK_SAPPHIRE.get()), has(ModItem.PINK_SAPPHIRE.get()))
                .unlockedBy(getHasName(Items.FEATHER), has(Items.FEATHER))
                .unlockedBy(getHasName(Items.BOW), has(Items.BOW))
                .unlockedBy(getHasName(ModItem.FAIRY_DUST.get()), has(ModItem.FAIRY_DUST.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.HEART_ARROW.get(), 3)
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .define('A', ModItem.PINK_SAPPHIRE.get())
                .define('B', Items.ARROW)
                .define('C', ModItem.FAIRY_DUST.get())
                .unlockedBy(getHasName(ModItem.PINK_SAPPHIRE.get()), has(ModItem.PINK_SAPPHIRE.get()))
                .unlockedBy(getHasName(Items.ARROW), has(Items.ARROW))
                .unlockedBy(getHasName(ModItem.FAIRY_DUST.get()), has(ModItem.FAIRY_DUST.get()))
                .save(recipeOutput);

        simpleShapeless(recipeOutput, RecipeCategory.MISC, ModItem.STRAWBERRY_SEEDS.get(), 1, ModItem.STRAWBERRY.get());
        simpleShapeless(recipeOutput, RecipeCategory.MISC, ModItem.MINT_SEEDS.get(), 1, ModItem.MINT.get());
        simpleShapeless(recipeOutput, RecipeCategory.MISC, ModItem.VANILLA_SEEDS.get(), 1, ModItem.VANILLA.get());

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_AXE.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_AXE.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_AXE.get()), has(ModItem.PINK_SAPPHIRE_AXE.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_axe_from_pink_sapphire_axe"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_PICKAXE.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_PICKAXE.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_PICKAXE.get()), has(ModItem.PINK_SAPPHIRE_PICKAXE.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_pickaxe_from_pink_sapphire_pickaxe"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_HOE.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_HOE.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_HOE.get()), has(ModItem.PINK_SAPPHIRE_HOE.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_hoe_from_pink_sapphire_hoe"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_SHOVEL.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_SHOVEL.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_SHOVEL.get()), has(ModItem.PINK_SAPPHIRE_SHOVEL.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_shovel_from_pink_sapphire_shovel"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_SWORD.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_SWORD.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_SWORD.get()), has(ModItem.PINK_SAPPHIRE_SWORD.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_sword_from_pink_sapphire_sword"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_BOOTS.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_BOOTS.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_BOOTS.get()), has(ModItem.PINK_SAPPHIRE_BOOTS.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_boots_from_pink_sapphire_boots"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_CHESTPLATE.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_CHESTPLATE.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_CHESTPLATE.get()), has(ModItem.PINK_SAPPHIRE_CHESTPLATE.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_chestplate_from_pink_sapphire_chestplate"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_HELMET.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_HELMET.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_HELMET.get()), has(ModItem.PINK_SAPPHIRE_HELMET.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_helmet_from_pink_sapphire_helmet"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItem.RUBY_TEMPLATE_UPGRADE.get()), Ingredient.of(ModItem.PINK_SAPPHIRE_LEGGINGS.get()), Ingredient.of(ModItem.RUBY.get()), RecipeCategory.TOOLS, ModItem.RUBY_LEGGINGS.get())
                .unlocks(getHasName(ModItem.RUBY_TEMPLATE_UPGRADE.get()), has(ModItem.RUBY_TEMPLATE_UPGRADE.get()))
                .unlocks(getHasName(ModItem.PINK_SAPPHIRE_LEGGINGS.get()), has(ModItem.PINK_SAPPHIRE_LEGGINGS.get()))
                .unlocks(getHasName(ModItem.RUBY.get()), has(ModItem.RUBY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "ruby_leggings_from_pink_sapphire_leggings"));
    }

    protected static void simpleMoonStick(RecipeOutput finishedRecipeConsumer, ItemLike stick) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stick, 1)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" C ")
                .define('A', ModItem.PINK_SAPPHIRE.get())
                .define('B', Items.BLAZE_ROD)
                .define('C', ModItem.FAIRY_DUST.get())
                .unlockedBy(getHasName(ModItem.PINK_SAPPHIRE.get()), has(ModItem.PINK_SAPPHIRE.get()))
                .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD))
                .unlockedBy(getHasName(ModItem.FAIRY_DUST.get()), has(ModItem.FAIRY_DUST.get()))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleMilkBucket(RecipeOutput finishedRecipeConsumer, ItemLike ingredient, ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', ingredient)
                .define('B', Items.MILK_BUCKET)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleTable(RecipeOutput finishedRecipeConsumer, ItemLike table, ItemLike log, ItemLike slab) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, table, 1)
                .pattern("AAA")
                .pattern("B B")
                .pattern("B B")
                .define('A', slab)
                .define('B', log)
                .unlockedBy(getHasName(log), has(log))
                .unlockedBy(getHasName(slab), has(slab))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleChair(RecipeOutput finishedRecipeConsumer, ItemLike chair, ItemLike log, ItemLike slab) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, chair, 1)
                .pattern("A  ")
                .pattern("ABA")
                .pattern("C C")
                .define('A', slab)
                .define('B', ItemTags.WOOL)
                .define('C', log)
                .unlockedBy(getHasName(log), has(log))
                .unlockedBy(getHasName(slab), has(slab))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleFruitSapling(RecipeOutput finishedRecipeConsumer, ItemLike sapling, ItemLike fruit) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, sapling, 1)
                .requires(fruit)
                .requires(fruit)
                .requires(ItemTags.SAPLINGS)
                .unlockedBy(getHasName(fruit), has(fruit))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleShoji(RecipeOutput finishedRecipeConsumer, ItemLike shoji, ItemLike wood) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, shoji, 3)
                .pattern("ABA")
                .pattern("BAB")
                .pattern("ABA")
                .define('A', wood)
                .define('B', Items.PAPER)
                .unlockedBy(getHasName(wood), has(wood))
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(finishedRecipeConsumer);
    }
    protected static void simpleShoji2(RecipeOutput finishedRecipeConsumer, ItemLike shoji, ItemLike wood) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, shoji, 3)
                .pattern("BAB")
                .pattern("ABA")
                .pattern("BAB")
                .define('A', wood)
                .define('B', Items.PAPER)
                .unlockedBy(getHasName(wood), has(wood))
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleShojiBase(RecipeOutput finishedRecipeConsumer, ItemLike shoji, ItemLike wood) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, shoji, 3)
                .pattern("ABA")
                .pattern("BAB")
                .pattern("AAA")
                .define('A', wood)
                .define('B', Items.PAPER)
                .unlockedBy(getHasName(wood), has(wood))
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(finishedRecipeConsumer);
    }
    protected static void simpleShojiBase2(RecipeOutput finishedRecipeConsumer, ItemLike shoji, ItemLike wood) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, shoji, 3)
                .pattern("BAB")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', wood)
                .define('B', Items.PAPER)
                .unlockedBy(getHasName(wood), has(wood))
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleDoor(RecipeOutput finishedRecipeConsumer, ItemLike door, ItemLike wood) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, door, 3)
                .pattern("BA")
                .pattern("AB")
                .pattern("BA")
                .define('A', Items.PAPER)
                .define('B', wood)
                .unlockedBy(getHasName(wood), has(wood))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleDoor2(RecipeOutput finishedRecipeConsumer, ItemLike door, ItemLike wood) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, door, 3)
                .pattern("AB")
                .pattern("BA")
                .pattern("AB")
                .define('A', Items.PAPER)
                .define('B', wood)
                .unlockedBy(getHasName(wood), has(wood))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleLantern(RecipeOutput finishedRecipeConsumer, ItemLike lantern, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, lantern, 1)
                .pattern("ABA")
                .pattern("ACA")
                .pattern("ABA")
                .define('A', Items.PAPER)
                .define('B', ingredient)
                .define('C', Items.TORCH)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleLamp(RecipeOutput finishedRecipeConsumer, ItemLike lamp, ItemLike wood) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, lamp, 1)
                .pattern("A A")
                .pattern("BCB")
                .pattern("D D")
                .define('A', Items.PAPER)
                .define('B', Items.STICK)
                .define('C', Items.TORCH)
                .define('D', wood)
                .unlockedBy(getHasName(wood), has(wood))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleScrool(RecipeOutput finishedRecipeConsumer, ItemLike result, ItemLike ingredient1) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern(" A ")
                .pattern("BCB")
                .pattern("DDD")
                .define('A', Items.STRING)
                .define('B', Items.STICK)
                .define('C', ingredient1)
                .define('D', Items.PAPER)
                .unlockedBy(getHasName(ingredient1), has(ingredient1))
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleScreen(RecipeOutput finishedRecipeConsumer, ItemLike screen, ItemLike wood) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, screen, 1)
                .pattern("ABA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', wood)
                .define('B', Items.PAPER)
                .unlockedBy(getHasName(wood), has(wood))
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(finishedRecipeConsumer);
    }

    protected static void simplePie(RecipeOutput finishedRecipeConsumer, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .pattern("ABC")
                .pattern("DDD")
                .define('A', Items.SUGAR)
                .define('B', ingredient)
                .define('C', Items.EGG)
                .define('D', Items.WHEAT)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleCroissant(RecipeOutput finishedRecipeConsumer, ItemLike result, ItemLike ingredient1) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result, 3)
                .pattern(" AB")
                .pattern("CDE")
                .pattern("CC ")
                .define('A', Items.SUGAR)
                .define('B', ingredient1)
                .define('C', Items.WHEAT)
                .define('D', ModItem.CREAM.get())
                .define('E', Items.EGG)
                .unlockedBy(getHasName(ingredient1), has(ingredient1))
                .save(finishedRecipeConsumer);
    }

    protected static void simplePudding(RecipeOutput finishedRecipeConsumer, ItemLike result, ItemLike ingredient1) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .pattern("ABA")
                .pattern("CDC")
                .pattern("ABA")
                .define('A', ModItem.AGARAGAR.get())
                .define('B', Items.SUGAR)
                .define('C', ingredient1)
                .define('D', Items.MILK_BUCKET)
                .unlockedBy(getHasName(ingredient1), has(ingredient1))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleCake(RecipeOutput finishedRecipeConsumer, ItemLike result, ItemLike ingredient1, ItemLike ingredient2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .pattern("ABA")
                .pattern("CDC")
                .pattern("EEE")
                .define('A', ingredient1)
                .define('B', ingredient2)
                .define('C', Items.SUGAR)
                .define('D', Items.MILK_BUCKET)
                .define('E', Items.WHEAT)
                .unlockedBy(getHasName(ingredient1), has(ingredient1))
                .unlockedBy(getHasName(ingredient2), has(ingredient2))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleThreeCake(RecipeOutput finishedRecipeConsumer, ItemLike result, ItemLike cake) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .pattern("A")
                .pattern("A")
                .pattern("A")
                .define('A', cake)
                .unlockedBy(getHasName(cake), has(cake))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleShapeless(RecipeOutput finishedRecipeConsumer, RecipeCategory category, ItemLike result, int resultCount, ItemLike ingredient1) {
        ShapelessRecipeBuilder.shapeless(category, result, resultCount)
                .requires(ingredient1, 1)
                .unlockedBy(getHasName(ingredient1), has(ingredient1))
                .save(finishedRecipeConsumer);
    }

    protected static void doubleSimpleShapeless(RecipeOutput finishedRecipeConsumer, ItemLike result, int resultCount, ItemLike ingredient1, ItemLike ingredient2) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, resultCount)
                .requires(ingredient1, 1)
                .requires(ingredient2, 1)
                .unlockedBy(getHasName(ingredient1), has(ingredient1))
                .unlockedBy(getHasName(ingredient2), has(ingredient2))
                .save(finishedRecipeConsumer);
    }

    protected static void doubleSimpleShapelessOneUnlockedBy(RecipeOutput finishedRecipeConsumer, ItemLike result, ItemLike ingredient1, ItemLike ingredient2) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 1)
                .requires(ingredient1, 1)
                .requires(ingredient2, 1)
                .unlockedBy(getHasName(ingredient1), has(ingredient1))
                .save(finishedRecipeConsumer);
    }

    protected static void mojinRecipes(RecipeOutput finishedRecipeConsumer, ItemLike mojin, ItemLike flavor) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, mojin)
                .pattern("ABC")
                .pattern("DED")
                .pattern(" F ")
                .define('A', ModItem.MINT.get())
                .define('B', ModItem.LEMON.get())
                .define('C', flavor)
                .define('D', Items.SUGAR)
                .define('E', Items.WATER_BUCKET)
                .define('F', ModItem.JUICE_GLASS.get())
                .unlockedBy(getHasName(ModItem.JUICE_GLASS.get()), has(ModItem.JUICE_GLASS.get()))
                .save(finishedRecipeConsumer);
    }

    protected static void simpleBubbleTea(RecipeOutput finishedRecipeConsumer, ItemLike bubbleTea, ItemLike flavor) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, bubbleTea)
                .pattern("ABA")
                .pattern("CCC")
                .pattern(" D ")
                .define('A', ModItem.BOBA.get())
                .define('B', Items.WATER_BUCKET)
                .define('C', flavor)
                .define('D', ModItem.JUICE_GLASS.get())
                .unlockedBy(getHasName(ModItem.JUICE_GLASS.get()), has(ModItem.JUICE_GLASS.get()))
                .unlockedBy(getHasName(ModItem.BOBA.get()), has(ModItem.BOBA.get()))
                .save(finishedRecipeConsumer);
    }

    protected static void iceCreamRecipes(RecipeOutput finishedRecipeConsumer, ItemLike iceCream, ItemLike flavor) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, iceCream, 1)
                .pattern("ABC")
                .pattern("DEF")
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.SNOWBALL)
                .define('C', Items.EGG)
                .define('D', Items.SUGAR)
                .define('E', ModItem.ICE_CREAM_CUP.get())
                .define('F', flavor)
                .unlockedBy(getHasName(ModItem.ICE_CREAM_CUP.get()), has(ModItem.ICE_CREAM_CUP.get()))
                .save(finishedRecipeConsumer);
    }

    protected static void waffleIceCreamRecipes(RecipeOutput finishedRecipeConsumer, ItemLike waffleIceCream, ItemLike flavor) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, waffleIceCream, 1)
                .pattern("ABC")
                .pattern("DEF")
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.SNOWBALL)
                .define('C', Items.EGG)
                .define('D', Items.SUGAR)
                .define('E', ModItem.FISH_WAFFLE.get())
                .define('F', flavor)
                .unlockedBy(getHasName(ModItem.WAFFLE.get()), has(ModItem.WAFFLE.get()))
                .save(finishedRecipeConsumer);
    }


    protected static void blockIngotRecipes(RecipeOutput finishedRecipeConsumer, ItemLike block, ItemLike ingot) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(finishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, block.asItem().getDescriptionId() + "_from_" + ingot.asItem().getDescriptionId() + "_item"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9)
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(finishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID,ingot.asItem().getDescriptionId() + "_item_from_" + block.asItem().getDescriptionId()));
    }

    protected static void armorRecipes(RecipeOutput finishedRecipeConsumer, Item helmet, Item chestplate, Item leggings, Item boots, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, helmet)
                .pattern("AAA")
                .pattern("A A")
                .define('A', material)
                .unlockedBy(getHasName(material), has(material))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, chestplate)
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', material)
                .unlockedBy(getHasName(material), has(material))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, leggings)
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', material)
                .unlockedBy(getHasName(material), has(material))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, boots)
                .pattern("A A")
                .pattern("A A")
                .define('A', material)
                .unlockedBy(getHasName(material), has(material))
                .save(finishedRecipeConsumer);
    }

    protected static void toolRecipes(RecipeOutput finishedRecipeConsumer, Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, sword)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', material)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', material)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', material)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', material)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .pattern(" AA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', material)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(finishedRecipeConsumer);
    }

}
