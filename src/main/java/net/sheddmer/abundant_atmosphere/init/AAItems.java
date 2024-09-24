package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.Direction;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.block.PuffballMushroomBlock;
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
    public static final DeferredItem<Item> LARGE_PUFFBALL_MUSHROOM = ITEMS.register("large_puffball_mushroom", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MUD_BALL = ITEMS.register("mud_ball", () -> new MudBallItem(new Item.Properties()));

}
