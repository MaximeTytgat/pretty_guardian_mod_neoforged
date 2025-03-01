package com.max.prettyguardian.client;


import com.max.prettyguardian.entityonshoulder.PlayerEntityOnShoulder;

import java.util.ArrayList;
import java.util.List;

public class ClientPlayerEntityOnShoulderData {
    private ClientPlayerEntityOnShoulderData() {}
    private static final List<PlayerEntityOnShoulder> playerEntityOnShoulderList = new ArrayList<>();

    public static void setEntityOnShoulder(PlayerEntityOnShoulder playerEntityOnShoulder) {
        ClientPlayerEntityOnShoulderData.playerEntityOnShoulderList.add(playerEntityOnShoulder);
    }

    public static void letGoEntity(String playerId) {
        playerEntityOnShoulderList.removeIf(playerEntityOnShoulder -> playerEntityOnShoulder.playerId().equals(playerId));
    }

    public static boolean hasEntityOnShoulder(String playerId) {
        return playerEntityOnShoulderList.stream().anyMatch(playerEntityOnShoulder -> playerEntityOnShoulder.playerId().equals(playerId));
    }

    public static PlayerEntityOnShoulder get(String stringUUID) {
        return playerEntityOnShoulderList.stream().filter(playerEntityOnShoulder -> playerEntityOnShoulder.playerId().equals(stringUUID)).findFirst().orElse(null);
    }
}
