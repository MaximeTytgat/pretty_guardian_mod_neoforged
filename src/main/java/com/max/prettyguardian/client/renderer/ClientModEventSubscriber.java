package com.max.prettyguardian.client.renderer;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.client.renderer.entity.projectiles.BubbleRenderer;
import com.max.prettyguardian.client.renderer.entity.projectiles.CuteArrowRenderer;
import com.max.prettyguardian.client.renderer.entity.projectiles.HeartRenderer;
import com.max.prettyguardian.client.renderer.entity.projectiles.StarLightRenderer;
import com.max.prettyguardian.worldgen.entity.ModEntityType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = PrettyGuardian.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {
    private ClientModEventSubscriber() {}
    @SubscribeEvent
    public static void doSetup(EntityRenderersEvent.RegisterRenderers event) {
        EntityRenderers.register(ModEntityType.HEART_ARROW.get(), CuteArrowRenderer::new);
        EntityRenderers.register(ModEntityType.HEART.get(), HeartRenderer::new);
        EntityRenderers.register(ModEntityType.BUBBLE.get(), BubbleRenderer::new);
        EntityRenderers.register(ModEntityType.STAR_LIGHT.get(), StarLightRenderer::new);
    }
}