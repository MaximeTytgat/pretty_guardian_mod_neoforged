package com.max.prettyguardian.entity;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.entity.custom.ButterflyEntity;
import com.max.prettyguardian.entity.custom.CelestialRabbitEntity;
import com.max.prettyguardian.entity.custom.FairyEntity;
import com.max.prettyguardian.entity.custom.StrawberryCowEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    private ModEntities() {}
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, PrettyGuardian.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<StrawberryCowEntity>> STRAWBERRY_COW =
            ENTITY_TYPES.register("strawberry_cow", () -> EntityType.Builder.of(StrawberryCowEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.4F).build("strawberry_cow"));
    public static final DeferredHolder<EntityType<?>, EntityType<CelestialRabbitEntity>> CELESTIAL_RABBIT =
            ENTITY_TYPES.register("celestial_rabbit", () -> EntityType.Builder.of(CelestialRabbitEntity::new, MobCategory.CREATURE)
                    .sized(0.5F, 0.8F).build("celestial_rabbit"));
    public static final DeferredHolder<EntityType<?>, EntityType<ButterflyEntity>> BUTTERFLY =
            ENTITY_TYPES.register("butterfly", () -> EntityType.Builder.of(ButterflyEntity::new, MobCategory.CREATURE)
                    .sized(0.5F, 0.35F).build("butterfly"));
    public static final DeferredHolder<EntityType<?>, EntityType<FairyEntity>> FAIRY =
            ENTITY_TYPES.register("fairy", () -> EntityType.Builder.of(FairyEntity::new, MobCategory.CREATURE)
                    .sized(0.3F, 0.3F).build("fairy"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
