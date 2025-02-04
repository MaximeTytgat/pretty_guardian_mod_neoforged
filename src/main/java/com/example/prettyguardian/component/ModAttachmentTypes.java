package com.example.prettyguardian.component;

import com.example.prettyguardian.entityonshoulder.PlayerEntityOnShoulder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static com.example.prettyguardian.PrettyGuardian.MOD_ID;

public class ModAttachmentTypes {
    private ModAttachmentTypes() {}
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MOD_ID);

    // TODO: Needed ?
    public static final Supplier<AttachmentType<ItemStackHandler>> PICNIC_BASKET_STACK_HANDLER = ATTACHMENT_TYPES.register(
            "picnic_basket_stack_handler", () -> AttachmentType.serializable(() -> new ItemStackHandler(4)).build()
    );

    public static final Supplier<AttachmentType<PlayerEntityOnShoulder>> PLAYER_ENTITY_ON_SHOULDER = ATTACHMENT_TYPES.register(
            "player_entity_on_shoulder", () -> AttachmentType.builder(PlayerEntityOnShoulder::new).serialize(PlayerEntityOnShoulder.CODEC).copyOnDeath().build()
    );

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }
}
