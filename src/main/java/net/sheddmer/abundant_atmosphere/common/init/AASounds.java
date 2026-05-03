package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AASounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, AbundantAtmosphere.MODID);

    // Block sounds
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_CHEST_OPEN = SOUND_EVENTS.register("block.stone_chest.open", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_chest.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_CHEST_CLOSE = SOUND_EVENTS.register("block.stone_chest.close", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location( "block.stone_chest.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BRAZIER_CRACKLES = SOUND_EVENTS.register("block.stone_brazier.crackle", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_brazier.crackle")));
    public static final DeferredHolder<SoundEvent, SoundEvent> MUD_LAMP_AMBIENT = SOUND_EVENTS.register("block.mud_lamp.ambient", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.mud_lamp.ambient" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DOOR_CLOSE = SOUND_EVENTS.register("block.stone_door.close", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_door.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DOOR_OPEN = SOUND_EVENTS.register("block.stone_door.open", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_door.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DOOR_LOCK = SOUND_EVENTS.register("block.stone_door.lock", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_door.lock")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DOOR_UNLOCK = SOUND_EVENTS.register("block.stone_door.unlock", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_door.unlock")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_TRAPDOOR_CLOSE = SOUND_EVENTS.register("block.stone_trapdoor.close", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_trapdoor.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_TRAPDOOR_OPEN = SOUND_EVENTS.register("block.stone_trapdoor.open", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_trapdoor.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_TRAPDOOR_LOCK = SOUND_EVENTS.register("block.stone_trapdoor.lock", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_trapdoor.lock")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_TRAPDOOR_UNLOCK = SOUND_EVENTS.register("block.stone_trapdoor.unlock", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.stone_trapdoor.unlock")));
    public static final DeferredHolder<SoundEvent, SoundEvent> MARSHY_CHIRPS = SOUND_EVENTS.register("block.midnight_lily.marshy_chirps", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("block.midnight_lily.marshy_chirps")));
    // Entity sounds
    public static final DeferredHolder<SoundEvent, SoundEvent> NUTLING_AMBIENT = SOUND_EVENTS.register("entity.nutling.ambient", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("entity.nutling.ambient")));
    public static final DeferredHolder<SoundEvent, SoundEvent> NUTLING_HURT = SOUND_EVENTS.register("entity.nutling.hurt", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("entity.nutling.hurt")));
    public static final DeferredHolder<SoundEvent, SoundEvent> NUTLING_DEATH = SOUND_EVENTS.register("entity.nutling.death", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("entity.nutling.death")));
    // Ambient sounds
    public static final DeferredHolder<SoundEvent, SoundEvent> GEOTHERMAL_GARDEN_ADDITIONS = SOUND_EVENTS.register("ambient.geothermal_garden.additions", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("ambient.geothermal_garden.additions")));
    public static final DeferredHolder<SoundEvent, SoundEvent> GEOTHERMAL_GARDEN_MUSIC = SOUND_EVENTS.register("music.overworld.geothermal_garden", () -> SoundEvent.createVariableRangeEvent(AbundantAtmosphere.location("music.overworld.geothermal_garden")));
    // Sound types
    public static final SoundType RED_BAMBOO = new SoundType(1.0F, 0.0F, SoundEvents.BAMBOO_BREAK, SoundEvents.BAMBOO_STEP, SoundEvents.BAMBOO_PLACE, SoundEvents.BAMBOO_HIT, SoundEvents.BAMBOO_FALL);
    public static final SoundType RED_BAMBOO_WOOD = new SoundType(1.0F, 0.0F, SoundEvents.BAMBOO_WOOD_BREAK, SoundEvents.BAMBOO_WOOD_STEP, SoundEvents.BAMBOO_WOOD_PLACE, SoundEvents.BAMBOO_WOOD_HIT, SoundEvents.BAMBOO_WOOD_FALL);
}
