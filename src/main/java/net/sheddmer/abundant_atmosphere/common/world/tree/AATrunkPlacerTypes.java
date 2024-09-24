package net.sheddmer.abundant_atmosphere.common.world.tree;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.world.tree.placer.GourdrotTrunkPlacer;

public class AATrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, AbundantAtmosphere.MODID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<GourdrotTrunkPlacer>> GOURDROT_TRUNK_PLACER = TRUNK_PLACER.register("gourdrot_trunk_placer", () -> new TrunkPlacerType<>(GourdrotTrunkPlacer.CODEC));

    public static void register(IEventBus bus) {TRUNK_PLACER.register(bus);}
}
