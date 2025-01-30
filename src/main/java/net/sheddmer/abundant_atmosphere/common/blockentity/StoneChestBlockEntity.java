package net.sheddmer.abundant_atmosphere.common.blockentity;

import net.minecraft.core.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.init.AABlockEntityTypes;

public class StoneChestBlockEntity extends BlockEntity {

    public StoneChestBlockEntity(BlockPos pos, BlockState blockState) {
        super(AABlockEntityTypes.STONE_CHEST.get(), pos, blockState);
    }
}