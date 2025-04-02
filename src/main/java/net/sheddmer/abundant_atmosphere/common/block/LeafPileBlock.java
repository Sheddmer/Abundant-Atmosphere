package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sheddmer.abundant_atmosphere.init.AAParticleTypes;
import net.sheddmer.abundant_atmosphere.init.AAProperties;

import javax.annotation.Nullable;
import java.util.Vector;
import java.util.function.BiConsumer;

public class LeafPileBlock extends Block implements SimpleWaterloggedBlock {
    public static final IntegerProperty LEVEL = AAProperties.LEAF_LEVEL;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE_ONE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    private static final VoxelShape SHAPE_TWO = Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);

    public LeafPileBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(LEVEL)) {
            case 1:
            default:
                return SHAPE_ONE;
            case 2:
                return SHAPE_TWO;
        }
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity.getDeltaMovement().length() < 0.1F) return;
        if (!entity.onGround() && entity.getDeltaMovement().y > 0) return;
        if (state.getValue(WATERLOGGED)) return;
        Vec3 entityPos = entity.position();
        float radius = 0.5f;
        if (entityPos.distanceTo(new Vec3(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5)) > radius) return;
        if (level.random.nextFloat() < 0.3 && level.isClientSide) {
            level.addParticle(AAParticleTypes.DRIED_LEAF.get(), entityPos.x, entityPos.y + 0.2, entityPos.z, Mth.randomBetween(level.random, -1.0F, 1.0F) * entity.getDeltaMovement().x, 0.05f, Mth.randomBetween(level.random, -1.0F, 1.0F) * entity.getDeltaMovement().z);
        }
        super.entityInside(state, level, pos, entity);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return Block.canSupportRigidBlock(level, pos.below());
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState altState, LevelAccessor accessor, BlockPos pos, BlockPos altPos) {
        if (!this.canSurvive(state, accessor, pos)) {
            ParticleUtils.spawnParticles(accessor, pos, Mth.randomBetweenInclusive(RandomSource.create(), 10, 20), 0.5, 0.1, true, AAParticleTypes.DRIED_LEAF.get());
        }
        return !this.canSurvive(state, accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, altState, accessor, pos, altPos);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(LEVEL, Math.min(2, blockState.getValue(LEVEL) + 1));
        }
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        if (!useContext.isSecondaryUseActive() && useContext.getItemInHand().is(this.asItem()) && state.getValue(LEVEL) < 2) {
            return true;
        }
        return super.canBeReplaced(state, useContext);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected void onExplosionHit(BlockState state, Level level, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> dropConsumer) {
        level.destroyBlock(pos, true);
        ParticleUtils.spawnParticles(level, pos, Mth.randomBetweenInclusive(RandomSource.create(), 10, 20), 0.5, 0.1, true, AAParticleTypes.DRIED_LEAF.get());
        super.onExplosionHit(state, level, pos, explosion, dropConsumer);
    }

    @Override
    protected void spawnDestroyParticles(Level level, Player player, BlockPos pos, BlockState state) {
        level.levelEvent(player, 2001, pos, getId(state));
        ParticleUtils.spawnParticles(level, pos, Mth.randomBetweenInclusive(RandomSource.create(), 10, 20), 0.4, 0.1, true, AAParticleTypes.DRIED_LEAF.get());
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEVEL, WATERLOGGED);
    }
}