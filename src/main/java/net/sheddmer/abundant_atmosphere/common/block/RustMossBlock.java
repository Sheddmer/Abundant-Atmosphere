package net.sheddmer.abundant_atmosphere.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.common.init.AAFeatures;
import net.sheddmer.abundant_atmosphere.common.init.AAParticleTypes;

import java.util.function.BiConsumer;

public class RustMossBlock extends Block implements BonemealableBlock {
    public static final MapCodec<RustMossBlock> CODEC = simpleCodec(RustMossBlock::new);

    @Override
    public MapCodec<RustMossBlock> codec() {
        return CODEC;
    }

    public RustMossBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.registryAccess()
                .registry(Registries.CONFIGURED_FEATURE)
                .flatMap(features -> features.getHolder(AAFeatures.PATCH_RUST_MOSS_BONEMEAL))
                .ifPresent(var -> var.value().place(level, level.getChunkSource().getGenerator(), random, pos.above()));
    }

    protected void onExplosionHit(BlockState state, Level level, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> dropConsumer) {
        BlockPos abovePos = pos.above();
        if (RandomSource.create().nextFloat() <= 0.25 && level.getBlockState(pos.above()).canBeReplaced()) {
            level.setBlockAndUpdate(abovePos, BaseFireBlock.getState(level, pos.above().relative(Direction.DOWN)));
        }
        super.onExplosionHit(state, level, pos, explosion, dropConsumer);
    }

    @Override
    public BonemealableBlock.Type getType() {
        return BonemealableBlock.Type.NEIGHBOR_SPREADER;
    }


}
