package com.max.prettyguardian.entity.client.celestialrabbit;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.entity.custom.CelestialRabbitEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CelestialRabbitCollarLayer<T extends CelestialRabbitEntity, M extends CelestialRabbitModel<T>> extends RenderLayer<T, M> {
    private static final RenderType CELESTIAL_RABBIT_COLLAR_LOCATION = RenderType.entityCutoutNoCullZOffset(ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "textures/entity/rabbit/celestial/celestial_rabbit_collar.png"));

    public CelestialRabbitCollarLayer(RenderLayerParent<T, M> layerParent) {
        super(layerParent);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, CelestialRabbitEntity celestialRabbitEntity, float v, float v1, float v2, float v3, float v4, float v5) {
        if (celestialRabbitEntity.isTame() && !celestialRabbitEntity.isInvisible()) {
            renderCollar((EntityModel<CelestialRabbitEntity>) this.getParentModel(), poseStack, multiBufferSource, i, LivingEntityRenderer.getOverlayCoords(celestialRabbitEntity, 0.0F));
        }
    }

    public static void renderCollar(EntityModel<CelestialRabbitEntity> model, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int packedOverlay) {
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(CELESTIAL_RABBIT_COLLAR_LOCATION);
        model.renderToBuffer(poseStack, vertexconsumer, i, packedOverlay, -1);
    }
}