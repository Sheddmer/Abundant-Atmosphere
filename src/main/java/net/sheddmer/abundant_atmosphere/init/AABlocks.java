package net.sheddmer.abundant_atmosphere.init;

import com.farcr.nomansland.common.block.BookshelfBlock;
import com.farcr.nomansland.common.block.TrimmedPlankBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.block.*;
import net.sheddmer.abundant_atmosphere.integration.AAModCompats;

import java.util.function.Supplier;

public class AABlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AbundantAtmosphere.MODID);

    // General blocks
    public static final DeferredBlock<Block> BLACKSALT_TILES = registerBlock("blacksalt_tiles", () -> new Block(BlockBehaviour.Properties.of().strength(1.4f, 1.4f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public static final DeferredBlock<Block> CHISELED_MUD_BRICKS = registerBlock("chiseled_mud_bricks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).requiresCorrectToolForDrops().strength(1.5f, 3.0f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.MUD_BRICKS)));
    // Calcite blocks
    public static final DeferredBlock<Block> POLISHED_CALCITE = registerBlock("polished_calcite", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).requiresCorrectToolForDrops().strength(0.75f, 1.0f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs", () ->  new StairBlock(POLISHED_CALCITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get())));
    public static final DeferredBlock<Block> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get())));
    public static final DeferredBlock<Block> POLISHED_CALCITE_WALL = registerBlock("polished_calcite_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get()).forceSolidOn()));
    public static final DeferredBlock<Block> CALCITE_TILES = registerBlock("calcite_tiles", () ->  new Block(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> CALCITE_TILE_STAIRS = registerBlock("calcite_tile_stairs", () ->  new StairBlock(POLISHED_CALCITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get())));
    public static final DeferredBlock<Block> CALCITE_TILE_SLAB = registerBlock("calcite_tile_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get())));
    public static final DeferredBlock<Block> CALCITE_TILE_WALL = registerBlock("calcite_tile_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE.get()).forceSolidOn()));
    // Dripstone blocks
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE = registerBlock("polished_dripstone", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops().strength(1.5f, 1.5f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE_STAIRS = registerBlock("polished_dripstone_stairs", () ->  new StairBlock(POLISHED_DRIPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE_SLAB = registerBlock("polished_dripstone_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE_WALL = registerBlock("polished_dripstone_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get()).forceSolidOn()));
    public static final DeferredBlock<Block> DRIPSTONE_TILES = registerBlock("dripstone_tiles", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<Block> DRIPSTONE_TILE_STAIRS = registerBlock("dripstone_tile_stairs", () ->  new StairBlock(POLISHED_DRIPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<Block> DRIPSTONE_TILE_SLAB = registerBlock("dripstone_tile_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<Block> DRIPSTONE_TILE_WALL = registerBlock("dripstone_tile_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get()).forceSolidOn()));
    public static final DeferredBlock<Block> DRIPSTONE_SHINGLES = registerBlock("dripstone_shingles", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<Block> DRIPSTONE_SHINGLE_STAIRS = registerBlock("dripstone_shingle_stairs", () ->  new StairBlock(POLISHED_DRIPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<Block> DRIPSTONE_SHINGLE_SLAB = registerBlock("dripstone_shingle_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get())));
    public static final DeferredBlock<Block> DRIPSTONE_SHINGLE_WALL = registerBlock("dripstone_shingle_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE.get()).forceSolidOn()));
    // Shuffled Brick blocks
    public static final DeferredBlock<Block> SHUFFLED_BRICKS = registerBlock("shuffled_bricks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).requiresCorrectToolForDrops().strength(2.5f, 8.0f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> SHUFFLED_BRICK_STAIRS = registerBlock("shuffled_brick_stairs", () ->  new StairBlock(SHUFFLED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SHUFFLED_BRICKS.get())));
    public static final DeferredBlock<Block> SHUFFLED_BRICK_SLAB = registerBlock("shuffled_brick_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SHUFFLED_BRICKS.get())));
    public static final DeferredBlock<Block> SHUFFLED_BRICK_WALL = registerBlock("shuffled_brick_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(SHUFFLED_BRICKS.get()).forceSolidOn()));

    public static final DeferredBlock<Block> DOWSITE = registerBlock("dowsite", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(1.5f, 6.0f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF)));
    public static final DeferredBlock<Block> POLISHED_DOWSITE = registerBlock("polished_dowsite", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(DOWSITE.get())));
    public static final DeferredBlock<Block> POLISHED_DOWSITE_STAIRS = registerBlock("polished_dowsite_stairs", () ->  new StairBlock(POLISHED_DOWSITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_DOWSITE.get())));
    public static final DeferredBlock<Block> POLISHED_DOWSITE_SLAB = registerBlock("polished_dowsite_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DOWSITE.get())));
    public static final DeferredBlock<Block> POLISHED_DOWSITE_WALL = registerBlock("polished_dowsite_wall", () ->  new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_DOWSITE.get()).forceSolidOn()));
    public static final DeferredBlock<Block> WISP_CANDLE = registerBlock("wisp_candle", () ->  new WispCandleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).strength(0.1f, 0.1f).lightLevel(state -> state.getValue(WispCandleBlock.LIT) ? 2 * state.getValue(WispCandleBlock.CANDLES) : 0).noOcclusion().sound(SoundType.CANDLE).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> MUD_LAMP = BLOCKS.register("mud_lamp", () ->  new MudLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(2.0f, 2.0f).lightLevel(state -> state.getValue(MudLampBlock.LIT) ? 10 : 0).noOcclusion().sound(SoundType.PACKED_MUD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WALL_MUD_LAMP = BLOCKS.register("wall_mud_lamp", () ->  new WallMudLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(2.0f, 2.0f).lightLevel(state -> state.getValue(MudLampBlock.LIT) ? 10 : 0).noOcclusion().sound(SoundType.PACKED_MUD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STONE_BRAZIER = registerBlock("stone_brazier", () -> new StoneBrazierBlock(1, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(4.0f, 8.0f).requiresCorrectToolForDrops().noOcclusion().ignitedByLava().lightLevel(state -> state.getValue(StoneBrazierBlock.LIT) ? 15 : 0).instrument(NoteBlockInstrument.BASS).sound(SoundType.POLISHED_DEEPSLATE)));
    public static final DeferredBlock<Block> SOUL_STONE_BRAZIER = registerBlock("soul_stone_brazier", () -> new StoneBrazierBlock(2, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(4.0f, 8.0f).requiresCorrectToolForDrops().noOcclusion().ignitedByLava().lightLevel(state -> state.getValue(StoneBrazierBlock.LIT) ? 10 : 0).instrument(NoteBlockInstrument.BASS).sound(SoundType.POLISHED_DEEPSLATE)));

    public static final DeferredBlock<Block> RAW_AMBER_BLOCK = registerBlock("raw_amber_block", () -> new DiffusedCrystalBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(1.0f, 0.5f).noOcclusion().lightLevel(state -> state.getValue(DiffusedCrystalBlock.DIFFUSED_LIGHT)).instrument(NoteBlockInstrument.CHIME).sound(SoundType.AMETHYST)));

    // Suspicious blocks
    public static final DeferredBlock<Block> SUSPICIOUS_DIRT = registerBlock("suspicious_dirt", () -> new BrushableBlock(Blocks.DIRT, SoundEvents.BRUSH_GRAVEL, SoundEvents.BRUSH_GRAVEL_COMPLETED, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.25f, 0.25f).sound(SoundType.SUSPICIOUS_GRAVEL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> SUSPICIOUS_RED_SAND = registerBlock("suspicious_red_sand", () -> new BrushableBlock(Blocks.RED_SAND, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.25f, 0.25f).instrument(NoteBlockInstrument.SNARE).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY)));

    // Natural blocks
    public static final DeferredBlock<Block> CAVE_CRUD = registerBlock("cave_crud", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(0.75f, 0.75f).sound(SoundType.ROOTED_DIRT)));
    public static final DeferredBlock<Block> MIDNIGHT_LILY = registerBlock("midnight_lily", () ->  new MidnightLilyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instabreak().noCollission().randomTicks().lightLevel(state -> state.getValue(MidnightLilyBlock.NIGHTLIGHT) ? 2 + state.getValue(MidnightLilyBlock.FLOWER_STACK) : 0).sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> POTTED_MIDNIGHT_LILY = BLOCKS.register("potted_midnight_lily", () -> new FlowerPotBlock(MIDNIGHT_LILY.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> PUFFBALL_MUSHROOM = registerBlock("puffball_mushroom", () -> new PuffballMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instabreak().noOcclusion().randomTicks().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> LARGE_PUFFBALL_MUSHROOM = registerBlock("large_puffball_mushroom", () -> new LargePuffballMushroomBlock(BlockBehaviour.Properties.ofFullCopy(PUFFBALL_MUSHROOM.get())));
    public static final DeferredBlock<Block> MOSS_CLUMP = registerBlock("moss_clump", () -> new MossClumpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.1f, 0.1f).noCollission().noOcclusion().replaceable().sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> IRISH_MOSS_BLOCK = registerBlock("irish_moss_block", () -> new MossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).strength(0.1f, 0.1f).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> IRISH_MOSS_CARPET = registerBlock("irish_moss_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).strength(0.1f, 0.1f).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> IRISH_MOSS_CLUMP = registerBlock("irish_moss_clump", () -> new MossClumpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.1f, 0.1f).noCollission().noOcclusion().replaceable().sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CERULEAN_FROGLIGHT = registerBlock("cerulean_froglight", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(0.3f, 0.3f).lightLevel(value -> 15).sound(SoundType.FROGLIGHT)));
    public static final DeferredBlock<Block> CHROMATIC_FROGLIGHT = BLOCKS.register("chromatic_froglight", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.3f, 0.3f).lightLevel(value -> 15).sound(SoundType.FROGLIGHT)));
    public static final DeferredBlock<Block> CAVE_SPROUTS = registerBlock("cave_sprouts", () -> new TallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
    // Mossy Blocks
    public static final DeferredBlock<Block> MOSSY_STONE = registerBlock("mossy_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_BASALT = registerBlock("mossy_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> MOSSY_DEEPSLATE = registerBlock("mossy_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> MOSSY_COBBLED_DEEPSLATE = registerBlock("mossy_cobbled_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE)));
    public static final DeferredBlock<Block> MOSSY_POLISHED_DEEPSLATE = registerBlock("mossy_polished_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE)));
    public static final DeferredBlock<Block> MOSSY_DEEPSLATE_BRICKS = registerBlock("mossy_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)));
    public static final DeferredBlock<Block> MOSSY_DEEPSLATE_TILES = registerBlock("mossy_deepslate_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_TILES)));

    // Stone Chests
    public static final DeferredBlock<Block> STONE_CHEST = registerBlock("stone_chest", () -> new StoneChestBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(4.0f, 8.0f).requiresCorrectToolForDrops().sound(SoundType.POLISHED_DEEPSLATE)));
    public static final DeferredBlock<Block> TRAPPED_STONE_CHEST = registerBlock("trapped_stone_chest", () -> new StoneChestBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(4.0f, 8.0f).requiresCorrectToolForDrops().sound(SoundType.POLISHED_DEEPSLATE)));

    // Stone Doors

    // Patterned Vases

    // Ashroot Woodset
    public static final DeferredBlock<Block> ASHROOT_LOG = registerBlock("ashroot_log", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASHROOT_WOOD = registerBlock("ashroot_wood", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_ASHROOT_LOG = registerBlock("stripped_ashroot_log", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_ASHROOT_WOOD = registerBlock("stripped_ashroot_wood", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASHROOT_PLANKS = registerBlock("ashroot_planks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASHROOT_STAIRS = registerBlock("ashroot_stairs", () ->  new StairBlock(ASHROOT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get())));
    public static final DeferredBlock<Block> ASHROOT_SLAB = registerBlock("ashroot_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get())));
    public static final DeferredBlock<Block> ASHROOT_FENCE = registerBlock("ashroot_fence", () ->  new FenceBlock(BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get())));
    public static final DeferredBlock<Block> ASHROOT_FENCE_GATE = registerBlock("ashroot_fence_gate", () ->  new FenceGateBlock(AAWoodTypes.ASHROOT ,BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get()).forceSolidOn()));
    public static final DeferredBlock<Block> ASHROOT_DOOR = registerBlock("ashroot_door", () ->  new DoorBlock(AABlockSetTypes.ASHROOT, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(3.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ASHROOT_TRAPDOOR = registerBlock("ashroot_trapdoor", () ->  new TrapDoorBlock(AABlockSetTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(ASHROOT_DOOR.get()).isValidSpawn(Blocks::never)));
    public static final DeferredBlock<Block> ASHROOT_PRESSURE_PLATE = registerBlock("ashroot_pressure_plate", () ->  new PressurePlateBlock(AABlockSetTypes.ASHROOT, BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get()).strength(0.5f, 0.5f).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ASHROOT_BUTTON = registerBlock("ashroot_button", () ->  new ButtonBlock(AABlockSetTypes.ASHROOT, 30, BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get()).strength(0.5f, 0.5f).noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ASHROOT_SIGN = BLOCKS.register("ashroot_sign", () -> new AAStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), AAWoodTypes.ASHROOT));
    public static final DeferredBlock<Block> ASHROOT_WALL_SIGN = BLOCKS.register("ashroot_wall_sign", () -> new AAWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), AAWoodTypes.ASHROOT));
    public static final DeferredBlock<Block> ASHROOT_HANGING_SIGN = BLOCKS.register("ashroot_hanging_sign", () -> new AACeilingHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), AAWoodTypes.ASHROOT));
    public static final DeferredBlock<Block> ASHROOT_WALL_HANGING_SIGN = BLOCKS.register("ashroot_wall_hanging_sign", () -> new AAWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), AAWoodTypes.ASHROOT));
    public static final DeferredBlock<Block> ASHROOT_SAPLING = registerBlock("ashroot_sapling", () ->  new LightlessSaplingBlock(TreeGrower.OAK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instabreak().randomTicks().noCollission().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ASHROOT_LEAVES = registerBlock("ashroot_leaves", () ->  new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.2f, 0.2f).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES).pushReaction(PushReaction.DESTROY).ignitedByLava()));

    // Gourdrot Woodset
    public static final DeferredBlock<Block> GOURDROT_LOG = registerBlock("gourdrot_log", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> GOURDROT_WOOD = registerBlock("gourdrot_wood", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_GOURDROT_LOG = registerBlock("stripped_gourdrot_log", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_GOURDROT_WOOD = registerBlock("stripped_gourdrot_wood", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(2.0f, 2.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> GOURDROT_PLANKS = registerBlock("gourdrot_planks", () ->  new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> GOURDROT_STAIRS = registerBlock("gourdrot_stairs", () ->  new StairBlock(GOURDROT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get())));
    public static final DeferredBlock<Block> GOURDROT_SLAB = registerBlock("gourdrot_slab", () ->  new SlabBlock(BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get())));
    public static final DeferredBlock<Block> GOURDROT_FENCE = registerBlock("gourdrot_fence", () ->  new FenceBlock(BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get())));
    public static final DeferredBlock<Block> GOURDROT_FENCE_GATE = registerBlock("gourdrot_fence_gate", () ->  new FenceGateBlock(AAWoodTypes.GOURDROT ,BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get()).forceSolidOn()));
    public static final DeferredBlock<Block> GOURDROT_DOOR = registerBlock("gourdrot_door", () ->  new DoorBlock(AABlockSetTypes.GOURDROT, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(3.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> GOURDROT_TRAPDOOR = registerBlock("gourdrot_trapdoor", () ->  new TrapDoorBlock(AABlockSetTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(GOURDROT_DOOR.get()).isValidSpawn(Blocks::never)));
    public static final DeferredBlock<Block> GOURDROT_PRESSURE_PLATE = registerBlock("gourdrot_pressure_plate", () ->  new PressurePlateBlock(AABlockSetTypes.GOURDROT, BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get()).strength(0.5f, 0.5f).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> GOURDROT_BUTTON = registerBlock("gourdrot_button", () ->  new ButtonBlock(AABlockSetTypes.GOURDROT, 30, BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get()).strength(0.5f, 0.5f).noCollission().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> GOURDROT_SIGN = BLOCKS.register("gourdrot_sign", () -> new AAStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), AAWoodTypes.GOURDROT));
    public static final DeferredBlock<Block> GOURDROT_WALL_SIGN = BLOCKS.register("gourdrot_wall_sign", () -> new AAWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), AAWoodTypes.GOURDROT));
    public static final DeferredBlock<Block> GOURDROT_HANGING_SIGN = BLOCKS.register("gourdrot_hanging_sign", () -> new AACeilingHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), AAWoodTypes.GOURDROT));
    public static final DeferredBlock<Block> GOURDROT_WALL_HANGING_SIGN = BLOCKS.register("gourdrot_wall_hanging_sign", () -> new AAWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), AAWoodTypes.GOURDROT));
    public static final DeferredBlock<Block> GOURDNUT = registerBlock("gourdnut", () -> new GourdnutBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.1f, 0.0f).noOcclusion().instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> GOURDROT_LEAVES = registerBlock("gourdrot_leaves", () ->  new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).strength(0.2f, 0.2f).randomTicks().noOcclusion().sound(SoundType.AZALEA_LEAVES).pushReaction(PushReaction.DESTROY).ignitedByLava()));

    // Farmer's Delight Integration

    // No Man's Land Integration
    public static final DeferredBlock<Block> TRIMMED_ASHROOT_PLANKS = registerBlock("trimmed_ashroot_planks", AAModCompats.NOMANSLAND.isLoaded() ? () -> new TrimmedPlankBlock(BlockBehaviour.Properties.ofFullCopy(ASHROOT_PLANKS.get())) : null);
    public static final DeferredBlock<Block> ASHROOT_BOOKSHELF = registerBlock("ashroot_bookshelf", AAModCompats.NOMANSLAND.isLoaded() ? () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)) : null);
    public static final DeferredBlock<Block> TRIMMED_GOURDROT_PLANKS = registerBlock("trimmed_gourdrot_planks", AAModCompats.NOMANSLAND.isLoaded() ? () -> new TrimmedPlankBlock(BlockBehaviour.Properties.ofFullCopy(GOURDROT_PLANKS.get())) : null);
    public static final DeferredBlock<Block> GOURDROT_BOOKSHELF = registerBlock("gourdrot_bookshelf", AAModCompats.NOMANSLAND.isLoaded() ? () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)) : null);


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        AAItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
