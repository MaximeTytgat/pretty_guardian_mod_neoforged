package com.max.prettyguardian;

import com.example.prettyguardian.CreativeTab;
import com.max.prettyguardian.blocks.PrettyGuardianBlock;
import com.example.prettyguardian.block.entity.ModBlockEntities;
import com.example.prettyguardian.client.gui.sreens.*;
import com.example.prettyguardian.component.ModAttachmentTypes;
import com.example.prettyguardian.effect.ModEffects;
import com.example.prettyguardian.enchantment.ModEnchantmentEffects;
import com.example.prettyguardian.entity.ModEntities;
import com.example.prettyguardian.entity.client.butterfly.ButterflyRenderer;
import com.example.prettyguardian.entity.client.celestialrabbit.CelestialRabbitRenderer;
import com.example.prettyguardian.entity.client.fairy.FairyRenderer;
import com.example.prettyguardian.entity.client.strawberrycow.StrawberryCowRenderer;
import com.max.prettyguardian.event.custom.JapChairEvent;
import com.example.prettyguardian.item.item.PrettyGuardianItem;
import com.example.prettyguardian.loot.ModLootModifiers;
import com.max.prettyguardian.networking.ModMessages;
import com.example.prettyguardian.particle.ModParticles;
import com.example.prettyguardian.client.gui.sreens.inventory.ModMenuTypes;
import com.example.prettyguardian.potion.ModPotions;
import com.example.prettyguardian.sound.ModSounds;
import com.example.prettyguardian.util.ModItemProperties;
import com.example.prettyguardian.world.entity.ai.poi.ModPoiTypes;
import com.example.prettyguardian.worldgen.entity.ModEntityType;
import com.example.prettyguardian.worldgen.structure.ModStructures;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PrettyGuardian.MOD_ID)
public class PrettyGuardian
{
    public static final String MOD_ID = "prettyguardian";
    public static final Logger LOGGER = LogUtils.getLogger();
    public PrettyGuardian()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModAttachmentTypes.register(modEventBus);

        PrettyGuardianBlock.register(modEventBus);
        PrettyGuardianItem.register(modEventBus);

        ModPoiTypes.register(modEventBus);

        ModEntityType.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModParticles.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModStructures.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);

        modEventBus.register(this);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        CreativeTab.register(modEventBus);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        ComposterBlock.COMPOSTABLES.put(PrettyGuardianItem.VANILLA_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(PrettyGuardianItem.MINT_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(PrettyGuardianItem.STRAWBERRY_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(PrettyGuardianItem.STRAWBERRY.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(PrettyGuardianItem.MINT.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(PrettyGuardianItem.VANILLA.get(), 0.65F);
        ModMessages.register();
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        private ClientModEvents() {}
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomProperties();

            MenuScreens.register(ModMenuTypes.PICNIC_BASKET_MENU.get(), PicnicBasketScreen::new);
            MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
            MenuScreens.register(ModMenuTypes.STAFF_MAGIC_TABLE_MENU.get(), MoonAltarScreen::new);
            MenuScreens.register(ModMenuTypes.GIFT_BOX_MENU.get(), GiftBoxScreen::new);
            MenuScreens.register(ModMenuTypes.LETTER_EDITOR_MENU.get(), LetterEditorScreen::new);
            EntityRenderers.register(ModEntities.STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
            EntityRenderers.register(ModEntities.CELESTIAL_RABBIT.get(), CelestialRabbitRenderer::new);
            EntityRenderers.register(ModEntities.BUTTERFLY.get(), ButterflyRenderer::new);
            EntityRenderers.register(ModEntities.FAIRY.get(), FairyRenderer::new);
            EntityRenderers.register(ModEntityType.SEAT_JAP_CHAIR.get(), JapChairEvent.SeatJapChairRenderer::new);
        }
    }
}
