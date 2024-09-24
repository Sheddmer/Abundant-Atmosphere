package net.sheddmer.abundant_atmosphere.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.sheddmer.abundant_atmosphere.common.block.StoneChestBlock;
import net.sheddmer.abundant_atmosphere.init.AABlockEntityTypes;
import net.sheddmer.abundant_atmosphere.init.AASounds;

public class StoneChestBlockEntity extends RandomizableContainerBlockEntity implements LidBlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            StoneChestBlockEntity.playSound(level, pos, state, AASounds.STONE_CHEST_OPEN.get());
        }
        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state) {
            StoneChestBlockEntity.playSound(level, pos, state, AASounds.STONE_CHEST_CLOSE.get());
        }
        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int p_155364_, int p_155365_) {
            StoneChestBlockEntity.this.signalOpenCount(level, pos, state, p_155364_, p_155365_);
        }

        @Override
        protected boolean isOwnContainer(Player p_155355_) {
            if (!(p_155355_.containerMenu instanceof ChestMenu)) {
                return false;
            } else {
                Container container = ((ChestMenu)p_155355_.containerMenu).getContainer();
                return container == StoneChestBlockEntity.this
                        || container instanceof CompoundContainer && ((CompoundContainer)container).contains(StoneChestBlockEntity.this);
            }
        }
    };
    private final ChestLidController chestLidController = new ChestLidController();

    protected StoneChestBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public StoneChestBlockEntity(BlockPos pPos, BlockState pBlockState) {
        this(AABlockEntityTypes.STONE_CHEST.get(), pPos, pBlockState);
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.abundant_atmosphere.stone_chest.single");
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        if (!this.trySaveLootTable(pTag)) {
            ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
        }
    }

    public static void lidAnimateTick(Level pLevel, BlockPos pPos, BlockState pState, StoneChestBlockEntity pBlockEntity) {
        pBlockEntity.chestLidController.tickLid();
    }

    static void playSound(Level pLevel, BlockPos pPos, BlockState pState, SoundEvent pSound) {
        ChestType chesttype = pState.getValue(StoneChestBlock.TYPE);
        if (chesttype != ChestType.LEFT) {
            double d0 = (double)pPos.getX() + 0.5;
            double d1 = (double)pPos.getY() + 0.5;
            double d2 = (double)pPos.getZ() + 0.5;
            if (chesttype == ChestType.RIGHT) {
                Direction direction = StoneChestBlock.getConnectedDirection(pState);
                d0 += (double)direction.getStepX() * 0.5;
                d2 += (double)direction.getStepZ() * 0.5;
            }

            pLevel.playSound(null, d0, d1, d2, pSound, SoundSource.BLOCKS, 0.5F, pLevel.random.nextFloat() * 0.1F + 0.9F);
        }
    }

    @Override
    public boolean triggerEvent(int pId, int pType) {
        if (pId == 1) {
            this.chestLidController.shouldBeOpen(pType > 0);
            return true;
        } else {
            return super.triggerEvent(pId, pType);
        }
    }

    @Override
    public void startOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.incrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.decrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItems) {
        this.items = pItems;
    }

    @Override
    public float getOpenNess(float pPartialTicks) {
        return this.chestLidController.getOpenness(pPartialTicks);
    }

    public static int getOpenCount(BlockGetter pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos);
        if (blockstate.hasBlockEntity()) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof StoneChestBlockEntity) {
                return ((StoneChestBlockEntity)blockentity).openersCounter.getOpenerCount();
            }
        }

        return 0;
    }

    public static void swapContents(StoneChestBlockEntity pChest, StoneChestBlockEntity pOtherChest) {
        NonNullList<ItemStack> nonnulllist = pChest.getItems();
        pChest.setItems(pOtherChest.getItems());
        pOtherChest.setItems(nonnulllist);
    }

    @Override
    protected AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
        return ChestMenu.threeRows(pId, pPlayer, this);
    }

    @Override
    public void setBlockState(BlockState p_155251_) {
        var oldState = getBlockState();
        super.setBlockState(p_155251_);
        if ((oldState.getValue(StoneChestBlock.FACING) != p_155251_.getValue(StoneChestBlock.FACING))
                || (oldState.getValue(StoneChestBlock.TYPE) != p_155251_.getValue(StoneChestBlock.TYPE))) {
            this.invalidateCapabilities();
        }
    }

    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    protected void signalOpenCount(Level pLevel, BlockPos pPos, BlockState pState, int pEventId, int pEventParam) {
        Block block = pState.getBlock();
        pLevel.blockEvent(pPos, block, 1, pEventParam);
    }
}