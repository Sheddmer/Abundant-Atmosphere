package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.entity.Nutling;

import java.util.function.Supplier;

public class AAEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AbundantAtmosphere.MODID);

    public static final Supplier<EntityType<Nutling>> NUTLING = ENTITY_TYPES.register("nutling", () -> EntityType.Builder.of(Nutling::new, MobCategory.MISC).sized(0.6f, 0.8f).eyeHeight(0.7f).clientTrackingRange(10).build("nutling"));

}