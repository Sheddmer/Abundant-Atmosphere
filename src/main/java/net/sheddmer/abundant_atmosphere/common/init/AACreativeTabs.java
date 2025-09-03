package net.sheddmer.abundant_atmosphere.common.init;

import com.google.common.collect.Sets;
import com.mojang.datafixers.kinds.IdF;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.integration.AAModCompats;
import net.sheddmer.abundant_atmosphere.common.integration.BBIntegration;
import net.sheddmer.abundant_atmosphere.common.integration.FDIntegration;
import net.sheddmer.abundant_atmosphere.common.integration.NMLIntegration;

public class AACreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AbundantAtmosphere.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABUNDANT_ATMOSPHERE_TAB = CREATIVE_TABS.register(AbundantAtmosphere.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.abundant_atmosphere")).icon(AABlocks.ASHROOT_SAPLING::toStack)
            .displayItems((parameters, output) -> {
                output.accept(AABlocks.ASHROOT_LOG);
                output.accept(AABlocks.ASHROOT_WOOD);
                output.accept(AABlocks.STRIPPED_ASHROOT_LOG);
                output.accept(AABlocks.STRIPPED_ASHROOT_WOOD);
                output.accept(AABlocks.ASHROOT_PLANKS);
                output.accept(AABlocks.ASHROOT_STAIRS);
                output.accept(AABlocks.ASHROOT_SLAB);
                if (AAModCompats.NOMANSLAND.isLoaded()) {
                    output.accept(NMLIntegration.ASHROOT_BOOKSHELF);
                    output.accept(NMLIntegration.TRIMMED_ASHROOT_PLANKS);
                }
                output.accept(AABlocks.ASHROOT_FENCE);
                output.accept(AABlocks.ASHROOT_FENCE_GATE);
                output.accept(AABlocks.ASHROOT_DOOR);
                output.accept(AABlocks.ASHROOT_TRAPDOOR);
                output.accept(AABlocks.ASHROOT_PRESSURE_PLATE);
                output.accept(AABlocks.ASHROOT_BUTTON);
                if (AAModCompats.BLOCKBOX.isLoaded()) {
                    output.accept(BBIntegration.ASHROOT_PALISADE);
                    output.accept(BBIntegration.SPIKED_ASHROOT_PALISADE);
                    output.accept(BBIntegration.STRIPPED_ASHROOT_PALISADE);
                    output.accept(BBIntegration.STRIPPED_SPIKED_ASHROOT_PALISADE);
                    output.accept(BBIntegration.ASHROOT_SEAT);
                }
                output.accept(AAItems.ASHROOT_SIGN);
                output.accept(AAItems.ASHROOT_HANGING_SIGN);
                output.accept(AAItems.ASHROOT_BOAT);
                output.accept(AAItems.ASHROOT_CHEST_BOAT);
                output.accept(AABlocks.ASHROOT_LEAVES);
                output.accept(AABlocks.ASHROOT_SAPLING);
                output.accept(AABlocks.GOURDROT_LOG);
                output.accept(AABlocks.GOURDROT_WOOD);
                output.accept(AABlocks.STRIPPED_GOURDROT_LOG);
                output.accept(AABlocks.STRIPPED_GOURDROT_WOOD);
                output.accept(AABlocks.GOURDROT_PLANKS);
                output.accept(AABlocks.GOURDROT_STAIRS);
                output.accept(AABlocks.GOURDROT_SLAB);
                if (AAModCompats.NOMANSLAND.isLoaded()) {
                    output.accept(NMLIntegration.GOURDROT_BOOKSHELF);
                    output.accept(NMLIntegration.TRIMMED_GOURDROT_PLANKS);
                }
                output.accept(AABlocks.GOURDROT_FENCE);
                output.accept(AABlocks.GOURDROT_FENCE_GATE);
                output.accept(AABlocks.GOURDROT_DOOR);
                output.accept(AABlocks.GOURDROT_TRAPDOOR);
                output.accept(AABlocks.GOURDROT_PRESSURE_PLATE);
                output.accept(AABlocks.GOURDROT_BUTTON);
                if (AAModCompats.BLOCKBOX.isLoaded()) {
                    output.accept(BBIntegration.GOURDROT_PALISADE);
                    output.accept(BBIntegration.SPIKED_GOURDROT_PALISADE);
                    output.accept(BBIntegration.STRIPPED_GOURDROT_PALISADE);
                    output.accept(BBIntegration.STRIPPED_SPIKED_GOURDROT_PALISADE);
                    output.accept(BBIntegration.GOURDROT_SEAT);
                }
                output.accept(AAItems.GOURDROT_SIGN);
                output.accept(AAItems.GOURDROT_HANGING_SIGN);
                output.accept(AAItems.GOURDROT_BOAT);
                output.accept(AAItems.GOURDROT_CHEST_BOAT);
                output.accept(AABlocks.GOURDROT_LEAVES);
                output.accept(AABlocks.GOURDNUT);
                output.accept(AABlocks.RED_BAMBOO_BLOCK);
                output.accept(AABlocks.STRIPPED_RED_BAMBOO_BLOCK);
                output.accept(AABlocks.RED_BAMBOO_PLANKS);
                output.accept(AABlocks.RED_BAMBOO_MOSAIC);
                output.accept(AABlocks.RED_BAMBOO_STAIRS);
                output.accept(AABlocks.RED_BAMBOO_MOSAIC_STAIRS);
                output.accept(AABlocks.RED_BAMBOO_SLAB);
                output.accept(AABlocks.RED_BAMBOO_MOSAIC_SLAB);
                if (AAModCompats.NOMANSLAND.isLoaded()) {
                    output.accept(NMLIntegration.RED_BAMBOO_BOOKSHELF);
                    output.accept(NMLIntegration.TRIMMED_RED_BAMBOO_PLANKS);
                }
                output.accept(AABlocks.RED_BAMBOO_FENCE);
                output.accept(AABlocks.RED_BAMBOO_FENCE_GATE);
                output.accept(AABlocks.RED_BAMBOO_DOOR);
                output.accept(AABlocks.RED_BAMBOO_TRAPDOOR);
                output.accept(AABlocks.RED_BAMBOO_PRESSURE_PLATE);
                output.accept(AABlocks.RED_BAMBOO_BUTTON);
                output.accept(AAItems.RED_BAMBOO_SIGN);
                output.accept(AAItems.RED_BAMBOO_HANGING_SIGN);
                output.accept(AAItems.RED_BAMBOO_RAFT);
                output.accept(AAItems.RED_BAMBOO_CHEST_RAFT);
                output.accept(AABlocks.RED_BAMBOO);
                output.accept(AABlocks.POLISHED_CALCITE);
                output.accept(AABlocks.POLISHED_CALCITE_STAIRS);
                output.accept(AABlocks.POLISHED_CALCITE_SLAB);
                output.accept(AABlocks.POLISHED_CALCITE_WALL);
                output.accept(AABlocks.CALCITE_TILES);
                output.accept(AABlocks.CALCITE_TILE_STAIRS);
                output.accept(AABlocks.CALCITE_TILE_SLAB);
                output.accept(AABlocks.CALCITE_TILE_WALL);
                output.accept(AABlocks.POLISHED_DRIPSTONE);
                output.accept(AABlocks.POLISHED_DRIPSTONE_STAIRS);
                output.accept(AABlocks.POLISHED_DRIPSTONE_SLAB);
                output.accept(AABlocks.POLISHED_DRIPSTONE_WALL);
                output.accept(AABlocks.DRIPSTONE_TILES);
                output.accept(AABlocks.DRIPSTONE_TILE_STAIRS);
                output.accept(AABlocks.DRIPSTONE_TILE_SLAB);
                output.accept(AABlocks.DRIPSTONE_TILE_WALL);
                output.accept(AABlocks.DRIPSTONE_SHINGLES);
                output.accept(AABlocks.DRIPSTONE_SHINGLE_STAIRS);
                output.accept(AABlocks.DRIPSTONE_SHINGLE_SLAB);
                output.accept(AABlocks.DRIPSTONE_SHINGLE_WALL);
                output.accept(AABlocks.SHUFFLED_BRICKS);
                output.accept(AABlocks.SHUFFLED_BRICK_STAIRS);
                output.accept(AABlocks.SHUFFLED_BRICK_SLAB);
                output.accept(AABlocks.SHUFFLED_BRICK_WALL);
                output.accept(AABlocks.MOSSY_SHUFFLED_BRICKS);
                output.accept(AABlocks.MOSSY_SHUFFLED_BRICK_STAIRS);
                output.accept(AABlocks.MOSSY_SHUFFLED_BRICK_SLAB);
                output.accept(AABlocks.MOSSY_SHUFFLED_BRICK_WALL);
                output.accept(AABlocks.BLACKSALT_TILES);
                output.accept(AABlocks.BLACKSALT_TILE_STAIRS);
                output.accept(AABlocks.BLACKSALT_TILE_SLAB);
                output.accept(AABlocks.MOSSY_BASALT);
                output.accept(AABlocks.STONE_DOOR);
                output.accept(AABlocks.STONE_TRAPDOOR);
                output.accept(AABlocks.STONE_WALL);
                output.accept(AABlocks.MOSSY_STONE);
                output.accept(AABlocks.MOSSY_STONE_STAIRS);
                output.accept(AABlocks.MOSSY_STONE_SLAB);
                output.accept(AABlocks.MOSSY_STONE_WALL);
                output.accept(AABlocks.DEEPSLATE_DOOR);
                output.accept(AABlocks.DEEPSLATE_TRAPDOOR);
                output.accept(AABlocks.DEEPSLATE_PILLAR);
                output.accept(AABlocks.MOSSY_DEEPSLATE);
                output.accept(AABlocks.MOSSY_COBBLED_DEEPSLATE);
                output.accept(AABlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
                output.accept(AABlocks.MOSSY_COBBLED_DEEPSLATE_SLAB);
                output.accept(AABlocks.MOSSY_COBBLED_DEEPSLATE_WALL);
                output.accept(AABlocks.MOSSY_POLISHED_DEEPSLATE);
                output.accept(AABlocks.MOSSY_POLISHED_DEEPSLATE_STAIRS);
                output.accept(AABlocks.MOSSY_POLISHED_DEEPSLATE_SLAB);
                output.accept(AABlocks.MOSSY_POLISHED_DEEPSLATE_WALL);
                output.accept(AABlocks.MOSSY_DEEPSLATE_BRICKS);
                output.accept(AABlocks.MOSSY_DEEPSLATE_BRICK_STAIRS);
                output.accept(AABlocks.MOSSY_DEEPSLATE_BRICK_SLAB);
                output.accept(AABlocks.MOSSY_DEEPSLATE_BRICK_WALL);
                output.accept(AABlocks.MOSSY_DEEPSLATE_TILES);
                output.accept(AABlocks.MOSSY_DEEPSLATE_TILE_STAIRS);
                output.accept(AABlocks.MOSSY_DEEPSLATE_TILE_SLAB);
                output.accept(AABlocks.MOSSY_DEEPSLATE_TILE_WALL);
                output.accept(AABlocks.MUD_DOOR);
                output.accept(AABlocks.MUD_TRAPDOOR);
                output.accept(AABlocks.CHISELED_MUD_BRICKS);
                output.accept(AABlocks.MUD_LAMP);
                output.accept(AABlocks.MOSSY_MUD_BRICKS);
                output.accept(AABlocks.MOSSY_MUD_BRICK_STAIRS);
                output.accept(AABlocks.MOSSY_MUD_BRICK_SLAB);
                output.accept(AABlocks.MOSSY_MUD_BRICK_WALL);
                output.accept(AABlocks.BLACKSTONE_DOOR);
                output.accept(AABlocks.BLACKSTONE_TRAPDOOR);
                output.accept(AABlocks.NETHER_BRICK_DOOR);
                output.accept(AABlocks.NETHER_BRICK_TRAPDOOR);
                output.accept(AABlocks.STONE_BRAZIER);
                output.accept(AABlocks.SOUL_STONE_BRAZIER);
                output.accept(AABlocks.CAVE_CRUD);
                output.accept(AABlocks.CAVE_SPROUTS);
                output.accept(AABlocks.SUSPICIOUS_RED_SAND);
                output.accept(AABlocks.MOSS_CLUMP);
                output.accept(AABlocks.RUST_MOSS_CLUMP);
                output.accept(AABlocks.RUST_MOSS_BLOCK);
                output.accept(AABlocks.RUST_MOSS_CARPET);
                output.accept(AABlocks.RUST_MOSS_SPROUTS);
                output.accept(AABlocks.LEAF_PILE);
                output.accept(AAItems.PUFFBALL_SPORES);
                output.accept(AABlocks.PUFFBALL_MUSHROOM);
                output.accept(AABlocks.LARGE_PUFFBALL_MUSHROOM);
                output.accept(AABlocks.PORESHROOM);
                output.accept(AABlocks.PORESHROOM_BLOCK);
                output.accept(AABlocks.CATSBANE);
                output.accept(AABlocks.SAFFRON_BUSHBUDS);
                output.accept(AABlocks.CHERRY_BUSHBUDS);
                output.accept(AABlocks.UMBRA_BUSHBUDS);
                output.accept(AABlocks.MIDNIGHT_LILY);
                output.accept(AABlocks.WISP_CANDLE);
                output.accept(AABlocks.CERULEAN_FROGLIGHT);
                output.accept(AABlocks.CHROMATIC_FROGLIGHT);
                output.accept(AAItems.PUFFBALL_SLICE);
                output.accept(AAItems.PUFFBALL_CUTLET);
                if (AAModCompats.FARMERSDELIGHT.isLoaded() && AAModCompats.NOMANSLAND.isLoaded()) output.accept(FDIntegration.SWAMP_SCRAN);
                output.accept(AAItems.ROASTED_GOURDNUT);
                output.accept(AAItems.SQUASHBERRY_JAM);
                output.accept(AAItems.SQUASHBERRY_BREAD);

                if (AAModCompats.FARMERSDELIGHT.isLoaded()) {
                    output.accept(FDIntegration.ASHROOT_CABINET);
                    output.accept(FDIntegration.GOURDROT_CABINET);
                    output.accept(FDIntegration.RED_BAMBOO_CABINET);
                }
            }).build());

}
