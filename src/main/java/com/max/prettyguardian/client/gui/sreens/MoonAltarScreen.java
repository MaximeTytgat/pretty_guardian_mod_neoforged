package com.max.prettyguardian.client.gui.sreens;


import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.client.gui.sreens.inventory.MoonAltarMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class MoonAltarScreen extends AbstractContainerScreen<MoonAltarMenu> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "textures/gui/container/moon_altar.png");

    public MoonAltarScreen(MoonAltarMenu staffMagicTableMenu, Inventory inventory, Component component) {
        super(staffMagicTableMenu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        imageWidth = 198;
        imageHeight = 228;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 121, y + 43, 218, 0, 4, Math.min(menu.getScaledProgress(), 5));
            guiGraphics.blit(TEXTURE, x + 73, y + 43, 198, 0, 4, Math.min(menu.getScaledProgress(), 5));
            if (menu.getScaledProgress() > 5) {
                guiGraphics.blit(TEXTURE, x + 121 - Math.min(menu.getScaledProgress() - 5, 8), y + 45, 218 - Math.min(menu.getScaledProgress() - 5, 8), 2, Math.min(menu.getScaledProgress() - 5, 8), 3);
                guiGraphics.blit(TEXTURE, x + 77, y + 45, 202, 2, Math.min(menu.getScaledProgress() - 5, 8), 3);
            }
            if (menu.getScaledProgress() > 8) {
                guiGraphics.blit(TEXTURE, x + 91, y + 58, 198, 5, 17, menu.getScaledProgress() - 13);
            }
        }
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics, mouseX, mouseY, delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
