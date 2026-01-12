package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.common.init.AATags;

public class CreepingCloverBlock extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    public static final BooleanProperty BLOOM = BlockStateProperties.BLOOM;
    private static final VoxelShape SHAPE = Shapes.or(box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0));
    private static final VoxelShape SHAPE_GROWN = Shapes.or(box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0), box(5.0, 4.0, 5.0, 11.0, 10.0, 11.0));

    public CreepingCloverBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0).setValue(BLOOM, true));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) == 5) {
            return SHAPE_GROWN;
        }
        return SHAPE;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        BlockState belowPos = level.getBlockState(pos.below());
        if (state.getValue(BLOOM) && belowPos.is(AATags.PLANT_PLACEABLE_ON) && source.nextInt(8) == 0) {
            if (state.getValue(AGE) == 2 || state.getValue(AGE) == 4) {
                level.setBlock(pos, state.setValue(BLOOM, false), 2);
            }
            level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState belowstate = reader.getBlockState(blockpos);
        if (AAConfig.PLANT_PLACEMENT.get()) {
            return belowstate.is(AATags.PLANT_PLACEABLE_ON);
        } else {
            return belowstate.is(BlockTags.DIRT);
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState altState, LevelAccessor accessor, BlockPos pos, BlockPos altPos) {
        return !this.canSurvive(state, accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, altState, accessor, pos, altPos);
    }

    public final boolean isMaxAge(BlockState state) {
        return state.getValue(AGE) == 5;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return state.getValue(BLOOM) && !this.isMaxAge(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, BLOOM);
    }
}