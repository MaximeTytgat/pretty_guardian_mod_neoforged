package com.max.prettyguardian.world.entity.ai.poi;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import com.google.common.collect.ImmutableSet;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModPoiTypes {
    private ModPoiTypes() {}

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, PrettyGuardian.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> MOON_TEMPLE = POI_TYPES.register("moon_temple",
            () -> new PoiType(ImmutableSet.copyOf(ModBlock.MOON_ALTAR.get().getStateDefinition().getPossibleStates()), 1, 1)
    );

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
    }
}
