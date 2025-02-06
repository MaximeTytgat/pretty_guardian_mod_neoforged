package com.max.prettyguardian.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.fml.ModList;

import java.util.Random;
import java.util.function.Predicate;

public abstract class ModStructureUtils {
    private ModStructureUtils() {}

    private static final Predicate<Block> isAir = block -> block == Blocks.AIR || block == Blocks.CAVE_AIR;

    public static boolean isLavaLake(NoiseColumn blockReader) {
        boolean isLake = true;
        if (blockReader.getBlock(31).getBlock() != Blocks.LAVA) {
            isLake = false;
        } else {
            for(int i = 32; i < 70; i ++) {
                isLake = isLake && (isAir.test(blockReader.getBlock(i).getBlock()));
            }
        }
        return isLake;
    }

    public static boolean verticalSpace(NoiseColumn blockReader, int min, int max, int height) {
        int heightTracked = 0;
        for(int i = max; i >= min && heightTracked < height; i --) {
            if(isAir.test(blockReader.getBlock(i).getBlock())) {
                heightTracked ++;
            } else {
                heightTracked = 0;
            }
        }
        return heightTracked == height;
    }

    public static BlockPos getElevation(Structure.GenerationContext context, int min, int max) {
        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
        NoiseColumn blockReader = context.chunkGenerator().getBaseColumn(blockpos.getX(), blockpos.getZ(), context.heightAccessor(), context.randomState());

        boolean found = false;
        for (int i = min; i < max; i++) {
            if (isAir.test(blockReader.getBlock(i + 1).getBlock()) && !isAir.test(blockReader.getBlock(i).getBlock())) {
                blockpos = new BlockPos(blockpos.getX(), i, blockpos.getZ());
                found = true;
            }
        }
        if (!found) {
            blockpos = new BlockPos(blockpos.getX(), new Random(context.seed()).nextInt(max - min) + min, blockpos.getZ());
        }
        return blockpos;
    }

    public static int getScaledNetherHeight(int vanillaHeight) {
        return (int) (vanillaHeight / 128.0F * (ModList.get().isLoaded("starmute") ? 256.0F : 128.0F));
    }
}