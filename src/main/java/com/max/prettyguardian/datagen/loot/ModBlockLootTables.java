package com.max.prettyguardian.datagen.loot;

import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.block.custom.crop.StrawberryCropBlock;
import com.max.prettyguardian.block.custom.furniture.JapDoubleLanternBlock;
import com.max.prettyguardian.block.custom.furniture.JapHugeLanternBlock;
import com.max.prettyguardian.block.custom.furniture.JapScreenBlock;
import com.max.prettyguardian.item.ModItem;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class ModBlockLootTables extends BlockLootSubProvider {
    private final List<Block> knownBlocks = new ArrayList<Block>();

    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlock.STRAWBERRY_CROP.get());
        this.dropSelf(ModBlock.PINK_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlock.RUBY_BLOCK.get());
        this.dropSelf(ModBlock.CHOCOLATE_BLOCK.get());
        this.dropSelf(ModBlock.MARSHMELLO_BLOCK.get());
        this.dropSelf(ModBlock.ROASTED_MARSHMELLO_BLOCK.get());
        this.dropSelf(ModBlock.PISTACHIO_SAPLING.get());
        this.dropSelf(ModBlock.LEMON_SAPLING.get());
        this.dropSelf(ModBlock.BOBA_SAPLING.get());
        this.dropSelf(ModBlock.MYMELODY_PLUSH.get());
        this.dropSelf(ModBlock.KUROMI_PLUSH.get());
        this.dropSelf(ModBlock.CAVALIER_PLUSH.get());
        this.dropSelf(ModBlock.TEDDYBEAR_PLUSH.get());
        this.dropSelf(ModBlock.RABBIT_PLUSH.get());
        this.dropSelf(ModBlock.COW_PLUSH.get());
        this.dropSelf(ModBlock.CINNAMOROLL_PLUSH.get());
        this.dropSelf(ModBlock.BABYYODA_PLUSH.get());
        this.dropSelf(ModBlock.CAPPUCCINO_PLUSH.get());
        this.dropSelf(ModBlock.CHIFFON_PLUSH.get());
        this.dropSelf(ModBlock.EXPRESSO_PLUSH.get());
        this.dropSelf(ModBlock.MOCHA_PLUSH.get());
        this.dropSelf(ModBlock.PRINCESS_PORON_PLUSH.get());
        this.dropSelf(ModBlock.PLUSH_BEAR_HUGE.get());

        this.add(ModBlock.SCREEN_JAPANESE_CHERRY_PLANK.get(), this::createSreenLootTable);
        this.add(ModBlock.SCREEN_JAPANESE_CHERRY_LOG.get(), this::createSreenLootTable);
        this.add(ModBlock.SCREEN_JAPANESE_BIRCH.get(), this::createSreenLootTable);

        this.dropSelf(ModBlock.SHOJI_BLOSSOM.get());
        this.dropSelf(ModBlock.SHOJI_BLOSSOM_BOTTOM.get());
        this.dropSelf(ModBlock.SHOJI_BLOSSOM_SMALL.get());
        this.dropSelf(ModBlock.SHOJI_BLOSSOM_SMALL_BOTTOM.get());

        this.dropSelf(ModBlock.SHOJI_CHERRY.get());
        this.dropSelf(ModBlock.SHOJI_CHERRY_BOTTOM.get());
        this.dropSelf(ModBlock.SHOJI_CHERRY_SMALL.get());
        this.dropSelf(ModBlock.SHOJI_CHERRY_SMALL_BOTTOM.get());

        this.dropSelf(ModBlock.SHOJI_BIRCH.get());
        this.dropSelf(ModBlock.SHOJI_BIRCH_BOTTOM.get());
        this.dropSelf(ModBlock.SHOJI_BIRCH_SMALL.get());
        this.dropSelf(ModBlock.SHOJI_BIRCH_SMALL_BOTTOM.get());

        this.dropSelf(ModBlock.LANTERN_JAPANESE.get());
        this.dropSelf(ModBlock.LANTERN_JAPANESE_SAKURA.get());
        this.dropSelf(ModBlock.LANTERN_JAPANESE_FESTIVAL.get());

        this.add(ModBlock.LANTERN_JAPANESE_BIG.get(), this::createBigLanternLootTable);
        this.add(ModBlock.LANTERN_JAPANESE_SAKURA_BIG.get(), this::createBigLanternLootTable);
        this.add(ModBlock.LANTERN_JAPANESE_FESTIVAL_BIG.get(), this::createBigLanternLootTable);

        this.add(ModBlock.LANTERN_HUGE_JAPANESE.get(), this::createHugeLanternLootTable);
        this.add(ModBlock.LANTERN_SAKURA_HUGE_JAPANESE.get(), this::createHugeLanternLootTable);
        this.add(ModBlock.LANTERN_FESTIVAL_HUGE_JAPANESE.get(), this::createHugeLanternLootTable);

        this.add(ModBlock.BONZAI_CHERRY.get(), this::createBonzaiLootTable);
        this.add(ModBlock.LUCKY_NEKO.get(), this::createBonzaiLootTable);
        this.add(ModBlock.SCROLL_JAPANESE_AXOLOTL.get(), this::createBonzaiLootTable);
        this.add(ModBlock.SCROLL_JAPANESE_BEE.get(), this::createBonzaiLootTable);
        this.add(ModBlock.SCROLL_JAPANESE_CINNAMON_ROLL.get(), this::createBonzaiLootTable);
        this.add(ModBlock.SCROLL_JAPANESE_MUSHROOM.get(), this::createBonzaiLootTable);
        this.add(ModBlock.SCROLL_JAPANESE_DAY.get(), this::createBonzaiLootTable);
        this.add(ModBlock.SCROLL_JAPANESE_NIGHT.get(), this::createBonzaiLootTable);
        this.add(ModBlock.SCROLL_JAPANESE_DAY_2.get(), this::createBonzaiLootTable);
        this.add(ModBlock.SCROLL_JAPANESE_SUNFLOWER.get(), this::createBonzaiLootTable);

        this.dropSelf(ModBlock.LAMP_JAPANESE_OAK.get());
        this.dropSelf(ModBlock.LAMP_JAPANESE_BIRCH.get());
        this.dropSelf(ModBlock.LAMP_JAPANESE_SPRUCE.get());
        this.dropSelf(ModBlock.LAMP_JAPANESE_JUNGLE.get());
        this.dropSelf(ModBlock.LAMP_JAPANESE_ACACIA.get());
        this.dropSelf(ModBlock.LAMP_JAPANESE_DARK_OAK.get());
        this.dropSelf(ModBlock.LAMP_JAPANESE_MANGROVE.get());
        this.dropSelf(ModBlock.LAMP_JAPANESE_CHERRY.get());

        this.add(ModBlock.DOOR_SHOJI_BLOSSOM.get(), this::createBonzaiLootTable);
        this.add(ModBlock.DOOR_SHOJI_BLOSSOM_SMALL.get(), this::createBonzaiLootTable);
        this.add(ModBlock.DOOR_SHOJI_BIRCH.get(), this::createBonzaiLootTable);
        this.add(ModBlock.DOOR_SHOJI_BIRCH_SMALL.get(), this::createBonzaiLootTable);
        this.add(ModBlock.DOOR_SHOJI_CHERRY.get(), this::createBonzaiLootTable);
        this.add(ModBlock.DOOR_SHOJI_CHERRY_SMALL.get(), this::createBonzaiLootTable);

        this.dropSelf(ModBlock.TABLE_JAPANESE_OAK.get());
        this.dropSelf(ModBlock.TABLE_JAPANESE_BIRCH.get());
        this.dropSelf(ModBlock.TABLE_JAPANESE_SPRUCE.get());
        this.dropSelf(ModBlock.TABLE_JAPANESE_CHERRY_LOG.get());
        this.dropSelf(ModBlock.TABLE_JAPANESE_CHERRY_PLANK.get());

        this.dropSelf(ModBlock.CHAIR_JAPANESE_OAK.get());
        this.dropSelf(ModBlock.CHAIR_JAPANESE_BIRCH.get());
        this.dropSelf(ModBlock.CHAIR_JAPANESE_SPRUCE.get());
        this.dropSelf(ModBlock.CHAIR_JAPANESE_CHERRY_LOG.get());
        this.dropSelf(ModBlock.CHAIR_JAPANESE_CHERRY_PLANK.get());

        this.dropSelf(ModBlock.SILVER_CRYSTAL.get());

        this.dropSelf(ModBlock.SEA_SHELL.get());

        this.dropSelf(ModBlock.GEM_POLISHING_STATION.get());
        this.dropSelf(ModBlock.MOON_ALTAR.get());


        this.add(ModBlock.PISTACHIO_LEAVES_CROP.get(), block -> createLeavesDrops(block, ModBlock.PISTACHIO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlock.LEMON_LEAVES_CROP.get(), block -> createLeavesDrops(block, ModBlock.LEMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlock.BOBA_LEAVES_CROP.get(), block -> createLeavesDrops(block, ModBlock.BOBA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));


        this.createLapisOreDrops(ModBlock.THREE_STRAWBERRY_CAKE.get());

        
        this.add(ModBlock.PINK_SAPPHIRE_ORE.get(), createOreDrop(ModBlock.PINK_SAPPHIRE_ORE.get(), ModItem.PINK_SAPPHIRE.get()));
        this.add(ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE.get(), createOreDrop(ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE.get(), ModItem.PINK_SAPPHIRE.get()));

        this.add(ModBlock.RUBY_ORE.get(), createOreDrop(ModBlock.RUBY_ORE.get(), ModItem.RUBY.get()));
        this.add(ModBlock.DEEPSLATE_RUBY_ORE.get(), createOreDrop(ModBlock.DEEPSLATE_RUBY_ORE.get(), ModItem.RUBY.get()));

        LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlock.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 4));

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlock.STRAWBERRY_CROP.get(),
                this.applyExplosionDecay(ModBlock.STRAWBERRY_CROP.get(),
                        LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItem.STRAWBERRY_SEEDS.get())))
                                .withPool(LootPool.lootPool().when(builder).add(LootItem.lootTableItem(ModItem.STRAWBERRY.get())
                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registrylookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 2))))
                                .withPool(LootPool.lootPool().when(builder).add(LootItem.lootTableItem(ModItem.STRAWBERRY_SEEDS.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))))));

        LootItemCondition.Builder builder1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlock.MINT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 4));

        this.add(ModBlock.MINT_CROP.get(), createCropDrops(ModBlock.MINT_CROP.get(), ModItem.MINT.get(),
                ModItem.MINT_SEEDS.get(), builder1));

        LootItemCondition.Builder builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlock.VANILLA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 7));

        this.add(ModBlock.VANILLA_CROP.get(), createCropDrops(ModBlock.VANILLA_CROP.get(), ModItem.VANILLA.get(),
                ModItem.VANILLA_SEEDS.get(), builder2));

        this.add(ModBlock.PICNIC_BASKET.get(), this::createShulkerBoxDrop);
    }

    protected LootTable.Builder createSreenLootTable(Block block) {
        return LootTable.lootTable().withPool(
                this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(DoorBlock.HALF, DoubleBlockHalf.LOWER)
                                                        .hasProperty(JapScreenBlock.PART, JapScreenBlock.ParaventPart.LEFT))))));

    }

    protected LootTable.Builder createHugeLanternLootTable(Block block) {
        return LootTable.lootTable().withPool(
                this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(JapHugeLanternBlock.HALF, JapHugeLanternBlock.TripleBlockHalf.MIDDLE))))));

    }

    protected LootTable.Builder createBigLanternLootTable(Block block) {
        return LootTable.lootTable().withPool(
                this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(JapDoubleLanternBlock.HALF, DoubleBlockHalf.UPPER))))));

    }

    protected LootTable.Builder createBonzaiLootTable(Block block) {
        return LootTable.lootTable().withPool(
                this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(JapDoubleLanternBlock.HALF, DoubleBlockHalf.LOWER))))));
    }

    @Override
    protected LootTable.@NotNull Builder createLapisOreDrops(@NotNull Block block) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(ModItem.STRAWBERRY_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 9.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected void add(@NotNull Block block, @NotNull LootTable.Builder builder) {
        super.add(block, builder);
        this.knownBlocks.add(block);
    }

    @Override
    protected void add(@NotNull Block block, @NotNull Function<Block, LootTable.Builder> factory) {
        super.add(block, factory);
        this.knownBlocks.add(block);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }
}
