package net.sheddmer.abundant_atmosphere.common.integration;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sheddmer.abundant_atmosphere.init.AABlocks;
import vectorwing.blockbox.common.block.PalisadeBlock;
import vectorwing.blockbox.common.block.SeatBlock;
import vectorwing.blockbox.common.block.SpikedPalisadeBlock;
import vectorwing.blockbox.common.registry.ModBlocks;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;
import static net.sheddmer.abundant_atmosphere.init.AABlocks.registerBlock;

public class BBIntegration {
    public static final DeferredBlock<Block> STRIPPED_SPIKED_ASHROOT_PALISADE = registerBlock("stripped_spiked_ashroot_palisade", () -> new SpikedPalisadeBlock(ModBlocks.PROPERTIES_PALISADE.mapColor(MapColor.WOOD).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> SPIKED_ASHROOT_PALISADE = registerBlock("spiked_ashroot_palisade", () -> new SpikedPalisadeBlock(STRIPPED_SPIKED_ASHROOT_PALISADE, ModBlocks.PROPERTIES_PALISADE.mapColor(MapColor.WOOD).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ASHROOT_PALISADE = registerBlock("stripped_ashroot_palisade", () -> new PalisadeBlock(STRIPPED_SPIKED_ASHROOT_PALISADE, ModBlocks.PROPERTIES_PALISADE.mapColor(MapColor.WOOD).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ASHROOT_PALISADE = registerBlock("ashroot_palisade", () -> new PalisadeBlock(SPIKED_ASHROOT_PALISADE, STRIPPED_ASHROOT_PALISADE, ModBlocks.PROPERTIES_PALISADE.mapColor(MapColor.WOOD).sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> STRIPPED_SPIKED_GOURDROT_PALISADE = registerBlock("stripped_spiked_gourdrot_palisade", () -> new SpikedPalisadeBlock(ModBlocks.PROPERTIES_PALISADE.mapColor(MapColor.WOOD).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> SPIKED_GOURDROT_PALISADE = registerBlock("spiked_gourdrot_palisade", () -> new SpikedPalisadeBlock(STRIPPED_SPIKED_GOURDROT_PALISADE, ModBlocks.PROPERTIES_PALISADE.mapColor(MapColor.WOOD).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GOURDROT_PALISADE = registerBlock("stripped_gourdrot_palisade", () -> new PalisadeBlock(STRIPPED_SPIKED_GOURDROT_PALISADE, ModBlocks.PROPERTIES_PALISADE.mapColor(MapColor.WOOD).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> GOURDROT_PALISADE = registerBlock("gourdrot_palisade", () -> new PalisadeBlock(SPIKED_GOURDROT_PALISADE, STRIPPED_GOURDROT_PALISADE, ModBlocks.PROPERTIES_PALISADE.mapColor(MapColor.WOOD).sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> ASHROOT_SEAT = registerBlock("ashroot_seat", () -> new SeatBlock(ofFullCopy(AABlocks.ASHROOT_PLANKS.get())));
    public static final DeferredBlock<Block> GOURDROT_SEAT = registerBlock("gourdrot_seat", () -> new SeatBlock(ofFullCopy(AABlocks.GOURDROT_PLANKS.get())));
    public static final DeferredBlock<Block> RED_BAMBOO_SEAT = registerBlock("red_bamboo_seat", () -> new SeatBlock(ofFullCopy(AABlocks.RED_BAMBOO_PLANKS.get())));

    public static void register() {
    }
}