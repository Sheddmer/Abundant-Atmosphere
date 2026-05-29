package net.sheddmer.abundant_atmosphere.common.integration;

import com.teamabnormals.woodworks.common.block.ChiseledBambooBookShelfBlock;
import com.teamabnormals.woodworks.common.block.ClosetBlock;
import com.teamabnormals.woodworks.common.block.TrappedClosetBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.teamabnormals.woodworks.core.registry.WoodworksBlocks.BLOCKS;
import static net.sheddmer.abundant_atmosphere.common.init.AAItems.registerItem;

public class WWIntegration {
    public static final DeferredBlock<ClosetBlock> RED_BAMBOO_CLOSET = BLOCKS.createClosetBlock("red_bamboo_closet", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED));
    public static final DeferredBlock<TrappedClosetBlock> TRAPPED_RED_BAMBOO_CLOSET = BLOCKS.createTrappedClosetBlock("trapped_red_bamboo_closet", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED));
    public static final DeferredBlock<ChiseledBambooBookShelfBlock> RED_BAMBOO_CHISELED_BOOKSHELF = BLOCKS.createBlock("red_bamboo_chiseled_bookshelf", () -> new ChiseledBambooBookShelfBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)));

    public static final DeferredItem<BlockItem> RED_BAMBOO_CLOSET_ITEM = registerItem("red_bamboo_closet", () -> new BlockItem(RED_BAMBOO_CLOSET.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> TRAPPED_RED_BAMBOO_CLOSET_ITEM = registerItem("trapped_red_bamboo_closet", () -> new BlockItem(TRAPPED_RED_BAMBOO_CLOSET.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> RED_BAMBOO_CHISELED_BOOKSHELF_ITEM = registerItem("red_bamboo_chiseled_bookshelf", () -> new BlockItem(RED_BAMBOO_CHISELED_BOOKSHELF.get(), new Item.Properties()));

    public static void register() {
    }
}
