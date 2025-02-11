package com.max.prettyguardian.component.custom;

import net.minecraft.world.item.component.FireworkExplosion;

public record LoveLetterComponent(String loveLetterAuthor, String loveLetterText) {
    public static final LoveLetterComponent DEFAULT = new LoveLetterComponent("", "");

    public boolean isSigned() {
        return !loveLetterAuthor.isEmpty();
    }
}
