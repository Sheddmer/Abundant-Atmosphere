package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.common.init.AATags;

public class LightlessSaplingBlock extends SaplingBlock {
    public LightlessSaplingBlock(TreeGrower grower, Properties properties) {
        super(grower, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (AAConfig.PLANT_PLACEMENT.get()) {
            if (level.getMaxLocalRawBrightness(pos.above()) >= 0 && source.nextInt(7) == 0 && level.getBlockState(pos.below()).is(AATags.SAPLING_GROWS_ON)) {
                this.advanceTree(level, pos, state, source);
            }
        } else if (level.getMaxLocalRawBrightness(pos.above()) >= 0 && source.nextInt(7) == 0) {
            this.advanceTree(level, pos, state, source);
        }
    }
}