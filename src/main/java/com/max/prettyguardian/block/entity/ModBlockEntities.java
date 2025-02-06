package com.max.prettyguardian.block.entity;

import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.PrettyGuardian;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    private ModBlockEntities() {
        throw new IllegalStateException("Register class");
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PrettyGuardian.MOD_ID);

    public static final Supplier<BlockEntityType<PicnicBasketBlockEntity>> PICNIC_BASKET_BE =
            BLOCK_ENTITY_TYPES.register("picnic_basket_be", () ->
                    BlockEntityType.Builder.of(PicnicBasketBlockEntity::new,
                            ModBlock.PICNIC_BASKET.get()).build(null));

    public static final Supplier<BlockEntityType<GemPolishingStationBlockEntity>> GEM_POLISHING_BE =
            BLOCK_ENTITY_TYPES.register("gem_polishing_station_be", () ->
                    BlockEntityType.Builder.of(GemPolishingStationBlockEntity::new,
                            ModBlock.GEM_POLISHING_STATION.get()).build(null));

    public static final Supplier<BlockEntityType<MoonAltarBlockEntity>> MOON_ALTAR_BE =
            BLOCK_ENTITY_TYPES.register("moon_altar_be", () ->
                    BlockEntityType.Builder.of(MoonAltarBlockEntity::new,
                            ModBlock.MOON_ALTAR.get()).build(null));

    public static final Supplier<BlockEntityType<SilverCrystalBlockEntity>> SILVER_CRYSTAL_BE =
            BLOCK_ENTITY_TYPES.register("silver_crystal_be", () ->
                    BlockEntityType.Builder.of(SilverCrystalBlockEntity::new,
                            ModBlock.SILVER_CRYSTAL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
