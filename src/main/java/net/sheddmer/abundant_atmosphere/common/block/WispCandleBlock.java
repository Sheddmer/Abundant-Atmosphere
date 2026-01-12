package net.sheddmer.abundant_atmosphere.common.block;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;
import net.sheddmer.abundant_atmosphere.common.blockentity.WispCandleBlockEntity;
import net.sheddmer.abundant_atmosphere.common.init.AAParticleTypes;
import net.sheddmer.abundant_atmosphere.common.init.AAProperties;
import net.sheddmer.abundant_atmosphere.common.init.AASounds;

import javax.annotation.Nullable;
import java.util.List;

public class WispCandleBlock extends Block implements SimpleWaterloggedBlock {
    public static final MapCodec<WispCandleBlock> CODEC = simpleCodec(WispCandleBlock::new);
    public static final IntegerProperty CANDLES = BlockStateProperties.CANDLES;
    public static final BooleanProperty IGNITABLE = AAProperties.IGNITABLE;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE_ONE = Block.box(6.0, 0.0, 6.0, 10.0, 5.0, 10.0);
    private static final VoxelShape SHAPE_TWO = Block.box(4.0, 0.0, 4.0, 12.0, 5.0, 12.0);
    private static final VoxelShape SHAPE_THREE = Block.box(3.0, 0.0, 3.0, 13.0, 6.0, 13.0);
    private static final Int2ObjectMap<List<Vec3>> PARTICLE_OFFSETS = Util.make(() -> {
        Int2ObjectMap<List<Vec3>> int2objectmap = new Int2ObjectOpenHashMap<>();
        int2objectmap.defaultReturnValue(ImmutableList.of());
        int2objectmap.put(1, ImmutableList.of(new Vec3(0.5, 0.5, 0.5)));
        int2objectmap.put(2, ImmutableList.of(new Vec3(0.375, 0.375, 0.5625), new Vec3(0.625, 0.5, 0.375)));
        int2objectmap.put(3, ImmutableList.of(new Vec3(0.3125, 0.5625, 0.5625), new Vec3(0.5625, 0.5, 0.375), new Vec3(0.6875, 0.375, 0.625)));
        int2objectmap.put(4, ImmutableList.of(new Vec3(0.3125, 0.4375, 0.375), new Vec3(0.625, 0.5, 0.3125), new Vec3(0.375, 0.5625, 0.6875), new Vec3(0.6875, 0.375, 0.625)));
        return Int2ObjectMaps.unmodifiable(int2objectmap);
    });

    @Override
    protected MapCodec<WispCandleBlock> codec() {
        return CODEC;
    }

    public WispCandleBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(CANDLES, 1).setValue(IGNITABLE, false).setValue(LIT, false).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(CANDLES)) {
            case 1:
            default:
                return SHAPE_ONE;
            case 2:
                return SHAPE_TWO;
            case 3, 4:
                return SHAPE_THREE;
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!state.getValue(WATERLOGGED)) {
            if (player.getItemInHand(hand).is(Items.LAPIS_LAZULI) && !state.getValue(IGNITABLE) && !state.getValue(LIT)) {
                level.playLocalSound(pos, AASounds.DUST_LAPIS.get(), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                if (!level.isClientSide && !player.isCreative())
                    stack.consume(1, player);
                ParticleUtils.spawnParticles(level, pos, Mth.randomBetweenInclusive(RandomSource.create(), 8, 12), 0.5f, 0.3f, true, new DustParticleOptions(Vec3.fromRGB24(2117542).toVector3f(), 1.0f));
                level.setBlock(pos, state.setValue(IGNITABLE, true), 2);
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
            if (player.getItemInHand(hand).canPerformAction(ItemAbilities.FIRESTARTER_LIGHT) && state.getValue(IGNITABLE) && !state.getValue(LIT)) {
                if (stack.is(Items.FIRE_CHARGE)) {
                    level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (level.random.nextFloat() - level.random.nextFloat()) * 0.8F + 1.8F);
                    if (!level.isClientSide && !player.isCreative())
                        stack.consume(1, player);
                } else {
                    level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, (level.random.nextFloat() - level.random.nextFloat()) * 0.8F + 1.8F);
                }
                level.playLocalSound(pos, AASounds.WISP_CANDLE_ACTIVATE.get(), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                if (!level.isClientSide && !player.isCreative())
                    stack.hurtAndBreak(1, player, stack.getEquipmentSlot());
                ParticleUtils.spawnParticles(level, pos, Mth.randomBetweenInclusive(RandomSource.create(), 6, 10), 0.5f, 0.3f, true, new DustParticleOptions(Vec3.fromRGB24(8090367).toVector3f(), 1.0f));
                level.setBlock(pos, state.setValue(IGNITABLE, false).setValue(LIT, true), 2);
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
            if (player.getItemInHand(hand).canPerformAction(ItemAbilities.FIRESTARTER_LIGHT) && !state.getValue(IGNITABLE) && !state.getValue(LIT)) {
                player.displayClientMessage(Component.translatable("subtitles.abundant_atmosphere.wisp_candle.fail"), true);
                return ItemInteractionResult.FAIL;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        if (state.getValue(LIT)) {
            this.getParticleOffsets(state).forEach(position -> addParticlesAndSound(level, position.add((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()), source));
        }
    }

    private static void addParticlesAndSound(Level level, Vec3 offset, RandomSource source) {
        float f = source.nextFloat();
        if (f < 0.3F) {
            level.addParticle(ParticleTypes.SMOKE, offset.x, offset.y, offset.z, 0.0, 0.0, 0.0);
            if (f < 0.17F) {
                level.playLocalSound(offset.x + 0.5, offset.y + 0.5, offset.z + 0.5, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + source.nextFloat(), source.nextFloat() * 0.7F + 0.3F, false
                );
            }
        }
        if (f < 0.5F) {
            level.addParticle(AAParticleTypes.WISP_FLAME.get(), offset.x, offset.y, offset.z, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        if (!useContext.isSecondaryUseActive() && useContext.getItemInHand().is(this.asItem()) && state.getValue(CANDLES) < 4) {
            return true;
        }
        return super.canBeReplaced(state, useContext);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(CANDLES, Math.min(4, blockState.getValue(CANDLES) + 1));
        } else {
            FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
            boolean flag = fluidstate.getType() == Fluids.WATER;
            return super.getStateForPlacement(context).setValue(WATERLOGGED, Boolean.valueOf(flag));
        }
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS.get(state.getValue(CANDLES).intValue());
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CANDLES, IGNITABLE, LIT, WATERLOGGED);
    }
}
