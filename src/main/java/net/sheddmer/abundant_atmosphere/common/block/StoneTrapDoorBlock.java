package net.sheddmer.abundant_atmosphere.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sheddmer.abundant_atmosphere.common.init.AASounds;

import javax.annotation.Nullable;

public class StoneTrapDoorBlock extends TrapDoorBlock implements SimpleWaterloggedBlock {
    private final BlockSetType type;

    public StoneTrapDoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
        this.type = type;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false).setValue(HALF, Half.BOTTOM).setValue(POWERED, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (state.getValue(POWERED)) {
            level.playSound(null, pos, SoundEvents.DECORATED_POT_STEP, SoundSource.BLOCKS, 1.0F, 0.35F + level.getRandom().nextFloat() * 0.1F);
            player.displayClientMessage(Component.translatable("block.abundant_atmosphere.trapdoor.locked"), true);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            this.toggle(state, level, pos, player);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    private void toggle(BlockState state, Level level, BlockPos pos, @Nullable Player player) {
        BlockState blockstate = state.cycle(OPEN);
        level.setBlock(pos, blockstate, 2);
        if (blockstate.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        this.playSound(player, level, pos, blockstate.getValue(OPEN));
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            boolean flag = level.hasNeighborSignal(pos);
            if (flag != state.getValue(POWERED)) {
                this.playLockSound(null, level, pos, flag);
                level.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)), 2);
                if (state.getValue(WATERLOGGED)) {
                    level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
                }
            }
        }
    }

    protected void playLockSound(@Nullable Player player, Level level, BlockPos pos, boolean isOpened) {
        level.playSound(player, pos, isOpened ? AASounds.STONE_TRAPDOOR_LOCK.get() : AASounds.STONE_TRAPDOOR_UNLOCK.get(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
        level.gameEvent(player, isOpened ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = this.defaultBlockState();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Direction direction = context.getClickedFace();
        if (!context.replacingClickedOnBlock() && direction.getAxis().isHorizontal()) {
            blockstate = blockstate.setValue(FACING, direction)
                    .setValue(HALF, context.getClickLocation().y - (double)context.getClickedPos().getY() > 0.5 ? Half.TOP : Half.BOTTOM);
        } else {
            blockstate = blockstate.setValue(FACING, context.getHorizontalDirection().getOpposite())
                    .setValue(HALF, direction == Direction.UP ? Half.BOTTOM : Half.TOP);
        }

        if (context.getLevel().hasNeighborSignal(context.getClickedPos())) {
            blockstate = blockstate.setValue(POWERED, true);
        }

        return blockstate.setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    protected BlockSetType type() {
        return this.type;
    }
}
