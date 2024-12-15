package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AASounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, AbundantAtmosphere.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_CHEST_OPEN = SOUND_EVENTS.register("block.stone_chest.open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_chest.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> STONE_CHEST_CLOSE = SOUND_EVENTS.register("block.stone_chest.close", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, "block.stone_chest.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BRAZIER_CRACKLES = SOUND_EVENTS.register("block.stone_brazier.crackle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"block.stone_brazier.crackle" )));

}
