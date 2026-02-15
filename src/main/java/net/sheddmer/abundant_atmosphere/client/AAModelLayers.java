package net.sheddmer.abundant_atmosphere.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

@OnlyIn(Dist.CLIENT)
public class AAModelLayers {

    public static final ModelLayerLocation NUTLING_LAYER = new ModelLayerLocation(AbundantAtmosphere.location("nutling"), "main");

    public static final ModelLayerLocation GOURDNUT_LAYER = new ModelLayerLocation(AbundantAtmosphere.location("gourdnut"), "main");

    public static final ModelLayerLocation STONE_CHEST_LAYER = new ModelLayerLocation(AbundantAtmosphere.location("stone_chest"), "main");
}