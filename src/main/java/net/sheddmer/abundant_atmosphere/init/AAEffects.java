package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.effect.WispGuardMobEffect;

public class AAEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, AbundantAtmosphere.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> WISP_GUARD = MOB_EFFECTS.register("wisp_guard", () -> new WispGuardMobEffect(MobEffectCategory.BENEFICIAL, 4738376));

}
