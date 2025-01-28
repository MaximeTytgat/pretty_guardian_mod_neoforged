package com.example.prettyguardian.item.client;

import com.example.prettyguardian.item.custom.RubyArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RubyArmorRenderer extends GeoArmorRenderer<RubyArmorItem> {
    public RubyArmorRenderer() {
        super(new RubyArmorModel());
    }
}
