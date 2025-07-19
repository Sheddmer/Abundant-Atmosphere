package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AATags;

public class RedBambooSaplingBlock extends Block implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 12.0, 12.0);

    public RedBambooSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(level, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(3) == 0 && level.isEmptyBlock(pos.above()) && level.getRawBrightness(pos.above(), 0) >= 9) {
            this.growBamboo(level, pos);
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        net.neoforged.neoforge.common.util.TriState soilDecision = level.getBlockState(pos.below()).canSustainPlant(level, pos.below(), net.minecraft.core.Direction.UP, state);
        if (!soilDecision.isDefault()) return soilDecision.isTrue();
        return level.getBlockState(pos.below()).is(AATags.RED_BAMBOO_PLANTABLE_ON);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (!state.canSurvive(level, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (facing == Direction.UP && facingState.is(AABlocks.RED_BAMBOO)) {
                level.setBlock(currentPos, AABlocks.RED_BAMBOO.get().defaultBlockState(), 2);
            }
            return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        }
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(AABlocks.RED_BAMBOO);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.growBamboo(level, pos);
    }

    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return player.getMainHandItem().canPerformAction(net.neoforged.neoforge.common.ItemAbilities.SWORD_DIG) ? 1.0F : super.getDestroyProgress(state, player, level, pos);
    }

    protected void growBamboo(Level level, BlockPos state) {
        level.setBlock(state.above(), AABlocks.RED_BAMBOO.get().defaultBlockState().setValue(RedBambooStalkBlock.LEAVES, BambooLeaves.SMALL), 3);
    }
}
