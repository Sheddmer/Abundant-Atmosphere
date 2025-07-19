package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.world.feature.HugePoreshroomFeature;
import net.sheddmer.abundant_atmosphere.common.world.feature.OverworldDeltaFeature;
import net.sheddmer.abundant_atmosphere.common.world.feature.RedBambooFeature;

import java.util.function.Supplier;

public class AAFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, AbundantAtmosphere.MODID);

    public static final Supplier<Feature<ProbabilityFeatureConfiguration>> RED_BAMBOO = FEATURES.register("red_bamboo", () -> new RedBambooFeature(ProbabilityFeatureConfiguration.CODEC));
    public static final Supplier<Feature<DeltaFeatureConfiguration>> DELTA_OVERWORLD = FEATURES.register("delta_overworld", () -> new OverworldDeltaFeature(DeltaFeatureConfiguration.CODEC));
    public static final Supplier<Feature<HugeMushroomFeatureConfiguration>> HUGE_PORESHROOM = FEATURES.register("huge_poreshroom", () -> new HugePoreshroomFeature(HugeMushroomFeatureConfiguration.CODEC));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUST_MOSS_PATCH_BONEMEAL = registerConfiguredFeature("rust_moss_patch_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_SPROUTS_PATCH = registerConfiguredFeature("cave_sprouts_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_PORESHROOM_CHECKED = registerConfiguredFeature("huge_poreshroom_checked");

    public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
}