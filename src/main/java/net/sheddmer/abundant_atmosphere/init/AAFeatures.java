package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AAFeatures {
    public static final ResourceKey<PlacedFeature> EMPTYTEST = registerPlacedFeature("emptytest");

    private static ResourceKey<PlacedFeature> registerPlacedFeature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
}
