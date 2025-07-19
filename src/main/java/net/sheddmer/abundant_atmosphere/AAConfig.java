package net.sheddmer.abundant_atmosphere;

import net.neoforged.neoforge.common.ModConfigSpec;

public class AAConfig {
    public static ModConfigSpec COMMON_CONFIG;
    public static final String CATEGORY_VANILLA_CHANGES = "vanilla overrides";
    public static ModConfigSpec.BooleanValue PLANT_PLACEMENT;
    public static final String CATEGORY_BIOMES = "biome generation";
    public static ModConfigSpec.BooleanValue BIOMES;
    public static ModConfigSpec.BooleanValue BASALT_HOT_SPRINGS;
    public static ModConfigSpec.BooleanValue ANCIENT_SPRING_CAVES;

    static  {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
        COMMON_BUILDER.push(CATEGORY_VANILLA_CHANGES);
        PLANT_PLACEMENT = COMMON_BUILDER
                .comment("Determines if plants should be placeable on more block types, like mossy blocks & packed mud")
                .define("plant_placement_changes", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();

        COMMON_BUILDER.push(CATEGORY_BIOMES);
        BIOMES = COMMON_BUILDER
                .comment("Determines if custom biomes are enabled")
                .define("biomes", true);
        BASALT_HOT_SPRINGS = COMMON_BUILDER
                .comment("Determines if Basalt Hot Springs are enabled")
                .define("basalt_hot_springs", true);
        ANCIENT_SPRING_CAVES = COMMON_BUILDER
                .comment("Determines if Ancient Spring Caves are enabled")
                .define("ancient_spring_caves", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}