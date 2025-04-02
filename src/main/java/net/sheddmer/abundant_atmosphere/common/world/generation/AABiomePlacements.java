package net.sheddmer.abundant_atmosphere.common.world.generation;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.init.AABiomes;

public class AABiomePlacements {
    public static void register() {

        if (AAConfig.BASALT_HOT_SPRINGS.get()) {
            BiomePlacement.replaceOverworld(Biomes.CHERRY_GROVE, AABiomes.BASALT_HOT_SPRINGS, 0.5);
        }

        if (AAConfig.ANCIENT_SPRING_CAVES.get()) {
            BiomePlacement.addOverworld(AABiomes.ANCIENT_SPRING_CAVES,
                    Climate.parameters(
                            Climate.Parameter.span(-0.1F, 0.9F),
                            Climate.Parameter.span(-1F, 0.1F),
                            Climate.Parameter.span(-0.1F, 1F),
                            Climate.Parameter.span(0.25F, 1F),
                            Climate.Parameter.span(0.8F, 2F),
                            Climate.Parameter.span(-0.6F, 0.4F),
                            0F));
        }

    }
}