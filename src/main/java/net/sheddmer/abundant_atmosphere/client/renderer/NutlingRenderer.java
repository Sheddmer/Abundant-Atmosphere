package net.sheddmer.abundant_atmosphere.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.client.AAModelLayers;
import net.sheddmer.abundant_atmosphere.client.model.nutling.NutlingHeadLayer;
import net.sheddmer.abundant_atmosphere.client.model.nutling.NutlingModel;
import net.sheddmer.abundant_atmosphere.common.entity.Nutling;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class NutlingRenderer extends MobRenderer<Nutling, NutlingModel<Nutling>> {

    public NutlingRenderer(EntityRendererProvider.Context context) {
        super(context, new NutlingModel<>(context.bakeLayer(AAModelLayers.NUTLING_LAYER)), 0.4F);
        addLayer(new NutlingHeadLayer(this));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Nutling nutling) {
        return AbundantAtmosphere.location("textures/entity/nutling/nutling.png");
    }
}