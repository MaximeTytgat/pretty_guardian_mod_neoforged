package com.max.prettyguardian.event;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.client.gui.sreens.*;
import com.max.prettyguardian.client.gui.sreens.inventory.ModMenuTypes;
import com.max.prettyguardian.entity.ModEntities;
import com.max.prettyguardian.entity.custom.ButterflyEntity;
import com.max.prettyguardian.entity.custom.CelestialRabbitEntity;
import com.max.prettyguardian.entity.custom.FairyEntity;
import com.max.prettyguardian.entityonshoulder.PlayerEntityOnShoulder;
import com.max.prettyguardian.networking.handler.ModClientPayloadHandler;
import com.max.prettyguardian.networking.handler.ModServerPayloadHandler;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;


@EventBusSubscriber(modid = PrettyGuardian.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    private ModEventBusEvents() {}

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.STRAWBERRY_COW.get(), Cow.createAttributes().build());
        event.put(ModEntities.CELESTIAL_RABBIT.get(), CelestialRabbitEntity.createAttributes().build());
        event.put(ModEntities.BUTTERFLY.get(), ButterflyEntity.createAttributes().build());
        event.put(ModEntities.FAIRY.get(), FairyEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.STRAWBERRY_COW.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                PlayerEntityOnShoulder.PLAYER_ENTITY_ON_SHOULDER_TYPE,
                PlayerEntityOnShoulder.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        ModClientPayloadHandler::handleDataOnMain,
                        ModServerPayloadHandler::handleDataOnMain
                )
        );
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.PICNIC_BASKET_MENU.get(), PicnicBasketScreen::new);
        event.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
        event.register(ModMenuTypes.STAFF_MAGIC_TABLE_MENU.get(), MoonAltarScreen::new);
        event.register(ModMenuTypes.GIFT_BOX_MENU.get(), GiftBoxScreen::new);
        event.register(ModMenuTypes.LETTER_EDITOR_MENU.get(), LetterEditorScreen::new);
    }
}

