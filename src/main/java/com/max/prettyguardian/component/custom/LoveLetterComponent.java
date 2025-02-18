package com.max.prettyguardian.component.custom;

public record LoveLetterComponent(String loveLetterAuthor, String loveLetterText) {
    public static final LoveLetterComponent DEFAULT = new LoveLetterComponent("", "");

    public boolean isSigned() {
        return loveLetterAuthor != null && !loveLetterAuthor.isEmpty();
    }
}
