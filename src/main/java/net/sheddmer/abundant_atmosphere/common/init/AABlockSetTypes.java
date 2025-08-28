package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

import static net.minecraft.world.level.block.state.properties.BlockSetType.register;

public class AABlockSetTypes {
    public static final BlockSetType ASHROOT = register(new BlockSetType(AbundantAtmosphere.MODID + ":ashroot"));
    public static final BlockSetType GOURDROT = register(new BlockSetType(AbundantAtmosphere.MODID + ":gourdrot"));
    public static final BlockSetType RED_BAMBOO = register(new BlockSetType(AbundantAtmosphere.MODID + ":red_bamboo", true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.BAMBOO_WOOD, SoundEvents.BAMBOO_WOOD_DOOR_CLOSE, SoundEvents.BAMBOO_WOOD_DOOR_OPEN, SoundEvents.BAMBOO_WOOD_TRAPDOOR_CLOSE, SoundEvents.BAMBOO_WOOD_TRAPDOOR_OPEN, SoundEvents.BAMBOO_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BAMBOO_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.BAMBOO_WOOD_BUTTON_CLICK_OFF, SoundEvents.BAMBOO_WOOD_BUTTON_CLICK_ON));
    public static final BlockSetType STONE_DOOR = register(new BlockSetType(AbundantAtmosphere.MODID + ":stone_door", true, true, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.STONE, AASounds.STONE_DOOR_CLOSE.get(), AASounds.STONE_DOOR_OPEN.get(), AASounds.STONE_TRAPDOOR_CLOSE.get(), AASounds.STONE_TRAPDOOR_OPEN.get(), SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
    public static final BlockSetType DEEPSLATE_DOOR = register(new BlockSetType(AbundantAtmosphere.MODID + ":deepslate_door", true, true, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.POLISHED_DEEPSLATE, AASounds.STONE_DOOR_CLOSE.get(), AASounds.STONE_DOOR_OPEN.get(), AASounds.STONE_TRAPDOOR_CLOSE.get(), AASounds.STONE_TRAPDOOR_OPEN.get(), SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
    public static final BlockSetType MUD_DOOR = register(new BlockSetType(AbundantAtmosphere.MODID + ":mud_door", true, true, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.MUD_BRICKS, AASounds.STONE_DOOR_CLOSE.get(), AASounds.STONE_DOOR_OPEN.get(), AASounds.STONE_TRAPDOOR_CLOSE.get(), AASounds.STONE_TRAPDOOR_OPEN.get(), SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
    public static final BlockSetType NETHER_BRICK_DOOR = register(new BlockSetType(AbundantAtmosphere.MODID + ":nether_brick_door", true, true, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.NETHER_BRICKS, AASounds.STONE_DOOR_CLOSE.get(), AASounds.STONE_DOOR_OPEN.get(), AASounds.STONE_TRAPDOOR_CLOSE.get(), AASounds.STONE_TRAPDOOR_OPEN.get(), SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));

}