package com.example.prettyguardian.datagen;

import com.example.prettyguardian.PrettyGuardian;
import com.example.prettyguardian.block.ModBlock;
import com.example.prettyguardian.item.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static final String MOD_ID = PrettyGuardian.MOD_ID;
    private static final String ITEM_FOLDER = "item/";
    private static final String ITEM_GENERATED = "item/generated";
    private static final String ITEM_HANDHELD = "item/handheld";
    private static final String LAYER0 = "layer0";
    private static final String LAYER1 = "layer1";

    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    private void simpleItem(DeferredItem<Item> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace(ITEM_GENERATED)).texture(LAYER0,
                ResourceLocation.fromNamespaceAndPath(MOD_ID, ITEM_FOLDER + item.getId().getPath()));
    }

    private void simpleItemForBlock(DeferredBlock<Block> block) {
        withExistingParent(block.getId().getPath(),
                ResourceLocation.withDefaultNamespace(ITEM_GENERATED)).texture(LAYER0,
                ResourceLocation.fromNamespaceAndPath(MOD_ID, ITEM_FOLDER + block.getId().getPath()));
    }

    private void handheldItem(DeferredItem<Item> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace(ITEM_HANDHELD)).texture(LAYER0,
                ResourceLocation.fromNamespaceAndPath(MOD_ID, ITEM_FOLDER + item.getId().getPath()));
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItem.STRAWBERRY_SEEDS);
        simpleItem(ModItem.VANILLA_SEEDS);
        simpleItem(ModItem.MINT_SEEDS);
        simpleItemForBlock(ModBlock.CHOCOLATE_CAKE);
        simpleItemForBlock(ModBlock.CREAM_CAKE);
        simpleItemForBlock(ModBlock.RHUM_CAKE);
        simpleItemForBlock(ModBlock.STRAWBERRY_CAKE);
        simpleItemForBlock(ModBlock.BERRY_STRAWBERRY_CAKE);
        simpleItemForBlock(ModBlock.VELVET_CAKE);
        simpleItemForBlock(ModBlock.CREAM_STRAWBERRY_CAKE);
        simpleItemForBlock(ModBlock.STRAWBERRY_CHOCO_CAKE);
        simpleItemForBlock(ModBlock.THREE_VELVET_CAKE);
        simpleItemForBlock(ModBlock.THREE_CHOCO_CAKE);
        simpleItemForBlock(ModBlock.THREE_STRAWBERRY_CAKE);
        simpleItemForBlock(ModBlock.THREE_STRAWBERRY_CHOCO_CAKE);
        simpleItemForBlock(ModBlock.APPLE_PIE);
        simpleItemForBlock(ModBlock.CHOCOLATE_PIE);
        simpleItemForBlock(ModBlock.MAGIC_PIE);
        simpleItemForBlock(ModBlock.LEMON_PIE);
        simpleItemForBlock(ModBlock.STRAWBERRY_PIE);

        simpleItem(ModItem.STRAWBERRY);
        simpleItem(ModItem.VANILLA);
        simpleItem(ModItem.MINT);
        simpleItem(ModItem.PISTACHIO);
        simpleItem(ModItem.LEMON);
        simpleItem(ModItem.BOBA);
        simpleItem(ModItem.RAW_BOBA);
        simpleItem(ModItem.AGARAGAR);
        simpleItem(ModItem.CREAM);
        simpleItem(ModItem.RAW_SQUID);
        simpleItem(ModItem.SQUID_STICK);
        simpleItem(ModItem.SQUID_COOKED);

        simpleItem(ModItem.CHOCOLATE_STRAWBERRY);
        simpleItem(ModItem.SECRET_DONUT);
        simpleItem(ModItem.DONUT);
        simpleItem(ModItem.STRAWBERRY_DONUT);
        simpleItem(ModItem.CHOCOLATE_DONUT);
        simpleItem(ModItem.SECRET_MOCHI_DONUT);
        simpleItem(ModItem.MOCHI_DONUT);
        simpleItem(ModItem.STRAWBERRY_MOCHI_DONUT);
        simpleItem(ModItem.CHOCOLATE_MOCHI_DONUT);
        simpleItem(ModItem.CARAMEL);
        simpleItem(ModItem.CHOCOLATE);
        simpleItem(ModItem.STRAWBERRY_MILK_BUCKET);
        simpleItem(ModItem.CHOCOLATE_MILK_BUCKET);
        simpleItem(ModItem.VANILLA_MILK_BUCKET);
        simpleItem(ModItem.STRAWBERRY_MILK_CARTON);
        simpleItem(ModItem.CHOCOLATE_MILK_CARTON);
        simpleItem(ModItem.VANILLA_MILK_CARTON);
        simpleItem(ModItem.PISTACHIO_ICE_CREAM);
        simpleItem(ModItem.VANILLA_ICE_CREAM);
        simpleItem(ModItem.CHOCOLATE_ICE_CREAM);
        simpleItem(ModItem.STRAWBERRY_ICE_CREAM);
        simpleItem(ModItem.POKKY_ICE_CREAM);
        simpleItem(ModItem.APPLE_MOJITO);
        simpleItem(ModItem.MINT_MOJITO);
        simpleItem(ModItem.STRAWBERRY_MOJITO);
        simpleItem(ModItem.BUBBLETEA_MELON);
        simpleItem(ModItem.BUBBLETEA_STRAWBERRY);
        simpleItem(ModItem.BUBBLETEA_CARAMEL);
        simpleItem(ModItem.WAFFLE);
        simpleItem(ModItem.FISH_WAFFLE);
        simpleItem(ModItem.CHOCOLATE_WAFFLE);
        simpleItem(ModItem.ICE_CREAM_WAFFLE_VANILLA);
        simpleItem(ModItem.ICE_CREAM_WAFFLE_CHOCOLATE);
        simpleItem(ModItem.ICE_CREAM_WAFFLE_STRAWBERRY);
        simpleItem(ModItem.ICE_CREAM_WAFFLE_PISTACHIO);
        simpleItem(ModItem.CHOCOLATE_POCKY);
        simpleItem(ModItem.STRAWBERRY_POCKY);
        simpleItem(ModItem.TAKOYAKI);
        simpleItem(ModItem.DANGO_CARAMEL);
        simpleItem(ModItem.TRICOLOR_DANGO);
        simpleItem(ModItem.POPSICLE);
        simpleItem(ModItem.CREAM_POPSICLE);
        simpleItem(ModItem.CHOCOLATE_POPSICLE);
        simpleItem(ModItem.STRAWBERRY_POPSICLE);
        simpleItem(ModItem.CARAMEL_PUDDING);
        simpleItem(ModItem.CHOCOLATE_PUDDING);
        simpleItem(ModItem.STRAWBERRY_PUDDING);
        simpleItem(ModItem.PISTACHIO_PUDDING);
        simpleItem(ModItem.MARSHMALLOW);
        simpleItem(ModItem.MARSHMALLOW_STICK);
        simpleItem(ModItem.ROASTED_MARSHMALLOW_STICK);
        simpleItem(ModItem.SMORE);
        simpleItem(ModItem.MARSHMELLOW_STRAWBERRY_BURGER);
        simpleItem(ModItem.CANDY_APPLE);
        simpleItem(ModItem.CHOCOLATE_CROISSANT);
        simpleItem(ModItem.VANILLA_CROISSANT);
        simpleItem(ModItem.STRAWBERRY_CROISSANT);
        simpleItem(ModItem.PISTACHIO_CROISSANT);
        simpleItem(ModItem.RHUM_BOTTLE);
        simpleItem(ModItem.JUICE_GLASS);
        simpleItem(ModItem.ICE_CREAM_CUP);

        simpleItem(ModItem.PINK_SAPPHIRE);
        simpleItem(ModItem.HEART_ARROW);

        simpleItem(ModItem.CUTIE_MOON_ROD);
        simpleItem(ModItem.ETERNAL_TIARE);
        simpleItem(ModItem.MOON_KALEIDOSCOPE);
        simpleItem(ModItem.MOON_STICK);
        simpleItem(ModItem.MOON_STICK_PEARL);
        simpleItem(ModItem.SPIRAL_HEART_MOON_ROD);

        simpleItem(ModItem.PLUTONS_KEY);
        handheldItem(ModItem.PINK_SAPPHIRE_AXE);
        handheldItem(ModItem.PINK_SAPPHIRE_PICKAXE);
        handheldItem(ModItem.PINK_SAPPHIRE_SHOVEL);
        handheldItem(ModItem.PINK_SAPPHIRE_HOE);
        handheldItem(ModItem.PINK_SAPPHIRE_SWORD);

        trimmedArmorItem(ModItem.PINK_SAPPHIRE_HELMET);
        trimmedArmorItem(ModItem.PINK_SAPPHIRE_CHESTPLATE);
        trimmedArmorItem(ModItem.PINK_SAPPHIRE_LEGGINGS);
        trimmedArmorItem(ModItem.PINK_SAPPHIRE_BOOTS);

        simpleItem(ModItem.RUBY);
        simpleItem(ModItem.RAW_RUBY);
        handheldItem(ModItem.RUBY_AXE);
        handheldItem(ModItem.RUBY_PICKAXE);
        handheldItem(ModItem.RUBY_SHOVEL);
        handheldItem(ModItem.RUBY_HOE);
        handheldItem(ModItem.RUBY_SWORD);

        simpleItem(ModItem.SAILORMOON_OST_MUSIC_DISC);
        simpleItem(ModItem.FIREFLIES_MUSIC_DISC);
        simpleItem(ModItem.LOFI_MUSIC_DISC);
        simpleItem(ModItem.TAVERN_MUSIC_DISC);
        simpleItem(ModItem.THE_LANTERN_FAIR_MUSIC_DISC);

        simpleItem(ModItem.BUTTERFLY_NET);

        trimmedArmorItem(ModItem.RUBY_HELMET);
        trimmedArmorItem(ModItem.RUBY_CHESTPLATE);
        trimmedArmorItem(ModItem.RUBY_LEGGINGS);
        trimmedArmorItem(ModItem.RUBY_BOOTS);

        saplingItem(ModBlock.PISTACHIO_SAPLING);
        saplingItem(ModBlock.LEMON_SAPLING);
        saplingItem(ModBlock.BOBA_SAPLING);

        simpleBlockItemBlockTexture();

        String templatePath = "item/template_spawn_egg";

        withExistingParent(ModItem.STRAWBERRY_COW_EGG.getId().getPath(),
                mcLoc(templatePath));
        withExistingParent(ModItem.CELESTIAL_RABBIT_EGG.getId().getPath(),
                mcLoc(templatePath));
        withExistingParent(ModItem.FAIRY_EGG.getId().getPath(),
                mcLoc(templatePath));

        simpleItem(ModItem.FAIRY_DUST);
        simpleItem(ModItem.GIFT_BOX);
        simpleItem(ModItem.LOVE_LETTER);
        simpleItem(ModItem.RUBY_TEMPLATE_UPGRADE);
    }


    private void saplingItem(DeferredBlock<Block> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace(ITEM_GENERATED)).texture(LAYER0,
                ResourceLocation.fromNamespaceAndPath(MOD_ID, "block/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(DeferredItem<Item> itemRegistryObject) {

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {

                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = ITEM_FOLDER + armorItem.toString().split(":")[1];
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, trimPath);
                ResourceLocation trimNameResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile(ITEM_GENERATED))
                        .texture(LAYER0, armorItemResLoc)
                        .texture(LAYER1, trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc(ITEM_GENERATED))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture(LAYER0,
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        ITEM_FOLDER + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private void simpleBlockItemBlockTexture() {
        withExistingParent(ModBlock.STRAWBERRY_CROP_FLOWER.getId().getPath(),
                ResourceLocation.withDefaultNamespace(ITEM_GENERATED)).texture(LAYER0,
                ResourceLocation.fromNamespaceAndPath(MOD_ID, "block/" + ModBlock.STRAWBERRY_CROP_FLOWER.getId().getPath()));
    }

    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
}
