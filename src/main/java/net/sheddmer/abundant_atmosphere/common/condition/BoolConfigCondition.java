package net.sheddmer.abundant_atmosphere.common.condition;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.jetbrains.annotations.NotNull;

public record BoolConfigCondition(ModConfigSpec.BooleanValue config, Boolean value) implements ICondition {
    public static final MapCodec<BoolConfigCondition> CODEC = RecordCodecBuilder.mapCodec(inst ->
            inst.group(Codec.BOOL.fieldOf("config").forGetter(BoolConfigCondition::config)).and(Codec.BOOL.fieldOf("value").forGetter(BoolConfigCondition::value))
                    .apply(inst, BoolConfigCondition::new));

    @Override
    public boolean test(@NotNull ICondition.IContext context) {
        if (config.isTrue() && value) {
            return true;
        } else if (config.isFalse() && !value) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @NotNull
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}