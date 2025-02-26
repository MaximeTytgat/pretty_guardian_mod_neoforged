package com.max.prettyguardian.datagen;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.item.ModItem;
import com.max.prettyguardian.util.ModTags;
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
        tag(ItemTags.TRIMMABLE_ARMOR)
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

        tag(ModTags.Items.CAKE)
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

        tag(ModTags.Items.HEART_ARROWS).add(ModItem.HEART_ARROW.get());

        tag(ModTags.Items.STAFF_ITEM)
                .add(
                        ModItem.ETERNAL_SILVER_CRISTAL_STAFF.get(),
                        ModItem.CUTIE_MOON_ROD.get(),
                        ModItem.ETERNAL_TIARE.get(),
                        ModItem.MOON_KALEIDOSCOPE.get(),
                        ModItem.MOON_STICK.get(),
                        ModItem.MOON_STICK_PEARL.get(),
                        ModItem.SPIRAL_HEART_MOON_ROD.get()
                );

        tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(
                        ModItem.SAILORMOON_OST_MUSIC_DISC.get(),
                        ModItem.FIREFLIES_MUSIC_DISC.get(),
                        ModItem.LOFI_MUSIC_DISC.get(),
                        ModItem.TAVERN_MUSIC_DISC.get(),
                        ModItem.THE_LANTERN_FAIR_MUSIC_DISC.get()
                );

        tag(ItemTags.SAPLINGS)
                .add(
                        ModBlock.BOBA_SAPLING.get().asItem(),
                        ModBlock.LEMON_SAPLING.get().asItem(),
                        ModBlock.PISTACHIO_SAPLING.get().asItem()
                );

        tag(ItemTags.SWORDS)
                .add(
                        ModItem.PINK_SAPPHIRE_SWORD.get(),
                        ModItem.RUBY_SWORD.get(),
                        ModItem.SPACE_SWORD.get()
                );
        tag(ItemTags.AXES)
                .add(
                        ModItem.PINK_SAPPHIRE_AXE.get(),
                        ModItem.RUBY_AXE.get()
                );
        tag(ItemTags.PICKAXES)
                .add(
                        ModItem.PINK_SAPPHIRE_PICKAXE.get(),
                        ModItem.RUBY_PICKAXE.get()
                );
        tag(ItemTags.SHOVELS)
                .add(
                        ModItem.PINK_SAPPHIRE_SHOVEL.get(),
                        ModItem.RUBY_SHOVEL.get()
                );
        tag(ItemTags.HOES)
                .add(
                        ModItem.PINK_SAPPHIRE_HOE.get(),
                        ModItem.RUBY_HOE.get()
                );

        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(
                        ModItem.MINT_SEEDS.get(),
                        ModItem.STRAWBERRY_SEEDS.get(),
                        ModItem.VANILLA_SEEDS.get()
                );
    }
}
