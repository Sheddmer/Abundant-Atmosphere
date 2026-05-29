package net.sheddmer.abundant_atmosphere.common.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.common.init.AATags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BushBlock.class)
public class AABushBlockMixin extends Block {

    // These changes are being done to expand the amount of blocks most plants can be placed on using the plant_placeable_on tag. It should not modify how they function, just where they can be placed.

    public AABushBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "mayPlaceOn", at = @At("RETURN"), cancellable = true)
    protected void mayPlaceOnPlantPlaceable(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BushBlock bushBlock = (BushBlock)(Object) this;
        boolean isSapling = bushBlock instanceof SaplingBlock;
        if (AAConfig.PLANT_PLACEMENT.isTrue() && state.is(AATags.PLANT_PLACEABLE) && !isSapling) cir.setReturnValue(true);
    }
}