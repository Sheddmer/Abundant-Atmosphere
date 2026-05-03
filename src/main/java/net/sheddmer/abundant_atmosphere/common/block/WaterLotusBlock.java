package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class WaterLotusBlock extends Block implements BonemealableBlock, SimpleWaterloggedBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 12.0, 15.0);
    private static final VoxelShape SHAPE_BUD = Block.box(3.0, 0.0, 3.0, 13.0, 12.0, 13.0);
    private static final VoxelShape SHAPE_ROOTS = Block.box(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);

    public WaterLotusBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 1).setValue(HALF, DoubleBlockHalf.UPPER).setValue(WATERLOGGED, false));
    }

    @Override
    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return SHAPE_ROOTS;
        }
        else if (state.getValue(AGE) == 0) {
            return SHAPE_BUD;
        }
        else return SHAPE;
    }

    @Override
    @NotNull
    protected BlockState updateShape(BlockState state, Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (facing.getAxis() != Direction.Axis.Y
                || doubleblockhalf == DoubleBlockHalf.LOWER != (facing == Direction.UP)
                || facingState.is(this) && facingState.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(level, currentPos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, @NotNull ItemStack stack) {
        BlockPos blockpos = pos.below();
        level.setBlock(blockpos, state.setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, true), 3);
    }

    public static void placeAt(LevelAccessor level, BlockState state, BlockPos pos, int flags) {
        BlockPos blockpos = pos.below();
        level.setBlock(pos, state.setValue(AGE, 0), flags);
        level.setBlock(blockpos, state.setValue(AGE, 0).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, true), flags);
    }

    @SuppressWarnings("unused")
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        FluidState fluidstate = level.getFluidState(pos.below());
        FluidState fluidstate1 = level.getFluidState(pos);
        return fluidstate.getType() == Fluids.WATER && fluidstate1.isEmpty();
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return this.mayPlaceOn(level.getBlockState(pos.below()), level, pos);
    }

    @Override
    @NotNull
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(true) : super.getFluidState(state);
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, BlockState state) {
        return state.getValue(AGE) != 2;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource source, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource source, @NotNull BlockPos pos, BlockState state) {
        int i = state.getValue(AGE);
        if (i < 2) {
            if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
                level.setBlock(pos.above(), this.defaultBlockState().setValue(AGE, 2), 3);
                level.setBlock(pos, withPropertiesOf(state).setValue(AGE, 2), 3);
            } else {
                level.setBlock(pos, withPropertiesOf(state).setValue(AGE, 2), 3);
                level.setBlock(pos.below(), state.setValue(AGE, 2).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, true), 3);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, HALF, WATERLOGGED);
    }
}