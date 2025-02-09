package com.max.prettyguardian.client.gui.sreens.inventory;

import com.max.prettyguardian.PrettyGuardian;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypes {
    private ModMenuTypes() {}
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, PrettyGuardian.MOD_ID);

    public static final Supplier<MenuType<PicnicBasketMenu>> PICNIC_BASKET_MENU =
            MENUS.register("picnic_basket_menu", () -> IMenuTypeExtension.create(PicnicBasketMenu::new));

    public static final Supplier<MenuType<GemPolishingStationMenu>> GEM_POLISHING_MENU =
            MENUS.register("gem_polishing_menu", () -> IMenuTypeExtension.create(GemPolishingStationMenu::new));

    public static final Supplier<MenuType<MoonAltarMenu>> STAFF_MAGIC_TABLE_MENU =
            MENUS.register("staff_magic_table_menu", () -> IMenuTypeExtension.create(MoonAltarMenu::new));

    public static final Supplier<MenuType<GiftBoxMenu>> GIFT_BOX_MENU =
            MENUS.register("gift_box_menu", () -> IMenuTypeExtension.create(GiftBoxMenu::new));

    public static final Supplier<MenuType<FakeLoveLetterMenu>> LETTER_EDITOR_MENU =
            MENUS.register("letter_editor_menu", () -> IMenuTypeExtension.create(FakeLoveLetterMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
