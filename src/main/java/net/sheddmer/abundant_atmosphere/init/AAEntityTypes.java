package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.entity.AABoatEntity;
import net.sheddmer.abundant_atmosphere.common.entity.AAChestBoatEntity;
import net.sheddmer.abundant_atmosphere.common.entity.MudBall;

public class AAEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AbundantAtmosphere.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<AABoatEntity>> BOAT =
            ENTITY_TYPES.register("boat", () -> EntityType.Builder.<AABoatEntity>of(AABoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("boat"));

    public static final DeferredHolder<EntityType<?>, EntityType<AAChestBoatEntity>> CHEST_BOAT =
            ENTITY_TYPES.register("chest_boat", () -> EntityType.Builder.<AAChestBoatEntity>of(AAChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("chest_boat"));

    public static final DeferredHolder<EntityType<?>, EntityType<MudBall>> MUD_BALL =
            ENTITY_TYPES.register("mud_ball", () -> EntityType.Builder.<MudBall>of(MudBall::new, MobCategory.MISC)
            .sized(0.25f, 0.25f).clientTrackingRange(4).build("mud_ball"));
}
