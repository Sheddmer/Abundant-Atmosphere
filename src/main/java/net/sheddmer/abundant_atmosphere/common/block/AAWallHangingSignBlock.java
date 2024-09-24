package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.sheddmer.abundant_atmosphere.common.blockentity.AAHangingSignBlockEntity;

public class AAWallHangingSignBlock extends WallHangingSignBlock {
    public AAWallHangingSignBlock(Properties properties, WoodType type) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
        return new AAHangingSignBlockEntity(pos, state);
    }
}