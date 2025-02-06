package com.max.prettyguardian;

import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.effect.ModEffects;
import com.max.prettyguardian.enchantment.ModEnchantmentEffects;
import com.max.prettyguardian.item.ModItem;
import com.max.prettyguardian.loot.ModLootModifiers;
import com.max.prettyguardian.particle.ModParticles;
import com.max.prettyguardian.potion.ModPotions;

import com.max.prettyguardian.worldgen.entity.ModEntityType;
import com.max.prettyguardian.worldgen.structure.ModStructures;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.level.block.ComposterBlock;
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

@Mod(PrettyGuardian.MOD_ID)
public class PrettyGuardian
{
    public static final String MOD_ID = "prettyguardian";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PrettyGuardian(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        ModBlock.register(modEventBus);
        ModItem.register(modEventBus);
        CreativeTab.register(modEventBus);

        ModEntityType.register(modEventBus);
        ModStructures.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModEffects.register(modEventBus);

        ModParticles.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");

        ComposterBlock.COMPOSTABLES.put(ModItem.VANILLA_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItem.MINT_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItem.STRAWBERRY_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItem.STRAWBERRY.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ModItem.MINT.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ModItem.VANILLA.get(), 0.65F);

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
        }
    }
}
