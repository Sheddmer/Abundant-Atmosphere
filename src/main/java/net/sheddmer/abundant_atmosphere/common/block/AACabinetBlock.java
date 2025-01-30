package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.sheddmer.abundant_atmosphere.common.blockentity.AACabinetBlockEntity;
import net.sheddmer.abundant_atmosphere.init.AABlockEntityTypes;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.entity.CabinetBlockEntity;

public class AACabinetBlock extends CabinetBlock {
    public AACabinetBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockEntity tile = level.getBlockEntity(pos);
            if (tile instanceof AACabinetBlockEntity) {
                player.openMenu((CabinetBlockEntity)tile);
            }
        }

        return InteractionResult.SUCCESS;
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof AACabinetBlockEntity) {
            ((CabinetBlockEntity)tileEntity).recheckOpen();
        }

    }

    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return AABlockEntityTypes.AA_CABINET.get().create(pos, state);
    }
}
