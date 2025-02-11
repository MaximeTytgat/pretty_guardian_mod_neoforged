package com.max.prettyguardian.networking.handler;

import com.max.prettyguardian.client.ClientPlayerEntityOnShoulderData;
import com.max.prettyguardian.entityonshoulder.PlayerEntityOnShoulder;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ModClientPayloadHandler {
    public static void handleDataOnMain(final PlayerEntityOnShoulder playerEntityOnShoulder, final IPayloadContext iPayloadContext) {
        if (playerEntityOnShoulder.entityTypeDescriptionId() == null) {
            ClientPlayerEntityOnShoulderData.letGoEntity(playerEntityOnShoulder.playerId());
        } else {
            ClientPlayerEntityOnShoulderData.setEntityOnShoulder(playerEntityOnShoulder);
        }
    }
}
