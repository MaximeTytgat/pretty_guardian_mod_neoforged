package com.example.prettyguardian.item.custom;

import com.example.prettyguardian.entity.custom.ButterflyEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ButterflyEggItem extends EggItem {
    private final Supplier<? extends EntityType<? extends Mob>> type;
    private final ButterflyEntity.Variant variant;
    public ButterflyEggItem(Supplier<? extends EntityType<? extends Mob>> type, ButterflyEntity.Variant variant, Properties props) {
        super(props);
        this.type = type;
        this.variant = variant;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        return super.use(level, player, interactionHand);
    }
//
//    @Override
//    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
//        Level level = useOnContext.getLevel();
//        if (!(level instanceof ServerLevel)) return InteractionResult.SUCCESS;
//
//        ItemStack itemstack = useOnContext.getItemInHand();
//        BlockPos blockpos = useOnContext.getClickedPos();
//        Direction direction = useOnContext.getClickedFace();
//        BlockState blockstate = level.getBlockState(blockpos);
//
//        BlockPos blockpos1;
//        if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
//            blockpos1 = blockpos;
//        } else {
//            blockpos1 = blockpos.relative(direction);
//        }
//
//        this.type.get();
//
//        if (this.spawn((ServerLevel)level, itemstack, useOnContext.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
//            itemstack.shrink(1);
//            level.gameEvent(useOnContext.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
//        }
//
//        return InteractionResult.CONSUME;
//    }
//
//    @Nullable
//    public ButterflyEntity spawn(ServerLevel serverLevel, @Nullable ItemStack itemStack, @Nullable Player player, BlockPos blockPos, MobSpawnType mobSpawnType, boolean b, boolean b1) {
//        Consumer<ButterflyEntity> consumer;
//        CompoundTag compoundtag;
//        if (itemStack != null) {
//            compoundtag = itemStack.getTag();
//            consumer = createDefaultStackConfig(serverLevel, itemStack, player);
//        } else {
//            consumer = butterflyEntity -> {};
//            compoundtag = null;
//        }
//
//        return this.spawn(serverLevel, compoundtag, consumer, blockPos, mobSpawnType, b, b1);
//    }
//
//    public static <T extends Entity> Consumer<T> createDefaultStackConfig(ServerLevel serverLevel, ItemStack itemStack, @Nullable Player player) {
//        return appendDefaultStackConfig(t -> {}, serverLevel, itemStack, player);
//    }
//    public static <T extends Entity> Consumer<T> appendDefaultStackConfig(Consumer<T> tConsumer, ServerLevel serverLevel, ItemStack itemStack, @Nullable Player player) {
//        return appendCustomEntityStackConfig(appendCustomNameConfig(tConsumer, itemStack), serverLevel, itemStack, player);
//    }
//
//    public static <T extends Entity> Consumer<T> appendCustomNameConfig(Consumer<T> tConsumer, ItemStack itemStack) {
//        return itemStack.has(DataComponents.CUSTOM_NAME) ? tConsumer.andThen(t ->  t.setCustomName(itemStack.get(DataComponents.CUSTOM_NAME))) : tConsumer;
//    }
//
//    public static <T extends Entity> Consumer<T> appendCustomEntityStackConfig(Consumer<T> tConsumer, ServerLevel serverLevel, ItemStack itemStack, @Nullable Player player) {
//        CompoundTag compoundtag = itemStack.getTag();
//        return compoundtag != null ? tConsumer.andThen(t -> updateCustomEntityTag(serverLevel, player, t, compoundtag)) : tConsumer;
//    }
//
//    public static void updateCustomEntityTag(Level level, @Nullable Player player, @Nullable Entity entity, @Nullable CompoundTag compoundTag) {
//        MinecraftServer minecraftserver = level.getServer();
//        if (
//                compoundTag != null
//                && compoundTag.contains("EntityTag", 10)
//                && minecraftserver != null
//                && entity != null
//                && (
//                        level.isClientSide
//                        || !entity.onlyOpCanSetNbt()
//                        || player != null
//                        && minecraftserver.getPlayerList().isOp(player.getGameProfile())
//                )
//        ) {
//                CompoundTag compoundtag = entity.saveWithoutId(new CompoundTag());
//                UUID uuid = entity.getUUID();
//                compoundtag.merge(compoundTag.getCompound("EntityTag"));
//                entity.setUUID(uuid);
//                entity.load(compoundtag);
//        }
//    }
//
//
//    @Nullable
//    public ButterflyEntity spawn(ServerLevel serverLevel, @Nullable CompoundTag compoundTag, @Nullable Consumer<ButterflyEntity> butterflyEntityConsumer, BlockPos blockPos, MobSpawnType mobSpawnType, boolean b, boolean b1) {
//        ButterflyEntity t = this.create(serverLevel, compoundTag, butterflyEntityConsumer, blockPos, mobSpawnType, b, b1);
//        if (t != null) {
//            serverLevel.addFreshEntityWithPassengers(t);
//        }
//
//        return t;
//    }
//
//    protected static double getYOffset(LevelReader levelReader, BlockPos blockPos, boolean b, AABB aabb1) {
//        AABB aabb = new AABB(blockPos);
//        if (b) {
//            aabb = aabb.expandTowards(0.0D, -1.0D, 0.0D);
//        }
//
//        Iterable<VoxelShape> iterable = levelReader.getCollisions(null, aabb);
//        return 1.0D + Shapes.collide(Direction.Axis.Y, aabb1, iterable, b ? -2.0D : -1.0D);
//    }
//
//    @Nullable
//    public ButterflyEntity create(ServerLevel serverLevel, @Nullable CompoundTag compoundTag, @Nullable Consumer<ButterflyEntity> butterflyEntityConsumer, BlockPos p_262595_, MobSpawnType p_262666_, boolean b, boolean p_262588_) {
//        ButterflyEntity t = this.create(serverLevel);
//        if (t == null) {
//            return null;
//        } else {
//            double d0;
//            if (b) {
//                t.setPos(p_262595_.getX() + 0.5D, p_262595_.getY() + 1, p_262595_.getZ() + 0.5D);
//                d0 = getYOffset(serverLevel, p_262595_, p_262588_, t.getBoundingBox());
//            } else {
//                d0 = 0.0D;
//            }
//
//            t.moveTo(p_262595_.getX() + 0.5D, p_262595_.getY() + d0, p_262595_.getZ() + 0.5D, Mth.wrapDegrees(serverLevel.random.nextFloat() * 360.0F), 0.0F);
//            if (t instanceof ButterflyEntity) {
//                t.yHeadRot = t.getYRot();
//                t.yBodyRot = t.getYRot();
//                ButterflyEntity.ButterflyGroupData butterflyGroupData = new ButterflyEntity.ButterflyGroupData(this.variant);
//                t.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(t.blockPosition()), p_262666_, butterflyGroupData);
//                t.playAmbientSound();
//            }
//
//            if (butterflyEntityConsumer != null) {
//                butterflyEntityConsumer.accept(t);
//            }
//
//            return t;
//        }
//    }
//
//    @Nullable
//    public ButterflyEntity create(Level level) {
//        return !this.isEnabled(level.enabledFeatures()) ? null : ModEntities.BUTTERFLY.get().create(level);
//    }
}
