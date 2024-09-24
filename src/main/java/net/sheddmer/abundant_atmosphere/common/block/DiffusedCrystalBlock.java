package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.sheddmer.abundant_atmosphere.init.AAProperties;

public class DiffusedCrystalBlock extends Block {
    public static final IntegerProperty DIFFUSED_LIGHT = AAProperties.DIFFUSED_LIGHT;

    public DiffusedCrystalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIFFUSED_LIGHT, 0));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIFFUSED_LIGHT);
    }
}
