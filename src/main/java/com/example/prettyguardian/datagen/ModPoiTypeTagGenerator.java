package com.example.prettyguardian.datagen;

import com.example.prettyguardian.PrettyGuardian;
import com.example.prettyguardian.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagGenerator extends PoiTypeTagsProvider {
    public ModPoiTypeTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PrettyGuardian.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider pProvider) {
        tag(ModTags.PoiTypeTags.MOON_TEMPLE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "moon_temple"));
    }
}
