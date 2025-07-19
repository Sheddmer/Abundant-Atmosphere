package net.sheddmer.abundant_atmosphere.common.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.common.init.AATags;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BushBlock.class)
public class AABushBlockMixin extends Block {

    // These changes are being done to expand the amount of blocks most plants can be placed on using the plant_placeable_on tag. It should not modify how they function, just where they can be placed.

    public AABushBlockMixin(Properties properties) {
        super(properties);
    }
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        if (AAConfig.PLANT_PLACEMENT.get()) {
            return state.is(AATags.PLANT_PLACEABLE_ON) || state.getBlock() instanceof net.minecraft.world.level.block.FarmBlock;
        } else {
            return state.is(BlockTags.DIRT) || state.getBlock() instanceof FarmBlock;
        }
    }
}