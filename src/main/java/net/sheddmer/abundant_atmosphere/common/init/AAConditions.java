package net.sheddmer.abundant_atmosphere.common.init;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.condition.BoolConfigCondition;

import java.util.function.Supplier;

public class AAConditions {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS = DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, AbundantAtmosphere.MODID);
    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<BoolConfigCondition>> BOOL_CONFIG_CONDITION = CONDITION_CODECS.register("boolean_config", () -> BoolConfigCondition.CODEC);
}
