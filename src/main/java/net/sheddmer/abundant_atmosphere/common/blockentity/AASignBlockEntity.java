package net.sheddmer.abundant_atmosphere.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.init.AABlockEntityTypes;

public class AASignBlockEntity extends SignBlockEntity {
    public AASignBlockEntity(BlockPos pos, BlockState state) {
        super(AABlockEntityTypes.AA_SIGN.get(), pos,state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return AABlockEntityTypes.AA_SIGN.get();
    }
}
