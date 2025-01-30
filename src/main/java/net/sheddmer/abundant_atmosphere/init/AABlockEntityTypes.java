package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.blockentity.AACabinetBlockEntity;
import net.sheddmer.abundant_atmosphere.common.blockentity.AAHangingSignBlockEntity;
import net.sheddmer.abundant_atmosphere.common.blockentity.AASignBlockEntity;
import net.sheddmer.abundant_atmosphere.common.blockentity.StoneChestBlockEntity;
import net.sheddmer.abundant_atmosphere.integration.AAModCompats;

public class AABlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AbundantAtmosphere.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AASignBlockEntity>> AA_SIGN = BLOCK_ENTITY_TYPES.register("aa_sign", () -> BlockEntityType.Builder.of(AASignBlockEntity::new, AABlocks.ASHROOT_SIGN.get(), AABlocks.ASHROOT_WALL_SIGN.get(), AABlocks.GOURDROT_SIGN.get(), AABlocks.GOURDROT_WALL_SIGN.get(), AABlocks.RED_BAMBOO_SIGN.get(), AABlocks.RED_BAMBOO_WALL_SIGN.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AAHangingSignBlockEntity>> AA_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("aa_hanging_sign", () -> BlockEntityType.Builder.of(AAHangingSignBlockEntity::new, AABlocks.ASHROOT_HANGING_SIGN.get(), AABlocks.ASHROOT_WALL_HANGING_SIGN.get(), AABlocks.GOURDROT_HANGING_SIGN.get(), AABlocks.GOURDROT_WALL_HANGING_SIGN.get(), AABlocks.RED_BAMBOO_HANGING_SIGN.get(), AABlocks.RED_BAMBOO_WALL_HANGING_SIGN.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StoneChestBlockEntity>> STONE_CHEST = BLOCK_ENTITY_TYPES.register("stone_chest", () -> BlockEntityType.Builder.of(StoneChestBlockEntity::new, AABlocks.STONE_CHEST.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AACabinetBlockEntity>> AA_CABINET = AAModCompats.FARMERSDELIGHT.isLoaded() ? BLOCK_ENTITY_TYPES.register("aa_cabinet", () -> BlockEntityType.Builder.of(AACabinetBlockEntity::new, AABlocks.ASHROOT_CABINET.get(), AABlocks.GOURDROT_CABINET.get(), AABlocks.RED_BAMBOO_CABINET.get()).build(null)) : null;

}
