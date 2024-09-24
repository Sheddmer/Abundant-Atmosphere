package net.sheddmer.abundant_atmosphere.common.block;

import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sheddmer.abundant_atmosphere.common.blockentity.StoneChestBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class StoneChestBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape NS_SHAPE = Block.box(0.0, 0.0, 1.0, 16.0, 14.0, 15.0);
    private static final VoxelShape EW_SHAPE = Block.box(1.0, 0.0, 0.0, 15.0, 14.0, 16.0);
    protected final Supplier<BlockEntityType> blockEntityType;
    private static final DoubleBlockCombiner.Combiner<StoneChestBlockEntity, Optional<Container>> CHEST_COMBINER = new DoubleBlockCombiner.Combiner<StoneChestBlockEntity, Optional<Container>>() {
        public Optional<Container> acceptDouble(StoneChestBlockEntity chestBlock, StoneChestBlockEntity chestBlockAlt) {return Optional.of(new CompoundContainer(chestBlock, chestBlockAlt));}
        public Optional<Container> acceptSingle(StoneChestBlockEntity chestBlock) {return Optional.of(chestBlock);}
        public Optional<Container> acceptNone() {return Optional.empty();}};
    private static final DoubleBlockCombiner.Combiner<StoneChestBlockEntity, Optional<MenuProvider>> MENU_PROVIDER_COMBINER = new DoubleBlockCombiner.Combiner<StoneChestBlockEntity, Optional<MenuProvider>>() {
        public Optional<MenuProvider> acceptDouble(final StoneChestBlockEntity chestBlock, final StoneChestBlockEntity chestContainer) {
            final Container container = new CompoundContainer(chestBlock, chestContainer);
            return Optional.of(new MenuProvider() {
                @javax.annotation.Nullable
                @Override
                public AbstractContainerMenu createMenu(int p_51622_, Inventory p_51623_, Player p_51624_) {
                    if (chestBlock.canOpen(p_51624_) && chestContainer.canOpen(p_51624_)) {
                        chestBlock.unpackLootTable(p_51623_.player);
                        chestContainer.unpackLootTable(p_51623_.player);
                        return ChestMenu.sixRows(p_51622_, p_51623_, container);
                    } else {
                        return null;
                    }
                }
                @Override
                public Component getDisplayName() {
                    if (chestBlock.hasCustomName()) {
                        return chestBlock.getDisplayName();
                    } else {
                        return (Component)(chestContainer.hasCustomName() ? chestContainer.getDisplayName() : Component.translatable("container.abundant_atmosphere.stone_chest.large"));
                    }
                }
            });
        }
        public Optional<MenuProvider> acceptSingle(StoneChestBlockEntity entity) {return Optional.of(entity);}
        public Optional<MenuProvider> acceptNone() {return Optional.empty();}
    };

    public StoneChestBlock(Properties properties, Supplier<BlockEntityType> blockEntityType) {
        super(properties);
        this.blockEntityType = blockEntityType;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(TYPE, ChestType.SINGLE).setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends StoneChestBlock> codec() {
        return codec();
    }

    public BlockEntityType<? extends StoneChestBlockEntity> blockEntityType() {
        return this.blockEntityType.get();
    }

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
        ChestType chestType = state.getValue(TYPE);
        if (chestType == ChestType.SINGLE) {
            return DoubleBlockCombiner.BlockType.SINGLE;
        } else {
            return chestType == ChestType.RIGHT ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        return direction.getAxis() == Direction.Axis.X ? EW_SHAPE : NS_SHAPE;
    }

    public static Direction getConnectedDirection(BlockState state) {
        Direction direction = state.getValue(FACING);
        return state.getValue(TYPE) == ChestType.LEFT ? direction.getClockWise() : direction.getCounterClockWise();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        ChestType chesttype = ChestType.SINGLE;
        Direction direction = context.getHorizontalDirection().getOpposite();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag = context.isSecondaryUseActive();
        Direction direction1 = context.getClickedFace();
        if (direction1.getAxis().isHorizontal() && flag) {
            Direction direction2 = this.candidatePartnerFacing(context, direction1.getOpposite());
            if (direction2 != null && direction2.getAxis() != direction1.getAxis()) {
                direction = direction2;
                chesttype = direction2.getCounterClockWise() == direction1.getOpposite() ? ChestType.RIGHT : ChestType.LEFT;
            }
        }
        if (chesttype == ChestType.SINGLE && !flag) {
            if (direction == this.candidatePartnerFacing(context, direction.getClockWise())) {
                chesttype = ChestType.LEFT;
            } else if (direction == this.candidatePartnerFacing(context, direction.getCounterClockWise())) {
                chesttype = ChestType.RIGHT;
            }
        }
        return this.defaultBlockState()
                .setValue(FACING, direction)
                .setValue(TYPE, chesttype)
                .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @javax.annotation.Nullable
    private Direction candidatePartnerFacing(BlockPlaceContext context, Direction direction) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction));
        return blockstate.is(this) && blockstate.getValue(TYPE) == ChestType.SINGLE ? blockstate.getValue(FACING) : null;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        Containers.dropContentsOnDestroy(state, newState, level, pos);
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult result) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            MenuProvider menuprovider = this.getMenuProvider(state, level, pos);
            if (menuprovider != null) {
                player.openMenu(menuprovider);
                player.awardStat(this.getOpenChestStat());
                PiglinAi.angerNearbyPiglins(player, true);
            }
            return InteractionResult.CONSUME;
        }
    }

    protected Stat<ResourceLocation> getOpenChestStat() {
        return Stats.CUSTOM.get(Stats.OPEN_CHEST);
    }

    @javax.annotation.Nullable
    public static Container getContainer(StoneChestBlock pChest, BlockState pState, Level pLevel, BlockPos pPos, boolean pOverride) {
        return pChest.combine(pState, pLevel, pPos, pOverride).apply(CHEST_COMBINER).orElse(null);
    }

    public DoubleBlockCombiner.NeighborCombineResult<? extends StoneChestBlockEntity> combine(
            BlockState pState, Level pLevel, BlockPos pPos, boolean pOverride
    ) {
        BiPredicate<LevelAccessor, BlockPos> bipredicate;
        if (pOverride) {
            bipredicate = (p_51578_, p_51579_) -> false;
        } else {
            bipredicate = StoneChestBlock::isChestBlockedAt;
        }

        return DoubleBlockCombiner.combineWithNeigbour(
                this.blockEntityType.get(), StoneChestBlock::getBlockType, StoneChestBlock::getConnectedDirection, FACING, pState, pLevel, pPos, bipredicate
        );
    }

    @javax.annotation.Nullable
    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return this.combine(state, level, pos, false).apply(MENU_PROVIDER_COMBINER).orElse(null);
    }
    public static DoubleBlockCombiner.Combiner<StoneChestBlockEntity, Float2FloatFunction> opennessCombiner(final LidBlockEntity pLid) {
        return new DoubleBlockCombiner.Combiner<StoneChestBlockEntity, Float2FloatFunction>() {
            public Float2FloatFunction acceptDouble(StoneChestBlockEntity chestBlock, StoneChestBlockEntity chestContainer) {
                return p_51638_ -> Math.max(chestBlock.getOpenNess(p_51638_), chestContainer.getOpenNess(p_51638_));
            }
            public Float2FloatFunction acceptSingle(StoneChestBlockEntity entity) {
                return entity::getOpenNess;
            }
            public Float2FloatFunction acceptNone() {
                return pLid::getOpenNess;
            }
        };
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? createTickerHelper(pBlockEntityType, this.blockEntityType(), StoneChestBlockEntity::lidAnimateTick) : null;
    }

    public static boolean isChestBlockedAt(LevelAccessor accessor, BlockPos pos) {
        return isBlockedChestByBlock(accessor, pos) || isCatSittingOnChest(accessor, pos);
    }
    private static boolean isBlockedChestByBlock(BlockGetter pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.above();
        return pLevel.getBlockState(blockpos).isRedstoneConductor(pLevel, blockpos);
    }
    private static boolean isCatSittingOnChest(LevelAccessor pLevel, BlockPos pPos) {
        List<Cat> list = pLevel.getEntitiesOfClass(
                Cat.class,
                new AABB((double)pPos.getX(), (double)(pPos.getY() + 1), (double)pPos.getZ(), (double)(pPos.getX() + 1), (double)(pPos.getY() + 2), (double)(pPos.getZ() + 1)));
        if (!list.isEmpty()) {
            for (Cat cat : list) {
                if (cat.isInSittingPose()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pPos) {
        return AbstractContainerMenu.getRedstoneSignalFromContainer(getContainer(this, pBlockState, pLevel, pPos, false));
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }
    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        BlockState rotation = state.rotate(mirror.getRotation(state.getValue(FACING)));
        return mirror == Mirror.NONE ? rotation : rotation.setValue(TYPE, rotation.getValue(TYPE).getOpposite());
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof StoneChestBlockEntity) {
            ((StoneChestBlockEntity)entity).recheckOpen();
        }
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StoneChestBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, WATERLOGGED);
    }
}
