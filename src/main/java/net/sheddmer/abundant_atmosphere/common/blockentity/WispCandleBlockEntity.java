package net.sheddmer.abundant_atmosphere.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.common.init.AABlockEntityTypes;

public class WispCandleBlockEntity extends BlockEntity {

    public WispCandleBlockEntity(BlockPos pos, BlockState state) {
        super(AABlockEntityTypes.WISP_CANDLE.get(), pos, state);
    }

}