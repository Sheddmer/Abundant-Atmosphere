package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AATags {

    public static final TagKey<Biome> SPAWNS_TROPICAL_VARIANT_FROGS = registerBiomeTag("spawns_tropical_variant_frogs");
    public static final TagKey<MobEffect> WISP_CANDLE_CLEARS = registerEffectTag("wisp_candle_clears");
    public static final TagKey<Block> PUFFBALL_GROW_ON = registerBlockTag("puffball_grow_on");

    private static TagKey<Biome> registerBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
    private static TagKey<MobEffect> registerEffectTag(String name) {
        return TagKey.create(Registries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }

}
