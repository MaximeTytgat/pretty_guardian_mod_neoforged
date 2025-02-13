package com.max.prettyguardian.client.renderer.entity.projectiles;


import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.entity.custom.projectile.StarLightEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;


public class StarLightRenderer extends EntityRenderer<StarLightEntity> {
    private static final ResourceLocation TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "textures/entity/projectiles/star_light.png");
    private static final RenderType RENDER_TYPE = RenderType.entityCutoutNoCull(TEXTURE_LOCATION);

    public StarLightRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull StarLightEntity starLightEntity) {
        return TEXTURE_LOCATION;
    }

    protected int getBlockLightLevel(@NotNull StarLightEntity lightEntity, @NotNull BlockPos blockPos) {
        return 15;
    }

    public void render(@NotNull StarLightEntity starLightEntity, float v, float v1, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        poseStack.scale(2.0F, 2.0F, 2.0F);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        PoseStack.Pose last = poseStack.last();
        Matrix4f matrix4f = last.pose();
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RENDER_TYPE);
        vertex(vertexconsumer, matrix4f, last, i, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, matrix4f, last, i, 1.0F, 0, 1, 1);
        vertex(vertexconsumer, matrix4f, last, i, 1.0F, 1, 1, 0);
        vertex(vertexconsumer, matrix4f, last, i, 0.0F, 1, 0, 0);
        poseStack.popPose();
        super.render(starLightEntity, v, v1, poseStack, multiBufferSource, i);
    }

    private static void vertex(VertexConsumer vertexConsumer, Matrix4f matrix4f, PoseStack.Pose pose, int i, float v, int i1, int i2, int i3) {
        vertexConsumer.addVertex(matrix4f, v - 0.5F, i1 - 0.25F, 0.0F).setColor(255, 255, 255, 255).setUv(i2, i3).setOverlay(OverlayTexture.NO_OVERLAY).setUv2(i, 240).setNormal(pose, 0.0F, 1.0F, 0.0F);
    }
}