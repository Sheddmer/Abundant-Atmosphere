package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.sheddmer.abundant_atmosphere.common.integration.AAModCompats;
import net.sheddmer.abundant_atmosphere.common.integration.NMLIntegration;

public class AAFlammables {
    public static void register() {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;

        fireBlock.setFlammable(AABlocks.ASHROOT_PLANKS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASHROOT_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASHROOT_SLAB.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASHROOT_FENCE.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASHROOT_LEAVES.get(), 30, 60);
        if (AAModCompats.NOMANSLAND.isLoaded()) fireBlock.setFlammable(NMLIntegration.ASHROOT_BOOKSHELF.get(), 30, 20);
        if (AAModCompats.NOMANSLAND.isLoaded()) fireBlock.setFlammable(NMLIntegration.TRIMMED_ASHROOT_PLANKS.get(), 5, 20);

        fireBlock.setFlammable(AABlocks.GOURDROT_PLANKS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_SLAB.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_FENCE.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_LEAVES.get(), 30, 60);
        if (AAModCompats.NOMANSLAND.isLoaded()) fireBlock.setFlammable(NMLIntegration.GOURDROT_BOOKSHELF.get(), 30, 20);
        if (AAModCompats.NOMANSLAND.isLoaded()) fireBlock.setFlammable(NMLIntegration.TRIMMED_GOURDROT_PLANKS.get(), 5, 20);

        fireBlock.setFlammable(AABlocks.RED_BAMBOO_PLANKS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.RED_BAMBOO_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.RED_BAMBOO_SLAB.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.RED_BAMBOO_FENCE.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.RED_BAMBOO_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.RED_BAMBOO_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.RED_BAMBOO_MOSAIC_SLAB.get(), 5, 20);
        if (AAModCompats.NOMANSLAND.isLoaded()) fireBlock.setFlammable(NMLIntegration.RED_BAMBOO_BOOKSHELF.get(), 30, 20);
        if (AAModCompats.NOMANSLAND.isLoaded()) fireBlock.setFlammable(NMLIntegration.TRIMMED_RED_BAMBOO_PLANKS.get(), 5, 20);

        fireBlock.setFlammable(AABlocks.LEAF_PILE.get(), 30, 60);

        fireBlock.setFlammable(AABlocks.RUST_MOSS_BLOCK.get(), 100, 160);
        fireBlock.setFlammable(AABlocks.RUST_MOSS_CARPET.get(), 120, 200);
        fireBlock.setFlammable(AABlocks.RUST_MOSS_CLUMP.get(), 120, 200);
        fireBlock.setFlammable(AABlocks.RUST_MOSS_SPROUTS.get(), 120, 200);
    }
}
