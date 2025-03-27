package net.sheddmer.abundant_atmosphere.common.integration;

import com.farcr.nomansland.common.block.TrimmedPlankBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.sheddmer.abundant_atmosphere.init.AABlocks;
import net.sheddmer.abundant_atmosphere.init.AAFoods;
import net.sheddmer.abundant_atmosphere.init.AASounds;

import static net.sheddmer.abundant_atmosphere.init.AABlocks.registerBlock;
import static net.sheddmer.abundant_atmosphere.init.AAItems.registerItem;

public class NMLIntegration {
    public static final DeferredBlock<Block> TRIMMED_ASHROOT_PLANKS = registerBlock("trimmed_ashroot_planks", () -> new TrimmedPlankBlock(BlockBehaviour.Properties.ofFullCopy(AABlocks.ASHROOT_PLANKS.get())));
    public static final DeferredBlock<Block> ASHROOT_BOOKSHELF = registerBlock("ashroot_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)));
    public static final DeferredBlock<Block> TRIMMED_GOURDROT_PLANKS = registerBlock("trimmed_gourdrot_planks", () -> new TrimmedPlankBlock(BlockBehaviour.Properties.ofFullCopy(AABlocks.GOURDROT_PLANKS.get())));
    public static final DeferredBlock<Block> GOURDROT_BOOKSHELF = registerBlock("gourdrot_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)));
    public static final DeferredBlock<Block> TRIMMED_RED_BAMBOO_PLANKS = registerBlock("trimmed_red_bamboo_planks", () -> new TrimmedPlankBlock(BlockBehaviour.Properties.ofFullCopy(AABlocks.RED_BAMBOO_PLANKS.get())));
    public static final DeferredBlock<Block> RED_BAMBOO_BOOKSHELF = registerBlock("red_bamboo_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).sound(AASounds.RED_BAMBOO_WOOD)));
    public static final DeferredBlock<Block> SILT_VASE = registerBlock("silt_vase", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SILT_PATTERNED_VASE = registerBlock("silt_patterned_vase", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredItem<Item> SWAMP_SCRAN = registerItem("swamp_scran", AAModCompats.FARMERSDELIGHT.isLoaded() ? () -> new Item(new Item.Properties().food(AAFoods.SWAMP_SCRAN).stacksTo(16)) : null);

    public static void register() {
    }

}