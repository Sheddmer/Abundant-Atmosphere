package net.sheddmer.abundant_atmosphere.common.world.generation;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.world.level.biome.Biomes;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.init.AABiomes;

public class AABiomePlacements {
    public static void register() {

        if (AAConfig.BASALT_HOT_SPRINGS.get()) {
            BiomePlacement.replaceOverworld(Biomes.CHERRY_GROVE, AABiomes.BASALT_HOT_SPRINGS, 0.5);
        }

    }
}