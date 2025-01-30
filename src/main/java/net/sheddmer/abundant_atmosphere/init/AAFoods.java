package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.sheddmer.abundant_atmosphere.integration.AAModCompats;

public class AAFoods {
    public static final FoodProperties PUFFBALL_SLICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties PUFFBALL_CUTLET = new FoodProperties.Builder().nutrition(7).saturationModifier(0.7F).build();
    public static final FoodProperties SWAMP_SCRAN = new FoodProperties.Builder().nutrition(6).saturationModifier(-0.25F).usingConvertsTo(Items.BOWL).alwaysEdible().effect(new MobEffectInstance(MobEffects.HUNGER, 200, 1), 1.0F).effect(new MobEffectInstance(MobEffects.POISON, 100, 0), 0.15F).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 850, 0), 0.65F).build();
    public static final FoodProperties ROASTED_GOURDNUT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build();
    public static final FoodProperties COOKED_TROPICAL_FISH = new FoodProperties.Builder().nutrition(4).saturationModifier(0.05F).build();
}