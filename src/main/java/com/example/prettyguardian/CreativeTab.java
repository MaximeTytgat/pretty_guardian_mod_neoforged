package com.example.prettyguardian;

import com.example.prettyguardian.block.ModBlock;
import com.example.prettyguardian.item.ModItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTab {
    private CreativeTab() {}
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PrettyGuardian.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PRETTY_GUARDIAN_TAB = CREATIVE_MODE_TABS.register("pretty_guardian_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.prettyguardian"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItem.CHOCOLATE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModBlock.CREAM_CAKE.get());
                output.accept(ModBlock.STRAWBERRY_CAKE.get());
                output.accept(ModBlock.BERRY_STRAWBERRY_CAKE.get());
                output.accept(ModBlock.RHUM_CAKE.get());
                output.accept(ModBlock.CREAM_STRAWBERRY_CAKE.get());
                output.accept(ModBlock.THREE_STRAWBERRY_CAKE.get());
                output.accept(ModBlock.CHOCOLATE_CAKE.get());
                output.accept(ModBlock.THREE_CHOCO_CAKE.get());
                output.accept(ModBlock.STRAWBERRY_CHOCO_CAKE.get());
                output.accept(ModBlock.THREE_STRAWBERRY_CHOCO_CAKE.get());
                output.accept(ModBlock.VELVET_CAKE.get());
                output.accept(ModBlock.THREE_VELVET_CAKE.get());

                output.accept(ModItem.SECRET_DONUT.get());
                output.accept(ModItem.DONUT.get());
                output.accept(ModItem.STRAWBERRY_DONUT.get());
                output.accept(ModItem.CHOCOLATE_DONUT.get());
                output.accept(ModItem.SECRET_MOCHI_DONUT.get());
                output.accept(ModItem.MOCHI_DONUT.get());
                output.accept(ModItem.STRAWBERRY_MOCHI_DONUT.get());
                output.accept(ModItem.CHOCOLATE_MOCHI_DONUT.get());

                output.accept(ModBlock.APPLE_PIE.get());
                output.accept(ModBlock.CHOCOLATE_PIE.get());
                output.accept(ModBlock.MAGIC_PIE.get());
                output.accept(ModBlock.LEMON_PIE.get());
                output.accept(ModBlock.STRAWBERRY_PIE.get());
                output.accept(ModItem.CARAMEL.get());
                output.accept(ModItem.RAW_BOBA.get());
                output.accept(ModItem.BOBA.get());
                output.accept(ModItem.LEMON.get());
                output.accept(ModItem.PISTACHIO.get());
                output.accept(ModItem.AGARAGAR.get());
                output.accept(ModItem.CREAM.get());
                output.accept(ModItem.RAW_SQUID.get());
                output.accept(ModItem.SQUID_STICK.get());
                output.accept(ModItem.SQUID_COOKED.get());

                output.accept(ModItem.STRAWBERRY_SEEDS.get());
                output.accept(ModItem.STRAWBERRY.get());
                output.accept(ModItem.CHOCOLATE_STRAWBERRY.get());
                output.accept(ModItem.VANILLA_SEEDS.get());
                output.accept(ModItem.VANILLA.get());
                output.accept(ModItem.MINT_SEEDS.get());
                output.accept(ModItem.MINT.get());

                output.accept(ModItem.WAFFLE.get());
                output.accept(ModItem.FISH_WAFFLE.get());
                output.accept(ModItem.CHOCOLATE_WAFFLE.get());
                output.accept(ModItem.ICE_CREAM_WAFFLE_VANILLA.get());
                output.accept(ModItem.ICE_CREAM_WAFFLE_CHOCOLATE.get());
                output.accept(ModItem.ICE_CREAM_WAFFLE_STRAWBERRY.get());
                output.accept(ModItem.ICE_CREAM_WAFFLE_PISTACHIO.get());

                output.accept(ModItem.SMORE.get());
                output.accept(ModItem.MARSHMELLOW_STRAWBERRY_BURGER.get());

                output.accept(ModItem.STRAWBERRY_MILK_BUCKET.get());
                output.accept(ModItem.CHOCOLATE_MILK_BUCKET.get());
                output.accept(ModItem.VANILLA_MILK_BUCKET.get());
                output.accept(ModItem.STRAWBERRY_MILK_CARTON.get());
                output.accept(ModItem.CHOCOLATE_MILK_CARTON.get());
                output.accept(ModItem.VANILLA_MILK_CARTON.get());

                output.accept(ModItem.PISTACHIO_ICE_CREAM.get());
                output.accept(ModItem.VANILLA_ICE_CREAM.get());
                output.accept(ModItem.CHOCOLATE_ICE_CREAM.get());
                output.accept(ModItem.STRAWBERRY_ICE_CREAM.get());
                output.accept(ModItem.POKKY_ICE_CREAM.get());

                output.accept(ModItem.APPLE_MOJITO.get());
                output.accept(ModItem.MINT_MOJITO.get());
                output.accept(ModItem.STRAWBERRY_MOJITO.get());
                output.accept(ModItem.BUBBLETEA_MELON.get());
                output.accept(ModItem.BUBBLETEA_STRAWBERRY.get());
                output.accept(ModItem.BUBBLETEA_CARAMEL.get());

                output.accept(ModItem.POPSICLE.get());
                output.accept(ModItem.CREAM_POPSICLE.get());
                output.accept(ModItem.CHOCOLATE_POPSICLE.get());
                output.accept(ModItem.STRAWBERRY_POPSICLE.get());
                output.accept(ModItem.CHOCOLATE_POCKY.get());
                output.accept(ModItem.STRAWBERRY_POCKY.get());
                output.accept(ModItem.TAKOYAKI.get());
                output.accept(ModItem.DANGO_CARAMEL.get());
                output.accept(ModItem.TRICOLOR_DANGO.get());

                output.accept(ModItem.CARAMEL_PUDDING.get());
                output.accept(ModItem.CHOCOLATE_PUDDING.get());
                output.accept(ModItem.STRAWBERRY_PUDDING.get());
                output.accept(ModItem.PISTACHIO_PUDDING.get());

                output.accept(ModItem.MARSHMALLOW.get());
                output.accept(ModItem.MARSHMALLOW_STICK.get());
                output.accept(ModItem.ROASTED_MARSHMALLOW_STICK.get());

                output.accept(ModItem.CANDY_APPLE.get());

                output.accept(ModItem.CHOCOLATE_CROISSANT.get());
                output.accept(ModItem.VANILLA_CROISSANT.get());
                output.accept(ModItem.STRAWBERRY_CROISSANT.get());
                output.accept(ModItem.PISTACHIO_CROISSANT.get());
                output.accept(ModItem.RHUM_BOTTLE.get());

                output.accept(ModItem.JUICE_GLASS.get());
                output.accept(ModItem.ICE_CREAM_CUP.get());

//                output.accept(ModItem.RAW_PINK_SAPPHIRE.get());
                output.accept(ModItem.PINK_SAPPHIRE.get());
                output.accept(ModBlock.PINK_SAPPHIRE_BLOCK.get());
                output.accept(ModBlock.PINK_SAPPHIRE_ORE.get());
                output.accept(ModBlock.DEEPSLATE_PINK_SAPPHIRE_ORE.get());

                output.accept(ModItem.PINK_SAPPHIRE_SWORD.get());
                output.accept(ModItem.PINK_SAPPHIRE_PICKAXE.get());
                output.accept(ModItem.PINK_SAPPHIRE_AXE.get());
                output.accept(ModItem.PINK_SAPPHIRE_SHOVEL.get());
                output.accept(ModItem.PINK_SAPPHIRE_HOE.get());

                output.accept(ModItem.PINK_SAPPHIRE_HELMET.get());
                output.accept(ModItem.PINK_SAPPHIRE_CHESTPLATE.get());
                output.accept(ModItem.PINK_SAPPHIRE_LEGGINGS.get());
                output.accept(ModItem.PINK_SAPPHIRE_BOOTS.get());

                output.accept(ModItem.RUBY.get());
//                output.accept(ModItem.RAW_RUBY.get());
                output.accept(ModBlock.RUBY_BLOCK.get());
                output.accept(ModBlock.RUBY_ORE.get());
                output.accept(ModBlock.DEEPSLATE_RUBY_ORE.get());

                output.accept(ModItem.RUBY_SWORD.get());
                output.accept(ModItem.RUBY_PICKAXE.get());
                output.accept(ModItem.RUBY_AXE.get());
                output.accept(ModItem.RUBY_SHOVEL.get());
                output.accept(ModItem.RUBY_HOE.get());

                output.accept(ModItem.RUBY_HELMET.get());
                output.accept(ModItem.RUBY_CHESTPLATE.get());
                output.accept(ModItem.RUBY_LEGGINGS.get());
                output.accept(ModItem.RUBY_BOOTS.get());

                output.accept(ModItem.ETERNAL_SILVER_CRISTAL_STAFF.get());

                output.accept(ModItem.CUPIDON_BOW.get());
                output.accept(ModItem.HEART_ARROW.get());

                output.accept(ModItem.CUTIE_MOON_ROD.get());
                output.accept(ModItem.ETERNAL_TIARE.get());
                output.accept(ModItem.MOON_KALEIDOSCOPE.get());
                output.accept(ModItem.MOON_STICK.get());
                output.accept(ModItem.MOON_STICK_PEARL.get());
                output.accept(ModItem.SPIRAL_HEART_MOON_ROD.get());

                output.accept(ModItem.PLUTONS_KEY.get());
                output.accept(ModItem.NEPTUNES_MIRROR.get());
                output.accept(ModItem.SPACE_SWORD.get());

                output.accept(ModBlock.PICNIC_BASKET.get());
                output.accept(ModItem.SAILORMOON_OST_MUSIC_DISC.get());
                output.accept(ModItem.FIREFLIES_MUSIC_DISC.get());
                output.accept(ModItem.LOFI_MUSIC_DISC.get());
                output.accept(ModItem.TAVERN_MUSIC_DISC.get());
                output.accept(ModItem.THE_LANTERN_FAIR_MUSIC_DISC.get());

                output.accept(ModBlock.CHOCOLATE_BLOCK.get());
                output.accept(ModBlock.MARSHMELLO_BLOCK.get());
                output.accept(ModBlock.ROASTED_MARSHMELLO_BLOCK.get());

                output.accept(ModBlock.PISTACHIO_LEAVES_CROP.get());
                output.accept(ModBlock.PISTACHIO_SAPLING.get());

                output.accept(ModBlock.LEMON_LEAVES_CROP.get());
                output.accept(ModBlock.LEMON_SAPLING.get());

                output.accept(ModBlock.BOBA_LEAVES_CROP.get());
                output.accept(ModBlock.BOBA_SAPLING.get());

                output.accept(ModBlock.MYMELODY_PLUSH.get());
                output.accept(ModBlock.KUROMI_PLUSH.get());
                output.accept(ModBlock.CAVALIER_PLUSH.get());
                output.accept(ModBlock.TEDDYBEAR_PLUSH.get());
                output.accept(ModBlock.RABBIT_PLUSH.get());
                output.accept(ModBlock.COW_PLUSH.get());
                output.accept(ModBlock.CINNAMOROLL_PLUSH.get());
                output.accept(ModBlock.BABYYODA_PLUSH.get());
                output.accept(ModBlock.CAPPUCCINO_PLUSH.get());
                output.accept(ModBlock.CHIFFON_PLUSH.get());
                output.accept(ModBlock.EXPRESSO_PLUSH.get());
                output.accept(ModBlock.MOCHA_PLUSH.get());
                output.accept(ModBlock.PRINCESS_PORON_PLUSH.get());
                output.accept(ModBlock.PLUSH_BEAR_HUGE.get());
                output.accept(ModBlock.RANDOM_PLUSH_BOX.get());


                output.accept(ModBlock.LANTERN_JAPANESE.get());
                output.accept(ModBlock.LANTERN_JAPANESE_SAKURA.get());
                output.accept(ModBlock.LANTERN_JAPANESE_FESTIVAL.get());

                output.accept(ModBlock.LANTERN_JAPANESE_BIG.get());
                output.accept(ModBlock.LANTERN_JAPANESE_SAKURA_BIG.get());
                output.accept(ModBlock.LANTERN_JAPANESE_FESTIVAL_BIG.get());

                output.accept(ModBlock.LANTERN_HUGE_JAPANESE.get());
                output.accept(ModBlock.LANTERN_SAKURA_HUGE_JAPANESE.get());
                output.accept(ModBlock.LANTERN_FESTIVAL_HUGE_JAPANESE.get());

                output.accept(ModBlock.LAMP_JAPANESE_OAK.get());
                output.accept(ModBlock.LAMP_JAPANESE_BIRCH.get());
                output.accept(ModBlock.LAMP_JAPANESE_SPRUCE.get());
                output.accept(ModBlock.LAMP_JAPANESE_JUNGLE.get());
                output.accept(ModBlock.LAMP_JAPANESE_ACACIA.get());
                output.accept(ModBlock.LAMP_JAPANESE_DARK_OAK.get());
                output.accept(ModBlock.LAMP_JAPANESE_MANGROVE.get());
                output.accept(ModBlock.LAMP_JAPANESE_CHERRY.get());

                output.accept(ModBlock.SCREEN_JAPANESE_CHERRY_PLANK.get());
                output.accept(ModBlock.SCREEN_JAPANESE_CHERRY_LOG.get());
                output.accept(ModBlock.SCREEN_JAPANESE_BIRCH.get());

                output.accept(ModBlock.SHOJI_BIRCH.get());
                output.accept(ModBlock.SHOJI_BIRCH_BOTTOM.get());
                output.accept(ModBlock.SHOJI_BIRCH_SMALL.get());
                output.accept(ModBlock.SHOJI_BIRCH_SMALL_BOTTOM.get());

                output.accept(ModBlock.SHOJI_BLOSSOM.get());
                output.accept(ModBlock.SHOJI_BLOSSOM_BOTTOM.get());
                output.accept(ModBlock.SHOJI_BLOSSOM_SMALL.get());
                output.accept(ModBlock.SHOJI_BLOSSOM_SMALL_BOTTOM.get());

                output.accept(ModBlock.SHOJI_CHERRY.get());
                output.accept(ModBlock.SHOJI_CHERRY_BOTTOM.get());
                output.accept(ModBlock.SHOJI_CHERRY_SMALL.get());
                output.accept(ModBlock.SHOJI_CHERRY_SMALL_BOTTOM.get());

                output.accept(ModBlock.SCROLL_JAPANESE_AXOLOTL.get());
                output.accept(ModBlock.SCROLL_JAPANESE_BEE.get());
                output.accept(ModBlock.SCROLL_JAPANESE_CINNAMON_ROLL.get());
                output.accept(ModBlock.SCROLL_JAPANESE_MUSHROOM.get());
                output.accept(ModBlock.SCROLL_JAPANESE_DAY.get());
                output.accept(ModBlock.SCROLL_JAPANESE_NIGHT.get());
                output.accept(ModBlock.SCROLL_JAPANESE_DAY_2.get());
                output.accept(ModBlock.SCROLL_JAPANESE_SUNFLOWER.get());

                output.accept(ModBlock.DOOR_SHOJI_BLOSSOM.get());
                output.accept(ModBlock.DOOR_SHOJI_BLOSSOM_SMALL.get());
                output.accept(ModBlock.DOOR_SHOJI_BIRCH.get());
                output.accept(ModBlock.DOOR_SHOJI_BIRCH_SMALL.get());
                output.accept(ModBlock.DOOR_SHOJI_CHERRY.get());
                output.accept(ModBlock.DOOR_SHOJI_CHERRY_SMALL.get());

                output.accept(ModBlock.TABLE_JAPANESE_OAK.get());
                output.accept(ModBlock.TABLE_JAPANESE_SPRUCE.get());
                output.accept(ModBlock.TABLE_JAPANESE_BIRCH.get());
                output.accept(ModBlock.TABLE_JAPANESE_CHERRY_PLANK.get());
                output.accept(ModBlock.TABLE_JAPANESE_CHERRY_LOG.get());

                output.accept(ModBlock.CHAIR_JAPANESE_OAK.get());
                output.accept(ModBlock.CHAIR_JAPANESE_SPRUCE.get());
                output.accept(ModBlock.CHAIR_JAPANESE_BIRCH.get());
                output.accept(ModBlock.CHAIR_JAPANESE_CHERRY_PLANK.get());
                output.accept(ModBlock.CHAIR_JAPANESE_CHERRY_LOG.get());

                output.accept(ModBlock.BONZAI_CHERRY.get());
                output.accept(ModBlock.LUCKY_NEKO.get());

                output.accept(ModBlock.SEA_SHELL.get());

                output.accept(ModItem.FAIRY_DUST.get());
                output.accept(ModItem.GIFT_BOX.get());
                output.accept(ModItem.LOVE_LETTER.get());
                output.accept(ModItem.RUBY_TEMPLATE_UPGRADE.get());
//                output.accept(ModBlock.GEM_POLISHING_STATION.get());
                output.accept(ModBlock.MOON_ALTAR.get());

                output.accept(ModItem.BUTTERFLY_NET.get());
                output.accept(ModItem.ADMIRAL_BUTTERFLY_EGG.get());
                output.accept(ModItem.APOLLO_BUTTERFLY_EGG.get());
                output.accept(ModItem.DUSK_BUTTERFLY_EGG.get());
                output.accept(ModItem.LEMON_BUTTERFLY_EGG.get());
                output.accept(ModItem.MORPHO_BUTTERFLY_EGG.get());
                output.accept(ModItem.ORCHID_BUTTERFLY_EGG.get());
                output.accept(ModItem.PEACOCK_BUTTERFLY_EGG.get());
                output.accept(ModItem.PINK_BUTTERFLY_EGG.get());
                output.accept(ModItem.SKIPPER_BUTTERFLY_EGG.get());
                output.accept(ModItem.VIOLETTE_BUTTERFLY_EGG.get());
                output.accept(ModItem.FAIRY_EGG.get());
                output.accept(ModItem.STRAWBERRY_COW_EGG.get());
                output.accept(ModItem.CELESTIAL_RABBIT_EGG.get());

                output.accept(ModBlock.SILVER_CRYSTAL.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
