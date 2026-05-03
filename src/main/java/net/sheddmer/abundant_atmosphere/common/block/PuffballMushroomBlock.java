package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AATags;
import org.jetbrains.annotations.NotNull;

public class PuffballMushroomBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(5.0, 0.0, 5.0, 11.0, 4.0, 11.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 6.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 6.0, 12.0),
            Block.box(3.0, 0.0, 3.0, 13.0, 7.0, 13.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0)};

    public PuffballMushroomBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    @Override
    @NotNull
    protected VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    @NotNull
    protected VoxelShape getCollisionShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        if (state.getValue(AGE) == 0 || state.getValue(AGE) == 1) {
            return Shapes.empty();
        }
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, @NotNull RandomSource source) {
        BlockState growthBlock = level.getBlockState(pos.below());
        if (state.getValue(AGE) < 4 && growthBlock.is(AATags.PUFFBALL_GROWS) && CommonHooks.canCropGrow(level, pos, state, source.nextInt(8) == 0)) {
            level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
        } else if (state.getValue(AGE) >= 4 && growthBlock.is(AATags.PUFFBALL_GROWS) && CommonHooks.canCropGrow(level, pos, state, source.nextInt(8) == 0)) {
            level.setBlock(pos, AABlocks.LARGE_PUFFBALL_MUSHROOM.get().defaultBlockState(), 2);
        }
    }

    @Override
    @NotNull
    protected BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState altState, @NotNull LevelAccessor accessor, @NotNull BlockPos pos, @NotNull BlockPos altPos) {
        return !this.canSurvive(state, accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, altState, accessor, pos, altPos);
    }

    @Override
    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader reader, BlockPos pos) {
        return Block.canSupportRigidBlock(reader, pos.below());
    }

    public void growFungus(Level level, BlockPos pos, BlockState state) {
        int i = state.getValue(AGE) + this.getBonemealAgeIncrease(level);
        int j = this.isMaxBonemeal();
        if (i > j) {
            i = 4;
        }
        level.setBlock(pos, state.setValue(AGE, i), 2);
    }

    protected int getBonemealAgeIncrease(Level pLevel) {
        return Mth.nextInt(pLevel.random, 1, 3);
    }

    public int isMaxBonemeal() {
        return 4;
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader reader, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource source, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource source, @NotNull BlockPos pos, BlockState state) {
        if (state.getValue(AGE) >= 4) {
            level.setBlock(pos, AABlocks.LARGE_PUFFBALL_MUSHROOM.get().defaultBlockState(), 1);
        } else {
            this.growFungus(level, pos, state);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}