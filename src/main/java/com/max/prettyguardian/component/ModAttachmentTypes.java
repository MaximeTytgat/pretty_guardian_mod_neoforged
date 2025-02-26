package com.max.prettyguardian.component;

import com.max.prettyguardian.entityonshoulder.PlayerEntityOnShoulder;
import net.minecraft.world.item.DyeColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static com.max.prettyguardian.PrettyGuardian.MOD_ID;

public class ModAttachmentTypes {
    private ModAttachmentTypes() {}
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MOD_ID);

    public static final Supplier<AttachmentType<PlayerEntityOnShoulder>> PLAYER_ENTITY_ON_SHOULDER = ATTACHMENT_TYPES.register(
            "player_entity_on_shoulder",
            () -> AttachmentType.builder(
                    () -> new PlayerEntityOnShoulder(
                            "",
                            "",
                            DyeColor.LIGHT_BLUE.getId(),
                            "",
                            false
                    )
            ).serialize(PlayerEntityOnShoulder.SHOULDER_CODEC).copyOnDeath().build()
    );

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }
}
