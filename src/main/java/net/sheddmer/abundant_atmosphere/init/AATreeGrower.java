package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

import java.util.Optional;

public class AATreeGrower {
    public static final TreeGrower ASHROOT = new TreeGrower("ashroot", Optional.empty(), Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "ashroot"))), Optional.empty());
    public static final TreeGrower GOURDROT = new TreeGrower("gourdrot", Optional.empty(), Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "gourdrot"))), Optional.empty());
}
