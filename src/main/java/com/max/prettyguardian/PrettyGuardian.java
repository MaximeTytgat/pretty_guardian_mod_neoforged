package com.max.prettyguardian;

import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.block.entity.ModBlockEntities;
import com.max.prettyguardian.client.gui.sreens.inventory.ModMenuTypes;
import com.max.prettyguardian.component.ModAttachmentTypes;
import com.max.prettyguardian.component.ModDataComponentTypes;
import com.max.prettyguardian.config.Config;
import com.max.prettyguardian.effect.ModEffects;
import com.max.prettyguardian.enchantment.ModEnchantmentEffects;
import com.max.prettyguardian.entity.ModEntities;
import com.max.prettyguardian.entity.client.JapChairRenderer;
import com.max.prettyguardian.entity.client.butterfly.ButterflyRenderer;
import com.max.prettyguardian.entity.client.celestialrabbit.CelestialRabbitRenderer;
import com.max.prettyguardian.entity.client.fairy.FairyRenderer;
import com.max.prettyguardian.entity.client.strawberrycow.StrawberryCowRenderer;
import com.max.prettyguardian.item.ModItem;
import com.max.prettyguardian.loot.ModLootModifiers;
import com.max.prettyguardian.particle.ModParticles;
import com.max.prettyguardian.potion.ModPotions;
import com.max.prettyguardian.recipe.ModRecipeSerializer;
import com.max.prettyguardian.recipe.ModRecipeType;
import com.max.prettyguardian.sound.ModSounds;
import com.max.prettyguardian.util.ModItemProperties;
import com.max.prettyguardian.world.entity.ai.poi.ModPoiTypes;
import com.max.prettyguardian.worldgen.structure.ModStructures;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.util.Locale;

@Mod(PrettyGuardian.MOD_ID)
public class PrettyGuardian
{
    public static final String MOD_ID = "prettyguardian";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PrettyGuardian(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        ModBlock.register(modEventBus);
        ModItem.register(modEventBus);
        CreativeTab.register(modEventBus);
        ModStructures.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModEffects.register(modEventBus);
        ModEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModDataComponentTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModAttachmentTypes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModRecipeSerializer.register(modEventBus);
        ModRecipeType.register(modEventBus);
        ModPoiTypes.register(modEventBus);
        ModParticles.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.oneShotPlayers != null)
            LOGGER.info("ONE SHOT PLAYERS >> {}", Config.oneShotPlayers);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            EntityRenderers.register(ModEntities.STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
            EntityRenderers.register(ModEntities.CELESTIAL_RABBIT.get(), CelestialRabbitRenderer::new);
            EntityRenderers.register(ModEntities.BUTTERFLY.get(), ButterflyRenderer::new);
            EntityRenderers.register(ModEntities.FAIRY.get(), FairyRenderer::new);
            EntityRenderers.register(ModEntities.JAP_CHAIR.get(), JapChairRenderer::new);

            ModItemProperties.addCustomProperties();
        }
    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
