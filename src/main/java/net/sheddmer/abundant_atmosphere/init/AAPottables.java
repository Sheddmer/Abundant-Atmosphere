package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class AAPottables {
    public static void register() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.ASHROOT_SAPLING.getId(), AABlocks.POTTED_ASHROOT_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.GOURDNUT.getId(), AABlocks.POTTED_GOURDNUT);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.RED_BAMBOO.getId(), AABlocks.POTTED_RED_BAMBOO);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.MIDNIGHT_LILY.getId(), AABlocks.POTTED_MIDNIGHT_LILY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.SAFFRON_BUSHBUDS.getId(), AABlocks.POTTED_SAFFRON_BUSHBUDS);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.CHERRY_BUSHBUDS.getId(), AABlocks.POTTED_CHERRY_BUSHBUDS);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.UMBRA_BUSHBUDS.getId(), AABlocks.POTTED_UMBRA_BUSHBUDS);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.PORESHROOM.getId(), AABlocks.POTTED_PORESHROOM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AABlocks.CATSBANE.getId(), AABlocks.POTTED_CATSBANE);
    }
}