package com.max.prettyguardian.datagen;

import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        // TODO: Test and add other data maps
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModBlock.CHAIR_JAPANESE_BIRCH.getId(), new FurnaceFuel(300), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItem.VANILLA_SEEDS, new Compostable(0.3F),  false)
                .add(ModItem.MINT_SEEDS, new Compostable(0.3F),  false)
                .add(ModItem.STRAWBERRY_SEEDS, new Compostable(0.3F),  false)
                .add(ModItem.STRAWBERRY, new Compostable(0.65F),  false)
                .add(ModItem.MINT, new Compostable(0.65F),  false)
                .add(ModItem.VANILLA, new Compostable(0.65F),  false);
    }
}
