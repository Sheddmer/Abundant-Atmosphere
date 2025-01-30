package net.sheddmer.abundant_atmosphere.mixin;

import net.minecraft.core.Holder;
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
import net.sheddmer.abundant_atmosphere.common.entity.frogvariant.AAFrogVariants;
import net.sheddmer.abundant_atmosphere.init.AATags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Frog.class)
public abstract class AAFrogVariantMixin extends Animal {
    @Shadow
    public abstract void setVariant(Holder<FrogVariant> variant);
    protected AAFrogVariantMixin(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At("TAIL"), method = "finalizeSpawn")
    private void finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance instance, MobSpawnType type, SpawnGroupData data, CallbackInfoReturnable<SpawnGroupData> cir) {
        Holder<Biome> holder = accessor.getBiome(this.blockPosition());
        if (holder.is(AATags.SPAWNS_TROPICAL_VARIANT_FROGS)) {
            setVariant(AAFrogVariants.TROPICAL);
        } else if (holder.is(AATags.SPAWNS_BUDGETT_VARIANT_FROGS)) {
            setVariant(AAFrogVariants.BUDGETT);
        }
    }
}