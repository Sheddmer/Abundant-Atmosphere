package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.sheddmer.abundant_atmosphere.common.entity.Nutling;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AAEntities;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class CarvedGourdnutBlock extends GourdnutBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    @Nullable
    private BlockPattern nutlingPattern;
    private static final Predicate<BlockState> GOURDNUT_PREDICATE = state -> state != null
            && (state.is(AABlocks.CARVED_GOURDNUT) || state.is(AABlocks.LAMP_O_GOURD));

    public CarvedGourdnutBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(HANGING, false).setValue(WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());

        for (Direction direction : context.getNearestLookingDirections()) {
            Direction rotation = direction.getOpposite();
            if (direction.getAxis().isHorizontal()) {
                BlockState blockstate = this.defaultBlockState().setValue(FACING, rotation).setValue(HANGING, context.getClickLocation().y - (double) context.getClickedPos().getY() > 0.5);
                if (blockstate.canSurvive(context.getLevel(), context.getClickedPos())) {
                    return blockstate.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
                }
            }
        }
        return null;
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(state.getBlock()) && !state.getValue(HANGING)) {
            this.trySpawnGolem(level, pos);
        }
    }

    private void trySpawnGolem(Level level, BlockPos pos) {
        BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = this.getOrCreateNutling().find(level, pos);
        if (blockpattern$blockpatternmatch != null) {
            Nutling nutling = AAEntities.NUTLING.get().create(level);
            if (nutling != null) {
                spawnGolemInWorld(level, blockpattern$blockpatternmatch, nutling, blockpattern$blockpatternmatch.getBlock(0, 1, 0).getPos());
            }
        }
    }

    private static void spawnGolemInWorld(Level level, BlockPattern.BlockPatternMatch patternMatch, Entity golem, BlockPos pos) {
        clearPatternBlocks(level, patternMatch);
        golem.moveTo((double)pos.getX() + 0.5, (double)pos.getY() + 0.05, (double)pos.getZ() + 0.5, 0.0F, 0.0F);
        level.addFreshEntity(golem);

        for (ServerPlayer serverplayer : level.getEntitiesOfClass(ServerPlayer.class, golem.getBoundingBox().inflate(5.0))) {
            CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, golem);
        }

        updatePatternBlocks(level, patternMatch);
    }

    public static void clearPatternBlocks(Level level, BlockPattern.BlockPatternMatch patternMatch) {
        for (int i = 0; i < patternMatch.getWidth(); i++) {
            for (int j = 0; j < patternMatch.getHeight(); j++) {
                BlockInWorld blockinworld = patternMatch.getBlock(i, j, 0);
                level.setBlock(blockinworld.getPos(), Blocks.AIR.defaultBlockState(), 2);
                level.levelEvent(2001, blockinworld.getPos(), Block.getId(blockinworld.getState()));
            }
        }
    }

    public static void updatePatternBlocks(Level level, BlockPattern.BlockPatternMatch patternMatch) {
        for (int i = 0; i < patternMatch.getWidth(); i++) {
            for (int j = 0; j < patternMatch.getHeight(); j++) {
                BlockInWorld blockinworld = patternMatch.getBlock(i, j, 0);
                level.blockUpdated(blockinworld.getPos(), Blocks.AIR);
            }
        }
    }

    private BlockPattern getOrCreateNutling() {
        if (this.nutlingPattern == null) {
            this.nutlingPattern = BlockPatternBuilder.start().aisle("^", "#")
                    .where('^', BlockInWorld.hasState(GOURDNUT_PREDICATE))
                    .where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK)))
                    .build();
        }
        return this.nutlingPattern;
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
    public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HANGING, WATERLOGGED);
    }
}
