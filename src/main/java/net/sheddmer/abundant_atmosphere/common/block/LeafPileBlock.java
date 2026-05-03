package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
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
import net.sheddmer.abundant_atmosphere.common.init.AAParticles;
import net.sheddmer.abundant_atmosphere.common.init.AAProperties;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

public class LeafPileBlock extends Block implements SimpleWaterloggedBlock {
    public static final IntegerProperty LEVEL = AAProperties.LEAF_LEVEL;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

    public LeafPileBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LEVEL, 1).setValue(WATERLOGGED, false));
    }

    @Override
    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Entity entity) {
        if (entity.getDeltaMovement().length() < 0.1F) return;
        if (!entity.onGround() && entity.getDeltaMovement().y > 0) return;
        Vec3 entityPos = entity.position();
        float radius = 0.5f;
        if (entityPos.distanceTo(new Vec3(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5)) > radius) return;
        if (level.random.nextFloat() < 0.3 && level.isClientSide) {
            level.addParticle(AAParticles.DRIED_LEAF.get(), entityPos.x, entityPos.y + 0.2, entityPos.z, Mth.randomBetween(level.random, -1.0F, 1.0F) * entity.getDeltaMovement().x, 0.05f, Mth.randomBetween(level.random, -1.0F, 1.0F) * entity.getDeltaMovement().z);
        }
        super.entityInside(state, level, pos, entity);
    }

    @SuppressWarnings("unused")
    protected boolean mayPlaceOn( BlockState state, BlockGetter level, BlockPos pos) {
        FluidState fluidstate = level.getFluidState(pos.below());
        FluidState fluidstate1 = level.getFluidState(pos);
        return Block.canSupportRigidBlock(level, pos.below()) || fluidstate.getType() == Fluids.WATER && fluidstate1.isEmpty();
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return this.mayPlaceOn(level.getBlockState(pos.below()), level, pos);
    }

    @Override
    @NotNull
    protected BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState altState, @NotNull LevelAccessor accessor, @NotNull BlockPos pos, @NotNull BlockPos altPos) {
        if (!this.canSurvive(state, accessor, pos)) {
            ParticleUtils.spawnParticles(accessor, pos, Mth.randomBetweenInclusive(RandomSource.create(), 10, 20), 0.5, 0.1, true, AAParticles.DRIED_LEAF.get());
        }
        return !this.canSurvive(state, accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, altState, accessor, pos, altPos);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockPos);
        BlockState state = context.getLevel().getBlockState(blockPos);
        if (state.is(this)) return state.setValue(LEVEL, Math.min(4, state.getValue(LEVEL) + 1));
        return this.defaultBlockState().setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @Override
    public boolean canBeReplaced(@NotNull BlockState state, BlockPlaceContext context) {
        if (!context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && state.getValue(LEVEL) < 4) {
            return true;
        }
        return super.canBeReplaced(state, context);
    }

    protected void onExplosionHit(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Explosion explosion, @NotNull BiConsumer<ItemStack, BlockPos> dropConsumer) {
        level.destroyBlock(pos, true);
        ParticleUtils.spawnParticles(level, pos, Mth.randomBetweenInclusive(RandomSource.create(), 10, 20), 0.5, 0.1, true, AAParticles.DRIED_LEAF.get());
        super.onExplosionHit(state, level, pos, explosion, dropConsumer);
    }

    @Override
    @NotNull
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void spawnDestroyParticles(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state) {
        ParticleUtils.spawnParticles(level, pos, Mth.randomBetweenInclusive(RandomSource.create(), 10, 20), 0.4, 0.1, true, AAParticles.DRIED_LEAF.get());
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType type) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEVEL, WATERLOGGED);
    }
}