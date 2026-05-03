package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class CatsbaneBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 14.0, 14.0);

    public CatsbaneBlock(Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader reader, BlockPos pos) {
        return Block.canSupportRigidBlock(reader, pos.below());
    }
}