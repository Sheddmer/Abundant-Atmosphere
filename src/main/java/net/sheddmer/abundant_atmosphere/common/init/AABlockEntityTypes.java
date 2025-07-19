package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.blockentity.*;

public class AABlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AbundantAtmosphere.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StoneChestBlockEntity>> STONE_CHEST = BLOCK_ENTITY_TYPES.register("stone_chest", () -> BlockEntityType.Builder.of(StoneChestBlockEntity::new, AABlocks.STONE_CHEST.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WispCandleBlockEntity>> WISP_CANDLE = BLOCK_ENTITY_TYPES.register("wisp_candle", () -> BlockEntityType.Builder.of(WispCandleBlockEntity::new, AABlocks.WISP_CANDLE.get()).build(null));

    public static void addBlockEntities(final BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.BRUSHABLE_BLOCK, AABlocks.SUSPICIOUS_DIRT.get(), AABlocks.SUSPICIOUS_RED_SAND.get());
        event.modify(BlockEntityType.SIGN, AABlocks.ASHROOT_SIGN.get(), AABlocks.ASHROOT_WALL_SIGN.get(), AABlocks.GOURDROT_SIGN.get(), AABlocks.GOURDROT_WALL_SIGN.get(), AABlocks.RED_BAMBOO_SIGN.get(), AABlocks.RED_BAMBOO_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN, AABlocks.ASHROOT_HANGING_SIGN.get(), AABlocks.ASHROOT_WALL_HANGING_SIGN.get(), AABlocks.GOURDROT_HANGING_SIGN.get(), AABlocks.GOURDROT_WALL_HANGING_SIGN.get(), AABlocks.RED_BAMBOO_HANGING_SIGN.get(), AABlocks.RED_BAMBOO_WALL_HANGING_SIGN.get());
    }

}
