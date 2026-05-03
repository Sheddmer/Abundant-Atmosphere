package net.sheddmer.abundant_atmosphere.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.IShearable;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AATags;
import org.jetbrains.annotations.NotNull;

public class CaveSproutsBlock extends BushBlock implements IShearable, BonemealableBlock {
    public static final MapCodec<CaveSproutsBlock> CODEC = simpleCodec(CaveSproutsBlock::new);
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);
    protected static final VoxelShape SHAPE_SHORT = Block.box(2.0, 0.0, 2.0, 14.0, 6.0, 14.0);

    @Override
    @NotNull
    public MapCodec<CaveSproutsBlock> codec() {
        return CODEC;
    }

    public CaveSproutsBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(AATags.CAVE_PLANT_PLACEABLE);
    }

    @Override
    @NotNull
    protected VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        if (state.is(AABlocks.SHORT_CAVE_SPROUTS)) {
            return SHAPE_SHORT;
        }
        return SHAPE;
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, BlockState state) {
        return state.is(AABlocks.SHORT_CAVE_SPROUTS);
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        level.setBlockAndUpdate(pos, AABlocks.CAVE_SPROUTS.get().defaultBlockState());
    }
}