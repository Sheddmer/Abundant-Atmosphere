package net.sheddmer.abundant_atmosphere;

import net.neoforged.neoforge.common.ModConfigSpec;

public class AAConfig {
    public static ModConfigSpec COMMON_CONFIG;
    public static final String CATEGORY_VANILLA_CHANGES = "overrides";
    public static ModConfigSpec.BooleanValue VANILLA_CHANGES;
    public static ModConfigSpec.BooleanValue MUD_STAGES;
    public static final String CATEGORY_BIOMES = "biomes";
    public static ModConfigSpec.BooleanValue BIOMES;
    public static ModConfigSpec.BooleanValue BASALT_HOT_SPRINGS;
    public static ModConfigSpec.BooleanValue ANCIENT_SPRING_CAVES;

    static  {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
        COMMON_BUILDER.push(CATEGORY_VANILLA_CHANGES);
        VANILLA_CHANGES = COMMON_BUILDER
                .comment("If vanilla overrides are enabled")
                .define("overrides", true);
        MUD_STAGES = COMMON_BUILDER
                .comment("If damp and wet mud are enabled")
                .define("mud_stages", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();


        COMMON_BUILDER.push(CATEGORY_BIOMES);
        BIOMES = COMMON_BUILDER
                .comment("If any custom biomes are enabled")
                .define("biomes", true);
        BASALT_HOT_SPRINGS = COMMON_BUILDER
                .comment("If the basalt hot springs is enabled")
                .define("basalt_hot_springs", true);
        ANCIENT_SPRING_CAVES = COMMON_BUILDER
                .comment("If the ancient spring caves is enabled")
                .define("basalt_hot_springs", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}