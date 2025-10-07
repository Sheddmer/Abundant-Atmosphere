package net.sheddmer.abundant_atmosphere.common.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.sheddmer.abundant_atmosphere.common.init.AAParticleTypes;
import net.sheddmer.abundant_atmosphere.common.init.AAProperties;

import java.util.List;

public class MidnightLilyBlock extends BushBlock implements BonemealableBlock, SuspiciousEffectHolder {
    protected static final MapCodec<SuspiciousStewEffects> EFFECTS_FIELD = SuspiciousStewEffects.CODEC.fieldOf("suspicious_stew_effects");
    public static final MapCodec<MidnightLilyBlock> CODEC = RecordCodecBuilder.mapCodec(
            p_308824_ -> p_308824_.group(EFFECTS_FIELD.forGetter(MidnightLilyBlock::getSuspiciousEffects), propertiesCodec()).apply(p_308824_, MidnightLilyBlock::new)
    );
    private static final VoxelShape SHAPE_ONE = Block.box(5.0, 0.0, 5.0, 11.0, 10.0, 11.0);
    private static final VoxelShape SHAPE_TWO = Block.box(3.0, 0.0, 3.0, 13.0, 10.0, 12.0);
    private static final VoxelShape SHAPE_THREE = Block.box(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
    public static final IntegerProperty FLOWER_STACK = AAProperties.FLOWER_AMOUNT_3;
    public static final BooleanProperty NIGHTLIGHT = AAProperties.NIGHTLIGHT;
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    private final SuspiciousStewEffects suspiciousStewEffects;

    public MidnightLilyBlock(SuspiciousStewEffects suspiciousStewEffects, Properties properties) {
        super(properties);
        this.suspiciousStewEffects = suspiciousStewEffects;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FLOWER_STACK, 1).setValue(NIGHTLIGHT, false).setValue(PERSISTENT, false));
    }

    public MidnightLilyBlock(Holder<MobEffect> effect, float seconds, BlockBehaviour.Properties properties) {
        this(makeEffectList(effect, seconds), properties);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        boolean night = level.isNight();
        if (!state.getValue(PERSISTENT) && state.getValue(NIGHTLIGHT) != night) {
            level.setBlock(pos, state.setValue(NIGHTLIGHT, night), 2);
        }
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (itemAbility == ItemAbilities.SHEARS_TRIM && !state.getValue(PERSISTENT)) {
            return state.setValue(PERSISTENT, true).setValue(NIGHTLIGHT, false);
        }
        return null;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        super.animateTick(state, level, pos, source);
        int h = state.getValue(FLOWER_STACK);
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        if (!state.getValue(PERSISTENT) && state.getValue(NIGHTLIGHT)) {
            if (source.nextFloat() < 0.5F * h) {
                blockpos$mutableblockpos.set(i + Mth.nextInt(source, h * -5, h * 5), j + Mth.nextInt(source, h * -5, h * 5), k + Mth.nextInt(source, h * -5, h * 5));
                level.addParticle(AAParticleTypes.FIREFLY.get(), (double) blockpos$mutableblockpos.getX() + source.nextDouble(), (double) blockpos$mutableblockpos.getY() + source.nextDouble(), (double) blockpos$mutableblockpos.getZ() + source.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        if (!useContext.isSecondaryUseActive() && useContext.getItemInHand().is(this.asItem()) && state.getValue(FLOWER_STACK) < 3) {
            return true;
        }
        return super.canBeReplaced(state, useContext);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(level, pos);
        switch (state.getValue(FLOWER_STACK)) {
            case 1:
            default:
                return SHAPE_ONE.move(vec3.x, vec3.y, vec3.z);
            case 2:
                return SHAPE_TWO.move(vec3.x, vec3.y, vec3.z);
            case 3:
                return SHAPE_THREE.move(vec3.x, vec3.y, vec3.z);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(FLOWER_STACK, Math.min(3, blockState.getValue(FLOWER_STACK) + 1));
        }
        return this.defaultBlockState();
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int i = state.getValue(FLOWER_STACK);
        if (i < 3) {
            level.setBlock(pos, state.setValue(FLOWER_STACK, i + 1), 2);
        } else {
            popResource(level, pos, new ItemStack(this));
        }
    }

    protected static SuspiciousStewEffects makeEffectList(Holder<MobEffect> effect, float seconds) {
        return new SuspiciousStewEffects(List.of(new SuspiciousStewEffects.Entry(effect, Mth.floor(seconds * 20.0F))));
    }

    @Override
    public SuspiciousStewEffects getSuspiciousEffects() {
        return this.suspiciousStewEffects;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FLOWER_STACK, NIGHTLIGHT, PERSISTENT);
    }
}