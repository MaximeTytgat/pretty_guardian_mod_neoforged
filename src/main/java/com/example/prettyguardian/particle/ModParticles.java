package com.example.prettyguardian.particle;

import com.example.prettyguardian.PrettyGuardian;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModParticles {
    private ModParticles() {}

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, PrettyGuardian.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_CRIT_PARTICLES = PARTICLE_TYPES.register("pink_crit_particles", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STAR_LIGHT_PARTICLES = PARTICLE_TYPES.register("star_light_particles", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LOVE_PARTICLES = PARTICLE_TYPES.register("love_particles", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BUBBLE = PARTICLE_TYPES.register("bubble_particles", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CELESTIAL_RABBIT_PARTICLES = PARTICLE_TYPES.register("celestial_rabbit_particles", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_FAIRY_PARTICLES = PARTICLE_TYPES.register("pink_fairy_particles", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLUE_FAIRY_PARTICLES = PARTICLE_TYPES.register("blue_fairy_particles", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_SONIC_BOOM_PARTICLES = PARTICLE_TYPES.register("pink_sonic_boom_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}