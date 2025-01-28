package com.example.prettyguardian.datagen;

import com.example.prettyguardian.block.ModBlock;
import com.example.prettyguardian.PrettyGuardian;
import com.example.prettyguardian.util.ModTags;
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
        this.tag(ModTags.Blocks.CAKE).add(
                ModBlock.CHOCOLATE_CAKE.get(),
                ModBlock.THREE_CHOCO_CAKE.get(),
                ModBlock.THREE_STRAWBERRY_CAKE.get(),
                ModBlock.THREE_STRAWBERRY_CHOCO_CAKE.get()
        );

        this.tag(ModTags.Blocks.JAP_TABLE).add(
                ModBlock.TABLE_JAPANESE_OAK.get(),
                ModBlock.TABLE_JAPANESE_BIRCH.get(),
                ModBlock.TABLE_JAPANESE_SPRUCE.get(),
                ModBlock.TABLE_JAPANESE_CHERRY_LOG.get(),
                ModBlock.TABLE_JAPANESE_CHERRY_PLANK.get()
        );

        this.tag(BlockTags.SAPLINGS).add(
                ModBlock.BOBA_SAPLING.get(),
                ModBlock.LEMON_SAPLING.get(),
                ModBlock.PISTACHIO_SAPLING.get()
        );

        this.tag(BlockTags.LEAVES).add(
                ModBlock.BOBA_LEAVES_CROP.get(),
                ModBlock.LEMON_LEAVES_CROP.get(),
                ModBlock.PISTACHIO_LEAVES_CROP.get()
        );
    }
}
