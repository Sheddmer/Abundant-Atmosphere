package net.sheddmer.abundant_atmosphere.common.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.sheddmer.abundant_atmosphere.common.block.MudLampBlock;
import net.sheddmer.abundant_atmosphere.common.block.StoneBrazierBlock;
import net.sheddmer.abundant_atmosphere.common.block.WallMudLampBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownPotion.class)
public abstract class AAThrownPotionMixin extends Entity {

    public AAThrownPotionMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At("TAIL"), method = "dowseFire")
    private void dowseFire(BlockPos pPos, CallbackInfo cir) {
        BlockState blockstate = this.level().getBlockState(pPos);
        if (MudLampBlock.isLit(blockstate)) {
            MudLampBlock.extinguish(null, blockstate, this.level(), pPos);
        } else if (WallMudLampBlock.isLit(blockstate)) {
            WallMudLampBlock.extinguish(null, blockstate, this.level(), pPos);
        } else if (StoneBrazierBlock.isLit(blockstate)){
            this.level().setBlockAndUpdate(pPos, blockstate.setValue(StoneBrazierBlock.LIT, Boolean.valueOf(false)));
        }
    }
}