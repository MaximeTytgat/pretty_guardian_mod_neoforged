package com.max.prettyguardian.block.custom.crop;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.OptionalInt;

public class CropLeavesBlock extends LeavesBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final int MAX_AGE = 3;

    public final DeferredItem<Item> fruit;

    public CropLeavesBlock(DeferredItem<Item>  fruit, Properties properties) {
        super(properties);
        this.fruit = fruit;
        registerDefaultState(stateDefinition.any().setValue(DISTANCE, 7).setValue(PERSISTENT, false).setValue(AGE, 0).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT, AGE, WATERLOGGED);
    }

    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getAge(BlockState state) {
        return state.getValue(this.getAgeProperty());
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    public BlockState getStateForAge(BlockState state, int age) {
        return state.setValue(AGE, age);
    }

    public final boolean canGrow(BlockState state) {
        return this.getAge(state) < this.getMaxAge();
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return this.canGrow(blockState);
    }

    @Override
    public boolean isBonemealSuccess(
            @NotNull Level level,
            @NotNull RandomSource random,
            @NotNull BlockPos pos,
            @NotNull BlockState state
    ) {
        return true;
    }

    public void growCrops(Level level, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        level.setBlockAndUpdate(pos, this.getStateForAge(state, i));
    }

    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 2, this.getMaxAge());
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource rand, @NotNull BlockPos pos, @NotNull BlockState state) {
        growCrops(level, pos, state);
    }

    @Override
    protected boolean isRandomlyTicking(@NotNull BlockState state) {
        return (state.getValue(DISTANCE) == 7 && !state.getValue(PERSISTENT)) || this.canGrow(state);
    }

    @Override
    protected void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        PrettyGuardian.LOGGER.info("randomTick, persistent: {}, distance: {}", state.getValue(PERSISTENT), state.getValue(DISTANCE));
        if (this.decaying(state)) {
            PrettyGuardian.LOGGER.info("decaying !");
            dropResources(state, level, pos);
            if (!this.canGrow(state)) popResource(level, pos, new ItemStack(this.fruit.get()));
            level.removeBlock(pos, false);
        } else if (level.isAreaLoaded(pos, 1) && level.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                boolean grow = random.nextDouble() < Config.fruitsGrowChance;
                if (CommonHooks.canCropGrow(level, pos, state, grow)) {
                    level.setBlockAndUpdate(pos, this.getStateForAge(state,i + 1));
                    CommonHooks.fireCropGrowPost(level, pos, state);
                }
            }
        }
    }

    private static BlockState updateDistance(BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos) {
        int i = 7;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for(Direction direction : Direction.values()) {
            mutableBlockPos.setWithOffset(blockPos, direction);
            i = Math.min(i, getDistanceAt(levelAccessor.getBlockState(mutableBlockPos)) + 1);
            if (i == 1) {
                break;
            }
        }

        return blockState.setValue(DISTANCE, i);
    }

    private static int getDistanceAt(BlockState blockState) {
        return getOptionalDistanceAt(blockState).orElse(7);
    }

    public static @NotNull OptionalInt getOptionalDistanceAt(BlockState blockState) {
        if (blockState.is(BlockTags.LOGS)) {
            return OptionalInt.of(0);
        } else {
            return blockState.hasProperty(DISTANCE) ? OptionalInt.of(blockState.getValue(DISTANCE)) : OptionalInt.empty();
        }
    }

    @Override
    public @NotNull BlockState getStateForPlacement(BlockPlaceContext context) {
        PrettyGuardian.LOGGER.info("getStateForPlacement");
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockstate = this.defaultBlockState().setValue(DISTANCE, 7).setValue(PERSISTENT, true).setValue(AGE, 0).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        return updateDistance(blockstate, context.getLevel(), context.getClickedPos());
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(
            @NotNull BlockState blockState,
           @NotNull Level level,
           @NotNull BlockPos blockPos,
           @NotNull Player player,
           @NotNull BlockHitResult blockHitResult
    ) {
        if (blockState.getValue(AGE) == 3 && level.setBlockAndUpdate(blockPos, this.getStateForAge(blockState,1))) {
            if (!level.isClientSide) {
                ItemStack fruitItem = new ItemStack(this.fruit.get());
                if (player instanceof ServerPlayer) {
                    popResourceFromFace(level, blockPos, blockHitResult.getDirection(), fruitItem);
                } else {
                    ItemHandlerHelper.giveItemToPlayer(player, fruitItem);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
    }
}