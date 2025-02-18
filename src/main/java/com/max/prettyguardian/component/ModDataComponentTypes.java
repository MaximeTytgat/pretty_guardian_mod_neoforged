package com.max.prettyguardian.component;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.component.custom.LoveLetterComponent;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    private ModDataComponentTypes() {}
    public static final DeferredRegister.DataComponents DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, PrettyGuardian.MOD_ID);

    public static final Codec<LoveLetterComponent> LOVE_LETTER_COMPONENT_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("loveLetterAuthor").forGetter(LoveLetterComponent::loveLetterAuthor),
                    Codec.STRING.fieldOf("loveLetterText").forGetter(LoveLetterComponent::loveLetterText)
            ).apply(instance, LoveLetterComponent::new)
    );

    public static final StreamCodec<ByteBuf, LoveLetterComponent> LOVE_LETTER_COMPONENT_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, LoveLetterComponent::loveLetterAuthor,
            ByteBufCodecs.STRING_UTF8, LoveLetterComponent::loveLetterText,
            LoveLetterComponent::new
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<LoveLetterComponent>> LOVE_LETTER_COMPONENT = DATA_COMPONENT_TYPES.registerComponentType(
            "love_letter",
            builder -> builder
                    .persistent(LOVE_LETTER_COMPONENT_CODEC)
                    .networkSynchronized(LOVE_LETTER_COMPONENT_STREAM_CODEC)
                    .cacheEncoding()
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ItemStack>> GIFT_BOX_INVENTORY = DATA_COMPONENT_TYPES.registerComponentType("gift_box_inventory",
            builder -> builder
                    .persistent(ItemStack.OPTIONAL_CODEC)
                    .networkSynchronized(ItemStack.OPTIONAL_STREAM_CODEC)
                    .cacheEncoding()
    );

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
