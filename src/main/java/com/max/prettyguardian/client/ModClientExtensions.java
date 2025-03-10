package com.max.prettyguardian.client;

import com.max.prettyguardian.item.ModItem;
import com.max.prettyguardian.item.client.EternalSilverCristalStaffRenderer;
import com.max.prettyguardian.item.client.RubyArmorRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.neoforged.neoforge.client.IArmPoseTransformer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;

public class ModClientExtensions {
    public static final IClientItemExtensions NEPTUNES_MIRROR = new IClientItemExtensions() {
        public static final EnumProxy<HumanoidModel.ArmPose> MIRROR_ARM_POSE = new EnumProxy<>(HumanoidModel.ArmPose.class, false, (IArmPoseTransformer) ((model, entity, arm) -> {
            ModelPart mainHand = arm == HumanoidArm.LEFT ? model.leftArm : model.rightArm;
            int dir = (arm == HumanoidArm.LEFT ? -1 : 1);

            float cr = (entity.isCrouching() ? 0.3F : 0.0F);

            float headXRot = wrapRad(model.head.xRot);
            float headYRot = wrapRad(model.head.yRot);

            float pitch = Mth.clamp(headXRot, -1.6f, 0.8f) + 0.55f - cr;
            mainHand.xRot = (float) (pitch - Math.PI / 2f) - dir * 0.3f * headYRot;

            float yaw = 0.7f * dir;
            mainHand.yRot = Mth.clamp(-yaw * Mth.cos(pitch + cr) + headYRot, -1.1f, 1.1f);
            mainHand.zRot = -yaw * Mth.sin(pitch + cr);

            AnimationUtils.bobModelPart(mainHand, entity.tickCount, -dir);
        }));

        @Override
        public HumanoidModel.ArmPose getArmPose(@NotNull LivingEntity entityLiving, @NotNull InteractionHand hand, @NotNull ItemStack itemStack) {
            if (!itemStack.isEmpty()) {
                if (entityLiving.getUsedItemHand() == hand && entityLiving.getUseItemRemainingTicks() > 0) {
                    return MIRROR_ARM_POSE.getValue();
                }
            }
            return HumanoidModel.ArmPose.EMPTY;
        }

        @Override
        public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm, ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess) {
            int i = arm == HumanoidArm.RIGHT ? 1 : -1;

            poseStack.translate(i * 0.56F, -0.52F, -0.72F);

            if (player.isUsingItem() && player.getUseItemRemainingTicks() > 0 && player.getUseItem() == itemInHand) {
                float timeLeft = itemInHand.getUseDuration(player) - (player.getUseItemRemainingTicks() - partialTick + 1.0F);
                float f12 = 1;

                float f15 = Mth.sin((timeLeft - 0.1F) * 1.3F);
                float f18 = f12 - 0.1F;
                float f20 = f15 * f18;
                poseStack.translate(0, f20 * 0.004F, 0);

                poseStack.translate(0, 0, f12 * 0.04F);
                poseStack.scale(1.0F, 1.0F, 1.0F + f12 * 0.2F);
            }

            return true;
        }
    };

    private static float wrapRad(float pValue) {
        float p = 6.2831855F;
        float d0 = pValue % p;
        if (d0 >= Math.PI) {
            d0 -= p;
        }

        if (d0 < -3.141592653589793) {
            d0 += p;
        }

        return d0;
    }

    public static final IClientItemExtensions ETERNAL_SILVER_CRISTAL_STAFF_ITEM = new IClientItemExtensions() {
        private EternalSilverCristalStaffRenderer renderer;
        @Override
        public @NotNull BlockEntityWithoutLevelRenderer getCustomRenderer() {
            if (renderer == null) {
                renderer = new EternalSilverCristalStaffRenderer();
            }
            return renderer;
        }
    };

    public static final IClientItemExtensions RUBY_ARMOR_ITEM = new IClientItemExtensions() {
        private RubyArmorRenderer renderer;

        @Override
        public @NotNull HumanoidModel<?> getHumanoidArmorModel(
                @NotNull LivingEntity livingEntity,
                @NotNull ItemStack itemStack,
                @NotNull EquipmentSlot equipmentSlot,
                @NotNull HumanoidModel<?> original
        ) {
            if (this.renderer == null)
                this.renderer = new RubyArmorRenderer();

            Minecraft mc = Minecraft.getInstance();
            this.renderer.prepForRender(
                    livingEntity,
                    itemStack,
                    equipmentSlot,
                    original,
                    mc.renderBuffers().bufferSource(),
                    mc.getTimer().getGameTimeDeltaPartialTick(true),
                    0,
                    0,
                    0,
                    0
            );

            return this.renderer;
        }
    };


    public static void registerClientItemExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(NEPTUNES_MIRROR, ModItem.NEPTUNES_MIRROR.get());
        event.registerItem(ETERNAL_SILVER_CRISTAL_STAFF_ITEM, ModItem.ETERNAL_SILVER_CRISTAL_STAFF.get());
        event.registerItem(RUBY_ARMOR_ITEM, ModItem.RUBY_CHESTPLATE.get());
        event.registerItem(RUBY_ARMOR_ITEM, ModItem.RUBY_HELMET.get());
        event.registerItem(RUBY_ARMOR_ITEM, ModItem.RUBY_LEGGINGS.get());
        event.registerItem(RUBY_ARMOR_ITEM, ModItem.RUBY_BOOTS.get());
    }
}
