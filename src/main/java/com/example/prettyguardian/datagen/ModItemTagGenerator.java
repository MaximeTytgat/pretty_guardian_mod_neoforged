package com.example.prettyguardian.datagen;

import com.example.prettyguardian.PrettyGuardian;
import com.example.prettyguardian.block.ModBlock;
import com.example.prettyguardian.item.ModItem;
import com.example.prettyguardian.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(
            PackOutput packOutput,
            CompletableFuture<HolderLookup.Provider> providerCompletableFuture,
            CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture, PrettyGuardian.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider holderLookupProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItem.PINK_SAPPHIRE_HELMET.get(),
                        ModItem.PINK_SAPPHIRE_CHESTPLATE.get(),
                        ModItem.PINK_SAPPHIRE_LEGGINGS.get(),
                        ModItem.PINK_SAPPHIRE_BOOTS.get(),
                        ModItem.RUBY_HELMET.get(),
                        ModItem.RUBY_CHESTPLATE.get(),
                        ModItem.RUBY_LEGGINGS.get(),
                        ModItem.RUBY_BOOTS.get()
                );

        this.tag(ModTags.Items.CAKE)
                .add(
                        ModBlock.CHOCOLATE_CAKE.get().asItem(),
                        ModBlock.CREAM_CAKE.get().asItem(),
                        ModBlock.RHUM_CAKE.get().asItem(),
                        ModBlock.STRAWBERRY_CAKE.get().asItem(),
                        ModBlock.BERRY_STRAWBERRY_CAKE.get().asItem(),
                        ModBlock.VELVET_CAKE.get().asItem(),
                        ModBlock.CREAM_STRAWBERRY_CAKE.get().asItem(),
                        ModBlock.STRAWBERRY_CHOCO_CAKE.get().asItem(),
                        ModBlock.THREE_STRAWBERRY_CAKE.get().asItem(),
                        ModBlock.THREE_STRAWBERRY_CHOCO_CAKE.get().asItem(),
                        ModBlock.THREE_CHOCO_CAKE.get().asItem(),
                        ModBlock.THREE_VELVET_CAKE.get().asItem()
                );

        this.tag(ModTags.Items.HEART_ARROWS).add(ModItem.HEART_ARROW.get());

        this.tag(ModTags.Items.STAFF_ITEM)
                .add(
                        ModItem.ETERNAL_SILVER_CRISTAL_STAFF.get(),
                        ModItem.CUTIE_MOON_ROD.get(),
                        ModItem.ETERNAL_TIARE.get(),
                        ModItem.MOON_KALEIDOSCOPE.get(),
                        ModItem.MOON_STICK.get(),
                        ModItem.MOON_STICK_PEARL.get(),
                        ModItem.SPIRAL_HEART_MOON_ROD.get()
                );

//        this.tag(ItemTags.MUSIC_DISCS)
//                .add(
//                        ModItem.SAILORMOON_OST_MUSIC_DISC.get(),
//                        ModItem.FIREFLIES_MUSIC_DISC.get(),
//                        ModItem.LOFI_MUSIC_DISC.get(),
//                        ModItem.TAVERN_MUSIC_DISC.get(),
//                        ModItem.THE_LANTERN_FAIR_MUSIC_DISC.get()
//                );

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(
                        ModItem.SAILORMOON_OST_MUSIC_DISC.get(),
                        ModItem.FIREFLIES_MUSIC_DISC.get(),
                        ModItem.LOFI_MUSIC_DISC.get(),
                        ModItem.TAVERN_MUSIC_DISC.get(),
                        ModItem.THE_LANTERN_FAIR_MUSIC_DISC.get()
                );

        this.tag(ItemTags.SAPLINGS)
                .add(
                        ModBlock.BOBA_SAPLING.get().asItem(),
                        ModBlock.LEMON_SAPLING.get().asItem(),
                        ModBlock.PISTACHIO_SAPLING.get().asItem()
                );
    }
}
