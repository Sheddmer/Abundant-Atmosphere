package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WallFungusBlock extends Block implements BonemealableBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape SHAPE_NORTH = Shapes.or(box(4.0, 0.0, 5.0, 12.0, 16.0, 16.0));
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(box(4.0, 0.0, 0.0, 12.0, 16.0, 11.0));
    private static final VoxelShape SHAPE_EAST = Shapes.or(box(0.0, 0.0, 4.0, 11.0, 16.0, 12.0));
    private static final VoxelShape SHAPE_WEST = Shapes.or(box(5.0, 0.0, 4.0, 16.0, 16.0, 12.0));

    public WallFungusBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
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
        for (Direction direction : context.getNearestLookingDirections()) {
            Direction rotation = direction.getOpposite();
            if (direction.getAxis().isHorizontal()) {
                BlockState blockstate = this.defaultBlockState().setValue(FACING, rotation);
                if (blockstate.canSurvive(context.getLevel(), context.getClickedPos())) {
                    return blockstate;
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
        return getConnectedDirection(state).getOpposite() == direction && !state.canSurvive(accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, accessor, pos, neighborPos);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.above()).isAir() && this.canSurvive(state, level, pos.above()) || level.getBlockState(pos.below()).isAir() && this.canSurvive(state, level, pos.below()) || level.getBlockState(pos.above()).canBeReplaced() && this.canSurvive(state, level, pos.above()) || level.getBlockState(pos.below()).canBeReplaced() && this.canSurvive(state, level, pos.below());
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (level.getBlockState(pos.above()).isAir() && this.canSurvive(state, level, pos.above()) || level.getBlockState(pos.above()).canBeReplaced() && this.canSurvive(state, level, pos.above())) {
            level.setBlock(pos.above(), state, 2);
        } else if (level.getBlockState(pos.below()).isAir() && this.canSurvive(state, level, pos.below()) || level.getBlockState(pos.below()).canBeReplaced() && this.canSurvive(state, level, pos.below())) {
            level.setBlock(pos.below(), state, 2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
