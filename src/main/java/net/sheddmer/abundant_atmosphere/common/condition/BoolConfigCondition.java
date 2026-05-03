package net.sheddmer.abundant_atmosphere.common.condition;

import com.electronwill.nightconfig.core.AbstractConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import org.jetbrains.annotations.NotNull;

public record BoolConfigCondition(ModConfigSpec.BooleanValue config, Boolean value) implements ICondition {
    private static final PrimitiveCodec<ModConfigSpec.BooleanValue> BOOLEAN_VALUE_CODEC = new PrimitiveCodec<ModConfigSpec.BooleanValue>(){
        @Override
        public <T> DataResult<ModConfigSpec.BooleanValue> read(DynamicOps<T> ops, T input) {
            String configName = ops.getStringValue(input).getOrThrow();
            AbstractConfig abstractConfig = AAConfig.COMMON_CONFIG.getValues().get(AAConfig.CATEGORY_VANILLA_CHANGES);
            if (abstractConfig.valueMap().get(configName) instanceof ModConfigSpec.BooleanValue booleanValue)
                return DataResult.success(booleanValue);
            return DataResult.error(() -> ("wrong codec name: " + configName));
        }

        @Override
        public <T> T write(DynamicOps<T> ops, ModConfigSpec.BooleanValue value) {
            AbundantAtmosphere.LOGGER.warn("trying to encode BoolConfigCondition for some reason, shouldn't be doing that");
            return null;
        }
    };

    public static final MapCodec<BoolConfigCondition> CODEC = RecordCodecBuilder.mapCodec(
        inst -> inst.group(
            BOOLEAN_VALUE_CODEC.fieldOf("option").forGetter(BoolConfigCondition::config)).and(
            Codec.BOOL.fieldOf("enabled_when").forGetter(BoolConfigCondition::value))
                    .apply(inst, BoolConfigCondition::new)
    );

    @Override
    public boolean test(@NotNull ICondition.IContext context) {
        return config.get() == value;
    }

    @Override
    @NotNull
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}