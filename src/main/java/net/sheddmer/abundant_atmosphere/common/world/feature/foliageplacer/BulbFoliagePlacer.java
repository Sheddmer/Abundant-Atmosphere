package net.sheddmer.abundant_atmosphere.common.world.feature.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.sheddmer.abundant_atmosphere.common.init.AAFoliagePlacerTypes;

public class BulbFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<BulbFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(bulbFoliagePlacerInstance -> foliagePlacerParts(bulbFoliagePlacerInstance).apply(bulbFoliagePlacerInstance, BulbFoliagePlacer::new));

    public BulbFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return AAFoliagePlacerTypes.BULB_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource source, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        boolean flag = attachment.doubleTrunk();
        BlockPos blockpos = attachment.pos().above(offset);

        this.placeLeavesRow(level, blockSetter, source, config, blockpos, foliageRadius + attachment.radiusOffset(), -2, flag);
        this.placeLeavesRow(level, blockSetter, source, config, blockpos, foliageRadius + attachment.radiusOffset(), -1, flag);
        this.placeLeavesRow(level, blockSetter, source, config, blockpos, foliageRadius + attachment.radiusOffset(), 0, flag);
        this.placeLeavesRow(level, blockSetter, source, config, blockpos, foliageRadius - 1, 1, flag);

    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {return 4;}

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return localY == -2 ? (localX > 1 || localZ > 1) && localX != 0 && localZ != 0 : localX == range && localZ == range && range > 0 && localY > -1;
    }
}