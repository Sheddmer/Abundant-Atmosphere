package net.sheddmer.abundant_atmosphere.integration.biolith;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.world.level.biome.Biomes;
import net.sheddmer.abundant_atmosphere.init.AABiomes;

public class AABiomeIntegration {
    public static void registerBiomes() {

        BiomePlacement.replaceOverworld(
                Biomes.DEEP_DARK,
                AABiomes.AMBER_CAVERNS,
                0.5
        );

    }
}
