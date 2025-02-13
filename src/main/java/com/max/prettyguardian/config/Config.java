package com.max.prettyguardian.config;

import java.util.List;

import com.max.prettyguardian.PrettyGuardian;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;


@EventBusSubscriber(modid = PrettyGuardian.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.ConfigValue<List<? extends String>> ONE_SHOT_PLAYERS = BUILDER
            .comment("List of players who one shot with the scepter")
            .defineListAllowEmpty("oneShotPlayers", List.of("player1", "player2"),  () -> "", Config::validatePlayerName);

    private static final ModConfigSpec.EnumValue<EntityOnShoulderOnPlayerDeath> ENTITY_ON_SHOULDER_ON_PLAYER_DEATH = BUILDER
            .comment("What to do with the entity on the player's shoulder when the player dies")
            .defineEnum("entityOnShoulderOnPlayerDeath", EntityOnShoulderOnPlayerDeath.DROP);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static List<? extends String> oneShotPlayers;
    public static EntityOnShoulderOnPlayerDeath entityOnShoulderOnPlayerDeath;
    
    private static boolean validatePlayerName(final Object obj)
    {
        return obj instanceof String;
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        oneShotPlayers = ONE_SHOT_PLAYERS.get();
        entityOnShoulderOnPlayerDeath = ENTITY_ON_SHOULDER_ON_PLAYER_DEATH.get();
    }
}
