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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MangroveRootsBlock.class)
public class AAMangroveRootsRotationMixin extends Block {
    // this mixin changes Mangrove Roots more significantly by adding built in rotation support for the block. this does override certain aspects like the placement and skiprendering method.
    @Shadow
    @Final
    public static BooleanProperty WATERLOGGED;
    private static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public AAMangroveRootsRotationMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void MangroveRootsRotatingBlock(Properties properties, CallbackInfo cir) {
        this.registerDefaultState(this.getStateDefinition().any().setValue(AXIS, Direction.Axis.Y).setValue(WATERLOGGED, false));
    }

    @Inject(method = "skipRendering", at = @At("TAIL"), cancellable = true)
    protected void skipRenderingForRotation(BlockState state, BlockState blockState, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if (blockState.is(Blocks.MANGROVE_ROOTS) && direction.getAxis() == state.getValue(AXIS)) cir.setReturnValue(true);
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



    @Inject(method = "createBlockStateDefinition", at = @At("TAIL"))
    protected void createRotationBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(AXIS);
    }
}