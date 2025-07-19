package net.sheddmer.abundant_atmosphere.common.mixin;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangroveRootsBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MangroveRootsBlock.class)
public class AAMangroveRootsRotationMixin extends Block {
    @Shadow @Final public static BooleanProperty WATERLOGGED;
    private static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public AAMangroveRootsRotationMixin(Properties properties) {
        super(properties);
    }

    @Inject(at = @At("TAIL"), method = "<init>")
    public void MangroveRootsBlock(Properties properties, CallbackInfo ci) {
        this.registerDefaultState(this.getStateDefinition().any().setValue(AXIS, Direction.Axis.Y).setValue(WATERLOGGED, false));
    }


        @Override
    protected boolean skipRendering(BlockState state, BlockState blockState, Direction direction) {
        return blockState.is(Blocks.MANGROVE_ROOTS) && direction.getAxis() == state.getValue(AXIS);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return rotatePillar(state, rot);
    }

    private static BlockState rotatePillar(BlockState state, Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch (state.getValue(AXIS)) {
                    case X:
                        return state.setValue(AXIS, Direction.Axis.Z);
                    case Z:
                        return state.setValue(AXIS, Direction.Axis.X);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        return super.getStateForPlacement(context).setValue(WATERLOGGED, Boolean.valueOf(flag)).setValue(AXIS, context.getClickedFace().getAxis());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, WATERLOGGED);
    }
}
