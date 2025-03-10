package com.max.prettyguardian.client.gui.sreens;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.client.gui.components.CustomFittingMultiLineTextWidget;
import com.max.prettyguardian.client.gui.components.CustomMultiLineEditBox;
import com.max.prettyguardian.client.gui.components.CustomStringWidget;
import com.max.prettyguardian.client.gui.sreens.inventory.FakeLoveLetterMenu;
import com.max.prettyguardian.component.ModDataComponentTypes;
import com.max.prettyguardian.component.custom.LoveLetterComponent;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LetterEditorScreen extends AbstractContainerScreen<FakeLoveLetterMenu> {
    private static final ResourceLocation LOVE_LETTER_LOCATION = ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "textures/gui/love_letter.png");
    private static final ResourceLocation LOVE_LETTER_LAYER_LOCATION = ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "textures/gui/love_letter_layer.png");
    private CustomMultiLineEditBox output;
    private final ItemStack stack;
    private final List<FormattedCharSequence> cachedPageComponents;

    public LetterEditorScreen(FakeLoveLetterMenu fakeMenu, Inventory inventory, Component ignoredComponent) {
        super(fakeMenu, inventory, Component.empty());
        this.cachedPageComponents = Collections.emptyList();
        this.stack = inventory.getSelected();
    }

    @Override
    protected void init() {
        int bookX = (this.width - 170) / 2;
        int bookY = 20;

        Button.Builder doneButton = Button.builder(
                CommonComponents.GUI_DONE,
                button -> this.onClose()
        ).bounds((this.width / 2) + 5, 196, 100, 20);

        Button.Builder signButton = Button.builder(
                Component.translatable("gui.sign_and_close"),
                button -> this.onClose("sign")
        ).bounds((this.width / 2) - 105, 196, 100, 20);


        this.output = new CustomMultiLineEditBox(
                this.font, bookX + 30, bookY + 18, 105, 115,
                Component.translatable("screen.prettyguardian.love_letter.placeholder").withStyle(Style.EMPTY.withColor(11828699)),
                Component.empty()
        );

        this.output.setMessage(Component.translatable("screen.prettyguardian.love_letter.placeholder").withStyle(Style.EMPTY.withColor(11828699)));


        if (!this.stack.has(ModDataComponentTypes.LOVE_LETTER_COMPONENT.get())) {
            this.addRenderableWidget(this.output);
            this.addRenderableWidget(doneButton.build());
            this.addRenderableWidget(signButton.build());
            return;
        }

        LoveLetterComponent loveLetter = this.stack.get(ModDataComponentTypes.LOVE_LETTER_COMPONENT.get());
        if (loveLetter != null && loveLetter.loveLetterText() != null) {
            this.output.setValue(loveLetter.loveLetterText());
        }

        if (loveLetter == null || !loveLetter.isSigned()) {
            this.addRenderableWidget(this.output);
            this.addRenderableWidget(doneButton.build());
            this.addRenderableWidget(signButton.build());
            return;
        }

        String text = loveLetter.loveLetterText();
        String author = loveLetter.loveLetterAuthor();

        if (text == null) {
            text = "";
        }

        CustomFittingMultiLineTextWidget writtenOutput = new CustomFittingMultiLineTextWidget(
                bookX + 30, bookY + 18, 105, 115,
                Component.literal(text).withStyle(Style.EMPTY.withColor(11828699)),
                this.font
        );

        this.addRenderableWidget(new CustomStringWidget(bookX + 22, 160, 100, 20,
                Component.translatable("screen.prettyguardian.love_letter.send_by").withStyle(Style.EMPTY.withColor(10455011).applyFormats(ChatFormatting.BOLD))
                        .append(" ")
                        .append(author),
                this.font));

        this.addRenderableWidget(writtenOutput);
        this.addRenderableWidget(Button.builder(
                CommonComponents.GUI_DONE,
                button -> this.onClose()
        ).bounds((this.width / 2) - 100, 196, 200, 20).build());
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        int bookX = (this.width - 170) / 2;
        int bookY = 20;
        graphics.fillGradient(0, 0, this.width, this.height, -1072689136, -804253680);
        graphics.blit(LOVE_LETTER_LOCATION, bookX, bookY, 0, 0, 192, 192);

        int maxLines = Math.min(128 / 9, this.cachedPageComponents.size());
        for (int lineIndex = 0; lineIndex < maxLines; ++lineIndex) {
            FormattedCharSequence line = this.cachedPageComponents.get(lineIndex);
            int lineY = 32 + lineIndex * 9;
            graphics.drawString(this.font, line, bookX + 36, lineY, 0, false);
        }

        Style hoveredComponentStyle = this.getClickedComponentStyleAt(mouseX, mouseY);
        if (hoveredComponentStyle != null) {
            graphics.renderComponentHoverEffect(this.font, hoveredComponentStyle, mouseX, mouseY);
        }

        graphics.blit(LOVE_LETTER_LAYER_LOCATION, bookX, bookY, 0, 0, 192, 192);

        for (Renderable renderable : this.renderables) {
            renderable.render(graphics, mouseX, mouseY, partialTicks);
        }
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float v, int i, int i1) { /* no background rendering */ }

    @Nullable
    public Style getClickedComponentStyleAt(double v, double v1) {
        int floor = Mth.floor(v - ((double) (this.width - 192) / 2) - 36.0);
        int floor1 = Mth.floor(v1 - 2.0 - 30.0);
        if (floor >= 0 && floor1 >= 0) {
            Objects.requireNonNull(this.font);
            int min = Math.min(128 / 9, this.cachedPageComponents.size());
            if (floor <= 114) {
                assert this.minecraft != null;
                Objects.requireNonNull(this.minecraft.font);
                if (floor1 < 9 * min + min) {
                    Objects.requireNonNull(this.minecraft.font);
                    int i = floor1 / 9;
                    if (i < this.cachedPageComponents.size()) {
                        FormattedCharSequence formattedCharSequence = this.cachedPageComponents.get(i);
                        return this.minecraft.font.getSplitter().componentStyleAtWidth(formattedCharSequence, floor);
                    }

                    return null;
                }
            }

        }
        return null;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        PrettyGuardian.LOGGER.info("Key pressed !");
        InputConstants.Key mouseKey = InputConstants.getKey(keyCode, scanCode);
        if (this.minecraft != null && this.minecraft.options.keyInventory.isActiveAndMatches(mouseKey)) {
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void onClose() {
        String text = this.output.getValue();
        if (text == null || text.isEmpty()) {
            super.onClose();
            return;
        }

        LoveLetterComponent loveLetter = new LoveLetterComponent(null, text);
        if (this.stack.has(ModDataComponentTypes.LOVE_LETTER_COMPONENT.get())) {
            LoveLetterComponent oldLoveLetter = this.stack.get(ModDataComponentTypes.LOVE_LETTER_COMPONENT.get());
            if (oldLoveLetter == null || !oldLoveLetter.isSigned()) {
                this.stack.set(ModDataComponentTypes.LOVE_LETTER_COMPONENT.get(), loveLetter);
            }
        } else {
            this.stack.set(ModDataComponentTypes.LOVE_LETTER_COMPONENT.get(), loveLetter);
        }

        super.onClose();
    }

    public void onClose(String action) {
        assert Minecraft.getInstance().player != null;
        String playerName = Minecraft.getInstance().player.getName().getString();

        if (Objects.equals(action, "sign")) {
            LoveLetterComponent loveLetter = new LoveLetterComponent(playerName, this.output.getValue());
            this.stack.set(ModDataComponentTypes.LOVE_LETTER_COMPONENT.get(), loveLetter);
        }

        super.onClose();
    }

}