package net.sheddmer.abundant_atmosphere.integration;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

import static net.sheddmer.abundant_atmosphere.init.AABlocks.registerBlock;

public class FDIntegration {
    public static final DeferredBlock<Block> ASHROOT_CABINET = registerBlock("ashroot_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL)));
    public static final DeferredBlock<Block> GOURDROT_CABINET = registerBlock("gourdrot_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL)));
    public static final DeferredBlock<Block> RED_BAMBOO_CABINET = registerBlock("red_bamboo_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL)));

    public static void addBlockEntities(final BlockEntityTypeAddBlocksEvent event) {
        event.modify(ModBlockEntityTypes.CABINET.get(), ASHROOT_CABINET.get(), GOURDROT_CABINET.get(), RED_BAMBOO_CABINET.get());
    }

    public static void register() {
    }
}