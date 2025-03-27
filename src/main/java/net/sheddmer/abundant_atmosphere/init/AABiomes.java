package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AABiomes {

    public static final ResourceKey<Biome> BASALT_HOT_SPRINGS = createKey("basalt_hot_springs");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
}
