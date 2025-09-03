package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.sheddmer.abundant_atmosphere.common.integration.AAModCompats;

public class AAFoods {
    public static final FoodProperties ROASTED_GOURDNUT = new FoodProperties.Builder().nutrition(4).saturationModifier(0.6F).build();
    public static final FoodProperties SQUASHBERRY_JAM = new FoodProperties.Builder().nutrition(6).saturationModifier(0.55F).usingConvertsTo(Items.GLASS_BOTTLE).build();
    public static final FoodProperties SQUASHBERRY_BREAD = new FoodProperties.Builder().nutrition(10).saturationModifier(0.7F).build();
    public static final FoodProperties PUFFBALL_SLICE = AAModCompats.FARMERSDELIGHT.isLoaded() ? new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build() : null;
    public static final FoodProperties PUFFBALL_CUTLET = AAModCompats.FARMERSDELIGHT.isLoaded() ? new FoodProperties.Builder().nutrition(7).saturationModifier(0.7F).build() : null;
    public static final FoodProperties SWAMP_SCRAN = AAModCompats.FARMERSDELIGHT.isLoaded() && AAModCompats.NOMANSLAND.isLoaded() ? new FoodProperties.Builder().nutrition(6).saturationModifier(-0.25F).usingConvertsTo(Items.BOWL).alwaysEdible().effect(new MobEffectInstance(MobEffects.HUNGER, 200, 1), 1.0F).effect(new MobEffectInstance(MobEffects.POISON, 100, 0), 0.15F).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 850, 0), 0.65F).build() : null;
}