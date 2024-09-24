package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.sheddmer.abundant_atmosphere.common.blockentity.AAHangingSignBlockEntity;

public class AACeilingHangingSignBlock extends CeilingHangingSignBlock {
    public AACeilingHangingSignBlock(Properties properties, WoodType type) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AAHangingSignBlockEntity(pos, state);
    }
}
