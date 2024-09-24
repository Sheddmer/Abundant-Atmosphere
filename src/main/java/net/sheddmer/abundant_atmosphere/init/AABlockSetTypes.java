package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

import static net.minecraft.world.level.block.state.properties.BlockSetType.register;

public class AABlockSetTypes {
    public static final BlockSetType ASHROOT = register(new BlockSetType(AbundantAtmosphere.MODID + ":ashroot"));
    public static final BlockSetType GOURDROT = register(new BlockSetType(AbundantAtmosphere.MODID + ":gourdrot"));
}
