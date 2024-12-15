package net.sheddmer.abundant_atmosphere.common.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.kinds.Kind1;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

public class MudLampBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape SHAPE_NORTH = Shapes.or(box(4.0, 0.0, 4.0, 12.0, 4.0, 12.0), box(7.0, 2.0, 3.0, 9.0, 4.0, 4.0));
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(box(4.0, 0.0, 4.0, 12.0, 4.0, 12.0), box(7.0, 2.0, 12.0, 9.0, 4.0, 13.0));
    private static final VoxelShape SHAPE_EAST = Shapes.or(box(4.0, 0.0, 4.0, 12.0, 4.0, 12.0), box(12.0, 2.0, 7.0, 13.0, 4.0, 9.0));
    private static final VoxelShape SHAPE_WEST = Shapes.or(box(4.0, 0.0, 4.0, 12.0, 4.0, 12.0), box(3.0, 2.0, 7.0, 4.0, 4.0, 9.0));

    public MudLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, false).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
            default:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());

        for (Direction direction : context.getNearestLookingDirections()) {
            Direction rotation = direction.getOpposite();
            if (direction.getAxis().isHorizontal()) {
                BlockState blockstate = this.defaultBlockState().setValue(FACING, rotation);
                if (blockstate.canSurvive(context.getLevel(), context.getClickedPos())) {
                    return blockstate.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
                }
            }
        }
        return null;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return canSupportCenter(reader, pos.below(), Direction.UP);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState altState, LevelAccessor accessor, BlockPos pos, BlockPos altPos) {
        return direction == Direction.DOWN && !this.canSurvive(state, accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, altState, accessor, pos, altPos);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        float f = source.nextFloat();
        if (state.getValue(LIT)) {
            if (f < 0.3F) {
                level.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.45, pos.getY() + 0.5, 0.0, 0.0, 0.0);
                if (f < 0.17F) {
                    level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getY() + 0.5, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + source.nextFloat(), source.nextFloat() * 0.7F + 0.3F, false);
                }
            }
            level.addParticle(ParticleTypes.FLAME,  pos.getX() + 0.5, pos.getY() + 0.45, pos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult result, Projectile projectile) {
        if (!level.isClientSide && projectile.isOnFire() && !state.getValue(LIT)) {
            setLit(level, state, result.getBlockPos(), true);
        }
    }

    @Override
    public boolean placeLiquid(LevelAccessor pLevel, BlockPos pPos, BlockState pState, FluidState pFluidState) {
        if (!pState.getValue(WATERLOGGED) && pFluidState.getType() == Fluids.WATER) {
            BlockState blockstate = pState.setValue(WATERLOGGED, Boolean.valueOf(true));
            if (pState.getValue(LIT)) {
                extinguish(null, blockstate, pLevel, pPos);
            } else {
                pLevel.setBlock(pPos, blockstate, 3);
            }

            pLevel.scheduleTick(pPos, pFluidState.getType(), pFluidState.getType().getTickDelay(pLevel));
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (pStack.isEmpty() && pPlayer.getAbilities().mayBuild && pState.getValue(LIT)) {
            extinguish(pPlayer, pState, pLevel, pPos);
            return ItemInteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
        }
    }

    public static void extinguish(@Nullable Player pPlayer, BlockState state, LevelAccessor accessor, BlockPos pos) {
        setLit(accessor, state, pos, false);
        accessor.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.25, pos.getY() + 0.5, 0.0, 0.0, 0.0);
        accessor.playSound(null, pos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
        accessor.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pos);
    }

    private static void setLit(LevelAccessor accessor, BlockState state, BlockPos pos, boolean litState) {
        accessor.setBlock(pos, state.setValue(LIT, Boolean.valueOf(litState)), 11);
    }

    public static boolean isLit(BlockState state) {
        return state.hasProperty(LIT) && state.getValue(LIT);
    }

    @Override
    protected void onExplosionHit(BlockState state, Level level, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> consumer) {
        if (explosion.canTriggerBlocks() && state.getValue(LIT)) {
            extinguish(null, state, level, pos);
        }
        super.onExplosionHit(state, level, pos, explosion, consumer);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT, FACING, WATERLOGGED);
    }
}
