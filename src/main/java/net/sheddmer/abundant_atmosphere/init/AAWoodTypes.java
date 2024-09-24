package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.level.block.state.properties.WoodType;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public class AAWoodTypes {
    public static final WoodType ASHROOT = register(new WoodType(AbundantAtmosphere.MODID + ":ashroot", AABlockSetTypes.ASHROOT));
    public static final WoodType GOURDROT = register(new WoodType(AbundantAtmosphere.MODID + ":gourdrot", AABlockSetTypes.GOURDROT));
}
