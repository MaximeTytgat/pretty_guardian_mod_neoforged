package com.max.prettyguardian.datagen;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.item.ModItem;
import com.max.prettyguardian.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, PrettyGuardian.MOD_ID);
    }

    @Override
    protected void start() {
        add("raw_squid_from_squid", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/squid")).build()
        }, ModItem.RAW_SQUID.get(), 1));

        add("ruby_template_upgrade_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.6f).build()
        }, ModItem.RUBY_TEMPLATE_UPGRADE.get(), 1));

        float seedsChance = 0.1f;
        add("strawberry_seeds_from_short_grass", new AddItemModifier(new LootItemCondition[] {
                new LootItemBlockStatePropertyCondition.Builder(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(seedsChance).build()
        },
                ModItem.STRAWBERRY_SEEDS.get()
        , 1));

        add("strawberry_seeds_from_tall_grass", new AddItemModifier(new LootItemCondition[] {
                new LootItemBlockStatePropertyCondition.Builder(Blocks.TALL_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(seedsChance).build()
        },
                ModItem.STRAWBERRY_SEEDS.get()
        , 1));

        add("mint_seeds_from_short_grass", new AddItemModifier(new LootItemCondition[] {
                new LootItemBlockStatePropertyCondition.Builder(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(seedsChance).build()
        },
                ModItem.MINT_SEEDS.get()
        , 1));

        add("mint_seeds_from_tall_grass", new AddItemModifier(new LootItemCondition[] {
                new LootItemBlockStatePropertyCondition.Builder(Blocks.TALL_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(seedsChance).build()
        },
                ModItem.MINT_SEEDS.get()
        , 1));

        add("vanilla_seeds_from_short_grass", new AddItemModifier(new LootItemCondition[] {
                new LootItemBlockStatePropertyCondition.Builder(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(seedsChance).build()
        },
                ModItem.VANILLA_SEEDS.get()
        , 1));

        add("vanilla_seeds_from_tall_grass", new AddItemModifier(new LootItemCondition[] {
                new LootItemBlockStatePropertyCondition.Builder(Blocks.TALL_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(seedsChance).build()
        },
                ModItem.VANILLA_SEEDS.get()
        , 1));
    }
}
