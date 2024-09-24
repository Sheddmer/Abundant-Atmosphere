package net.sheddmer.abundant_atmosphere.common.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WallMudLampBlock extends MudLampBlock {
    private static final VoxelShape SHAPE_NORTH = Shapes.or(box(6.0, 4.0, 12.0, 10.0, 6.0, 16.0), box(4.0, 6.0, 8.0, 12.0, 10.0, 16.0), box(7.0, 8.0, 7.0, 9.0, 10.0,8.0));
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(box(6.0, 4.0, 0.0, 10.0, 6.0, 4.0), box(4.0, 6.0, 0.0, 12.0, 10.0, 8.0), box(7.0, 8.0, 8.0, 9.0, 10.0, 9.0));
    private static final VoxelShape SHAPE_EAST = Shapes.or(box(0.0, 4.0, 6.0, 4.0, 6.0, 10.0), box(0.0, 6.0, 4.0, 8.0, 10.0, 12.0), box(8.0, 8.0, 7.0, 9.0, 10.0, 9.0));
    private static final VoxelShape SHAPE_WEST = Shapes.or(box(12.0, 4.0, 6.0, 16.0, 6.0, 10.0), box(8.0, 6.0, 4.0, 16.0, 10.0, 12.0), box(7.0, 8.0, 7.0, 8.0, 10.0, 9.0));

    public WallMudLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, false).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
            default:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());

        for (Direction direction : context.getNearestLookingDirections()) {
            Direction rotation = direction.getOpposite();
            if (direction.getAxis().isHorizontal()) {
                BlockState blockstate = this.defaultBlockState().setValue(FACING, rotation);
                if (blockstate.canSurvive(context.getLevel(), context.getClickedPos())) {
                    return blockstate.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
                }
            }
        }
        return null;
    }

    protected static Direction getConnectedDirection(BlockState state) {
        return state.getValue(FACING);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        Direction direction = getConnectedDirection(state).getOpposite();
        return Block.canSupportCenter(reader, pos.relative(direction), direction.getOpposite());
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor accessor, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            accessor.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(accessor));
        }
        return getConnectedDirection(state).getOpposite() == direction && !state.canSurvive(accessor, pos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, direction, neighborState, accessor, pos, neighborPos);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        Direction direction = state.getValue(FACING);
        double d0 = (double) pos.getX() + 0.5;
        double d1 = (double) pos.getY() + 0.6;
        double d2 = (double) pos.getZ() + 0.5;
        Direction direction1 = direction.getOpposite();
        float f = source.nextFloat();
        if (state.getValue(LIT)) {
            if (f < 0.3F) {
                level.addParticle(ParticleTypes.SMOKE, d0 + 0.27 * (double) direction1.getStepX(), d1 + 0.22, d2 + 0.27 * (double) direction1.getStepZ(), 0.0, 0.0, 0.0);
                if (f < 0.17F) {
                    level.playLocalSound(d0 + 0.27 * (double) direction1.getStepX(), d1 + 0.22, d2 + 0.27 * (double) direction1.getStepZ(), SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + source.nextFloat(), source.nextFloat() * 0.7F + 0.3F, false
                    );
                }
            }
            level.addParticle(ParticleTypes.FLAME, d0 + 0.27 * (double) direction1.getStepX(), d1 + 0.22, d2 + 0.27 * (double) direction1.getStepZ(), 0.0, 0.0, 0.0);
        }
    }

}
