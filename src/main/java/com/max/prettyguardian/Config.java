package com.max.prettyguardian;

import java.util.List;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = PrettyGuardian.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.ConfigValue<List<? extends String>> ONE_SHOT_PLAYERS = BUILDER
            .comment("List of players who one shot with the scepter")
            .defineListAllowEmpty("oneShotPlayers", List.of("player1", "player2"),  () -> "", Config::validatePlayerName);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static List<? extends String> oneShotPlayers;
    
    private static boolean validatePlayerName(final Object obj)
    {
        return obj instanceof String;
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        oneShotPlayers = ONE_SHOT_PLAYERS.get();
    }
}
