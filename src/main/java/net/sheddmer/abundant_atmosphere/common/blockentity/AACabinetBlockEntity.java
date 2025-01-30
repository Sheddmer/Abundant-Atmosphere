package net.sheddmer.abundant_atmosphere.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.init.AABlockEntityTypes;
import vectorwing.farmersdelight.common.block.entity.CabinetBlockEntity;

public class AACabinetBlockEntity extends CabinetBlockEntity {
    public AACabinetBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public BlockEntityType<?> getType() {
        return AABlockEntityTypes.AA_CABINET.get();
    }
}
