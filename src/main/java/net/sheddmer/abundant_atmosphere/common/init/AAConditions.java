package net.sheddmer.abundant_atmosphere.common.init;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.condition.BambooConfigCondition;

import java.util.function.Supplier;

public class AAConditions {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS = DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, AbundantAtmosphere.MODID);

    public static final Supplier<MapCodec<BambooConfigCondition>> BAMBOO_CONFIG = CONDITION_CODECS.register("bamboo_config", () -> BambooConfigCondition.CODEC);
}
