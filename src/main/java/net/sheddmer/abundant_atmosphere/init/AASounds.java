package net.sheddmer.abundant_atmosphere.init;

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
    public static final DeferredHolder<SoundEvent, SoundEvent> DUST_LAPIS = SOUND_EVENTS.register("item.lapis_lazuli.dusting", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"item.lapis_lazuli.dusting" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> WISP_CANDLE_ACTIVATE = SOUND_EVENTS.register("block.wisp_candle.activate", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"block.wisp_candle.activate" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> ANCIENT_SPRING_CAVE_ADDITIONS = SOUND_EVENTS.register("ambient.ancient_spring_caves.additions", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"ambient.ancient_spring_caves.additions" )));
    public static final DeferredHolder<SoundEvent, SoundEvent> ANCIENT_SPRING_CAVE_MUSIC = SOUND_EVENTS.register("music.overworld.ancient_spring_caves", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"music.overworld.ancient_spring_caves" )));

    public static final SoundType RED_BAMBOO = new SoundType(1.0F, 0.0F, SoundEvents.BAMBOO_BREAK, SoundEvents.BAMBOO_STEP, SoundEvents.BAMBOO_PLACE, SoundEvents.BAMBOO_HIT, SoundEvents.BAMBOO_FALL);
    public static final SoundType RED_BAMBOO_WOOD = new SoundType(1.0F, 0.0F, SoundEvents.BAMBOO_WOOD_BREAK, SoundEvents.BAMBOO_WOOD_STEP, SoundEvents.BAMBOO_WOOD_PLACE, SoundEvents.BAMBOO_WOOD_HIT, SoundEvents.BAMBOO_WOOD_FALL);
}
