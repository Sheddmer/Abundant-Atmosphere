package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.sheddmer.abundant_atmosphere.common.init.AASounds;
import net.sheddmer.abundant_atmosphere.common.init.AATags;

import javax.annotation.Nullable;

public class StoneBrazierBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Shapes.or(box(2.0, 0.0, 2.0, 14.0, 2.0, 14.0), box(0.0, 2.0, 0.0, 16.0, 8.0, 16.0));
    private static final VoxelShape SHAPE_HANGING = Block.box(0.0, 2.0, 0.0, 16.0, 8.0, 16.0);
    private final int fireDamage;

    public StoneBrazierBlock(int fireDamage, Properties properties) {
        super(properties);
        this.fireDamage = fireDamage;
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, true).setValue(HANGING, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return state.getValue(HANGING) ? SHAPE_HANGING : SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor levelaccessor = context.getLevel();
        boolean flag = levelaccessor.getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                BlockState blockstate = this.defaultBlockState().setValue(HANGING, Boolean.valueOf(direction == Direction.UP));
                if (blockstate.canSurvive(context.getLevel(), context.getClickedPos())) {
                    return blockstate.setValue(WATERLOGGED, flag).setValue(LIT, !flag);
                }
            }
        }
        return null;
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (itemAbility == ItemAbilities.FIRESTARTER_LIGHT && canLight(state)) {
            return state.setValue(LIT, true);
        }
        if (itemAbility == ItemAbilities.SHOVEL_DOUSE && state.getValue(LIT)) {
            return state.setValue(LIT, false);
        }
        return null;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        if (state.getValue(HANGING)) {
            return Block.canSupportCenter(reader, pos.above(), Direction.DOWN);
        } else {
            return true;
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState altState, LevelAccessor accessor, BlockPos pos, BlockPos altPos) {
        return direction == Direction.UP && !this.canSurvive(state, accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, altState, accessor, pos, altPos);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (state.getValue(LIT) && entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().campfire(), (float)this.fireDamage);
        }
        super.entityInside(state, level, pos, entity);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        if (state.getValue(LIT)) {
            if (source.nextInt(10) == 0) {
                level.playLocalSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, AASounds.BRAZIER_CRACKLES.get(), SoundSource.BLOCKS, 0.5F + source.nextFloat(), source.nextFloat() * 0.7F + 0.6F, false);
            }
            if (source.nextInt(5) == 0) {
                level.addParticle(ParticleTypes.LARGE_SMOKE, (double) pos.getX() + Mth.randomBetween(source, 0.25F, 0.75F), (double) pos.getY() + 0.6, (double) pos.getZ() + Mth.randomBetween(source, 0.25F, 0.75F), 0, 0.0F, 0);
            }
        }
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            boolean flag = state.getValue(LIT);
            if (flag) {
                if (!level.isClientSide()) {
                    level.playSound(null, pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
                if (level.isClientSide()) {
                    level.addParticle(ParticleTypes.LARGE_SMOKE, (double) pos.getX() + Mth.randomBetween(RandomSource.create(), 0.25F, 0.75F), (double) pos.getY() + 0.6, (double) pos.getZ() + Mth.randomBetween(RandomSource.create(), 0.25F, 0.75F), 0, 0.0F, 0);
                }
            }
            level.setBlock(pos, state.setValue(WATERLOGGED, Boolean.valueOf(true)).setValue(LIT, Boolean.valueOf(false)), 3);
            level.scheduleTick(pos, fluidState.getType(), fluidState.getType().getTickDelay(level));
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        BlockPos blockpos = hit.getBlockPos();
        if (!level.isClientSide && projectile.isOnFire() && projectile.mayInteract(level, blockpos) && !state.getValue(LIT) && !state.getValue(WATERLOGGED)) {
            level.setBlock(blockpos, state.setValue(LIT, true), 11);
        }
    }

    public static boolean isLit(BlockState state) {
        return state.hasProperty(LIT) && state.getValue(LIT);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    public static boolean canLight(BlockState state) {
        return state.is(AATags.STONE_BRAZIERS, stateBase -> stateBase.hasProperty(WATERLOGGED) && stateBase.hasProperty(LIT))
                && !state.getValue(WATERLOGGED)
                && !state.getValue(LIT);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, HANGING, WATERLOGGED);
    }
}
