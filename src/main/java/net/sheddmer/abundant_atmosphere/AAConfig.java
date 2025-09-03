package net.sheddmer.abundant_atmosphere;

import net.neoforged.neoforge.common.ModConfigSpec;

public class AAConfig {
    public static ModConfigSpec COMMON_CONFIG;
    public static final String CATEGORY_VANILLA_CHANGES = "vanilla overrides";
    public static ModConfigSpec.BooleanValue PLANT_PLACEMENT;
    public static ModConfigSpec.BooleanValue BAMBOO_RECIPE_REBALANCE;
    public static final String CATEGORY_BIOMES = "biome generation";
    public static ModConfigSpec.BooleanValue BIOMES;
    public static ModConfigSpec.BooleanValue ERODED_BASALT_JUNGLE;
    public static ModConfigSpec.BooleanValue GEOTHERMAL_GARDEN;

    static  {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
        COMMON_BUILDER.push(CATEGORY_VANILLA_CHANGES);
        PLANT_PLACEMENT = COMMON_BUILDER
                .comment("Changes plants so they are placeable on more block types, like mossy blocks & packed mud. These use new block tags, abundant_atmosphere/plant_placeable_on & sapling_grows_on")
                .define("plant_placement_changes", true);
        BAMBOO_RECIPE_REBALANCE = COMMON_BUILDER
                .comment("Changes bamboo recipes so you can un-craft bamboo blocks & craft planks from regular bamboo, applies to Bamboo and Red Bamboo")
                .define("bamboo_recipe_rebalance", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();

        COMMON_BUILDER.push(CATEGORY_BIOMES);
        BIOMES = COMMON_BUILDER
                .comment("Determines if custom biomes are enabled")
                .define("biomes", true);
        ERODED_BASALT_JUNGLE = COMMON_BUILDER
                .comment("Determines if Eroded Basalt Jungles are enabled & generate")
                .define("eroded_basalt_jungle", true);
        GEOTHERMAL_GARDEN = COMMON_BUILDER
                .comment("Determines if Geothermal Gardens are enabled & generate")
                .define("geothermal_garden", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}