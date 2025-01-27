package com.example.prettyguardian.block;

import com.example.prettyguardian.item.ModItem;
import com.max.prettyguardian.PrettyGuardian;
import com.example.prettyguardian.block.custom.PicnicBasketBlock;
import com.example.prettyguardian.block.custom.SeaShell;
import com.example.prettyguardian.block.custom.SilverCrystalBlock;
import com.example.prettyguardian.block.custom.crop.CropLeavesBlock;
import com.example.prettyguardian.block.custom.crop.MintCropBlock;
import com.example.prettyguardian.block.custom.crop.StrawberryCropBlock;
import com.example.prettyguardian.block.custom.crop.VanillaCropBlock;
import com.example.prettyguardian.block.custom.food.BaseCake;
import com.example.prettyguardian.block.custom.food.BasePie;
import com.example.prettyguardian.block.custom.food.BaseThreeCake;
import com.example.prettyguardian.block.custom.furniture.*;
import com.example.prettyguardian.block.custom.plush.CowPlushBlock;
import com.example.prettyguardian.block.custom.plush.PlushiesBlock;
import com.example.prettyguardian.block.custom.plush.RandomPlushBoxBlock;
import com.example.prettyguardian.block.custom.table.GemPolishingStationBlock;
import com.example.prettyguardian.block.custom.table.MoonAltarBlock;
import com.max.prettyguardian.worldgen.tree.TreeGrowers;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.max.prettyguardian.item.PrettyGuardianItem.ITEMS;

public class ModBlock {
    private ModBlock() {
        throw new IllegalStateException("Register class");
    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PrettyGuardian.MOD_ID);



    public static final DeferredBlock<Block> CHOCOLATE_CAKE = registryBlock("chocolate_cake", () -> new BaseCake(cakeProperties()));
    public static final DeferredBlock<Block> CREAM_CAKE = registryBlock("cream_cake", () -> new BaseCake(cakeProperties()));
    public static final DeferredBlock<Block> RHUM_CAKE = registryBlock("rhum_cake", () -> new BaseCake(cakeProperties()));
    public static final DeferredBlock<Block> STRAWBERRY_CAKE = registryBlock("strawberry_cake", () -> new BaseCake(cakeProperties()));
    public static final DeferredBlock<Block> BERRY_STRAWBERRY_CAKE = registryBlock("berry_strawberry_cake", () -> new BaseCake(cakeProperties()));
    public static final DeferredBlock<Block> VELVET_CAKE = registryBlock("velvet_cake", () -> new BaseCake(cakeProperties()));
    public static final DeferredBlock<Block> CREAM_STRAWBERRY_CAKE = registryBlock("cream_strawberry_cake", () -> new BaseCake(cakeProperties()));
    public static final DeferredBlock<Block> STRAWBERRY_CHOCO_CAKE = registryBlock("strawberry_choco_cake", () -> new BaseCake(cakeProperties()));
    public static final DeferredBlock<Block> THREE_STRAWBERRY_CAKE = registryBlock("three_strawberry_cake", () -> new BaseThreeCake(cakeProperties()));
    public static final DeferredBlock<Block> THREE_STRAWBERRY_CHOCO_CAKE = registryBlock("three_strawberry_choco_cake", () -> new BaseThreeCake(cakeProperties()));
    public static final DeferredBlock<Block> THREE_CHOCO_CAKE = registryBlock("three_choco_cake", () -> new BaseThreeCake(cakeProperties()));
    public static final DeferredBlock<Block> THREE_VELVET_CAKE = registryBlock("three_velvet_cake", () -> new BaseThreeCake(cakeProperties()));
    public static final DeferredBlock<Block> APPLE_PIE = registryBlock("apple_pie", () -> new BasePie(cakeProperties()));
    public static final DeferredBlock<Block> CHOCOLATE_PIE = registryBlock("chocolate_pie", () -> new BasePie(cakeProperties()));
    public static final DeferredBlock<Block> MAGIC_PIE = registryBlock("magic_pie", () -> new BasePie(cakeProperties(), true));
    public static final DeferredBlock<Block> LEMON_PIE = registryBlock("lemon_pie", () -> new BasePie(cakeProperties()));
    public static final DeferredBlock<Block> STRAWBERRY_PIE = registryBlock("strawberry_pie", () -> new BasePie(cakeProperties()));

