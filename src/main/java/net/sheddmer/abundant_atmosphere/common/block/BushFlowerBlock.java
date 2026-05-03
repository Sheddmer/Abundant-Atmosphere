package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class BushFlowerBlock extends FlowerBlock {
    protected static final VoxelShape SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 10.0, 13.0);

    public BushFlowerBlock(Holder<MobEffect> effect, float seconds, Properties properties) {
        super(effect, seconds, properties);
    }

    @Override
    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }
}