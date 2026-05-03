package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AAFeatures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CaveCrudBlock extends Block implements BonemealableBlock {

    public CaveCrudBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(@NotNull BlockState state, @NotNull UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (itemAbility.equals(ItemAbilities.SHOVEL_FLATTEN)) {
            if (context.getClickedFace() != Direction.DOWN && context.getLevel().getBlockState(context.getClickedPos().above()).canBeReplaced()) {
                return AABlocks.CAVE_CRUD_PATH.get().defaultBlockState();
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, @NotNull BlockState state) {
        return level.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(features -> features.getHolder(AAFeatures.PATCH_CAVE_SPROUTS))
                .ifPresent(feature -> feature.value().place(level, level.getChunkSource().getGenerator(), random, pos.above()));
    }

    @Override
    @NotNull
    public BonemealableBlock.Type getType() {
        return BonemealableBlock.Type.NEIGHBOR_SPREADER;
    }
}