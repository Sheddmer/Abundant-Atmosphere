package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AAProperties {
    public static final IntegerProperty FLOWER_STACK = IntegerProperty.create("flower_stack", 1, 3);
    public static final BooleanProperty NIGHTLIGHT = BooleanProperty.create("nightlight");
    public static final IntegerProperty DIFFUSED_LIGHT = IntegerProperty.create("diffused_light", 0, 14);

}
