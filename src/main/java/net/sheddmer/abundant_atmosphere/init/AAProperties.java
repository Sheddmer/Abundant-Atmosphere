package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AAProperties {
    public static final IntegerProperty FLOWER_AMOUNT_3 = IntegerProperty.create("flower_amount", 1, 3);
    public static final BooleanProperty NIGHTLIGHT = BooleanProperty.create("nightlight");
    public static final BooleanProperty OVERGROWN = BooleanProperty.create("overgrown");
    public static final BooleanProperty IGNITABLE = BooleanProperty.create("ignitable");
    public static final IntegerProperty LEAF_LEVEL = IntegerProperty.create("level", 1, 2);
}
