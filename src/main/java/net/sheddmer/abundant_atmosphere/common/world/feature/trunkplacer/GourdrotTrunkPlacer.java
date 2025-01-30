package net.sheddmer.abundant_atmosphere.common.world.feature.trunkplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.sheddmer.abundant_atmosphere.init.AATrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;

public class GourdrotTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<GourdrotTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(gourdrotTrunkPlacerInstance -> trunkPlacerParts(gourdrotTrunkPlacerInstance).apply(gourdrotTrunkPlacerInstance, GourdrotTrunkPlacer::new));


    public GourdrotTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);


    }

    @Override
    protected TrunkPlacerType<?> type() {
        return AATrunkPlacerTypes.GOURDROT_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource source, int pFreeTreeHeight, BlockPos pos, TreeConfiguration config) {



        return null;
    }
}
