package net.sheddmer.abundant_atmosphere.common.integration.boatload;

import com.teamabnormals.boatload.common.item.FurnaceBoatItem;
import com.teamabnormals.boatload.common.item.LargeBoatItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import static net.sheddmer.abundant_atmosphere.common.init.AAItems.registerItem;

public class BLIntegration {
    public static final DeferredItem<Item> ASHROOT_FURNACE_BOAT = registerItem("ashroot_furnace_boat", () -> new FurnaceBoatItem(AABoatTypes.ASHROOT));
    public static final DeferredItem<Item> LARGE_ASHROOT_BOAT = registerItem("large_ashroot_boat", () -> new LargeBoatItem(AABoatTypes.ASHROOT));
    public static final DeferredItem<Item> GOURDROT_FURNACE_BOAT = registerItem("gourdrot_furnace_boat", () -> new FurnaceBoatItem(AABoatTypes.GOURDROT));
    public static final DeferredItem<Item> LARGE_GOURDROT_BOAT = registerItem("large_gourdrot_boat", () -> new LargeBoatItem(AABoatTypes.GOURDROT));
    public static final DeferredItem<Item> RED_BAMBOO_FURNACE_RAFT = registerItem("red_bamboo_furnace_raft", () -> new FurnaceBoatItem(AABoatTypes.RED_BAMBOO));
    public static final DeferredItem<Item> WIDE_RED_BAMBOO_RAFT = registerItem("wide_red_bamboo_raft", () -> new LargeBoatItem(AABoatTypes.RED_BAMBOO));

    public static void register() {
    }
}