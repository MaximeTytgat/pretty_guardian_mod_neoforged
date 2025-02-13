package com.max.prettyguardian.entity.client;

import com.max.prettyguardian.entity.custom.JapChairEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class JapChairRenderer extends EntityRenderer<JapChairEntity> {
    public JapChairRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull JapChairEntity entity) { return null; }

    @Override
    public boolean shouldRender(@NotNull JapChairEntity livingEntity, @NotNull Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}