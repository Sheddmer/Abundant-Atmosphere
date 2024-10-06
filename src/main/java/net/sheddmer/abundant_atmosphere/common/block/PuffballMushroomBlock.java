package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sheddmer.abundant_atmosphere.init.AABlocks;
import net.sheddmer.abundant_atmosphere.init.AAParticleTypes;
import net.sheddmer.abundant_atmosphere.init.AAProperties;
import net.sheddmer.abundant_atmosphere.init.AATags;
import org.checkerframework.checker.units.qual.A;

public class PuffballMushroomBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(5.0, 0.0, 5.0, 11.0, 4.0, 11.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 6.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 6.0, 12.0),
            Block.box(3.0, 0.0, 3.0, 13.0, 7.0, 13.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0)
    };

    public PuffballMushroomBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) == 0 || state.getValue(AGE) == 1) {
            return Shapes.empty();
        }
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getBlockState(pos.below()).is(AATags.PUFFBALL_GROW_ON)) {
            if (level.random.nextFloat() < 0.05) {
                if (state.getValue(AGE) == 4) {
                    level.setBlock(pos, AABlocks.LARGE_PUFFBALL_MUSHROOM.get().defaultBlockState(), 2);
                } else level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
            }
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState altState, LevelAccessor accessor, BlockPos pos, BlockPos altPos) {
        return !this.canSurvive(state, accessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, altState, accessor, pos, altPos);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return Block.canSupportRigidBlock(reader, pos.below());
    }

    public void growFungus(Level level, BlockPos pos, BlockState state) {
        int i = state.getValue(AGE) + this.getBonemealAgeIncrease(level);
        int j = this.isMaxBonemeal();
        if (i > j) {
            i = j;
        }

        level.setBlock(pos, state.setValue(AGE, i), 2);
    }

    protected int getBonemealAgeIncrease(Level pLevel) {
        return Mth.nextInt(pLevel.random, 1, 3);
    }

    public int isMaxBonemeal() {
        return 4;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource source, BlockPos pos, BlockState state) {
        this.growFungus(level, pos, state);
    }

        @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
