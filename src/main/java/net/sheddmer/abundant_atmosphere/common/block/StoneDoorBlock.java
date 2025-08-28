package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.sheddmer.abundant_atmosphere.common.init.AASounds;

import javax.annotation.Nullable;

public class StoneDoorBlock extends DoorBlock {
    private final BlockSetType type;

    public StoneDoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
        this.type = type;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false).setValue(HINGE, DoorHingeSide.LEFT).setValue(POWERED, false).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (state.getValue(POWERED)) {
            level.playSound(null, pos, SoundEvents.DECORATED_POT_STEP, SoundSource.BLOCKS, 1.0F, 0.35F + level.getRandom().nextFloat() * 0.1F);
            player.displayClientMessage(Component.translatable("block.abundant_atmosphere.door.locked"), true);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            state = state.cycle(OPEN);
            level.setBlock(pos, state, 10);
            this.playSound(player, level, pos, state.getValue(OPEN));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        boolean flag = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.relative(state.getValue(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (!this.defaultBlockState().is(block) && flag != state.getValue(POWERED)) {
            this.playLockSound(null, level, pos, flag);
            level.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)), 2);
        }
    }

    protected void playSound(@Nullable Player player, Level level, BlockPos pos, boolean isOpened) {
        level.playSound(player, pos, isOpened ? this.type.doorOpen() : this.type.doorClose(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
        level.gameEvent(player, isOpened ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
    }

    protected void playLockSound(@Nullable Player player, Level level, BlockPos pos, boolean isOpened) {
        level.playSound(player, pos, isOpened ? AASounds.STONE_DOOR_LOCK.get() : AASounds.STONE_DOOR_UNLOCK.get(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
        level.gameEvent(player, isOpened ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
    }

    public BlockSetType type() {
        return this.type;
    }
}
