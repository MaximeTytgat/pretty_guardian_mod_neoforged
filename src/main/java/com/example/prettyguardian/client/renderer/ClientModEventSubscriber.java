package com.example.prettyguardian.client.renderer;

import com.example.prettyguardian.PrettyGuardian;
import com.example.prettyguardian.client.renderer.entity.projectiles.BubbleRenderer;
import com.example.prettyguardian.client.renderer.entity.projectiles.CuteArrowRenderer;
import com.example.prettyguardian.client.renderer.entity.projectiles.HeartRenderer;
import com.example.prettyguardian.client.renderer.entity.projectiles.StarLightRenderer;
import com.example.prettyguardian.worldgen.entity.ModEntityType;
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