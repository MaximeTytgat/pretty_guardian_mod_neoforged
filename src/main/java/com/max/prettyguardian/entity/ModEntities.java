package com.max.prettyguardian.entity;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.entity.custom.*;
import com.max.prettyguardian.entity.custom.projectile.BubbleEntity;
import com.max.prettyguardian.entity.custom.projectile.CuteArrowEntity;
import com.max.prettyguardian.entity.custom.projectile.HeartEntity;
import com.max.prettyguardian.entity.custom.projectile.StarLightEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

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

    // Projectiles
    public static final Supplier<EntityType<CuteArrowEntity>> HEART_ARROW =
            ENTITY_TYPES.register("heart_arrow", () -> EntityType.Builder.of((EntityType.EntityFactory<CuteArrowEntity>) CuteArrowEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("heart_arrow"));
    public static final Supplier<EntityType<HeartEntity>> HEART =
            ENTITY_TYPES.register("heart", () -> EntityType.Builder.of((EntityType.EntityFactory<HeartEntity>) HeartEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("heart"));
    public static final Supplier<EntityType<BubbleEntity>> BUBBLE =
            ENTITY_TYPES.register("bubble", () -> EntityType.Builder.of(BubbleEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("bubble"));
    public static final Supplier<EntityType<StarLightEntity>> STAR_LIGHT =
            ENTITY_TYPES.register("star_light", () -> EntityType.Builder.of((EntityType.EntityFactory<StarLightEntity>) StarLightEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("star_light"));

    // Misc Entities
    public static final Supplier<EntityType<JapChairEntity>> JAP_CHAIR =
            ENTITY_TYPES.register("jap_chair", () -> EntityType.Builder.of((EntityType.EntityFactory<JapChairEntity>) JapChairEntity::new, MobCategory.MISC)
                    .sized(0F, 0F).clientTrackingRange(4).updateInterval(20).build("jap_chair"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
