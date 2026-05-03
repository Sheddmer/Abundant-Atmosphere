package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sheddmer.abundant_atmosphere.common.init.AATags;
import org.jetbrains.annotations.NotNull;

public class LargePuffballMushroomBlock extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
            Block.box(2.0, 0.0, 2.0, 14.0, 5.0, 14.0),
            Block.box(2.0, 0.0, 2.0, 14.0, 5.0, 14.0)};

    public LargePuffballMushroomBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    @Override
    @NotNull
    protected VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    @NotNull
    protected VoxelShape getCollisionShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    public final boolean isNotMaxAge(BlockState state) {
        return state.getValue(AGE) != 5;
    }

    @Override
    protected void randomTick(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (this.isNotMaxAge(state) && level.getBlockState(pos.below()).is(AATags.PUFFBALL_GROWS)) {
            if (level.random.nextFloat() < 0.05) {
                level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
            }
        }
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, BlockState state, @NotNull Entity entity) {
        if (state.getValue(AGE) >= 4 && entity instanceof Player) {
            level.destroyBlock(pos, true, entity);
            ParticleUtils.spawnParticlesOnBlockFaces(level, pos, new DustParticleOptions(Vec3.fromRGB24(8677966).toVector3f(), 2.0f), UniformInt.of(4, 12));
        } else if (entity instanceof Ravager && net.neoforged.neoforge.event.EventHooks.canEntityGrief(level, entity)) {
            level.destroyBlock(pos, true, entity);
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    @NotNull
    protected BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState altState, @NotNull LevelAccessor accessor, @NotNull BlockPos pos, @NotNull BlockPos altPos) {
        return !this.canSurvive(state, accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, altState, accessor, pos, altPos);
    }

    @Override
    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader reader, BlockPos pos) {
        return Block.canSupportRigidBlock(reader, pos.below());
    }

    @Override
    protected boolean isRandomlyTicking(@NotNull BlockState state) {
        return this.isNotMaxAge(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}