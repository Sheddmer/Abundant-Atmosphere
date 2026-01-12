package net.sheddmer.abundant_atmosphere.common.init;

import com.farcr.nomansland.common.registry.blocks.NMLBlocks;
import com.farcr.nomansland.common.registry.items.NMLItems;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.AAEnumParams;
import net.sheddmer.abundant_atmosphere.common.integration.boatload.BLIntegration;
import net.sheddmer.abundant_atmosphere.common.item.CreepieSproutItem;
import net.sheddmer.abundant_atmosphere.common.item.DrinkItem;
import net.sheddmer.abundant_atmosphere.common.item.FungusSporeItem;
import net.sheddmer.abundant_atmosphere.common.integration.AAModCompats;
import net.sheddmer.abundant_atmosphere.common.integration.BBIntegration;
import net.sheddmer.abundant_atmosphere.common.integration.FDIntegration;
import net.sheddmer.abundant_atmosphere.common.integration.NMLIntegration;

import java.util.function.Supplier;

public class AAItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AbundantAtmosphere.MODID);

    public static final DeferredItem<Item> MUD_LAMP = registerItem("mud_lamp", () -> new StandingAndWallBlockItem(AABlocks.MUD_LAMP.get(), AABlocks.WALL_MUD_LAMP.get(), new Item.Properties(), Direction.DOWN));
    public static final DeferredItem<Item> PUFFBALL_SPORES = registerItem("puffball_spores", () -> new FungusSporeItem(AABlocks.PUFFBALL_MUSHROOM.get(), 8677966, new Item.Properties()));
    public static final DeferredItem<Item> CHROMATIC_FROGLIGHT = registerItem("chromatic_froglight", () -> new BlockItem(AABlocks.CHROMATIC_FROGLIGHT.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> CATSBANE = registerItem("catsbane", () -> new StandingAndWallBlockItem(AABlocks.CATSBANE.get(), AABlocks.WALL_CATSBANE.get(), new Item.Properties(), Direction.DOWN));
    public static final DeferredItem<Item> PORESHROOM = registerItem("poreshroom", () -> new StandingAndWallBlockItem(AABlocks.PORESHROOM.get(), AABlocks.WALL_PORESHROOM.get(), new Item.Properties().food(AAFoods.PORESHROOM), Direction.DOWN));
    public static final DeferredItem<Item> SMALL_LILY_PAD = registerItem("small_lily_pad", () -> new PlaceOnWaterBlockItem(AABlocks.SMALL_LILY_PAD.get(), new Item.Properties()));
    // public static final DeferredItem<Item> FROG_BUCKET = ITEMS.register("frog_bucket", () -> new MobBucketItem(EntityType.FROG, Fluids.WATER, SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY)));
    public static final DeferredItem<Item> WISP_CANDLE = registerItem("wisp_candle", () -> new BlockItem(AABlocks.WISP_CANDLE.get(), new Item.Properties()));

    public static final DeferredItem<Item> CREEPIE_SPROUT = registerItem("creepie_sprout", () -> new CreepieSproutItem(new Item.Properties().stacksTo(16)));

    // Woodset items
    public static final DeferredItem<Item> ASHROOT_PLANKS = registerItem("ashroot_planks", () -> new BlockItem(AABlocks.ASHROOT_PLANKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> ASHROOT_SIGN = registerItem("ashroot_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AABlocks.ASHROOT_SIGN.get(), AABlocks.ASHROOT_WALL_SIGN.get()));
    public static final DeferredItem<Item> ASHROOT_HANGING_SIGN = registerItem("ashroot_hanging_sign", () -> new HangingSignItem(AABlocks.ASHROOT_HANGING_SIGN.get(), AABlocks.ASHROOT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> ASHROOT_BOAT = registerItem("ashroot_boat", () -> new BoatItem(false, AAEnumParams.ASHROOT_BOAT_TYPE.getValue(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ASHROOT_CHEST_BOAT = registerItem("ashroot_chest_boat", () -> new BoatItem(true, AAEnumParams.ASHROOT_BOAT_TYPE.getValue(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GOURDROT_PLANKS = registerItem("gourdrot_planks", () -> new BlockItem(AABlocks.GOURDROT_PLANKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GOURDROT_SIGN = registerItem("gourdrot_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AABlocks.GOURDROT_SIGN.get(), AABlocks.GOURDROT_WALL_SIGN.get()));
    public static final DeferredItem<Item> GOURDROT_HANGING_SIGN = registerItem("gourdrot_hanging_sign", () -> new HangingSignItem(AABlocks.GOURDROT_HANGING_SIGN.get(), AABlocks.GOURDROT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> GOURDROT_BOAT = registerItem("gourdrot_boat", () -> new BoatItem(false, AAEnumParams.GOURDROT_BOAT_TYPE.getValue(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GOURDROT_CHEST_BOAT = registerItem("gourdrot_chest_boat", () -> new BoatItem(true, AAEnumParams.GOURDROT_BOAT_TYPE.getValue(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> RED_BAMBOO_PLANKS = registerItem("red_bamboo_planks", () -> new BlockItem(AABlocks.RED_BAMBOO_PLANKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_BAMBOO_SIGN = registerItem("red_bamboo_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AABlocks.RED_BAMBOO_SIGN.get(), AABlocks.RED_BAMBOO_WALL_SIGN.get()));
    public static final DeferredItem<Item> RED_BAMBOO_HANGING_SIGN = registerItem("red_bamboo_hanging_sign", () -> new HangingSignItem(AABlocks.RED_BAMBOO_HANGING_SIGN.get(), AABlocks.RED_BAMBOO_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> RED_BAMBOO_RAFT = registerItem("red_bamboo_raft", () -> new BoatItem(false, AAEnumParams.RED_BAMBOO_RAFT_TYPE.getValue(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> RED_BAMBOO_CHEST_RAFT = registerItem("red_bamboo_chest_raft", () -> new BoatItem(true, AAEnumParams.RED_BAMBOO_RAFT_TYPE.getValue(), new Item.Properties().stacksTo(1)));

    // Food items
    public static final DeferredItem<Item> ROASTED_GOURDNUT = registerItem("roasted_gourdnut", () -> new Item(new Item.Properties().food(AAFoods.ROASTED_GOURDNUT)));
    public static final DeferredItem<Item> SQUASHBERRY_JAM = registerItem("squashberry_jam", () -> new DrinkItem(new Item.Properties().food(AAFoods.SQUASHBERRY_JAM).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final DeferredItem<Item> SQUASHBERRY_BREAD = registerItem("squashberry_bread", () -> new Item(new Item.Properties().food(AAFoods.SQUASHBERRY_BREAD)));
    public static final DeferredItem<Item> PUFFBALL_SLICE = registerItem("puffball_slice", () -> new Item(new Item.Properties().food(AAFoods.PUFFBALL_SLICE)));
    public static final DeferredItem<Item> PUFFBALL_CUTLET = registerItem("puffball_cutlet", () -> new Item(new Item.Properties().food(AAFoods.PUFFBALL_CUTLET)));

    @SuppressWarnings("unchecked")
    public static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<? extends Item> item) {
        DeferredItem<Item> toReturn = ITEMS.register(name, item);
        return (DeferredItem<T>) toReturn;
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
            event.insertAfter(Items.POLISHED_BASALT.getDefaultInstance(), AABlocks.BLACKSALT_TILES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.BLACKSALT_TILES.toStack(), AABlocks.BLACKSALT_TILE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.BLACKSALT_TILE_STAIRS.toStack(), AABlocks.BLACKSALT_TILE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
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
            event.insertAfter(Items.BRICK_WALL.getDefaultInstance(), AABlocks.SHUFFLED_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.SHUFFLED_BRICKS.toStack(), AABlocks.SHUFFLED_BRICK_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.SHUFFLED_BRICK_STAIRS.toStack(), AABlocks.SHUFFLED_BRICK_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.SHUFFLED_BRICK_SLAB.toStack(), AABlocks.SHUFFLED_BRICK_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.SHUFFLED_BRICK_WALL.toStack(), AABlocks.MOSSY_SHUFFLED_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_SHUFFLED_BRICKS.toStack(), AABlocks.MOSSY_SHUFFLED_BRICK_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_SHUFFLED_BRICK_STAIRS.toStack(), AABlocks.MOSSY_SHUFFLED_BRICK_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_SHUFFLED_BRICK_SLAB.toStack(), AABlocks.MOSSY_SHUFFLED_BRICK_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Ashroot woodset (added after cherry in building blocks)
            event.insertAfter(Items.MANGROVE_BUTTON.getDefaultInstance(), AABlocks.ASHROOT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
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
            // Red Bamboo woodset (added after bamboo in building blocks)
            event.insertAfter(Items.BAMBOO_BUTTON.getDefaultInstance(), AABlocks.RED_BAMBOO_BLOCK.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_BLOCK.toStack(), AABlocks.STRIPPED_RED_BAMBOO_BLOCK.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STRIPPED_RED_BAMBOO_BLOCK.toStack(), AABlocks.RED_BAMBOO_PLANKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_PLANKS.toStack(), AABlocks.RED_BAMBOO_MOSAIC.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_MOSAIC.toStack(), AABlocks.RED_BAMBOO_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_STAIRS.toStack(), AABlocks.RED_BAMBOO_MOSAIC_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_MOSAIC_STAIRS.toStack(), AABlocks.RED_BAMBOO_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_SLAB.toStack(), AABlocks.RED_BAMBOO_MOSAIC_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_MOSAIC_SLAB.toStack(), AABlocks.RED_BAMBOO_FENCE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_FENCE.toStack(), AABlocks.RED_BAMBOO_FENCE_GATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_FENCE_GATE.toStack(), AABlocks.RED_BAMBOO_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_DOOR.toStack(), AABlocks.RED_BAMBOO_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_TRAPDOOR.toStack(), AABlocks.RED_BAMBOO_PRESSURE_PLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RED_BAMBOO_PRESSURE_PLATE.toStack(), AABlocks.RED_BAMBOO_BUTTON.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Stone blocks
            event.insertAfter(Items.STONE_SLAB.getDefaultInstance(), AABlocks.STONE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STONE_WALL.toStack(), AABlocks.STONE_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STONE_DOOR.toStack(), AABlocks.STONE_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.STONE_BUTTON.getDefaultInstance(), AABlocks.MOSSY_STONE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_STONE.toStack(), AABlocks.MOSSY_STONE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_STONE_STAIRS.toStack(), AABlocks.MOSSY_STONE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_STONE_SLAB.toStack(), AABlocks.MOSSY_STONE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.BASALT.getDefaultInstance(), AABlocks.MOSSY_BASALT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Mud blocks
            event.insertAfter(Items.MUD_BRICK_WALL.getDefaultInstance(), AABlocks.MUD_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MUD_DOOR.toStack(), AABlocks.MUD_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MUD_TRAPDOOR.toStack(), AABlocks.CHISELED_MUD_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CHISELED_MUD_BRICKS.toStack(), AABlocks.MOSSY_MUD_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_MUD_BRICKS.toStack(), AABlocks.MOSSY_MUD_BRICK_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_MUD_BRICK_STAIRS.toStack(), AABlocks.MOSSY_MUD_BRICK_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_MUD_BRICK_SLAB.toStack(), AABlocks.MOSSY_MUD_BRICK_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Mossy deepslate blocks
            event.insertAfter(Items.DEEPSLATE.getDefaultInstance(), AABlocks.MOSSY_DEEPSLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.CHISELED_DEEPSLATE.getDefaultInstance(), AABlocks.DEEPSLATE_PILLAR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.CHISELED_DEEPSLATE.getDefaultInstance(), AABlocks.MOSSY_COBBLED_DEEPSLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_COBBLED_DEEPSLATE.toStack(), AABlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.toStack(), AABlocks.MOSSY_COBBLED_DEEPSLATE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_COBBLED_DEEPSLATE_SLAB.toStack(), AABlocks.MOSSY_COBBLED_DEEPSLATE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.POLISHED_DEEPSLATE_WALL.getDefaultInstance(), AABlocks.MOSSY_POLISHED_DEEPSLATE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_POLISHED_DEEPSLATE.toStack(), AABlocks.MOSSY_POLISHED_DEEPSLATE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_POLISHED_DEEPSLATE_STAIRS.toStack(), AABlocks.MOSSY_POLISHED_DEEPSLATE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_POLISHED_DEEPSLATE_SLAB.toStack(), AABlocks.MOSSY_POLISHED_DEEPSLATE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.DEEPSLATE_BRICK_WALL.getDefaultInstance(), AABlocks.MOSSY_DEEPSLATE_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_DEEPSLATE_BRICKS.toStack(), AABlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.toStack(), AABlocks.MOSSY_DEEPSLATE_BRICK_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_DEEPSLATE_BRICK_SLAB.toStack(), AABlocks.MOSSY_DEEPSLATE_BRICK_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.DEEPSLATE_TILE_WALL.getDefaultInstance(), AABlocks.MOSSY_DEEPSLATE_TILES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_DEEPSLATE_TILES.toStack(), AABlocks.MOSSY_DEEPSLATE_TILE_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_DEEPSLATE_TILE_STAIRS.toStack(), AABlocks.MOSSY_DEEPSLATE_TILE_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.MOSSY_DEEPSLATE_TILE_SLAB.toStack(), AABlocks.MOSSY_DEEPSLATE_TILE_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // Stone Doors & Trapdoors
            event.insertAfter(Items.COBBLED_DEEPSLATE_WALL.getDefaultInstance(), AABlocks.DEEPSLATE_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.DEEPSLATE_DOOR.toStack(), AABlocks.DEEPSLATE_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.POLISHED_BLACKSTONE_WALL.getDefaultInstance(), AABlocks.BLACKSTONE_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.BLACKSTONE_DOOR.toStack(), AABlocks.BLACKSTONE_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.NETHER_BRICK_FENCE.getDefaultInstance(), AABlocks.NETHER_BRICK_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.NETHER_BRICK_DOOR.toStack(), AABlocks.NETHER_BRICK_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            if (AAModCompats.NOMANSLAND.isLoaded()) {
                event.insertAfter(AABlocks.ASHROOT_SLAB.toStack(), NMLIntegration.ASHROOT_BOOKSHELF.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(NMLIntegration.ASHROOT_BOOKSHELF.toStack(), NMLIntegration.TRIMMED_ASHROOT_PLANKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(AABlocks.GOURDROT_SLAB.toStack(), NMLIntegration.GOURDROT_BOOKSHELF.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(NMLIntegration.GOURDROT_BOOKSHELF.toStack(), NMLIntegration.TRIMMED_GOURDROT_PLANKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(AABlocks.RED_BAMBOO_MOSAIC_SLAB.toStack(), NMLIntegration.RED_BAMBOO_BOOKSHELF.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(NMLIntegration.RED_BAMBOO_BOOKSHELF.toStack(), NMLIntegration.TRIMMED_RED_BAMBOO_PLANKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(Items.COBBLED_DEEPSLATE_WALL.getDefaultInstance(), NMLIntegration.MOSSY_COBBLED_DEEPSLATE_BRICKS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(NMLIntegration.MOSSY_COBBLED_DEEPSLATE_BRICKS.toStack(), NMLIntegration.MOSSY_COBBLED_DEEPSLATE_BRICK_STAIRS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(NMLIntegration.MOSSY_COBBLED_DEEPSLATE_BRICK_STAIRS.toStack(), NMLIntegration.MOSSY_COBBLED_DEEPSLATE_BRICK_SLAB.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(NMLIntegration.MOSSY_COBBLED_DEEPSLATE_BRICK_SLAB.toStack(), NMLIntegration.MOSSY_COBBLED_DEEPSLATE_BRICK_WALL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            if (AAModCompats.BLOCKBOX.isLoaded()) {
                event.insertAfter(AABlocks.ASHROOT_BUTTON.toStack(), BBIntegration.ASHROOT_PALISADE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BBIntegration.ASHROOT_PALISADE.toStack(), BBIntegration.SPIKED_ASHROOT_PALISADE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BBIntegration.SPIKED_ASHROOT_PALISADE.toStack(), BBIntegration.STRIPPED_ASHROOT_PALISADE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BBIntegration.STRIPPED_ASHROOT_PALISADE.toStack(), BBIntegration.STRIPPED_SPIKED_ASHROOT_PALISADE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(AABlocks.GOURDROT_BUTTON.toStack(), BBIntegration.GOURDROT_PALISADE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BBIntegration.GOURDROT_PALISADE.toStack(), BBIntegration.SPIKED_GOURDROT_PALISADE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BBIntegration.SPIKED_GOURDROT_PALISADE.toStack(), BBIntegration.STRIPPED_GOURDROT_PALISADE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BBIntegration.STRIPPED_GOURDROT_PALISADE.toStack(), BBIntegration.STRIPPED_SPIKED_GOURDROT_PALISADE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            if (AAModCompats.FARMERSDELIGHT.isLoaded()) {
                event.insertBefore(AABlocks.ASHROOT_FENCE.toStack(), FDIntegration.ASHROOT_CABINET.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertBefore(AABlocks.GOURDROT_FENCE.toStack(), FDIntegration.GOURDROT_CABINET.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertBefore(AABlocks.RED_BAMBOO_FENCE.toStack(), FDIntegration.RED_BAMBOO_CABINET.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
        if (tabKey == CreativeModeTabs.NATURAL_BLOCKS) {
            // general natural blocks
            event.insertAfter(Items.FARMLAND.getDefaultInstance(), AABlocks.CAVE_CRUD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CAVE_CRUD.toStack(), AABlocks.CAVE_CRUD_PATH.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.PINK_PETALS.getDefaultInstance(), AABlocks.MIDNIGHT_LILY.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.PEARLESCENT_FROGLIGHT.getDefaultInstance(), AABlocks.CERULEAN_FROGLIGHT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CERULEAN_FROGLIGHT.toStack(), AAItems.CHROMATIC_FROGLIGHT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.MOSS_BLOCK.getDefaultInstance(), AABlocks.MOSS_CLUMP.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.MOSS_CARPET.getDefaultInstance(), AABlocks.RUST_MOSS_CLUMP.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RUST_MOSS_CLUMP.toStack(), AABlocks.RUST_MOSS_BLOCK.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.RUST_MOSS_BLOCK.toStack(), AABlocks.RUST_MOSS_CARPET.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // ashroot natural blocks (added after azalea)
            event.insertAfter(Items.MUDDY_MANGROVE_ROOTS.getDefaultInstance(), AABlocks.ASHROOT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.MANGROVE_PROPAGULE.getDefaultInstance(), AABlocks.ASHROOT_SAPLING.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.MANGROVE_LEAVES.getDefaultInstance(), AABlocks.ASHROOT_LEAVES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // gourdrot natural blocks (added after ashroot)
            event.insertAfter(AABlocks.ASHROOT_LOG.toStack(), AABlocks.GOURDROT_LOG.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.ASHROOT_LEAVES.toStack(), AABlocks.GOURDROT_LEAVES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.PUMPKIN.getDefaultInstance(), AABlocks.GOURDNUT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.GOURDNUT.toStack(), AABlocks.CARVED_GOURDNUT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CARVED_GOURDNUT.toStack(), AABlocks.LAMP_O_GOURD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // puffball items
            event.insertAfter(Items.RED_MUSHROOM.getDefaultInstance(), AABlocks.PORESHROOM.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.PORESHROOM.toStack(), AABlocks.PUFFBALL_MUSHROOM.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.PUFFBALL_MUSHROOM.toStack(), AABlocks.LARGE_PUFFBALL_MUSHROOM.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.LARGE_PUFFBALL_MUSHROOM.toStack(), AABlocks.CATSBANE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.NETHER_WART.getDefaultInstance(), AAItems.PUFFBALL_SPORES.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.WITHER_ROSE.getDefaultInstance(), AABlocks.SAFFRON_BUSHBUDS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.SAFFRON_BUSHBUDS.toStack(), AABlocks.CHERRY_BUSHBUDS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CHERRY_BUSHBUDS.toStack(), AABlocks.UMBRA_BUSHBUDS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.BROWN_MUSHROOM_BLOCK.getDefaultInstance(), AABlocks.LEAF_PILE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.BAMBOO.getDefaultInstance(), AABlocks.RED_BAMBOO.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.RED_MUSHROOM_BLOCK.getDefaultInstance(), AABlocks.PORESHROOM_BLOCK.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.DEAD_BUSH.getDefaultInstance(), AABlocks.CAVE_SPROUTS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CAVE_SPROUTS.toStack(), AABlocks.RUST_MOSS_SPROUTS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.LILY_PAD.getDefaultInstance(), AABlocks.SMALL_LILY_PAD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.CACTUS.getDefaultInstance(), AABlocks.CREEPING_CLOVERS.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tabKey == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(Items.SOUL_LANTERN.getDefaultInstance(), AAItems.MUD_LAMP.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.PEARLESCENT_FROGLIGHT.getDefaultInstance(), AABlocks.CERULEAN_FROGLIGHT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.CERULEAN_FROGLIGHT.toStack(), AAItems.CHROMATIC_FROGLIGHT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // signs & hanging signs
            event.insertAfter(Items.MANGROVE_HANGING_SIGN.getDefaultInstance(), AAItems.ASHROOT_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ASHROOT_SIGN.toStack(), AAItems.ASHROOT_HANGING_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ASHROOT_HANGING_SIGN.toStack(), AAItems.GOURDROT_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.GOURDROT_SIGN.toStack(), AAItems.GOURDROT_HANGING_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.BAMBOO_HANGING_SIGN.getDefaultInstance(), AAItems.RED_BAMBOO_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.RED_BAMBOO_SIGN.toStack(), AAItems.RED_BAMBOO_HANGING_SIGN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // braziers
            event.insertAfter(Items.SOUL_CAMPFIRE.getDefaultInstance(), AABlocks.STONE_BRAZIER.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AABlocks.STONE_BRAZIER.toStack(), AABlocks.SOUL_STONE_BRAZIER.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            // suspicious blocks
            event.insertAfter(Items.SUSPICIOUS_SAND.getDefaultInstance(), AABlocks.SUSPICIOUS_RED_SAND.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            if (AAModCompats.FARMERSDELIGHT.isLoaded()) {
                event.accept(FDIntegration.ASHROOT_CABINET);
                event.insertAfter(FDIntegration.ASHROOT_CABINET.toStack(), FDIntegration.GOURDROT_CABINET.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(FDIntegration.GOURDROT_CABINET.toStack(), FDIntegration.RED_BAMBOO_CABINET.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            if (AAModCompats.BLOCKBOX.isLoaded()) {
                event.insertBefore(Items.WHITE_BED.getDefaultInstance(), BBIntegration.ASHROOT_SEAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BBIntegration.ASHROOT_SEAT.toStack(), BBIntegration.GOURDROT_SEAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BBIntegration.GOURDROT_SEAT.toStack(), BBIntegration.RED_BAMBOO_SEAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
        if (tabKey == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.insertBefore(Items.PUMPKIN_PIE.getDefaultInstance(), AAItems.ROASTED_GOURDNUT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ROASTED_GOURDNUT.toStack(), AAItems.SQUASHBERRY_BREAD.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.HONEY_BOTTLE.getDefaultInstance(), AAItems.SQUASHBERRY_JAM.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.POISONOUS_POTATO.getDefaultInstance(), AAItems.PUFFBALL_SLICE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.PUFFBALL_SLICE.toStack(), AAItems.PUFFBALL_CUTLET.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            if (AAModCompats.FARMERSDELIGHT.isLoaded()) {
                event.insertAfter(Items.COOKIE.getDefaultInstance(), FDIntegration.SQUASHBERRY_COOKIE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(Items.RABBIT_STEW.getDefaultInstance(), FDIntegration.GOURDNUT_PUDDING.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            if (AAModCompats.FARMERSDELIGHT.isLoaded() && AAModCompats.NOMANSLAND.isLoaded()) event.insertAfter(AAItems.PUFFBALL_CUTLET.toStack(), FDIntegration.SWAMP_SCRAN.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tabKey == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(Items.MANGROVE_CHEST_BOAT.getDefaultInstance(), AAItems.ASHROOT_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ASHROOT_BOAT.toStack(), AAItems.ASHROOT_CHEST_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.ASHROOT_CHEST_BOAT.toStack(), AAItems.GOURDROT_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.GOURDROT_BOAT.toStack(), AAItems.GOURDROT_CHEST_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.BAMBOO_CHEST_RAFT.getDefaultInstance(), AAItems.RED_BAMBOO_RAFT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AAItems.RED_BAMBOO_RAFT.toStack(), AAItems.RED_BAMBOO_CHEST_RAFT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            if (AAModCompats.BOATLOAD.isLoaded()) {
                event.insertAfter(AAItems.ASHROOT_CHEST_BOAT.toStack(), BLIntegration.ASHROOT_FURNACE_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BLIntegration.ASHROOT_FURNACE_BOAT.toStack(), BLIntegration.LARGE_ASHROOT_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(AAItems.GOURDROT_CHEST_BOAT.toStack(), BLIntegration.GOURDROT_FURNACE_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BLIntegration.GOURDROT_FURNACE_BOAT.toStack(), BLIntegration.LARGE_GOURDROT_BOAT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(AAItems.RED_BAMBOO_CHEST_RAFT.toStack(), BLIntegration.RED_BAMBOO_FURNACE_RAFT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(BLIntegration.RED_BAMBOO_FURNACE_RAFT.toStack(), BLIntegration.WIDE_RED_BAMBOO_RAFT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
        if (tabKey == CreativeModeTabs.COMBAT) {
            event.insertAfter(Items.TNT.getDefaultInstance(), AAItems.CREEPIE_SPROUT.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tabKey == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.insertAfter(Items.OAK_DOOR.getDefaultInstance(), AABlocks.STONE_DOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.OAK_TRAPDOOR.getDefaultInstance(), AABlocks.STONE_TRAPDOOR.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
