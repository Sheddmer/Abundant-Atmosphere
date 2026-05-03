package net.sheddmer.abundant_atmosphere.common.mixin;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sheddmer.abundant_atmosphere.common.block.WaterLotusBlock;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AATags;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(WaterlilyBlock.class)
public class AALilypadBlockMixin extends BushBlock implements BonemealableBlock {
    @Unique
    private static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    @Unique
    private static final VoxelShape SHAPE = Block.box(1.0, -1.0, 1.0, 15.0, 0.0, 15.0);

    protected AALilypadBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    public MapCodec<WaterlilyBlock> codec() {
        return WaterlilyBlock.CODEC;
    }

    @Override
    protected void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
        super.entityInside(state, level, pos, entity);
        if (level instanceof ServerLevel && entity instanceof Boat || level instanceof ServerLevel && entity.getType().is(AATags.BREAK_THROUGH_LILY_PADS)) {
            level.destroyBlock(new BlockPos(pos), true, entity);
        }
    }

    @Override
    @NotNull
    protected VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        if (context instanceof EntityCollisionContext entitycollisioncontext) {
            Entity entity = entitycollisioncontext.getEntity();
            if (entity != null) {
                if (entity instanceof Boat || entity.getType().is(AATags.PASS_THROUGH_LILY_PADS)) {
                    return Shapes.empty();
                }
            }
        }
        return super.getCollisionShape(state, level, pos, context);
    }

    @Override
    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    @NotNull
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    @NotNull
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource source, BlockPos pos, @NotNull BlockState state) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        for (BlockPos blockPos : BlockPos.betweenClosed(x - 3, y - 1, z - 3, x + 3, y + 2, z + 3)) {
            if (source.nextFloat() < 0.2F && state.canSurvive(level, blockPos) && level.isEmptyBlock(blockPos)) {
                if (source.nextFloat() < 0.4F) {
                    level.setBlockAndUpdate(blockPos, Blocks.LILY_PAD.defaultBlockState().setValue(FACING, Direction.from2DDataValue(source.nextIntBetweenInclusive(0,3))));
                } else if (source.nextFloat() < 0.1F) {
                    WaterLotusBlock.placeAt(level, AABlocks.PINK_WATER_LOTUS.get().defaultBlockState(), blockPos, 2);
                } else if (source.nextFloat() < 0.03F) {
                    WaterLotusBlock.placeAt(level, AABlocks.VIOLET_WATER_LOTUS.get().defaultBlockState(), blockPos, 2);
                } else {
                    level.setBlockAndUpdate(blockPos, AABlocks.SMALL_LILY_PAD.get().defaultBlockState().setValue(FACING, Direction.from2DDataValue(source.nextIntBetweenInclusive(0,3))));
                }
            }
        }
        if (state.is(AABlocks.SMALL_LILY_PAD)) {
            level.setBlockAndUpdate(pos, Blocks.LILY_PAD.withPropertiesOf(state));
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
