package net.sheddmer.abundant_atmosphere.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.init.AABlockEntityTypes;

public class AAHangingSignBlockEntity extends HangingSignBlockEntity {
    public AAHangingSignBlockEntity (BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return AABlockEntityTypes.AA_HANGING_SIGN.get();
    }
}