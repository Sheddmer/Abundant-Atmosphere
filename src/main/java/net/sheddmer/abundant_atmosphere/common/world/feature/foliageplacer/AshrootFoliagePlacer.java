package net.sheddmer.abundant_atmosphere.common.world.feature.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.sheddmer.abundant_atmosphere.init.AAFoliagePlacerTypes;

public class AshrootFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<AshrootFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(ashrootFoliagePlacerInstance -> foliagePlacerParts(ashrootFoliagePlacerInstance).apply(ashrootFoliagePlacerInstance, AshrootFoliagePlacer::new));

    public AshrootFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return AAFoliagePlacerTypes.ASHROOT_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource source, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        this.placeLeavesRow(level, blockSetter, source, config, attachment.pos().above(-2), 2, 0, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, source, config, attachment.pos().above(-1), 2, 0, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, source, config, attachment.pos().above(0), 2, 0, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, source, config, attachment.pos().above(1), 1, 0, attachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {return 4;}

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return localX > 1 && localZ > 1;
    }
}
