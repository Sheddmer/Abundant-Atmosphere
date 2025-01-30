package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.sheddmer.abundant_atmosphere.init.AAProperties;
import net.sheddmer.abundant_atmosphere.init.AATags;

public class MossyBasaltBlock extends RotatedPillarBlock {
    public static final BooleanProperty OVERGROWN = AAProperties.OVERGROWN;

    public MossyBasaltBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AXIS, Direction.Axis.Y).setValue(OVERGROWN, false));
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.UP ? state.setValue(OVERGROWN, isOvergrownSetting(facingState)) : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
    private static boolean isOvergrownSetting(BlockState state) {
        return state.is(AATags.MOSSY_BASALT_OVERGROWABLE);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, OVERGROWN);
    }
}