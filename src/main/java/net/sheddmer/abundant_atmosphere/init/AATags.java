package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AATags {

    public static final TagKey<Biome> SPAWNS_TROPICAL_FROGS = registerBiomeTag("spawns_tropical_frogs");
    public static final TagKey<Biome> SPAWNS_BUDGETT_FROGS = registerBiomeTag("spawns_budgett_frogs");
    public static final TagKey<Block> PUFFBALL_GROWS_ON = registerBlockTag("puffball_grows_on");
    public static final TagKey<Block> RED_BAMBOO_PLANTABLE_ON = registerBlockTag("red_bamboo_plantable_on");
    public static final TagKey<Block> MOSSY_BASALT_OVERGROWABLE = registerBlockTag("mossy_basalt_overgrowable");
    public static final TagKey<Block> PLANT_PLACEABLE_ON = registerBlockTag("plant_placeable_on");
    public static final TagKey<Block> SAPLING_GROWS_ON = registerBlockTag("sapling_grows_on");
    public static final TagKey<Block> STONE_BRAZIERS = registerBlockTag("stone_braziers");
    public static final TagKey<Block> MOSSY_BLOCKS = registerBlockTag("mossy_blocks");
    public static final TagKey<Block> RUST_MOSSY_BLOCKS = registerBlockTag("rust_mossy_blocks");

    private static TagKey<Biome> registerBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }
    private static TagKey<MobEffect> registerEffectTag(String name) {
        return TagKey.create(Registries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID, name));
    }

}