    public static final DeferredBlock<Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop", () -> new StrawberryCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> MINT_CROP = BLOCKS.register("mint_crop", () -> new MintCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> VANILLA_CROP = BLOCKS.register("vanilla_crop", () -> new VanillaCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> PINK_SAPPHIRE_BLOCK = registryBlock("pink_sapphire_block", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final DeferredBlock<Block> PINK_SAPPHIRE_ORE = registryBlock("pink_sapphire_ore", () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(2.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_PINK_SAPPHIRE_ORE = registryBlock("deepslate_pink_sapphire_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final DeferredBlock<Block> RUBY_BLOCK = registryBlock("ruby_block", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final DeferredBlock<Block> RUBY_ORE = registryBlock("ruby_ore", () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(2.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = registryBlock("deepslate_ruby_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final DeferredBlock<Block> PICNIC_BASKET = registryBlock("picnic_basket", () -> new PicnicBasketBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F).noOcclusion()));
    public static final DeferredBlock<Block> CHOCOLATE_BLOCK = registryBlock("chocolate_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).sound(SoundType.STONE).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> MARSHMELLO_BLOCK = registryBlock("marshmello_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> ROASTED_MARSHMELLO_BLOCK = registryBlock("roasted_marshmello_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> PISTACHIO_LEAVES_CROP = registryBlock("pistachio_leaves_crop", () -> new CropLeavesBlock(ModItem.PISTACHIO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> PISTACHIO_SAPLING = registryBlock("pistachio_sapling", () -> new SaplingBlock(TreeGrowers.PISTACHIO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LEMON_LEAVES_CROP = registryBlock("lemon_leaves_crop", () -> new CropLeavesBlock(ModItem.LEMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> LEMON_SAPLING = registryBlock("lemon_sapling", () -> new SaplingBlock(TreeGrowers.LEMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> BOBA_LEAVES_CROP = registryBlock("boba_leaves_crop", () -> new CropLeavesBlock(ModItem.RAW_BOBA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> BOBA_SAPLING = registryBlock("boba_sapling", () -> new SaplingBlock(TreeGrowers.BOBA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> STRAWBERRY_CROP_FLOWER = registryBlock("strawberry_crop_flower", () -> new FlowerBlock(MobEffects.LUCK, 5,  BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission().noLootTable()));
    public static final DeferredBlock<Block> MYMELODY_PLUSH = registryBlock("mymelody_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> KUROMI_PLUSH = registryBlock("kuromi_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CAVALIER_PLUSH = registryBlock("cavalier_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> TEDDYBEAR_PLUSH = registryBlock("teddybear_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> RABBIT_PLUSH = registryBlock("rabbit_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> COW_PLUSH = registryBlock("cow_plush", () -> new CowPlushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CINNAMOROLL_PLUSH = registryBlock("cinnamoroll_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BABYYODA_PLUSH = registryBlock("babyyoda_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CAPPUCCINO_PLUSH = registryBlock("cappuccino_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CHIFFON_PLUSH = registryBlock("chiffon_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> EXPRESSO_PLUSH = registryBlock("expresso_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> MOCHA_PLUSH = registryBlock("mocha_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PRINCESS_PORON_PLUSH = registryBlock("princess_poron_plush", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PLUSH_BEAR_HUGE = registryBlock("plush_bear_huge", () -> new PlushiesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> RANDOM_PLUSH_BOX = registryBlock("random_plush_box", () -> new RandomPlushBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).noLootTable()));

    public static final DeferredBlock<Block> SHOJI_BLOSSOM = registryBlock("shoji_blossom", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_BLOSSOM_BOTTOM = registryBlock("shoji_blossom_bottom", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_BLOSSOM_SMALL = registryBlock("shoji_blossom_small", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_BLOSSOM_SMALL_BOTTOM = registryBlock("shoji_blossom_small_bottom", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_CHERRY = registryBlock("shoji_cherry", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_CHERRY_BOTTOM = registryBlock("shoji_cherry_bottom", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_CHERRY_SMALL = registryBlock("shoji_cherry_small", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_CHERRY_SMALL_BOTTOM = registryBlock("shoji_cherry_small_bottom", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_BIRCH = registryBlock("shoji_birch", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_BIRCH_BOTTOM = registryBlock("shoji_birch_bottom", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_BIRCH_SMALL = registryBlock("shoji_birch_small", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_TRAPDOOR)));
    public static final DeferredBlock<Block> SHOJI_BIRCH_SMALL_BOTTOM = registryBlock("shoji_birch_small_bottom", () -> new ShojiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_TRAPDOOR)));

    public static final DeferredBlock<Block> LANTERN_JAPANESE = registryBlock("lantern_japanese", () -> new JapLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> LANTERN_JAPANESE_SAKURA = registryBlock("lantern_japanese_sakura", () -> new JapLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> LANTERN_JAPANESE_FESTIVAL = registryBlock("lantern_japanese_festival", () -> new JapLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> LANTERN_JAPANESE_BIG = registryBlock("lantern_japanese_big", () -> new JapDoubleLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> LANTERN_JAPANESE_SAKURA_BIG = registryBlock("lantern_japanese_sakura_big", () -> new JapDoubleLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> LANTERN_JAPANESE_FESTIVAL_BIG = registryBlock("lantern_japanese_festival_big", () -> new JapDoubleLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> LANTERN_HUGE_JAPANESE = registryBlock("lantern_huge_japanese", () -> new JapHugeLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> LANTERN_SAKURA_HUGE_JAPANESE = registryBlock("lantern_sakura_huge_japanese", () -> new JapHugeLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));
    public static final DeferredBlock<Block> LANTERN_FESTIVAL_HUGE_JAPANESE = registryBlock("lantern_festival_huge_japanese", () -> new JapHugeLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOL).strength(0.2F, 0.2F)));

    public static final DeferredBlock<Block> LAMP_JAPANESE_OAK = registryBlock("lamp_japanese_oak", () -> new JapLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOD).strength(0.6F, 0.6F)));
    public static final DeferredBlock<Block> LAMP_JAPANESE_SPRUCE = registryBlock("lamp_japanese_spruce", () -> new JapLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOD).strength(0.6F, 0.6F)));
    public static final DeferredBlock<Block> LAMP_JAPANESE_MANGROVE = registryBlock("lamp_japanese_mangrove", () -> new JapLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOD).strength(0.6F, 0.6F)));
    public static final DeferredBlock<Block> LAMP_JAPANESE_CHERRY = registryBlock("lamp_japanese_cherry", () -> new JapLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOD).strength(0.6F, 0.6F)));
    public static final DeferredBlock<Block> LAMP_JAPANESE_BIRCH = registryBlock("lamp_japanese_birch", () -> new JapLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOD).strength(0.6F, 0.6F)));
    public static final DeferredBlock<Block> LAMP_JAPANESE_JUNGLE = registryBlock("lamp_japanese_jungle", () -> new JapLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOD).strength(0.6F, 0.6F)));
    public static final DeferredBlock<Block> LAMP_JAPANESE_ACACIA = registryBlock("lamp_japanese_acacia", () -> new JapLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOD).strength(0.6F, 0.6F)));
    public static final DeferredBlock<Block> LAMP_JAPANESE_DARK_OAK = registryBlock("lamp_japanese_dark_oak", () -> new JapLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.WOOD).strength(0.6F, 0.6F)));

    public static final DeferredBlock<Block> DOOR_SHOJI_BLOSSOM = registryBlock("door_shoji_blossom", () -> new JapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), BlockSetType.CHERRY));
    public static final DeferredBlock<Block> DOOR_SHOJI_BLOSSOM_SMALL = registryBlock("door_shoji_blossom_small", () -> new JapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), BlockSetType.CHERRY));
    public static final DeferredBlock<Block> DOOR_SHOJI_BIRCH = registryBlock("door_shoji_birch", () -> new JapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), BlockSetType.CHERRY));
    public static final DeferredBlock<Block> DOOR_SHOJI_BIRCH_SMALL = registryBlock("door_shoji_birch_small", () -> new JapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), BlockSetType.CHERRY));
    public static final DeferredBlock<Block> DOOR_SHOJI_CHERRY = registryBlock("door_shoji_cherry", () -> new JapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), BlockSetType.CHERRY));
    public static final DeferredBlock<Block> DOOR_SHOJI_CHERRY_SMALL = registryBlock("door_shoji_cherry_small", () -> new JapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), BlockSetType.CHERRY));

    public static final DeferredBlock<Block> TABLE_JAPANESE_OAK = registryBlock("table_japanese_oak", () -> new JapTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> TABLE_JAPANESE_SPRUCE = registryBlock("table_japanese_spruce", () -> new JapTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> TABLE_JAPANESE_BIRCH = registryBlock("table_japanese_birch", () -> new JapTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> TABLE_JAPANESE_CHERRY_PLANK = registryBlock("table_japanese_cherry_plank", () -> new JapTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> TABLE_JAPANESE_CHERRY_LOG = registryBlock("table_japanese_cherry_log", () -> new JapTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));

    public static final DeferredBlock<Block> SCREEN_JAPANESE_CHERRY_PLANK = registryBlock("screen_japanese_cherry_plank", () -> new JapScreenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCREEN_JAPANESE_CHERRY_LOG = registryBlock("screen_japanese_cherry_log", () -> new JapScreenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCREEN_JAPANESE_BIRCH = registryBlock("screen_japanese_birch", () -> new JapScreenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));

    public static final DeferredBlock<Block> SEA_SHELL = registryBlock("sea_shell", () -> new SeaShell(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));

    public static final DeferredBlock<Block> GEM_POLISHING_STATION = registryBlock("gem_polishing_station", () -> new GemPolishingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOON_ALTAR = registryBlock("moon_altar", () -> new MoonAltarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).noOcclusion().requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CHAIR_JAPANESE_OAK = registryBlock("chair_japanese_oak", () -> new JapChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> CHAIR_JAPANESE_SPRUCE = registryBlock("chair_japanese_spruce", () -> new JapChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> CHAIR_JAPANESE_BIRCH = registryBlock("chair_japanese_birch", () -> new JapChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> CHAIR_JAPANESE_CHERRY_PLANK = registryBlock("chair_japanese_cherry_plank", () -> new JapChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> CHAIR_JAPANESE_CHERRY_LOG = registryBlock("chair_japanese_cherry_log", () -> new JapChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));

    public static final DeferredBlock<Block> SCROLL_JAPANESE_AXOLOTL = registryBlock("scroll_japanese_axolotl", () -> new JapScrollBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCROLL_JAPANESE_BEE = registryBlock("scroll_japanese_bee", () -> new JapScrollBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCROLL_JAPANESE_CINNAMON_ROLL = registryBlock("scroll_japanese_cinnamon_roll", () -> new JapScrollBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCROLL_JAPANESE_MUSHROOM = registryBlock("scroll_japanese_mushroom", () -> new JapScrollBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCROLL_JAPANESE_DAY = registryBlock("scroll_japanese_day", () -> new JapScrollBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCROLL_JAPANESE_NIGHT = registryBlock("scroll_japanese_night", () -> new JapScrollBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCROLL_JAPANESE_DAY_2 = registryBlock("scroll_japanese_day2", () -> new JapScrollBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> SCROLL_JAPANESE_SUNFLOWER = registryBlock("scroll_japanese_sunflower", () -> new JapScrollBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.5F, 2.5F)));

    public static final DeferredBlock<Block> BONZAI_CHERRY = registryBlock("cherry_bonzai", () -> new JapBonzaiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.5F, 2.5F)));
    public static final DeferredBlock<Block> LUCKY_NEKO = registryBlock("lucky_neko", () -> new LuckyNekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion().requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SILVER_CRYSTAL = registryBlock("silver_crystal", () -> new SilverCrystalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).lightLevel(blockState -> 8)));

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static <T extends Block> DeferredBlock<Block> registryBlock(String name, Supplier<T> block) {
        DeferredBlock<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static BlockBehaviour.Properties cakeProperties() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).noLootTable();
    }
}
