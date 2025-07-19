package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.world.feature.trunkplacer.AshrootTrunkPlacer;
import net.sheddmer.abundant_atmosphere.common.world.feature.trunkplacer.GourdrotTrunkPlacer;

public class AATrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, AbundantAtmosphere.MODID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<AshrootTrunkPlacer>> ASHROOT_TRUNK_PLACER = TRUNK_PLACER.register("ashroot_trunk_placer", () -> new TrunkPlacerType<>(AshrootTrunkPlacer.CODEC));
    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<GourdrotTrunkPlacer>> GOURDROT_TRUNK_PLACER = TRUNK_PLACER.register("gourdrot_trunk_placer", () -> new TrunkPlacerType<>(GourdrotTrunkPlacer.CODEC));

    public static void register(IEventBus bus) {TRUNK_PLACER.register(bus);}
}
