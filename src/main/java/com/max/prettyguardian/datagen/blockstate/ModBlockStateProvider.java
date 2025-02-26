package com.max.prettyguardian.datagen.blockstate;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.block.custom.crop.MintCropBlock;
import com.max.prettyguardian.block.custom.crop.StrawberryCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Objects;
import java.util.function.Function;

import static com.max.prettyguardian.datagen.blockstate.CakeModelProvider.simpleCake;
import static com.max.prettyguardian.datagen.blockstate.CakeModelProvider.simpleThreeCake;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final String CUTOUT = "cutout";
    private static final String BLOCK_PATH = "block/";

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PrettyGuardian.MOD_ID, exFileHelper);
    }

    private void blockWithItem(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void bottomTopBlockWithItem(Block block) {
        simpleBlockWithItem(block, models().cubeBottomTop(
                getBlockPath(block),
                blockTexture(block),
                ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, BLOCK_PATH + getBlockPath(block) + "_bottom"),
                ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, BLOCK_PATH + getBlockPath(block) + "_top")
        ));
    }

    protected ResourceLocation getBlockKey(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    protected String getBlockPath(Block block) {
        return getBlockKey(block).getPath();
    }

    private void topBlockWithItem(Block block) {
        simpleBlockWithItem(block, models().cubeTop(getBlockPath(block), blockTexture(block), ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, BLOCK_PATH + getBlockPath(block) + "_top")));
    }

    @Override
    protected void registerStatesAndModels() {
        makeStrawberryCrop((CropBlock) ModBlock.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        makeMintCrop((CropBlock) ModBlock.MINT_CROP.get(), "mint_stage", "mint_stage");

        blockWithItem(ModBlock.PINK_SAPPHIRE_BLOCK);
        blockWithItem(ModBlock.PINK_SAPPHIRE_ORE);
        blockWithItem(ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE);

        blockWithItem(ModBlock.RUBY_BLOCK);
        blockWithItem(ModBlock.RUBY_ORE);
        blockWithItem(ModBlock.DEEPSLATE_RUBY_ORE);

        blockWithItem(ModBlock.CHOCOLATE_BLOCK);
        topBlockWithItem(ModBlock.MARSHMELLO_BLOCK.get());
        bottomTopBlockWithItem(ModBlock.ROASTED_MARSHMELLO_BLOCK.get());

        simpleCake(ModBlock.CHOCOLATE_CAKE.get(), this);
        simpleCake(ModBlock.CREAM_CAKE.get(), this);
        simpleCake(ModBlock.RHUM_CAKE.get(), this);
        simpleCake(ModBlock.STRAWBERRY_CAKE.get(), this);
        simpleCake(ModBlock.BERRY_STRAWBERRY_CAKE.get(), this);
        simpleCake(ModBlock.VELVET_CAKE.get(), this);
        simpleCake(ModBlock.CREAM_STRAWBERRY_CAKE.get(), this);
        simpleCake(ModBlock.STRAWBERRY_CHOCO_CAKE.get(), this);

        simpleThreeCake(ModBlock.THREE_VELVET_CAKE.get(), this);
        simpleThreeCake(ModBlock.THREE_CHOCO_CAKE.get(), this);
        simpleThreeCake(ModBlock.THREE_STRAWBERRY_CAKE.get(), this);
        simpleThreeCake(ModBlock.THREE_STRAWBERRY_CHOCO_CAKE.get(), this);

        saplingBlock(ModBlock.PISTACHIO_SAPLING);
        saplingBlock(ModBlock.LEMON_SAPLING);
        saplingBlock(ModBlock.BOBA_SAPLING);

        simpleBlockWithItem(ModBlock.STRAWBERRY_CROP_FLOWER.get(), models().cross(blockTexture(ModBlock.STRAWBERRY_CROP_FLOWER.get()).getPath(),
                blockTexture(ModBlock.STRAWBERRY_CROP_FLOWER.get())).renderType(CUTOUT));

        simpleBlockWithItem(ModBlock.GEM_POLISHING_STATION.get(), new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(Objects.requireNonNull(getBlockKey(blockRegistryObject.get())).getPath(), blockTexture(blockRegistryObject.get())).renderType(CUTOUT));
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, BLOCK_PATH + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType(CUTOUT));

        return models;
    }

    public void makeMintCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> mintStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] mintStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((MintCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, BLOCK_PATH + textureName + state.getValue(((MintCropBlock) block).getAgeProperty()))).renderType(CUTOUT));

        return models;
    }
}
