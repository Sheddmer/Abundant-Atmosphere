package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

import static net.minecraft.world.level.block.state.properties.BlockSetType.register;

public class AABlockSetTypes {
    public static final BlockSetType ASHROOT = register(new BlockSetType(AbundantAtmosphere.MODID + ":ashroot"));
    public static final BlockSetType GOURDROT = register(new BlockSetType(AbundantAtmosphere.MODID + ":gourdrot"));
    public static final BlockSetType RED_BAMBOO = register(new BlockSetType(AbundantAtmosphere.MODID + ":red_bamboo", true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.BAMBOO_WOOD, SoundEvents.BAMBOO_WOOD_DOOR_CLOSE, SoundEvents.BAMBOO_WOOD_DOOR_OPEN, SoundEvents.BAMBOO_WOOD_TRAPDOOR_CLOSE, SoundEvents.BAMBOO_WOOD_TRAPDOOR_OPEN, SoundEvents.BAMBOO_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BAMBOO_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.BAMBOO_WOOD_BUTTON_CLICK_OFF, SoundEvents.BAMBOO_WOOD_BUTTON_CLICK_ON));
}