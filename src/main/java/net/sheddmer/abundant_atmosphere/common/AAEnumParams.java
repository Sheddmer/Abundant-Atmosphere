package net.sheddmer.abundant_atmosphere.common;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Items;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AAItems;

public class AAEnumParams {
    public static final EnumProxy<Boat.Type> ASHROOT_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, AABlocks.ASHROOT_PLANKS, AbundantAtmosphere.MODID + ":ashroot", AAItems.ASHROOT_BOAT, AAItems.ASHROOT_CHEST_BOAT, Items.STICK, false);
    public static final EnumProxy<Boat.Type> GOURDROT_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, AABlocks.GOURDROT_PLANKS, AbundantAtmosphere.MODID + ":gourdrot", AAItems.GOURDROT_BOAT, AAItems.GOURDROT_CHEST_BOAT, Items.STICK, false);
    public static final EnumProxy<Boat.Type> RED_BAMBOO_RAFT_TYPE = new EnumProxy<>(Boat.Type.class, AABlocks.RED_BAMBOO_PLANKS, AbundantAtmosphere.MODID + ":red_bamboo", AAItems.RED_BAMBOO_RAFT, AAItems.RED_BAMBOO_CHEST_RAFT, Items.STICK, true);
}