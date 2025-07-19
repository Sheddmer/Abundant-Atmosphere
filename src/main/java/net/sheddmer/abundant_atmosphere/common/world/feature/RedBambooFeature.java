package net.sheddmer.abundant_atmosphere.common.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.sheddmer.abundant_atmosphere.common.block.RedBambooStalkBlock;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;

public class RedBambooFeature extends Feature<ProbabilityFeatureConfiguration> {
    private static final BlockState BAMBOO_TRUNK = AABlocks.RED_BAMBOO.get().defaultBlockState().setValue(RedBambooStalkBlock.AGE, 1).setValue(RedBambooStalkBlock.LEAVES, BambooLeaves.NONE).setValue(RedBambooStalkBlock.STAGE, 0);
    private static final BlockState BAMBOO_FINAL_LARGE = BAMBOO_TRUNK.setValue(RedBambooStalkBlock.LEAVES, BambooLeaves.LARGE).setValue(RedBambooStalkBlock.STAGE, 1);
    private static final BlockState BAMBOO_TOP_LARGE = BAMBOO_TRUNK.setValue(RedBambooStalkBlock.LEAVES, BambooLeaves.LARGE);
    private static final BlockState BAMBOO_TOP_SMALL = BAMBOO_TRUNK.setValue(RedBambooStalkBlock.LEAVES, BambooLeaves.SMALL);

    public RedBambooFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        int i = 0;
        BlockPos blockpos = context.origin();
        WorldGenLevel worldgenlevel = context.level();
        RandomSource randomsource = context.random();
        ProbabilityFeatureConfiguration probabilityfeatureconfiguration = context.config();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();
        BlockPos.MutableBlockPos blockpos$mutableblockpos1 = blockpos.mutable();
        if (worldgenlevel.isEmptyBlock(blockpos$mutableblockpos)) {
            if (AABlocks.RED_BAMBOO.get().defaultBlockState().canSurvive(worldgenlevel, blockpos$mutableblockpos)) {
                int j = randomsource.nextInt(6) + 16;
                if (randomsource.nextFloat() < probabilityfeatureconfiguration.probability) {
                    int k = randomsource.nextInt(5);

                    for (int l = blockpos.getX() - k; l <= blockpos.getX() + k; l++) {
                        for (int i1 = blockpos.getZ() - k; i1 <= blockpos.getZ() + k; i1++) {
                            int j1 = l - blockpos.getX();
                            int k1 = i1 - blockpos.getZ();
                            if (j1 * j1 + k1 * k1 <= k * k) {
                                blockpos$mutableblockpos1.set(l, worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, l, i1) - 1, i1);
                                if (isDirt(worldgenlevel.getBlockState(blockpos$mutableblockpos1))) {
                                    worldgenlevel.setBlock(blockpos$mutableblockpos1, Blocks.PODZOL.defaultBlockState(), 2);
                                }
                            }
                        }
                    }
                }

                for (int l1 = 0; l1 < j && worldgenlevel.isEmptyBlock(blockpos$mutableblockpos); l1++) {
                    worldgenlevel.setBlock(blockpos$mutableblockpos, BAMBOO_TRUNK, 2);
                    blockpos$mutableblockpos.move(Direction.UP, 1);
                }

                if (blockpos$mutableblockpos.getY() - blockpos.getY() >= 4) {
                    worldgenlevel.setBlock(blockpos$mutableblockpos, BAMBOO_FINAL_LARGE, 2);
                    worldgenlevel.setBlock(blockpos$mutableblockpos.move(Direction.DOWN, 1), BAMBOO_TOP_LARGE, 2);
                    worldgenlevel.setBlock(blockpos$mutableblockpos.move(Direction.DOWN, 1), BAMBOO_TOP_LARGE, 2);
                    worldgenlevel.setBlock(blockpos$mutableblockpos.move(Direction.DOWN, 1), BAMBOO_TOP_SMALL, 2);
                    worldgenlevel.setBlock(blockpos$mutableblockpos.move(Direction.DOWN, 1), BAMBOO_TOP_SMALL, 2);

                }
            }

            i++;
        }

        return i > 0;
    }
}