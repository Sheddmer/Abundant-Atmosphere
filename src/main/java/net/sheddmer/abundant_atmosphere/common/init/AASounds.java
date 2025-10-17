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

    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_CHEST_OPEN = SOUND_EVENTS.register("block.stone_chest.open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_chest.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_CHEST_CLOSE = SOUND_EVENTS.register("block.stone_chest.close", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_chest.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BRAZIER_CRACKLES = SOUND_EVENTS.register("block.stone_brazier.crackle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"block.stone_brazier.crackle" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> MUD_LAMP_AMBIENT = SOUND_EVENTS.register("block.mud_lamp.ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"block.mud_lamp.ambient" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> DUST_LAPIS = SOUND_EVENTS.register("item.lapis_lazuli.dusted_onto_candle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"item.lapis_lazuli.dusted_onto_candle" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> WISP_CANDLE_ACTIVATE = SOUND_EVENTS.register("block.wisp_candle.activate", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"block.wisp_candle.activate" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> GEOTHERMAL_GARDEN_ADDITIONS = SOUND_EVENTS.register("ambient.geothermal_garden.additions", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"ambient.geothermal_garden.additions" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> GEOTHERMAL_GARDEN_MUSIC = SOUND_EVENTS.register("music.overworld.geothermal_garden", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"music.overworld.geothermal_garden" )));

    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DOOR_CLOSE = SOUND_EVENTS.register("block.stone_door.close", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_door.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DOOR_OPEN = SOUND_EVENTS.register("block.stone_door.open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_door.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DOOR_LOCK = SOUND_EVENTS.register("block.stone_door.lock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_door.lock")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DOOR_UNLOCK = SOUND_EVENTS.register("block.stone_door.unlock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_door.unlock")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_TRAPDOOR_CLOSE = SOUND_EVENTS.register("block.stone_trapdoor.close", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_trapdoor.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_TRAPDOOR_OPEN = SOUND_EVENTS.register("block.stone_trapdoor.open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_trapdoor.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_TRAPDOOR_LOCK = SOUND_EVENTS.register("block.stone_trapdoor.lock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_trapdoor.lock")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_TRAPDOOR_UNLOCK = SOUND_EVENTS.register("block.stone_trapdoor.unlock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_trapdoor.unlock")));


    public static final SoundType RED_BAMBOO = new SoundType(1.0F, 0.0F, SoundEvents.BAMBOO_BREAK, SoundEvents.BAMBOO_STEP, SoundEvents.BAMBOO_PLACE, SoundEvents.BAMBOO_HIT, SoundEvents.BAMBOO_FALL);
    public static final SoundType RED_BAMBOO_WOOD = new SoundType(1.0F, 0.0F, SoundEvents.BAMBOO_WOOD_BREAK, SoundEvents.BAMBOO_WOOD_STEP, SoundEvents.BAMBOO_WOOD_PLACE, SoundEvents.BAMBOO_WOOD_HIT, SoundEvents.BAMBOO_WOOD_FALL);
}
