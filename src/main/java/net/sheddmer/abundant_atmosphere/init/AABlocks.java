package net.sheddmer.abundant_atmosphere.init;

import com.google.common.collect.Sets;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.block.*;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class AABlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AbundantAtmosphere.MODID);
    public static LinkedHashSet<DeferredHolder<Item, BlockItem>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    // General blocks
    public static final DeferredBlock<Block> BLACKSALT_TILES = registerBlock("blacksalt_tiles", () -> new Block(BlockBehaviour.Properties.of().strength(1.4f, 1.4f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public static final DeferredBlock<StairBlock> BLACKSALT_TILE_STAIRS = registerBlock("blacksalt_tile_stairs", () ->  new StairBlock(BLACKSALT_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BLACKSALT_TILES.get())));
    public static final DeferredBlock<SlabBlock> BLACKSALT_TILE_SLAB = registerBlock("blacksalt_tile_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(BLACKSALT_TILES.get())));
    // Calcite blocks
    public static final DeferredBlock<Block> POLISHED_CALCITE = registerBlock("polished_calcite", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).requiresCorrectToolForDrops().strength(0.75f, 1.0f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));
    public static final DeferredBlock<StairBlock> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs", () ->  new StairBlock(POLISHED_CALCITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get())));
    public static final DeferredBlock<SlabBlock> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get())));
    public static final DeferredBlock<WallBlock> POLISHED_CALCITE_WALL = registerBlock("polished_calcite_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get()).forceSolidOn()));
    public static final DeferredBlock<Block> CALCITE_TILES = registerBlock("calcite_tiles", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get())));
    public static final DeferredBlock<StairBlock> CALCITE_TILE_STAIRS = registerBlock("calcite_tile_stairs", () ->  new StairBlock(CALCITE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CALCITE_TILES.get())));
    public static final DeferredBlock<SlabBlock> CALCITE_TILE_SLAB = registerBlock("calcite_tile_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(CALCITE_TILES.get())));
    public static final DeferredBlock<WallBlock> CALCITE_TILE_WALL = registerBlock("calcite_tile_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(CALCITE_TILES.get()).forceSolidOn()));
    // Dripstone blocks
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE = registerBlock("polished_dripstone", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops().strength(1.5f, 1.5f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<StairBlock> POLISHED_DRIPSTONE_STAIRS = registerBlock("polished_dripstone_stairs", () ->  new StairBlock(POLISHED_DRIPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<SlabBlock> POLISHED_DRIPSTONE_SLAB = registerBlock("polished_dripstone_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<WallBlock> POLISHED_DRIPSTONE_WALL = registerBlock("polished_dripstone_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get()).forceSolidOn()));
    public static final DeferredBlock<Block> DRIPSTONE_TILES = registerBlock("dripstone_tiles", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<StairBlock> DRIPSTONE_TILE_STAIRS = registerBlock("dripstone_tile_stairs", () ->  new StairBlock(DRIPSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_TILES.get())));
    public static final DeferredBlock<SlabBlock> DRIPSTONE_TILE_SLAB = registerBlock("dripstone_tile_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_TILES.get())));
    public static final DeferredBlock<WallBlock> DRIPSTONE_TILE_WALL = registerBlock("dripstone_tile_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_TILES.get()).forceSolidOn()));
    public static final DeferredBlock<Block> DRIPSTONE_SHINGLES = registerBlock("dripstone_shingles", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<StairBlock> DRIPSTONE_SHINGLE_STAIRS = registerBlock("dripstone_shingle_stairs", () ->  new StairBlock(DRIPSTONE_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_SHINGLES.get())));
    public static final DeferredBlock<SlabBlock> DRIPSTONE_SHINGLE_SLAB = registerBlock("dripstone_shingle_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_SHINGLES.get())));
    public static final DeferredBlock<WallBlock> DRIPSTONE_SHINGLE_WALL = registerBlock("dripstone_shingle_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_SHINGLES.get()).forceSolidOn()));
    // Shuffled Brick blocks
    public static final DeferredBlock<Block> SHUFFLED_BRICKS = registerBlock("shuffled_bricks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).requiresCorrectToolForDrops().strength(2.5f, 8.0f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<StairBlock> SHUFFLED_BRICK_STAIRS = registerBlock("shuffled_brick_stairs", () ->  new StairBlock(SHUFFLED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SHUFFLED_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> SHUFFLED_BRICK_SLAB = registerBlock("shuffled_brick_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SHUFFLED_BRICKS.get())));
    public static final DeferredBlock<WallBlock> SHUFFLED_BRICK_WALL = registerBlock("shuffled_brick_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(SHUFFLED_BRICKS.get()).forceSolidOn()));
    public static final DeferredBlock<Block> MOSSY_SHUFFLED_BRICKS = registerBlock("mossy_shuffled_bricks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).requiresCorrectToolForDrops().strength(2.5f, 8.0f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<StairBlock> MOSSY_SHUFFLED_BRICK_STAIRS = registerBlock("mossy_shuffled_brick_stairs", () ->  new StairBlock(MOSSY_SHUFFLED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MOSSY_SHUFFLED_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> MOSSY_SHUFFLED_BRICK_SLAB = registerBlock("mossy_shuffled_brick_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_SHUFFLED_BRICKS.get())));
    public static final DeferredBlock<WallBlock> MOSSY_SHUFFLED_BRICK_WALL = registerBlock("mossy_shuffled_brick_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_SHUFFLED_BRICKS.get()).forceSolidOn()));

    public static final DeferredBlock<WispCandleBlock> WISP_CANDLE = registerBlock("wisp_candle", () ->  new WispCandleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).strength(0.1f, 0.1f).lightLevel(state -> state.getValue(WispCandleBlock.LIT) ? 2 * state.getValue(WispCandleBlock.CANDLES) : 0).noOcclusion().sound(SoundType.CANDLE).pushReaction(PushReaction.DESTROY)));
    // Rusty Plating blocks
    public static final DeferredBlock<Block> RUSTY_PLATING = registerBlock("rusty_plating", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 8.0f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> CUT_RUSTY_PLATING = registerBlock("cut_rusty_plating", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 8.0f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<WallBlock> RUSTY_BARS = registerBlock("rusty_bars", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(RUSTY_PLATING.get()).forceSolidOn()));
    public static final DeferredBlock<StoneBrazierBlock> STONE_BRAZIER = registerBlock("stone_brazier", () -> new StoneBrazierBlock(1, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(4.0f, 8.0f).requiresCorrectToolForDrops().noOcclusion().ignitedByLava().lightLevel(state -> state.getValue(StoneBrazierBlock.LIT) ? 15 : 0).instrument(NoteBlockInstrument.BASS).sound(SoundType.POLISHED_DEEPSLATE)));
    public static final DeferredBlock<StoneBrazierBlock> SOUL_STONE_BRAZIER = registerBlock("soul_stone_brazier", () -> new StoneBrazierBlock(2, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(4.0f, 8.0f).requiresCorrectToolForDrops().noOcclusion().ignitedByLava().lightLevel(state -> state.getValue(StoneBrazierBlock.LIT) ? 10 : 0).instrument(NoteBlockInstrument.BASS).sound(SoundType.POLISHED_DEEPSLATE)));

    // Suspicious blocks
    public static final DeferredBlock<BrushableBlock> SUSPICIOUS_DIRT = registerBlock("suspicious_dirt", () -> new BrushableBlock(Blocks.DIRT, SoundEvents.BRUSH_GRAVEL, SoundEvents.BRUSH_GRAVEL_COMPLETED, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.25f, 0.25f).sound(SoundType.SUSPICIOUS_GRAVEL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<BrushableBlock> SUSPICIOUS_RED_SAND = registerBlock("suspicious_red_sand", () -> new BrushableBlock(Blocks.RED_SAND, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.25f, 0.25f).instrument(NoteBlockInstrument.SNARE).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY)));

    // Natural blocks
    public static final DeferredBlock<CaveCrudBlock> CAVE_CRUD = registerBlock("cave_crud", () ->  new CaveCrudBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(0.75f, 0.75f).sound(SoundType.ROOTED_DIRT)));
    public static final DeferredBlock<CaveSproutsBlock> CAVE_SPROUTS = registerBlock("cave_sprouts", () ->  new CaveSproutsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).instabreak().noCollission().noOcclusion().replaceable().offsetType(BlockBehaviour.OffsetType.XYZ).sound(SoundType.NETHER_SPROUTS).ignitedByLava()));
    public static final DeferredBlock<PuffballMushroomBlock> PUFFBALL_MUSHROOM = registerBlock("puffball_mushroom", () -> new PuffballMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instabreak().noOcclusion().randomTicks().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<LargePuffballMushroomBlock> LARGE_PUFFBALL_MUSHROOM = registerBlock("large_puffball_mushroom", () -> new LargePuffballMushroomBlock(BlockBehaviour.Properties.ofFullCopy(PUFFBALL_MUSHROOM.get())));
    public static final DeferredBlock<MossClumpBlock> MOSS_CLUMP = registerBlock("moss_clump", () -> new MossClumpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instabreak().noCollission().noOcclusion().replaceable().sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<RustMossBlock> RUST_MOSS_BLOCK = registerBlock("rust_moss_block", () -> new RustMossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).strength(0.1f, 0.1f).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<CarpetBlock> RUST_MOSS_CARPET = registerBlock("rust_moss_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).strength(0.1f, 0.1f).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<MossClumpBlock> RUST_MOSS_CLUMP = registerBlock("rust_moss_clump", () -> new MossClumpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instabreak().noCollission().noOcclusion().replaceable().sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<RotatedPillarBlock> CERULEAN_FROGLIGHT = registerBlock("cerulean_froglight", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(0.3f, 0.3f).lightLevel(value -> 15).sound(SoundType.FROGLIGHT)));
    public static final DeferredBlock<RotatedPillarBlock> CHROMATIC_FROGLIGHT = BLOCKS.register("chromatic_froglight", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.3f, 0.3f).lightLevel(value -> 15).sound(SoundType.FROGLIGHT)));
    public static final DeferredBlock<LeafPileBlock> LEAF_PILE = registerBlock("leaf_pile", () -> new LeafPileBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instabreak().noCollission().noOcclusion().replaceable().sound(SoundType.CHERRY_LEAVES).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<MushroomBlock> PORESHROOM = BLOCKS.register("poreshroom", () ->  new MushroomBlock(AAFeatures.HUGE_PORESHROOM_CHECKED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instabreak().noCollission().noOcclusion().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<WallFungusBlock> WALL_PORESHROOM = BLOCKS.register("wall_poreshroom", () ->  new WallFungusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instabreak().noCollission().noOcclusion().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_PORESHROOM = BLOCKS.register("potted_poreshroom", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.PORESHROOM, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM)));
    public static final DeferredBlock<HugeMushroomBlock> PORESHROOM_BLOCK = registerBlock("poreshroom_block", () ->  new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.2f, 0.2f).sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.FUNGUS).ignitedByLava()));
    public static final DeferredBlock<Block> CATSBANE = BLOCKS.register("catsbane", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instabreak().noCollission().noOcclusion().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<WallFungusBlock> WALL_CATSBANE = BLOCKS.register("wall_catsbane", () ->  new WallFungusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instabreak().noCollission().noOcclusion().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_CATSBANE = BLOCKS.register("potted_catsbane", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.CATSBANE, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM)));

    // Flowers
    public static final DeferredBlock<MidnightLilyBlock> MIDNIGHT_LILY = registerBlock("midnight_lily", () ->  new MidnightLilyBlock(MobEffects.BLINDNESS, 6.0F, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instabreak().noCollission().randomTicks().offsetType(BlockBehaviour.OffsetType.XZ).lightLevel(state -> state.getValue(MidnightLilyBlock.NIGHTLIGHT) ? 2 + state.getValue(MidnightLilyBlock.FLOWER_STACK) : 0).sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_MIDNIGHT_LILY = BLOCKS.register("potted_midnight_lily", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.MIDNIGHT_LILY, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));
    public static final DeferredBlock<BushFlowerBlock> SAFFRON_BUSHBUDS = registerBlock("saffron_bushbuds", () -> new BushFlowerBlock(MobEffects.DAMAGE_RESISTANCE, 2.0F ,BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SAFFRON_BUSHBUDS = BLOCKS.register("potted_saffron_bushbuds", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.SAFFRON_BUSHBUDS, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));
    public static final DeferredBlock<BushFlowerBlock> CHERRY_BUSHBUDS = registerBlock("cherry_bushbuds", () -> new BushFlowerBlock(MobEffects.HEALTH_BOOST, 7.0F ,BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_CHERRY_BUSHBUDS = BLOCKS.register("potted_cherry_bushbuds", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.CHERRY_BUSHBUDS, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));
    public static final DeferredBlock<BushFlowerBlock> UMBRA_BUSHBUDS = registerBlock("umbra_bushbuds", () -> new BushFlowerBlock(MobEffects.WITHER, 3.0F ,BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_UMBRA_BUSHBUDS = BLOCKS.register("potted_umbra_bushbuds", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.UMBRA_BUSHBUDS, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));

    // Mud blocks
    public static final DeferredBlock<Block> MOSSY_MUD_BRICKS = registerBlock("mossy_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<StairBlock> MOSSY_MUD_BRICK_STAIRS = registerBlock("mossy_mud_brick_stairs", () ->  new StairBlock(MOSSY_MUD_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MOSSY_MUD_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> MOSSY_MUD_BRICK_SLAB = registerBlock("mossy_mud_brick_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_MUD_BRICKS.get())));
    public static final DeferredBlock<WallBlock> MOSSY_MUD_BRICK_WALL = registerBlock("mossy_mud_brick_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_MUD_BRICKS.get()).forceSolidOn()));
    public static final DeferredBlock<Block> CHISELED_MUD_BRICKS = registerBlock("chiseled_mud_bricks", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<MudLampBlock> MUD_LAMP = BLOCKS.register("mud_lamp", () ->  new MudLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(0.5f, 1.0f).lightLevel(state -> state.getValue(MudLampBlock.LIT) ? 10 : 0).noOcclusion().sound(SoundType.PACKED_MUD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<WallMudLampBlock> WALL_MUD_LAMP = BLOCKS.register("wall_mud_lamp", () ->  new WallMudLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(0.5f, 1.0f).lightLevel(state -> state.getValue(MudLampBlock.LIT) ? 10 : 0).noOcclusion().sound(SoundType.PACKED_MUD).pushReaction(PushReaction.DESTROY)));

    // Mossy Blocks
    public static final DeferredBlock<WallBlock> STONE_WALL = registerBlock("stone_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).forceSolidOn()));
    public static final DeferredBlock<Block> MOSSY_STONE = registerBlock("mossy_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<StairBlock> MOSSY_STONE_STAIRS = registerBlock("mossy_stone_stairs", () ->  new StairBlock(MOSSY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MOSSY_STONE.get())));
    public static final DeferredBlock<SlabBlock> MOSSY_STONE_SLAB = registerBlock("mossy_stone_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_STONE.get())));
    public static final DeferredBlock<WallBlock> MOSSY_STONE_WALL = registerBlock("mossy_stone_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_STONE.get()).forceSolidOn()));
    public static final DeferredBlock<MossyBasaltBlock> MOSSY_BASALT = registerBlock("mossy_basalt", () -> new MossyBasaltBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<RotatedPillarBlock> MOSSY_DEEPSLATE = registerBlock("mossy_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> MOSSY_COBBLED_DEEPSLATE = registerBlock("mossy_cobbled_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE)));
    public static final DeferredBlock<StairBlock> MOSSY_COBBLED_DEEPSLATE_STAIRS = registerBlock("mossy_cobbled_deepslate_stairs", () ->  new StairBlock(MOSSY_COBBLED_DEEPSLATE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLED_DEEPSLATE.get())));
    public static final DeferredBlock<SlabBlock> MOSSY_COBBLED_DEEPSLATE_SLAB = registerBlock("mossy_cobbled_deepslate_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLED_DEEPSLATE.get())));
    public static final DeferredBlock<WallBlock> MOSSY_COBBLED_DEEPSLATE_WALL = registerBlock("mossy_cobbled_deepslate_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLED_DEEPSLATE.get()).forceSolidOn()));
    public static final DeferredBlock<Block> MOSSY_POLISHED_DEEPSLATE = registerBlock("mossy_polished_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE)));
    public static final DeferredBlock<StairBlock> MOSSY_POLISHED_DEEPSLATE_STAIRS = registerBlock("mossy_polished_deepslate_stairs", () ->  new StairBlock(MOSSY_COBBLED_DEEPSLATE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLED_DEEPSLATE.get())));
    public static final DeferredBlock<SlabBlock> MOSSY_POLISHED_DEEPSLATE_SLAB = registerBlock("mossy_polished_deepslate_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLED_DEEPSLATE.get())));
    public static final DeferredBlock<WallBlock> MOSSY_POLISHED_DEEPSLATE_WALL = registerBlock("mossy_polished_deepslate_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLED_DEEPSLATE.get()).forceSolidOn()));
    public static final DeferredBlock<Block> MOSSY_DEEPSLATE_BRICKS = registerBlock("mossy_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)));
    public static final DeferredBlock<StairBlock> MOSSY_DEEPSLATE_BRICK_STAIRS = registerBlock("mossy_deepslate_brick_stairs", () ->  new StairBlock(MOSSY_DEEPSLATE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MOSSY_DEEPSLATE_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> MOSSY_DEEPSLATE_BRICK_SLAB = registerBlock("mossy_deepslate_brick_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_DEEPSLATE_BRICKS.get())));
    public static final DeferredBlock<WallBlock> MOSSY_DEEPSLATE_BRICK_WALL = registerBlock("mossy_deepslate_brick_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_DEEPSLATE_BRICKS.get()).forceSolidOn()));
    public static final DeferredBlock<Block> MOSSY_DEEPSLATE_TILES = registerBlock("mossy_deepslate_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_TILES)));
    public static final DeferredBlock<StairBlock> MOSSY_DEEPSLATE_TILE_STAIRS = registerBlock("mossy_deepslate_tile_stairs", () ->  new StairBlock(MOSSY_DEEPSLATE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(MOSSY_DEEPSLATE_TILES.get())));
    public static final DeferredBlock<SlabBlock> MOSSY_DEEPSLATE_TILE_SLAB = registerBlock("mossy_deepslate_tile_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_DEEPSLATE_TILES.get())));
    public static final DeferredBlock<WallBlock> MOSSY_DEEPSLATE_TILE_WALL = registerBlock("mossy_deepslate_tile_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(MOSSY_DEEPSLATE_TILES.get()).forceSolidOn()));

    // Stone Chests
    public static final DeferredBlock<StoneChestBlock> STONE_CHEST = BLOCKS.register("stone_chest", () -> new StoneChestBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(4.0f, 8.0f).requiresCorrectToolForDrops().sound(SoundType.POLISHED_DEEPSLATE)));

    // Stone Doors
    public static final DeferredBlock<DoorBlock> STONE_DOOR = registerBlock("stone_door", () -> new DoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TrapDoorBlock> STONE_TRAPDOOR = registerBlock("stone_trapdoor", () -> new TrapDoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<DoorBlock> DEEPSLATE_DOOR = registerBlock("deepslate_door", () -> new DoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> DEEPSLATE_TRAPDOOR = registerBlock("deepslate_trapdoor", () -> new TrapDoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).noOcclusion()));
    public static final DeferredBlock<DoorBlock> MUD_DOOR = registerBlock("mud_door", () -> new DoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<TrapDoorBlock> MUD_TRAPDOOR = registerBlock("mud_trapdoor", () -> new TrapDoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<DoorBlock> BLACKSTONE_DOOR = registerBlock("blackstone_door", () -> new DoorBlock(BlockSetType.POLISHED_BLACKSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE)));
    public static final DeferredBlock<TrapDoorBlock> BLACKSTONE_TRAPDOOR = registerBlock("blackstone_trapdoor", () -> new TrapDoorBlock(BlockSetType.POLISHED_BLACKSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE)));
    public static final DeferredBlock<DoorBlock> NETHER_BRICK_DOOR = registerBlock("nether_brick_door", () -> new DoorBlock(BlockSetType.POLISHED_BLACKSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<TrapDoorBlock> NETHER_BRICK_TRAPDOOR = registerBlock("nether_brick_trapdoor", () -> new TrapDoorBlock(BlockSetType.POLISHED_BLACKSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));

    // Ashroot Woodset
    public static final DeferredBlock<LogBlock> ASHROOT_LOG = registerBlock("ashroot_log", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<LogBlock> ASHROOT_WOOD = registerBlock("ashroot_wood", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<LogBlock> STRIPPED_ASHROOT_LOG = registerBlock("stripped_ashroot_log", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<LogBlock> STRIPPED_ASHROOT_WOOD = registerBlock("stripped_ashroot_wood", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASHROOT_PLANKS = registerBlock("ashroot_planks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<StairBlock> ASHROOT_STAIRS = registerBlock("ashroot_stairs", () ->  new StairBlock(ASHROOT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> ASHROOT_SLAB = registerBlock("ashroot_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get())));
    public static final DeferredBlock<FenceBlock> ASHROOT_FENCE = registerBlock("ashroot_fence", () ->  new FenceBlock(BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> ASHROOT_FENCE_GATE = registerBlock("ashroot_fence_gate", () ->  new FenceGateBlock(AAWoodTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get()).forceSolidOn()));
    public static final DeferredBlock<DoorBlock> ASHROOT_DOOR = registerBlock("ashroot_door", () ->  new DoorBlock(AABlockSetTypes.ASHROOT, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(3.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<TrapDoorBlock> ASHROOT_TRAPDOOR = registerBlock("ashroot_trapdoor", () ->  new TrapDoorBlock(AABlockSetTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(ASHROOT_DOOR.get()).isValidSpawn(Blocks::never)));
    public static final DeferredBlock<PressurePlateBlock> ASHROOT_PRESSURE_PLATE = registerBlock("ashroot_pressure_plate", () ->  new PressurePlateBlock(AABlockSetTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get()).strength(0.5f, 0.5f).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<ButtonBlock> ASHROOT_BUTTON = registerBlock("ashroot_button", () ->  new ButtonBlock(AABlockSetTypes.ASHROOT, 30, BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get()).strength(0.5f, 0.5f).noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<StandingSignBlock> ASHROOT_SIGN = BLOCKS.register("ashroot_sign", () -> new StandingSignBlock(AAWoodTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final DeferredBlock<WallSignBlock> ASHROOT_WALL_SIGN = BLOCKS.register("ashroot_wall_sign", () -> new WallSignBlock(AAWoodTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
    public static final DeferredBlock<CeilingHangingSignBlock> ASHROOT_HANGING_SIGN = BLOCKS.register("ashroot_hanging_sign", () -> new CeilingHangingSignBlock(AAWoodTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
    public static final DeferredBlock<WallHangingSignBlock> ASHROOT_WALL_HANGING_SIGN = BLOCKS.register("ashroot_wall_hanging_sign", () -> new WallHangingSignBlock(AAWoodTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final DeferredBlock<LightlessSaplingBlock> ASHROOT_SAPLING = registerBlock("ashroot_sapling", () ->  new LightlessSaplingBlock(AATreeGrower.ASHROOT, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instabreak().randomTicks().noCollission().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_ASHROOT_SAPLING = BLOCKS.register("potted_ashroot_sapling", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.ASHROOT_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
    public static final DeferredBlock<LeavesBlock> ASHROOT_LEAVES = registerBlock("ashroot_leaves", () ->  new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.2f, 0.2f).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES).pushReaction(PushReaction.DESTROY).ignitedByLava()));

    // Gourdrot Woodset
    public static final DeferredBlock<LogBlock> GOURDROT_LOG = registerBlock("gourdrot_log", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<LogBlock> GOURDROT_WOOD = registerBlock("gourdrot_wood", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<LogBlock> STRIPPED_GOURDROT_LOG = registerBlock("stripped_gourdrot_log", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<LogBlock> STRIPPED_GOURDROT_WOOD = registerBlock("stripped_gourdrot_wood", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> GOURDROT_PLANKS = registerBlock("gourdrot_planks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<StairBlock> GOURDROT_STAIRS = registerBlock("gourdrot_stairs", () ->  new StairBlock(GOURDROT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> GOURDROT_SLAB = registerBlock("gourdrot_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get())));
    public static final DeferredBlock<FenceBlock> GOURDROT_FENCE = registerBlock("gourdrot_fence", () ->  new FenceBlock(BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> GOURDROT_FENCE_GATE = registerBlock("gourdrot_fence_gate", () ->  new FenceGateBlock(AAWoodTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get()).forceSolidOn()));
    public static final DeferredBlock<DoorBlock> GOURDROT_DOOR = registerBlock("gourdrot_door", () ->  new DoorBlock(AABlockSetTypes.GOURDROT, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(3.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<TrapDoorBlock> GOURDROT_TRAPDOOR = registerBlock("gourdrot_trapdoor", () ->  new TrapDoorBlock(AABlockSetTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(GOURDROT_DOOR.get()).isValidSpawn(Blocks::never)));
    public static final DeferredBlock<PressurePlateBlock> GOURDROT_PRESSURE_PLATE = registerBlock("gourdrot_pressure_plate", () ->  new PressurePlateBlock(AABlockSetTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get()).strength(0.5f, 0.5f).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<ButtonBlock> GOURDROT_BUTTON = registerBlock("gourdrot_button", () ->  new ButtonBlock(AABlockSetTypes.GOURDROT, 30, BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get()).strength(0.5f, 0.5f).noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<StandingSignBlock> GOURDROT_SIGN = BLOCKS.register("gourdrot_sign", () -> new StandingSignBlock(AAWoodTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final DeferredBlock<WallSignBlock> GOURDROT_WALL_SIGN = BLOCKS.register("gourdrot_wall_sign", () -> new WallSignBlock(AAWoodTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
    public static final DeferredBlock<CeilingHangingSignBlock> GOURDROT_HANGING_SIGN = BLOCKS.register("gourdrot_hanging_sign", () -> new CeilingHangingSignBlock(AAWoodTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
    public static final DeferredBlock<WallHangingSignBlock> GOURDROT_WALL_HANGING_SIGN = BLOCKS.register("gourdrot_wall_hanging_sign", () -> new WallHangingSignBlock(AAWoodTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final DeferredBlock<GourdnutBlock> GOURDNUT = registerBlock("gourdnut", () -> new GourdnutBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.1f, 0.0f).noOcclusion().instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.CHERRY_WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_GOURDNUT = BLOCKS.register("potted_gourdnut", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.GOURDNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_AZALEA)));
    public static final DeferredBlock<LeavesBlock> GOURDROT_LEAVES = registerBlock("gourdrot_leaves", () ->  new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).strength(0.2f, 0.2f).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES).pushReaction(PushReaction.DESTROY).ignitedByLava()));

    // Red Bamboo Woodset
    public static final DeferredBlock<LogBlock> RED_BAMBOO_BLOCK = registerBlock("red_bamboo_block", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(AASounds.RED_BAMBOO_WOOD).ignitedByLava()));
    public static final DeferredBlock<LogBlock> STRIPPED_RED_BAMBOO_BLOCK = registerBlock("stripped_red_bamboo_block", () ->  new LogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(AASounds.RED_BAMBOO_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> RED_BAMBOO_PLANKS = registerBlock("red_bamboo_planks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(AASounds.RED_BAMBOO_WOOD).ignitedByLava()));
    public static final DeferredBlock<StairBlock> RED_BAMBOO_STAIRS = registerBlock("red_bamboo_stairs", () ->  new StairBlock(RED_BAMBOO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> RED_BAMBOO_SLAB = registerBlock("red_bamboo_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_PLANKS.get())));
    public static final DeferredBlock<Block> RED_BAMBOO_MOSAIC = registerBlock("red_bamboo_mosaic", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_PLANKS.get())));
    public static final DeferredBlock<StairBlock> RED_BAMBOO_MOSAIC_STAIRS = registerBlock("red_bamboo_mosaic_stairs", () ->  new StairBlock(RED_BAMBOO_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_MOSAIC.get())));
    public static final DeferredBlock<SlabBlock> RED_BAMBOO_MOSAIC_SLAB = registerBlock("red_bamboo_mosaic_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_MOSAIC.get())));
    public static final DeferredBlock<FenceBlock> RED_BAMBOO_FENCE = registerBlock("red_bamboo_fence", () ->  new FenceBlock(BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> RED_BAMBOO_FENCE_GATE = registerBlock("red_bamboo_fence_gate", () ->  new FenceGateBlock(AAWoodTypes.RED_BAMBOO, BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_PLANKS.get()).forceSolidOn()));
    public static final DeferredBlock<DoorBlock> RED_BAMBOO_DOOR = registerBlock("red_bamboo_door", () ->  new DoorBlock(AABlockSetTypes.RED_BAMBOO, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(3.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(AASounds.RED_BAMBOO_WOOD).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<TrapDoorBlock> RED_BAMBOO_TRAPDOOR = registerBlock("red_bamboo_trapdoor", () ->  new TrapDoorBlock(AABlockSetTypes.RED_BAMBOO, BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_DOOR.get()).isValidSpawn(Blocks::never)));
    public static final DeferredBlock<PressurePlateBlock> RED_BAMBOO_PRESSURE_PLATE = registerBlock("red_bamboo_pressure_plate", () ->  new PressurePlateBlock(AABlockSetTypes.RED_BAMBOO, BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_PLANKS.get()).strength(0.5f, 0.5f).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<ButtonBlock> RED_BAMBOO_BUTTON = registerBlock("red_bamboo_button", () ->  new ButtonBlock(AABlockSetTypes.RED_BAMBOO, 30, BlockBehaviour.Properties.ofFullCopy(RED_BAMBOO_PLANKS.get()).strength(0.5f, 0.5f).noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<StandingSignBlock> RED_BAMBOO_SIGN = BLOCKS.register("red_bamboo_sign", () -> new StandingSignBlock(AAWoodTypes.RED_BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final DeferredBlock<WallSignBlock> RED_BAMBOO_WALL_SIGN = BLOCKS.register("red_bamboo_wall_sign", () -> new WallSignBlock(AAWoodTypes.RED_BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
    public static final DeferredBlock<CeilingHangingSignBlock> RED_BAMBOO_HANGING_SIGN = BLOCKS.register("red_bamboo_hanging_sign", () -> new CeilingHangingSignBlock(AAWoodTypes.RED_BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
    public static final DeferredBlock<WallHangingSignBlock> RED_BAMBOO_WALL_HANGING_SIGN = BLOCKS.register("red_bamboo_wall_hanging_sign", () -> new WallHangingSignBlock(AAWoodTypes.RED_BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final DeferredBlock<RedBambooSaplingBlock> RED_BAMBOO_SAPLING = BLOCKS.register("red_bamboo_sapling", () -> new RedBambooSaplingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_SAPLING)));
    public static final DeferredBlock<RedBambooStalkBlock> RED_BAMBOO = registerBlock("red_bamboo", () -> new RedBambooStalkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO).sound(AASounds.RED_BAMBOO)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_RED_BAMBOO = BLOCKS.register("potted_red_bamboo", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AABlocks.RED_BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BAMBOO)));

    @SuppressWarnings("unchecked")
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<? extends Block> block) {
        DeferredBlock<Block> toReturn = BLOCKS.register(name, block);
        CREATIVE_TAB_ITEMS.add(registerBlockItem(name, toReturn));
        return (DeferredBlock<T>) toReturn;
    }

    public static DeferredHolder<Item, BlockItem> registerBlockItem(String name, Supplier<? extends Block> block) {
        return AAItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
