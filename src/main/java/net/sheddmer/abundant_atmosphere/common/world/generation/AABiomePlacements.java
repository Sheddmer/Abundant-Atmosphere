package net.sheddmer.abundant_atmosphere.common.world.generation;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.world.level.biome.Climate;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.common.init.AABiomes;

public class AABiomePlacements {
    public static void register() {

        if (AAConfig.ERODED_BASALT_JUNGLE.get()) {
            BiomePlacement.addOverworld(AABiomes.ERODED_BAMBOO_JUNGLE,
                    Climate.parameters(
                            Climate.Parameter.span(0.2F, 0.55F),
                            Climate.Parameter.span(0.2F, 0.9F),
                            Climate.Parameter.span(0.0F, 0.35F),
                            Climate.Parameter.span(-0.05F, 0.35F),
                            Climate.Parameter.span(0.0F, 0.0F),
                            Climate.Parameter.span(0.2F, 0.65F),
                            0.0F));
        }

        if (AAConfig.GEOTHERMAL_GARDEN.get()) {
            BiomePlacement.addOverworld(AABiomes.GEOTHERMAL_GARDEN,
                    Climate.parameters(
                            Climate.Parameter.span(-0.1F, 0.9F),
                            Climate.Parameter.span(-1.0F, 0.1F),
                            Climate.Parameter.span(-0.1F, 1.0F),
                            Climate.Parameter.span(0.25F, 1.0F),
                            Climate.Parameter.span(0.85F, 2.0F),
                            Climate.Parameter.span(-0.6F, 0.4F),
                            0.0F));
        }
    }
}
