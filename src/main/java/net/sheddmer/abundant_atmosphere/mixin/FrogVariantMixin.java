package net.sheddmer.abundant_atmosphere.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.sheddmer.abundant_atmosphere.common.entity.frog.AAFrogVariants;
import net.sheddmer.abundant_atmosphere.init.AATags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Frog.class)
public abstract class FrogVariantMixin extends Animal {
    @Shadow
    public abstract void setVariant(Holder<FrogVariant> variant);
    protected FrogVariantMixin(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(at = @At("TAIL"), method = "finalizeSpawn")
    private void finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, SpawnGroupData pSpawnGroupData, CallbackInfoReturnable<SpawnGroupData> cir) {
        Holder<Biome> holder = pLevel.getBiome(this.blockPosition());
        if (holder.is(AATags.SPAWNS_TROPICAL_VARIANT_FROGS)) {
            setVariant(AAFrogVariants.TROPICAL);
        } else if (holder.is(AATags.SPAWNS_BUDGETT_VARIANT_FROGS)) {
            setVariant(AAFrogVariants.BUDGETT);
        }
    }
}
