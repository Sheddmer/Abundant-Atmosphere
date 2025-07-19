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
import net.sheddmer.abundant_atmosphere.common.init.AATrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;

public class AshrootTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<AshrootTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(ashrootTrunkPlacerInstance -> trunkPlacerParts(ashrootTrunkPlacerInstance).apply(ashrootTrunkPlacerInstance, AshrootTrunkPlacer::new));

    public AshrootTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return AATrunkPlacerTypes.ASHROOT_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        return List.of();
    }
}
