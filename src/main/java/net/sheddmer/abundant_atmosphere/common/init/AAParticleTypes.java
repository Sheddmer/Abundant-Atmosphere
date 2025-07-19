package net.sheddmer.abundant_atmosphere.common.init;


import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AAParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, AbundantAtmosphere.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FIREFLY = PARTICLE_TYPES.register("firefly", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WISP_FLAME = PARTICLE_TYPES.register("wisp_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DRIED_LEAF = PARTICLE_TYPES.register("dried_leaf", () -> new SimpleParticleType(false));

}
