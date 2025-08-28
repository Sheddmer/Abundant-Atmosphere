package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AABiomes {

    public static final ResourceKey<Biome> ERODED_BAMBOO_JUNGLE = createKey("eroded_bamboo_jungle");
    public static final ResourceKey<Biome> GEOTHERMAL_GARDEN = createKey("geothermal_garden");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
}