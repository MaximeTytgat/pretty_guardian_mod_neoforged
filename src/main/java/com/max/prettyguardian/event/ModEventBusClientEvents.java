package com.max.prettyguardian.event;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.block.entity.ModBlockEntities;
import com.max.prettyguardian.block.entity.renderer.MoonAltarBlockEntityRenderer;
import com.max.prettyguardian.entity.client.butterfly.ButterflyModel;
import com.max.prettyguardian.entity.client.celestialrabbit.CelestialRabbitModel;
import com.max.prettyguardian.entity.client.ModModelLayers;
import com.max.prettyguardian.entity.client.celestialrabbit.CelestialRabbitOnShoulderLayer;
import com.max.prettyguardian.entity.client.fairy.FairyModel;
import com.max.prettyguardian.particle.ModParticles;
import com.max.prettyguardian.particle.custom.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = PrettyGuardian.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    private ModEventBusClientEvents() {}

    // TODO Tester si c'est toujours necessaire
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.PINK_CRIT_PARTICLES.get(),
                PinkCritParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.STAR_LIGHT_PARTICLES.get(),
                StarLightParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.LOVE_PARTICLES.get(),
                LoveParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.BUBBLE.get(),
                BubbleParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.CELESTIAL_RABBIT_PARTICLES.get(),
                CelestialRabbitParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.PINK_FAIRY_PARTICLES.get(),
                PinkFairyParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.BLUE_FAIRY_PARTICLES.get(),
                BlueFairyParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.PINK_SONIC_BOOM_PARTICLES.get(),
                PinkSonicBoomParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.STRAWBERRY_COW_LAYER, CowModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CELESTIAL_RABBIT_LAYER, CelestialRabbitModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BUTTERFLY_LAYER, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FAIRY_LAYER, FairyModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.MOON_ALTAR_BE.get(), MoonAltarBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onEntityAddLayers(EntityRenderersEvent.AddLayers event) {
        for (PlayerSkin.Model skinName : event.getSkins()) {
            PlayerRenderer parent = event.getSkin(skinName);
            if (parent != null) {
                parent.addLayer(new CelestialRabbitOnShoulderLayer<>(parent));
            }
        }
    }

    @SubscribeEvent
    public static void blockColorHandlerEvent(final RegisterColorHandlersEvent.Block event)
    {
        event.register(
                (state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                ModBlock.BOBA_LEAVES_CROP.get(),
                ModBlock.LEMON_LEAVES_CROP.get(),
                ModBlock.PISTACHIO_LEAVES_CROP.get()
        );
    }

    @SubscribeEvent
    public static void itemColorHandlerEvent(final RegisterColorHandlersEvent.Item event)
    {
        event.register((stack, tintIndex) -> {
            BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(state, null, null, tintIndex);
        }, ModBlock.BOBA_LEAVES_CROP.get(),
                ModBlock.LEMON_LEAVES_CROP.get(),
                ModBlock.PISTACHIO_LEAVES_CROP.get()
        );
    }
}