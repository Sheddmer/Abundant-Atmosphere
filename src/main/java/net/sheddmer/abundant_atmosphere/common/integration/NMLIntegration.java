package net.sheddmer.abundant_atmosphere.common.integration;

import com.farcr.nomansland.common.block.TrimmedPlankBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AASounds;

import static net.sheddmer.abundant_atmosphere.common.init.AABlocks.registerBlock;

public class NMLIntegration {
    public static final DeferredBlock<TrimmedPlankBlock> TRIMMED_ASHROOT_PLANKS = registerBlock("trimmed_ashroot_planks", () -> new TrimmedPlankBlock(BlockBehaviour.Properties.ofFullCopy(AABlocks.ASHROOT_PLANKS.get())));
    public static final DeferredBlock<Block> ASHROOT_BOOKSHELF = registerBlock("ashroot_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)));
    public static final DeferredBlock<TrimmedPlankBlock> TRIMMED_GOURDROT_PLANKS = registerBlock("trimmed_gourdrot_planks", () -> new TrimmedPlankBlock(BlockBehaviour.Properties.ofFullCopy(AABlocks.GOURDROT_PLANKS.get())));
    public static final DeferredBlock<Block> GOURDROT_BOOKSHELF = registerBlock("gourdrot_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)));
    public static final DeferredBlock<TrimmedPlankBlock> TRIMMED_RED_BAMBOO_PLANKS = registerBlock("trimmed_red_bamboo_planks", () -> new TrimmedPlankBlock(BlockBehaviour.Properties.ofFullCopy(AABlocks.RED_BAMBOO_PLANKS.get())));
    public static final DeferredBlock<Block> RED_BAMBOO_BOOKSHELF = registerBlock("red_bamboo_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).sound(AASounds.RED_BAMBOO_WOOD)));

    public static final DeferredBlock<Block> MOSSY_COBBLED_DEEPSLATE_BRICKS = registerBlock("mossy_cobbled_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE)));
    public static final DeferredBlock<StairBlock> MOSSY_COBBLED_DEEPSLATE_BRICK_STAIRS = registerBlock("mossy_cobbled_deepslate_brick_stairs", () -> new StairBlock(MOSSY_COBBLED_DEEPSLATE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE_STAIRS)));
    public static final DeferredBlock<SlabBlock> MOSSY_COBBLED_DEEPSLATE_BRICK_SLAB = registerBlock("mossy_cobbled_deepslate_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE_SLAB)));
    public static final DeferredBlock<WallBlock> MOSSY_COBBLED_DEEPSLATE_BRICK_WALL = registerBlock("mossy_cobbled_deepslate_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE_WALL)));

    public static void register() {
    }
}