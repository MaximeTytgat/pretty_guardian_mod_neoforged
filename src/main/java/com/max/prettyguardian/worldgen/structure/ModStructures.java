package com.max.prettyguardian.worldgen.structure;

import com.max.prettyguardian.PrettyGuardian;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModStructures {
    private ModStructures() {}

    public static final DeferredRegister<StructureType<?>> MODDED_STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, PrettyGuardian.MOD_ID);

    public static final Supplier<StructureType<CorruptedCelestialTempleStructure>> CORRUPTED_CELESTIAL_TEMPLE =
            MODDED_STRUCTURES.register("corrupted_celestial_temple", () -> () -> CorruptedCelestialTempleStructure.CODEC);

    public static void register(IEventBus eventBus) { MODDED_STRUCTURES.register(eventBus); }
}