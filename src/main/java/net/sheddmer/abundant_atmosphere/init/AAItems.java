package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.entity.AABoatEntity;
import net.sheddmer.abundant_atmosphere.common.item.AABoatItem;
import net.sheddmer.abundant_atmosphere.common.item.MudBallItem;

public class AAItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AbundantAtmosphere.MODID);

    public static final DeferredItem<Item> ROASTED_GOURDNUT = ITEMS.register("roasted_gourdnut", () -> new Item(new Item.Properties().food(Foods.BAKED_POTATO)));
    public static final DeferredItem<Item> ASHROOT_SIGN = ITEMS.register("ashroot_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AABlocks.ASHROOT_SIGN.get(), AABlocks.ASHROOT_WALL_SIGN.get()));
    public static final DeferredItem<Item> ASHROOT_HANGING_SIGN = ITEMS.register("ashroot_hanging_sign", () -> new HangingSignItem(AABlocks.ASHROOT_HANGING_SIGN.get(), AABlocks.ASHROOT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> GOURDROT_SIGN = ITEMS.register("gourdrot_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AABlocks.GOURDROT_SIGN.get(), AABlocks.GOURDROT_WALL_SIGN.get()));
    public static final DeferredItem<Item> GOURDROT_HANGING_SIGN = ITEMS.register("gourdrot_hanging_sign", () -> new HangingSignItem(AABlocks.GOURDROT_HANGING_SIGN.get(), AABlocks.GOURDROT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> ASHROOT_BOAT = ITEMS.register("ashroot_boat", () -> new AABoatItem(false, AABoatEntity.Type.ASHROOT, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ASHROOT_CHEST_BOAT = ITEMS.register("ashroot_chest_boat", () -> new AABoatItem(true, AABoatEntity.Type.ASHROOT, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GOURDROT_BOAT = ITEMS.register("gourdrot_boat", () -> new AABoatItem(false, AABoatEntity.Type.GOURDROT, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GOURDROT_CHEST_BOAT = ITEMS.register("gourdrot_chest_boat", () -> new AABoatItem(true, AABoatEntity.Type.GOURDROT, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MUD_LAMP = ITEMS.register("mud_lamp", () -> new StandingAndWallBlockItem(AABlocks.MUD_LAMP.get(), AABlocks.WALL_MUD_LAMP.get(), new Item.Properties(), Direction.DOWN));
    public static final DeferredItem<Item> PUFFBALL_SPORES = ITEMS.register("puffball_spores", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MUD_BALL = ITEMS.register("mud_ball", () -> new MudBallItem(new Item.Properties()));

    public static final DeferredItem<Item> CHROMATIC_FROGLIGHT = ITEMS.register("chromatic_froglight", () -> new BlockItem(AABlocks.CHROMATIC_FROGLIGHT.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));


    // Insert Items
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.insertAfter(Items.POLISHED_BASALT.getDefaultInstance(), AABlocks.BLACKSALT_TILES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.MUD_BRICK_WALL.getDefaultInstance(), AABlocks.CHISELED_MUD_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Calcite blocks
            event.insertAfter(Items.POLISHED_ANDESITE_SLAB.getDefaultInstance(), Items.CALCITE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.CALCITE.getDefaultInstance(), AABlocks.POLISHED_CALCITE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_CALCITE.toStack(), AABlocks.POLISHED_CALCITE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_CALCITE_STAIRS.toStack(), AABlocks.POLISHED_CALCITE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_CALCITE_SLAB.toStack(), AABlocks.POLISHED_CALCITE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_CALCITE_WALL.toStack(), AABlocks.CALCITE_TILES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CALCITE_TILES.toStack(), AABlocks.CALCITE_TILE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CALCITE_TILE_STAIRS.toStack(), AABlocks.CALCITE_TILE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CALCITE_TILE_SLAB.toStack(), AABlocks.CALCITE_TILE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Dowsite blocks
            event.insertAfter(Items.POLISHED_GRANITE_SLAB.getDefaultInstance(), AABlocks.DOWSITE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DOWSITE.toStack(), AABlocks.POLISHED_DOWSITE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_DOWSITE.toStack(), AABlocks.POLISHED_DOWSITE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_DOWSITE_STAIRS.toStack(), AABlocks.POLISHED_DOWSITE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_DOWSITE_SLAB.toStack(), AABlocks.POLISHED_DOWSITE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Dripstone blocks
            event.insertAfter(AABlocks.CALCITE_TILE_WALL.toStack(), Items.DRIPSTONE_BLOCK.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.DRIPSTONE_BLOCK.getDefaultInstance(), AABlocks.POLISHED_DRIPSTONE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_DRIPSTONE.toStack(), AABlocks.POLISHED_DRIPSTONE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_DRIPSTONE_STAIRS.toStack(), AABlocks.POLISHED_DRIPSTONE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_DRIPSTONE_SLAB.toStack(), AABlocks.POLISHED_DRIPSTONE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.POLISHED_DRIPSTONE_WALL.toStack(), AABlocks.DRIPSTONE_TILES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DRIPSTONE_TILES.toStack(), AABlocks.DRIPSTONE_TILE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DRIPSTONE_TILE_STAIRS.toStack(), AABlocks.DRIPSTONE_TILE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DRIPSTONE_TILE_SLAB.toStack(), AABlocks.DRIPSTONE_TILE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DRIPSTONE_TILE_WALL.toStack(), AABlocks.DRIPSTONE_SHINGLES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DRIPSTONE_SHINGLES.toStack(), AABlocks.DRIPSTONE_SHINGLE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DRIPSTONE_SHINGLE_STAIRS.toStack(), AABlocks.DRIPSTONE_SHINGLE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DRIPSTONE_SHINGLE_SLAB.toStack(), AABlocks.DRIPSTONE_SHINGLE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Mixed Brick blocks
            event.insertAfter(Items.BRICK_WALL.getDefaultInstance(), AABlocks.MIXED_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MIXED_BRICKS.toStack(), AABlocks.MIXED_BRICK_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MIXED_BRICK_STAIRS.toStack(), AABlocks.MIXED_BRICK_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MIXED_BRICK_SLAB.toStack(), AABlocks.MIXED_BRICK_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Ashroot woodset (added after cherry in building blocks)
            event.insertAfter(Items.CHERRY_BUTTON.getDefaultInstance(), AABlocks.ASHROOT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_LOG.toStack(), AABlocks.ASHROOT_WOOD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_WOOD.toStack(), AABlocks.STRIPPED_ASHROOT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STRIPPED_ASHROOT_LOG.toStack(), AABlocks.STRIPPED_ASHROOT_WOOD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STRIPPED_ASHROOT_WOOD.toStack(), AABlocks.ASHROOT_PLANKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_PLANKS.toStack(), AABlocks.ASHROOT_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_STAIRS.toStack(), AABlocks.ASHROOT_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_SLAB.toStack(), AABlocks.ASHROOT_FENCE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_FENCE.toStack(), AABlocks.ASHROOT_FENCE_GATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_FENCE_GATE.toStack(), AABlocks.ASHROOT_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_DOOR.toStack(), AABlocks.ASHROOT_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_TRAPDOOR.toStack(), AABlocks.ASHROOT_PRESSURE_PLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_PRESSURE_PLATE.toStack(), AABlocks.ASHROOT_BUTTON.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Gourdrot woodset (added after ashroot in building blocks)
            event.insertAfter(AABlocks.ASHROOT_BUTTON.toStack(), AABlocks.GOURDROT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_LOG.toStack(), AABlocks.GOURDROT_WOOD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_WOOD.toStack(), AABlocks.STRIPPED_GOURDROT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STRIPPED_GOURDROT_LOG.toStack(), AABlocks.STRIPPED_GOURDROT_WOOD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STRIPPED_GOURDROT_WOOD.toStack(), AABlocks.GOURDROT_PLANKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_PLANKS.toStack(), AABlocks.GOURDROT_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_STAIRS.toStack(), AABlocks.GOURDROT_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_SLAB.toStack(), AABlocks.GOURDROT_FENCE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_FENCE.toStack(), AABlocks.GOURDROT_FENCE_GATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_FENCE_GATE.toStack(), AABlocks.GOURDROT_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_DOOR.toStack(), AABlocks.GOURDROT_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_TRAPDOOR.toStack(), AABlocks.GOURDROT_PRESSURE_PLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDROT_PRESSURE_PLATE.toStack(), AABlocks.GOURDROT_BUTTON.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Mossy blocks
            event.insertAfter(Items.STONE.getDefaultInstance(), AABlocks.MOSSY_STONE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.BASALT.getDefaultInstance(), AABlocks.MOSSY_BASALT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Mossy deepslate blocks
            event.insertAfter(Items.DEEPSLATE.getDefaultInstance(), AABlocks.MOSSY_DEEPSLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COBBLED_DEEPSLATE_WALL.getDefaultInstance(), AABlocks.MOSSY_COBBLED_DEEPSLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.POLISHED_DEEPSLATE_WALL.getDefaultInstance(), AABlocks.MOSSY_POLISHED_DEEPSLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.DEEPSLATE_BRICK_WALL.getDefaultInstance(), AABlocks.MOSSY_DEEPSLATE_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.DEEPSLATE_TILE_WALL.getDefaultInstance(), AABlocks.MOSSY_DEEPSLATE_TILES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            // general natural blocks
            event.insertAfter(Items.FARMLAND.getDefaultInstance(), AABlocks.CAVE_CRUD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.POINTED_DRIPSTONE.getDefaultInstance(), AABlocks.DOWSITE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.PINK_PETALS.getDefaultInstance(), AABlocks.MIDNIGHT_LILY.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.PEARLESCENT_FROGLIGHT.getDefaultInstance(), AABlocks.CERULEAN_FROGLIGHT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CERULEAN_FROGLIGHT.toStack(), AAItems.CHROMATIC_FROGLIGHT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.MOSS_BLOCK.getDefaultInstance(), AABlocks.MOSS_CLUMP.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.MOSS_CARPET.getDefaultInstance(), AABlocks.IRISH_MOSS_CLUMP.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.IRISH_MOSS_CLUMP.toStack(), AABlocks.IRISH_MOSS_BLOCK.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.IRISH_MOSS_BLOCK.toStack(), AABlocks.IRISH_MOSS_CARPET.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.AMETHYST_BLOCK.getDefaultInstance(), AABlocks.DIFFUSED_AMBER_BLOCK.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // ashroot natural blocks (added after azalea)
            event.insertAfter(Items.CHERRY_LOG.getDefaultInstance(), AABlocks.ASHROOT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.FLOWERING_AZALEA.getDefaultInstance(), AABlocks.ASHROOT_SAPLING.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.FLOWERING_AZALEA_LEAVES.getDefaultInstance(), AABlocks.ASHROOT_LEAVES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // gourdrot natural blocks (added after ashroot)
            event.insertAfter(AABlocks.ASHROOT_LOG.toStack(), AABlocks.GOURDROT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_LEAVES.toStack(), AABlocks.GOURDROT_LEAVES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.PUMPKIN.getDefaultInstance(), AABlocks.GOURDNUT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // puffball items
            event.insertAfter(Items.RED_MUSHROOM.getDefaultInstance(), AABlocks.PUFFBALL_MUSHROOM.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.NETHER_WART.getDefaultInstance(), AAItems.PUFFBALL_SPORES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(Items.CANDLE.getDefaultInstance(), AABlocks.WISP_CANDLE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.SOUL_LANTERN.getDefaultInstance(), AAItems.MUD_LAMP.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.PEARLESCENT_FROGLIGHT.getDefaultInstance(), AABlocks.CERULEAN_FROGLIGHT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.CHEST.getDefaultInstance(), AABlocks.STONE_CHEST.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // signs & hanging signs
            event.insertAfter(Items.CHERRY_HANGING_SIGN.getDefaultInstance(), AAItems.ASHROOT_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ASHROOT_SIGN.toStack(), AAItems.ASHROOT_HANGING_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ASHROOT_HANGING_SIGN.toStack(), AAItems.GOURDROT_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.GOURDROT_SIGN.toStack(), AAItems.GOURDROT_HANGING_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // braziers
            event.insertAfter(Items.SOUL_CAMPFIRE.getDefaultInstance(), AABlocks.STONE_BRAZIER.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STONE_BRAZIER.toStack(), AABlocks.SOUL_STONE_BRAZIER.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // suspicious blocks
            event.insertAfter(Items.SUSPICIOUS_SAND.getDefaultInstance(), AABlocks.SUSPICIOUS_RED_SAND.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.SUSPICIOUS_SAND.getDefaultInstance(), AABlocks.SUSPICIOUS_DIRT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.insertBefore(Items.PUMPKIN_PIE.getDefaultInstance(), AAItems.ROASTED_GOURDNUT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(Items.CHERRY_CHEST_BOAT.getDefaultInstance(), AAItems.ASHROOT_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ASHROOT_BOAT.toStack(), AAItems.ASHROOT_CHEST_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ASHROOT_CHEST_BOAT.toStack(), AAItems.GOURDROT_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.GOURDROT_BOAT.toStack(), AAItems.GOURDROT_CHEST_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(Items.CLAY_BALL.getDefaultInstance(), AAItems.MUD_BALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.insertAfter(Items.TRAPPED_CHEST.getDefaultInstance(), AABlocks.TRAPPED_STONE_CHEST.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
