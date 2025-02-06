package com.max.prettyguardian.item;

import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.entity.ModEntities;
import com.max.prettyguardian.entity.custom.ButterflyEntity;
import com.max.prettyguardian.item.custom.*;
import com.max.prettyguardian.item.custom.food.ClassicDonut;
import com.max.prettyguardian.item.custom.food.MilkItem;
import com.max.prettyguardian.item.custom.food.ReusableFoodContainerItem;
import com.max.prettyguardian.item.custom.projectiles.BubbleItem;
import com.max.prettyguardian.item.custom.projectiles.CuteArrowItem;
import com.max.prettyguardian.item.custom.projectiles.HeartItem;
import com.max.prettyguardian.item.custom.projectiles.StarLightItem;
import com.max.prettyguardian.item.custom.tool.*;
import com.max.prettyguardian.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItem {
    private ModItem() {}
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrettyGuardian.MOD_ID);

    public static final DeferredItem<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds", () -> new ItemNameBlockItem(ModBlock.STRAWBERRY_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final DeferredItem<Item> MINT_SEEDS = ITEMS.register("mint_seeds", () -> new ItemNameBlockItem(ModBlock.MINT_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> MINT = ITEMS.register("mint", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final DeferredItem<Item> VANILLA_SEEDS = ITEMS.register("vanilla_seeds", () -> new ItemNameBlockItem(ModBlock.VANILLA_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> VANILLA = ITEMS.register("vanilla", () -> new Item(new Item.Properties().food(ModFoods.BASE)));
    public static final DeferredItem<Item> PISTACHIO = ITEMS.register("pistachio", () -> new Item(new Item.Properties().food(ModFoods.BASE)));
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties().food(ModFoods.BASE)));
    public static final DeferredItem<Item> RAW_BOBA = ITEMS.register("raw_boba", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BOBA = ITEMS.register("boba", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AGARAGAR = ITEMS.register("agaragar", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CREAM = ITEMS.register("cream", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_SQUID = ITEMS.register("raw_squid", () -> new Item(new Item.Properties().food(ModFoods.SQUID)));
    public static final DeferredItem<Item> SQUID_STICK = ITEMS.register("squid_stick", () -> new Item(new Item.Properties().food(ModFoods.SQUID)));
    public static final DeferredItem<Item> SQUID_COOKED = ITEMS.register("squid_cooked", () -> new Item(new Item.Properties().food(ModFoods.SQUID_COOKED)));

    public static final DeferredItem<Item> CHOCOLATE_STRAWBERRY = ITEMS.register("chocolate_strawberry", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final DeferredItem<Item> SECRET_DONUT = ITEMS.register("secret_donut", () -> new Item(new Item.Properties().food(ModFoods.DONUT)));
    public static final DeferredItem<Item> DONUT = ITEMS.register("donut", () -> new ClassicDonut(new Item.Properties().food(ModFoods.DONUT)));
    public static final DeferredItem<Item> STRAWBERRY_DONUT = ITEMS.register("strawberry_donut", () -> new Item(new Item.Properties().food(ModFoods.DONUT)));
    public static final DeferredItem<Item> CHOCOLATE_DONUT = ITEMS.register("chocolate_donut", () -> new Item(new Item.Properties().food(ModFoods.DONUT)));
    public static final DeferredItem<Item> SECRET_MOCHI_DONUT = ITEMS.register("secret_mochi_donut", () -> new Item(new Item.Properties().food(ModFoods.MOCHI_DONUT)));
    public static final DeferredItem<Item> MOCHI_DONUT = ITEMS.register("mochi_donut", () -> new Item(new Item.Properties().food(ModFoods.MOCHI_DONUT)));
    public static final DeferredItem<Item> STRAWBERRY_MOCHI_DONUT = ITEMS.register("strawberry_mochi_donut", () -> new Item(new Item.Properties().food(ModFoods.MOCHI_DONUT)));
    public static final DeferredItem<Item> CHOCOLATE_MOCHI_DONUT = ITEMS.register("chocolate_mochi_donut", () -> new Item(new Item.Properties().food(ModFoods.MOCHI_DONUT)));
    public static final DeferredItem<Item> CARAMEL = ITEMS.register("caramel", () -> new Item(new Item.Properties().food(ModFoods.CARAMEL)));
    public static final DeferredItem<Item> CHOCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties().food(ModFoods.CHOCOLATE)));
    public static final DeferredItem<Item> STRAWBERRY_MILK_BUCKET = ITEMS.register("strawberry_milk_bucket", () -> new MilkItem(new Item.Properties().food(ModFoods.MILK).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> CHOCOLATE_MILK_BUCKET = ITEMS.register("chocolate_milk_bucket", () -> new MilkItem(new Item.Properties().food(ModFoods.MILK).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> VANILLA_MILK_BUCKET = ITEMS.register("vanilla_milk_bucket", () -> new MilkItem(new Item.Properties().food(ModFoods.MILK).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> STRAWBERRY_MILK_CARTON = ITEMS.register("strawberry_milk_carton", () -> new MilkItem(new Item.Properties().food(ModFoods.MILK_CARTON), false));
    public static final DeferredItem<Item> CHOCOLATE_MILK_CARTON = ITEMS.register("chocolate_milk_carton", () -> new MilkItem(new Item.Properties().food(ModFoods.MILK_CARTON), false));
    public static final DeferredItem<Item> VANILLA_MILK_CARTON = ITEMS.register("vanilla_milk_carton", () -> new MilkItem(new Item.Properties().food(ModFoods.MILK_CARTON), false));
    public static final DeferredItem<Item> PISTACHIO_ICE_CREAM = ITEMS.register("pistachio_ice_cream", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.ICE_CREAM), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.ICE_CREAM_CUP, false));
    public static final DeferredItem<Item> VANILLA_ICE_CREAM = ITEMS.register("vanilla_ice_cream", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.ICE_CREAM), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.ICE_CREAM_CUP, false));
    public static final DeferredItem<Item> CHOCOLATE_ICE_CREAM = ITEMS.register("chocolate_ice_cream", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.ICE_CREAM), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.ICE_CREAM_CUP, false));
    public static final DeferredItem<Item> STRAWBERRY_ICE_CREAM = ITEMS.register("strawberry_ice_cream", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.ICE_CREAM), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.ICE_CREAM_CUP, false));
    public static final DeferredItem<Item> POKKY_ICE_CREAM = ITEMS.register("pokky_ice_cream", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.POKKY_ICE_CREAM), 64, com.max.prettyguardian.item.item.PrettyGuardianItem.ICE_CREAM_CUP, false));
    public static final DeferredItem<Item> APPLE_MOJITO = ITEMS.register("apple_mojito", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.MOJITO), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.JUICE_GLASS));
    public static final DeferredItem<Item> MINT_MOJITO = ITEMS.register("mint_mojito", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.MOJITO), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.JUICE_GLASS));
    public static final DeferredItem<Item> STRAWBERRY_MOJITO = ITEMS.register("strawberry_mojito", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.MOJITO), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.JUICE_GLASS));
    public static final DeferredItem<Item> BUBBLETEA_MELON = ITEMS.register("bubbletea_melon", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.BUBBLE_TEA), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.JUICE_GLASS));
    public static final DeferredItem<Item> BUBBLETEA_STRAWBERRY = ITEMS.register("bubbletea_strawberry", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.BUBBLE_TEA), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.JUICE_GLASS));
    public static final DeferredItem<Item> BUBBLETEA_CARAMEL = ITEMS.register("bubbletea_caramel", () -> new ReusableFoodContainerItem(new Item.Properties().food(ModFoods.BUBBLE_TEA), 32, com.max.prettyguardian.item.item.PrettyGuardianItem.JUICE_GLASS));

    public static final DeferredItem<Item> WAFFLE = ITEMS.register("waffle", () -> new Item(new Item.Properties().food(ModFoods.WAFFLE)));
    public static final DeferredItem<Item> FISH_WAFFLE = ITEMS.register("fish_waffle", () -> new Item(new Item.Properties().food(ModFoods.WAFFLE)));
    public static final DeferredItem<Item> CHOCOLATE_WAFFLE = ITEMS.register("chocolate_waffle", () -> new Item(new Item.Properties().food(ModFoods.CHOCOLATE_WAFFLE)));
    public static final DeferredItem<Item> ICE_CREAM_WAFFLE_VANILLA = ITEMS.register("ice_cream_waffle_vanilla", () -> new Item(new Item.Properties().food(ModFoods.ICE_CREAM_WAFFLE)));
    public static final DeferredItem<Item> ICE_CREAM_WAFFLE_CHOCOLATE = ITEMS.register("ice_cream_waffle_chocolate", () -> new Item(new Item.Properties().food(ModFoods.ICE_CREAM_WAFFLE)));
    public static final DeferredItem<Item> ICE_CREAM_WAFFLE_STRAWBERRY = ITEMS.register("ice_cream_waffle_strawberry", () -> new Item(new Item.Properties().food(ModFoods.ICE_CREAM_WAFFLE)));
    public static final DeferredItem<Item> ICE_CREAM_WAFFLE_PISTACHIO = ITEMS.register("ice_cream_waffle_pistachio", () -> new Item(new Item.Properties().food(ModFoods.ICE_CREAM_WAFFLE)));
    public static final DeferredItem<Item> CHOCOLATE_POCKY = ITEMS.register("chocolate_pocky", () -> new Item(new Item.Properties().food(ModFoods.POCKY)));
    public static final DeferredItem<Item> STRAWBERRY_POCKY = ITEMS.register("strawberry_pocky", () -> new Item(new Item.Properties().food(ModFoods.POCKY)));
    public static final DeferredItem<Item> TAKOYAKI = ITEMS.register("takoyaki", () -> new Item(new Item.Properties().food(ModFoods.TAKOYAKI)));
    public static final DeferredItem<Item> DANGO_CARAMEL = ITEMS.register("dango_caramel", () -> new Item(new Item.Properties().food(ModFoods.DANGO)));
    public static final DeferredItem<Item> TRICOLOR_DANGO = ITEMS.register("tricolor_dango", () -> new Item(new Item.Properties().food(ModFoods.DANGO)));
    public static final DeferredItem<Item> POPSICLE = ITEMS.register("popsicle", () -> new Item(new Item.Properties().food(ModFoods.POPSICLE)));
    public static final DeferredItem<Item> CREAM_POPSICLE = ITEMS.register("cream_popsicle", () -> new Item(new Item.Properties().food(ModFoods.POPSICLE)));
    public static final DeferredItem<Item> CHOCOLATE_POPSICLE = ITEMS.register("chocolate_popsicle", () -> new Item(new Item.Properties().food(ModFoods.POPSICLE)));
    public static final DeferredItem<Item> STRAWBERRY_POPSICLE = ITEMS.register("strawberry_popsicle", () -> new Item(new Item.Properties().food(ModFoods.POPSICLE)));
    public static final DeferredItem<Item> CARAMEL_PUDDING = ITEMS.register("caramel_pudding", () -> new Item(new Item.Properties().food(ModFoods.PUDDING)));
    public static final DeferredItem<Item> CHOCOLATE_PUDDING = ITEMS.register("chocolate_pudding", () -> new Item(new Item.Properties().food(ModFoods.PUDDING)));
    public static final DeferredItem<Item> STRAWBERRY_PUDDING = ITEMS.register("strawberry_pudding", () -> new Item(new Item.Properties().food(ModFoods.PUDDING)));
    public static final DeferredItem<Item> PISTACHIO_PUDDING = ITEMS.register("pistachio_pudding", () -> new Item(new Item.Properties().food(ModFoods.PUDDING)));
    public static final DeferredItem<Item> MARSHMALLOW = ITEMS.register("marshmallow", () -> new Item(new Item.Properties().food(ModFoods.MARSHMELLOW)));
    public static final DeferredItem<Item> MARSHMALLOW_STICK = ITEMS.register("marshmallow_stick", () -> new Item(new Item.Properties().food(ModFoods.MARSHMELLOW)));
    public static final DeferredItem<Item> ROASTED_MARSHMALLOW_STICK = ITEMS.register("roasted_marshmallow_stick", () -> new Item(new Item.Properties().food(ModFoods.ROASTED_MARSHMELLOW)));
    public static final DeferredItem<Item> SMORE = ITEMS.register("smore", () -> new Item(new Item.Properties().food(ModFoods.SMORE)));
    public static final DeferredItem<Item> MARSHMELLOW_STRAWBERRY_BURGER = ITEMS.register("marshmellow_strawberry_burger", () -> new Item(new Item.Properties().food(ModFoods.MARSHMELLOW_STRAWBERRY_BURGER)));
    public static final DeferredItem<Item> CANDY_APPLE = ITEMS.register("candy_apple", () -> new Item(new Item.Properties().food(ModFoods.CANDY_APPLE)));
    public static final DeferredItem<Item> CHOCOLATE_CROISSANT = ITEMS.register("chocolate_croissant", () -> new Item(new Item.Properties().food(ModFoods.CROISSANT)));
    public static final DeferredItem<Item> VANILLA_CROISSANT = ITEMS.register("vanilla_croissant", () -> new Item(new Item.Properties().food(ModFoods.CROISSANT)));
    public static final DeferredItem<Item> STRAWBERRY_CROISSANT = ITEMS.register("strawberry_croissant", () -> new Item(new Item.Properties().food(ModFoods.CROISSANT)));
    public static final DeferredItem<Item> PISTACHIO_CROISSANT = ITEMS.register("pistachio_croissant", () -> new Item(new Item.Properties().food(ModFoods.CROISSANT)));
    public static final DeferredItem<Item> RHUM_BOTTLE = ITEMS.register("rhum_bottle", () -> new Item(new Item.Properties().food(ModFoods.RHUM)));
    public static final DeferredItem<Item> JUICE_GLASS = ITEMS.register("juice_glass", () -> new Item(new Item.Properties().food(ModFoods.RHUM)));
    public static final DeferredItem<Item> ICE_CREAM_CUP = ITEMS.register("ice_cream_cup", () -> new Item(new Item.Properties().food(ModFoods.RHUM)));


    public static final DeferredItem<Item> PINK_SAPPHIRE = ITEMS.register("pink_sapphire", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_PINK_SAPPHIRE = ITEMS.register("raw_pink_sapphire", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PINK_SAPPHIRE_SWORD = ITEMS.register("pink_sapphire_sword", () -> new SwordItem(ModToolTiers.PINK_SAPPHIRE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.PINK_SAPPHIRE,4, -1.4F))));
    public static final DeferredItem<Item> PINK_SAPPHIRE_PICKAXE = ITEMS.register("pink_sapphire_pickaxe", () -> new PickaxeItem(ModToolTiers.PINK_SAPPHIRE, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.PINK_SAPPHIRE, 2, -1.8F))));
    public static final DeferredItem<Item> PINK_SAPPHIRE_AXE = ITEMS.register("pink_sapphire_axe", () -> new AxeItem(ModToolTiers.PINK_SAPPHIRE, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.PINK_SAPPHIRE,6.0F, -2.0F))));
    public static final DeferredItem<Item> PINK_SAPPHIRE_SHOVEL = ITEMS.register("pink_sapphire_shovel", () -> new ShovelItem(ModToolTiers.PINK_SAPPHIRE, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.PINK_SAPPHIRE,2.5F, -2.0F))));
    public static final DeferredItem<Item> PINK_SAPPHIRE_HOE = ITEMS.register("pink_sapphire_hoe", () -> new HoeItem(ModToolTiers.PINK_SAPPHIRE, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.PINK_SAPPHIRE,-4, 1.0F))));

    public static final DeferredItem<Item> PINK_SAPPHIRE_HELMET = ITEMS.register("pink_sapphire_helmet", () -> new ArmorItem(ModArmorMaterials.PINK_SAPPHIRE, ArmorItem.Type.HELMET,  new Item.Properties()));
    public static final DeferredItem<Item> PINK_SAPPHIRE_CHESTPLATE = ITEMS.register("pink_sapphire_chestplate", () -> new ArmorItem(ModArmorMaterials.PINK_SAPPHIRE, ArmorItem.Type.CHESTPLATE,  new Item.Properties()));
    public static final DeferredItem<Item> PINK_SAPPHIRE_LEGGINGS = ITEMS.register("pink_sapphire_leggings", () -> new ArmorItem(ModArmorMaterials.PINK_SAPPHIRE, ArmorItem.Type.LEGGINGS,  new Item.Properties()));
    public static final DeferredItem<Item> PINK_SAPPHIRE_BOOTS = ITEMS.register("pink_sapphire_boots", () -> new ArmorItem(ModArmorMaterials.PINK_SAPPHIRE, ArmorItem.Type.BOOTS,  new Item.Properties()));

    public static final DeferredItem<Item> RAW_RUBY = ITEMS.register("raw_ruby", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(ModToolTiers.RUBY, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.RUBY,4, -1.4F))));
    public static final DeferredItem<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ModToolTiers.RUBY, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.RUBY,2, -1.8F))));
    public static final DeferredItem<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(ModToolTiers.RUBY, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.RUBY,6.0F, -2.0F))));
    public static final DeferredItem<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(ModToolTiers.RUBY, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.RUBY,2.5F, -2.0F))));
    public static final DeferredItem<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(ModToolTiers.RUBY, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.RUBY,-5, 0.0F))));

    public static final DeferredItem<Item> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,  new Item.Properties()));
    public static final DeferredItem<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,  new Item.Properties()));
    public static final DeferredItem<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,  new Item.Properties()));
    public static final DeferredItem<Item> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,  new Item.Properties()));


    public static final DeferredItem<Item> HEART_ARROW = ITEMS.register("heart_arrow", () -> new CuteArrowItem(new Item.Properties(), 5.9F));
    public static final DeferredItem<Item> CUTE_HEART = ITEMS.register("cute_heart", () -> new HeartItem(new Item.Properties(), 5.9F));
    public static final DeferredItem<Item> BUBBLE = ITEMS.register("bubble", () -> new BubbleItem(new Item.Properties(), 2F));
    public static final DeferredItem<Item> STAR_LIGHT = ITEMS.register("star_light", () -> new StarLightItem(new Item.Properties(), 5.9F));
    public static final DeferredItem<Item> ETERNAL_SILVER_CRISTAL_STAFF = ITEMS.register("eternal_silver_cristal_staff", () -> new EternalSilverCristalStaffitem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CUPIDON_BOW = ITEMS.register("cupidon_bow", () -> new CuteBowItem(new Item.Properties().stacksTo(1).durability(784)));
    public static final DeferredItem<Item> CUTIE_MOON_ROD = ITEMS.register("cutie_moon_rod", () -> new CuteWandItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ETERNAL_TIARE = ITEMS.register("eternal_tiare", () -> new CuteWandItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MOON_KALEIDOSCOPE = ITEMS.register("moon_kaleidoscope", () -> new CuteWandItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MOON_STICK = ITEMS.register("moon_stick", () -> new CuteWandItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MOON_STICK_PEARL = ITEMS.register("moon_stick_pearl", () -> new CuteWandItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SPIRAL_HEART_MOON_ROD = ITEMS.register("spiral_heart_moon_rod", () -> new CuteWandItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> PLUTONS_KEY = ITEMS.register("plutons_key", () -> new PlutonsKey(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> NEPTUNES_MIRROR = ITEMS.register("neptunes_mirror", () -> new NeptunesMirror(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SPACE_SWORD = ITEMS.register("space_sword", () -> new SpaceSwordItem(ModToolTiers.SPACE_SWORD, new Item.Properties().stacksTo(1).attributes(SwordItem.createAttributes(ModToolTiers.RUBY,3, -2.4F))));
    public static final DeferredItem<Item> STRAWBERRY_COW_EGG = ITEMS.register("strawberry_cow_egg", () -> new ForgeSpawnEggItem(ModEntities.STRAWBERRY_COW, 0xfcd6df, 0xf798be, new Item.Properties()));
    public static final DeferredItem<Item> CELESTIAL_RABBIT_EGG = ITEMS.register("celestial_rabbit_egg", () -> new ForgeSpawnEggItem(ModEntities.CELESTIAL_RABBIT, 0xf564df, 0xf548be, new Item.Properties()));

    public static final DeferredItem<Item> SAILORMOON_OST_MUSIC_DISC = ITEMS.register("sailormoon_ost_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.SAILORMOON_MOONPRIDE_KEY).stacksTo(1)));
    public static final DeferredItem<Item> FIREFLIES_MUSIC_DISC = ITEMS.register("fireflies_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.SAILORMOON_MOONPRIDE_KEY).stacksTo(1)));
    public static final DeferredItem<Item> LOFI_MUSIC_DISC = ITEMS.register("lofi_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.LOFI_KEY).stacksTo(1)));
    public static final DeferredItem<Item> TAVERN_MUSIC_DISC = ITEMS.register("tavern_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.TAVERN_KEY).stacksTo(1)));
    public static final DeferredItem<Item> THE_LANTERN_FAIR_MUSIC_DISC = ITEMS.register("the_lantern_fair_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.JAPANESE_FLUTE_KEY).stacksTo(1)));

    public static final DeferredItem<Item> FAIRY_DUST = ITEMS.register("fairy_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GIFT_BOX = ITEMS.register("gift_box", () -> new GiftBoxItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> LOVE_LETTER = ITEMS.register("love_letter", () -> new LoveLetterItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> BUTTERFLY_NET = ITEMS.registerItem("butterfly_net", () -> new ButterflyNetItem(new Item.Properties().stacksTo(1).durability(100)));
    public static final DeferredItem<Item> ADMIRAL_BUTTERFLY_EGG = ITEMS.register("admiral_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.ADMIRAL, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> APOLLO_BUTTERFLY_EGG = ITEMS.register("apollo_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.APOLLO, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> DUSK_BUTTERFLY_EGG = ITEMS.register("dusk_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.DUSK, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> LEMON_BUTTERFLY_EGG = ITEMS.register("lemon_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.LEMON, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> MORPHO_BUTTERFLY_EGG = ITEMS.register("morpho_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.MORPHO, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> ORCHID_BUTTERFLY_EGG = ITEMS.register("orchid_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.ORCHID, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> PEACOCK_BUTTERFLY_EGG = ITEMS.register("peacock_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.PEACOCK, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> PINK_BUTTERFLY_EGG = ITEMS.register("pink_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.PINK, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> SKIPPER_BUTTERFLY_EGG = ITEMS.register("skipper_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.SKIPPER, new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> VIOLETTE_BUTTERFLY_EGG = ITEMS.register("violette_butterfly_egg", () -> new ButterflyEggItem(ModEntities.BUTTERFLY, ButterflyEntity.Variant.VIOLETTE, new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> FAIRY_EGG = ITEMS.register("fairy_egg", () -> new ForgeSpawnEggItem(ModEntities.FAIRY, 0xf5d6df, 0x9798be, new Item.Properties()));

    public static final DeferredItem<Item> RUBY_TEMPLATE_UPGRADE = ITEMS.register("ruby_template_upgrade", () -> new SmithingTemplateItem(
            Component.translatable("item.prettyguardian.ruby_template_upgrade_apply_to"),
            Component.translatable("item.prettyguardian.ruby_template_upgrade_ingridient"),
            Component.translatable("item.prettyguardian.ruby_template_upgrade_upgrade_description"),
            Component.translatable("item.prettyguardian.ruby_template_upgrade_base_slot_description"),
            Component.translatable("item.prettyguardian.ruby_template_upgrade_additional_slot_description"),
            List.of(
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_hoe"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_sword")
            ),
            List.of(
                    ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "item/empty_slot_ruby")
            )
    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

