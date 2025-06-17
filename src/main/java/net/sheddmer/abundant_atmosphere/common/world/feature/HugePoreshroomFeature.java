package net.sheddmer.abundant_atmosphere.common.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugePoreshroomFeature extends AbstractHugeMushroomFeature {
    public HugePoreshroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected void makeCap(LevelAccessor level, RandomSource random, BlockPos pos, int treeHeight, BlockPos.MutableBlockPos mutablePos, HugeMushroomFeatureConfiguration config) {
        int i = config.foliageRadius;

        for (int j = -i; j <= i; j++) {
            for (int k = -i; k <= i; k++) {
                boolean flag = j == -i;
                boolean flag1 = j == i;
                boolean flag2 = k == -i;
                boolean flag3 = k == i;
                boolean flag4 = flag || flag1;
                boolean flag5 = flag2 || flag3;
                if (!flag4 || !flag5) {
                    mutablePos.setWithOffset(mutablePos, j, treeHeight, k);
                    if (!level.getBlockState(mutablePos).isSolidRender(level, mutablePos)) {
                        boolean flag6 = flag || flag5 && j == 1 - i;
                        boolean flag7 = flag1 || flag5 && j == i - 1;
                        boolean flag8 = flag2 || flag4 && k == 1 - i;
                        boolean flag9 = flag3 || flag4 && k == i - 1;
                        BlockState blockstate = config.capProvider.getState(random, pos);
                        if (blockstate.hasProperty(HugeMushroomBlock.WEST)
                                && blockstate.hasProperty(HugeMushroomBlock.EAST)
                                && blockstate.hasProperty(HugeMushroomBlock.NORTH)
                                && blockstate.hasProperty(HugeMushroomBlock.SOUTH)) {
                            blockstate = blockstate.setValue(HugeMushroomBlock.WEST, Boolean.valueOf(flag6))
                                    .setValue(HugeMushroomBlock.EAST, Boolean.valueOf(flag7))
                                    .setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(flag8))
                                    .setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(flag9));
                        }
                        this.setBlock(level, mutablePos, blockstate);
                    }
                }
            }
        }
    }

    @Override
    protected int getTreeRadiusForHeight(int p_65094_, int height, int foliageRadius, int y) {
        return y <= 3 ? 0 : foliageRadius;
    }
}
