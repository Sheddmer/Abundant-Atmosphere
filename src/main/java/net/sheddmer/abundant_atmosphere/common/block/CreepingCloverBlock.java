package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CreepingCloverBlock extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    public static final BooleanProperty BLOOM = BlockStateProperties.BLOOM;
    private static final VoxelShape SHAPE = Shapes.or(box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0));
    private static final VoxelShape SHAPE_GROWN = Shapes.or(box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0), box(5.0, 4.0, 5.0, 11.0, 10.0, 11.0));

    public CreepingCloverBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(AGE)) {
            default:
                return SHAPE;
            case 5:
                return SHAPE_GROWN;
        }
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