package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.world.feature.foliageplacer.AshrootFoliagePlacer;
import net.sheddmer.abundant_atmosphere.common.world.feature.foliageplacer.GourdrotFoliagePlacer;

public class AAFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, AbundantAtmosphere.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<AshrootFoliagePlacer>> ASHROOT_FOLIAGE_PLACER = FOLIAGE_PLACER.register("ashroot_foliage_placer", () -> new FoliagePlacerType<>(AshrootFoliagePlacer.CODEC));
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<GourdrotFoliagePlacer>> GOURDROT_FOLIAGE_PLACER = FOLIAGE_PLACER.register("gourdrot_foliage_placer", () -> new FoliagePlacerType<>(GourdrotFoliagePlacer.CODEC));

    public static void register(IEventBus bus) {FOLIAGE_PLACER.register(bus);}
}
