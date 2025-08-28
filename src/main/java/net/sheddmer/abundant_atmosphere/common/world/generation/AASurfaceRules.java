package net.sheddmer.abundant_atmosphere.common.world.generation;

import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.init.AABiomes;

public class AASurfaceRules {
    private static final SurfaceRules.RuleSource COARSE_DIRT = SurfaceRules.state(Blocks.COARSE_DIRT.defaultBlockState());

    public static void register() {
        SurfaceRules.RuleSource eroded_basalt_jungle = SurfaceRules.ifTrue(SurfaceRules.isBiome(AABiomes.ERODED_BAMBOO_JUNGLE), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.0), COARSE_DIRT)));

        SurfaceGeneration.addOverworldSurfaceRules(
                ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "rules/overworld"),
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(eroded_basalt_jungle)))
        );
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double value) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, value / 8.25, Double.MAX_VALUE);
    }
}