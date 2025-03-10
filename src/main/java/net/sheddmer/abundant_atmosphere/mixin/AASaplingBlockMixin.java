package net.sheddmer.abundant_atmosphere.mixin;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.init.AATags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SaplingBlock.class)
public class AASaplingBlockMixin extends BushBlock {

    // Modifies saplings to only grow on certain blocks under the sapling_grows_on tag, so they cannot grow on every block they are placed on.

    @Shadow
    public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {}

    protected AASaplingBlockMixin(Properties properties) {
        super(properties);
    }
    @Override
    public MapCodec<? extends SaplingBlock> codec() {
        return SaplingBlock.CODEC;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0 && level.getBlockState(pos.below()).is(AATags.SAPLING_GROWS_ON)) {
            this.advanceTree(level, pos, state, random);
        }
    }
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.below()).is(AATags.SAPLING_GROWS_ON);
    }
}