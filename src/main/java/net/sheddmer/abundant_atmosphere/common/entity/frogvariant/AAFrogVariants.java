package net.sheddmer.abundant_atmosphere.common.entity.frogvariant;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.animal.FrogVariant;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AAFrogVariants {
    public static final DeferredRegister<FrogVariant> FROG_VARIANTS = DeferredRegister.create(BuiltInRegistries.FROG_VARIANT, AbundantAtmosphere.MODID);
    public static final DeferredHolder<FrogVariant, FrogVariant> TROPICAL = FROG_VARIANTS.register("tropical", () -> new FrogVariant(AbundantAtmosphere.location("textures/entity/frog/tropical_frog.png")));
    public static final DeferredHolder<FrogVariant, FrogVariant> BUDGETT = FROG_VARIANTS.register("budgett", () -> new FrogVariant(AbundantAtmosphere.location("textures/entity/frog/budgett_frog.png")));
}