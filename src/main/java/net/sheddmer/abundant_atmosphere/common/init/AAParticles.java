package net.sheddmer.abundant_atmosphere.common.init;


import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AAParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, AbundantAtmosphere.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FIREFLY = PARTICLES.register("firefly", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WISP_FLAME = PARTICLES.register("wisp_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DRIED_LEAF = PARTICLES.register("dried_leaf", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FALLING_MOSS = PARTICLES.register("falling_moss", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FALLING_RUST_MOSS = PARTICLES.register("falling_rust_moss", () -> new SimpleParticleType(false));

}