package com.max.prettyguardian.datagen;

import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PrettyGuardian.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(ModTags.Blocks.CAKE).add(
                ModBlock.CHOCOLATE_CAKE.get(),
                ModBlock.THREE_CHOCO_CAKE.get(),
                ModBlock.THREE_STRAWBERRY_CAKE.get(),
                ModBlock.THREE_STRAWBERRY_CHOCO_CAKE.get()
        );

        tag(ModTags.Blocks.JAP_TABLE).add(
                ModBlock.TABLE_JAPANESE_OAK.get(),
                ModBlock.TABLE_JAPANESE_BIRCH.get(),
                ModBlock.TABLE_JAPANESE_SPRUCE.get(),
                ModBlock.TABLE_JAPANESE_CHERRY_LOG.get(),
                ModBlock.TABLE_JAPANESE_CHERRY_PLANK.get()
        );

        tag(BlockTags.SAPLINGS).add(
                ModBlock.BOBA_SAPLING.get(),
                ModBlock.LEMON_SAPLING.get(),
                ModBlock.PISTACHIO_SAPLING.get()
        );

        tag(BlockTags.LEAVES).add(
                ModBlock.BOBA_LEAVES_CROP.get(),
                ModBlock.LEMON_LEAVES_CROP.get(),
                ModBlock.PISTACHIO_LEAVES_CROP.get()
        );

        tag(ModTags.Blocks.NEEDS_PINK_SAPPHIRE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_PINK_SAPPHIRE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_PINK_SAPPHIRE_TOOL);

        tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(ModTags.Blocks.NEEDS_PINK_SAPPHIRE_TOOL);

        tag(ModTags.Blocks.INCORRECT_RUBY_TOOL)
                .addTag(ModTags.Blocks.INCORRECT_PINK_SAPPHIRE_TOOL)
                .remove(ModTags.Blocks.NEEDS_RUBY_TOOL);

//        tag(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlock.GEM_POLISHING_STATION.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlock.PINK_SAPPHIRE_ORE.get(),
                        ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE.get(),
                        ModBlock.PINK_SAPPHIRE_BLOCK.get(),
                        ModBlock.RUBY_ORE.get(),
                        ModBlock.DEEPSLATE_RUBY_ORE.get(),
                        ModBlock.RUBY_BLOCK.get()
                );

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(
                        ModBlock.GEM_POLISHING_STATION.get(),
                        ModBlock.LUCKY_NEKO.get(),
                        ModBlock.SILVER_CRYSTAL.get(),
                        ModBlock.MOON_ALTAR.get()
                );

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlock.PINK_SAPPHIRE_ORE.get(),
                        ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE.get(),
                        ModBlock.PINK_SAPPHIRE_BLOCK.get(),
                        ModBlock.RUBY_ORE.get(),
                        ModBlock.DEEPSLATE_RUBY_ORE.get(),
                        ModBlock.RUBY_BLOCK.get(),
                        ModBlock.GEM_POLISHING_STATION.get(),
                        ModBlock.SEA_SHELL.get(),
                        ModBlock.LUCKY_NEKO.get(),
                        ModBlock.SILVER_CRYSTAL.get(),
                        ModBlock.MOON_ALTAR.get()
                );

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        ModBlock.PICNIC_BASKET.get(),
                        ModBlock.SHOJI_BLOSSOM.get(),
                        ModBlock.SHOJI_BLOSSOM_BOTTOM.get(),
                        ModBlock.SHOJI_BLOSSOM_SMALL.get(),
                        ModBlock.SHOJI_BLOSSOM_SMALL_BOTTOM.get(),
                        ModBlock.SHOJI_CHERRY.get(),
                        ModBlock.SHOJI_CHERRY_BOTTOM.get(),
                        ModBlock.SHOJI_CHERRY_SMALL.get(),
                        ModBlock.SHOJI_CHERRY_SMALL_BOTTOM.get(),
                        ModBlock.SHOJI_BIRCH.get(),
                        ModBlock.SHOJI_BIRCH_BOTTOM.get(),
                        ModBlock.SHOJI_BIRCH_SMALL.get(),
                        ModBlock.SHOJI_BIRCH_SMALL_BOTTOM.get(),
                        ModBlock.LAMP_JAPANESE_OAK.get(),
                        ModBlock.LAMP_JAPANESE_SPRUCE.get(),
                        ModBlock.LAMP_JAPANESE_MANGROVE.get(),
                        ModBlock.LAMP_JAPANESE_CHERRY.get(),
                        ModBlock.LAMP_JAPANESE_BIRCH.get(),
                        ModBlock.LAMP_JAPANESE_JUNGLE.get(),
                        ModBlock.LAMP_JAPANESE_ACACIA.get(),
                        ModBlock.LAMP_JAPANESE_DARK_OAK.get(),
                        ModBlock.DOOR_SHOJI_BLOSSOM.get(),
                        ModBlock.DOOR_SHOJI_BLOSSOM_SMALL.get(),
                        ModBlock.DOOR_SHOJI_BIRCH.get(),
                        ModBlock.DOOR_SHOJI_BIRCH_SMALL.get(),
                        ModBlock.DOOR_SHOJI_CHERRY.get(),
                        ModBlock.DOOR_SHOJI_CHERRY_SMALL.get(),
                        ModBlock.TABLE_JAPANESE_OAK.get(),
                        ModBlock.TABLE_JAPANESE_SPRUCE.get(),
                        ModBlock.TABLE_JAPANESE_BIRCH.get(),
                        ModBlock.TABLE_JAPANESE_CHERRY_PLANK.get(),
                        ModBlock.TABLE_JAPANESE_CHERRY_LOG.get(),
                        ModBlock.SCREEN_JAPANESE_CHERRY_PLANK.get(),
                        ModBlock.SCREEN_JAPANESE_CHERRY_LOG.get(),
                        ModBlock.SCREEN_JAPANESE_BIRCH.get(),
                        ModBlock.CHAIR_JAPANESE_OAK.get(),
                        ModBlock.CHAIR_JAPANESE_SPRUCE.get(),
                        ModBlock.CHAIR_JAPANESE_BIRCH.get(),
                        ModBlock.CHAIR_JAPANESE_CHERRY_PLANK.get(),
                        ModBlock.CHAIR_JAPANESE_CHERRY_LOG.get(),
                        ModBlock.SCROLL_JAPANESE_AXOLOTL.get(),
                        ModBlock.SCROLL_JAPANESE_BEE.get(),
                        ModBlock.SCROLL_JAPANESE_CINNAMON_ROLL.get(),
                        ModBlock.SCROLL_JAPANESE_MUSHROOM.get(),
                        ModBlock.SCROLL_JAPANESE_DAY.get(),
                        ModBlock.SCROLL_JAPANESE_NIGHT.get(),
                        ModBlock.SCROLL_JAPANESE_DAY_2.get(),
                        ModBlock.SCROLL_JAPANESE_SUNFLOWER.get(),
                        ModBlock.CHERRY_BONSAI.get()
                );
    }
}
