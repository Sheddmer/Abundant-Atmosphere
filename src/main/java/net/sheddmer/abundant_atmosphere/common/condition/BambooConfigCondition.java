package net.sheddmer.abundant_atmosphere.common.condition;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.sheddmer.abundant_atmosphere.AAConfig;

public record BambooConfigCondition(Boolean value) implements ICondition {
    public static final MapCodec<BambooConfigCondition> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(Codec.BOOL.fieldOf("value").forGetter(BambooConfigCondition::value)).apply(inst, BambooConfigCondition::new));

    @Override
    public boolean test(ICondition.IContext context) {
        if (AAConfig.BAMBOO_RECIPE_REBALANCE.isTrue() && value) {
            return true;
        } else if (AAConfig.BAMBOO_RECIPE_REBALANCE.isFalse() && !value) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
