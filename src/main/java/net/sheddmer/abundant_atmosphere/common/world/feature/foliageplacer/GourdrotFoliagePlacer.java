package net.sheddmer.abundant_atmosphere.common.world.feature.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.sheddmer.abundant_atmosphere.common.init.AAFoliagePlacerTypes;

public class GourdrotFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<GourdrotFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(gourdrotFoliagePlacerInstance -> foliagePlacerParts(gourdrotFoliagePlacerInstance).apply(gourdrotFoliagePlacerInstance, GourdrotFoliagePlacer::new));

    public GourdrotFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return AAFoliagePlacerTypes.GOURDROT_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {

    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return false;
    }
}
