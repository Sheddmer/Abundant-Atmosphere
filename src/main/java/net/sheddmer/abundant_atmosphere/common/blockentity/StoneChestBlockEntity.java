package net.sheddmer.abundant_atmosphere.common.blockentity;

import net.minecraft.core.*;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.sheddmer.abundant_atmosphere.common.block.StoneChestBlock;
import net.sheddmer.abundant_atmosphere.common.init.AABlockEntityTypes;
import net.sheddmer.abundant_atmosphere.common.init.AASounds;

public class StoneChestBlockEntity extends RandomizableContainerBlockEntity {
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
        protected boolean isOwnContainer(Player player) {
            if (!(player.containerMenu instanceof ChestMenu)) {
                return false;
            } else {
                Container container = ((ChestMenu)player.containerMenu).getContainer();
                return container == StoneChestBlockEntity.this || container instanceof CompoundContainer && ((CompoundContainer)container).contains(StoneChestBlockEntity.this);
            }
        }
    };

    public StoneChestBlockEntity(BlockPos pos, BlockState blockState) {
        super(AABlockEntityTypes.STONE_CHEST.get(), pos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.abundant_atmosphere.stone_chest");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items, provider);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items, provider);
        }
    }

    static void playSound(Level level, BlockPos pos, BlockState state, SoundEvent sound) {
        ChestType chesttype = state.getValue(StoneChestBlock.TYPE);
        if (chesttype != ChestType.LEFT) {
            double d0 = (double)pos.getX() + 0.5;
            double d1 = (double)pos.getY() + 0.5;
            double d2 = (double)pos.getZ() + 0.5;
            if (chesttype == ChestType.RIGHT) {
                Direction direction = StoneChestBlock.getConnectedDirection(state);
                d0 += (double)direction.getStepX() * 0.5;
                d2 += (double)direction.getStepZ() * 0.5;
            }
            level.playSound(null, d0, d1, d2, sound, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
        }
    }

    public static void swapContents(StoneChestBlockEntity chest, StoneChestBlockEntity otherChest) {
        NonNullList<ItemStack> nonnulllist = chest.getItems();
        chest.setItems(otherChest.getItems());
        otherChest.setItems(nonnulllist);
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return ChestMenu.threeRows(id, inventory, this);
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    protected void signalOpenCount(Level level, BlockPos pos, BlockState state, int eventId, int eventParam) {
        Block block = state.getBlock();
        level.blockEvent(pos, block, 1, eventParam);
    }
}