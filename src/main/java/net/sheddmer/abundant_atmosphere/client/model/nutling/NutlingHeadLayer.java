package net.sheddmer.abundant_atmosphere.client.model.nutling;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.entity.Nutling;
import org.jetbrains.annotations.NotNull;

public class NutlingHeadLayer extends RenderLayer<Nutling, NutlingModel<Nutling>> {

    private static final ResourceLocation TEXTURE = AbundantAtmosphere.location("textures/entity/equipment/gourdnut.png");
    private static final ResourceLocation TEXTURE_FRIEND = AbundantAtmosphere.location("textures/entity/equipment/gourdnut_friend.png");

    public NutlingHeadLayer(RenderLayerParent<Nutling, NutlingModel<Nutling>> renderer) {
        super(renderer);
    }

    @Override
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, Nutling nutling, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (nutling.hasGourdnut() && !nutling.isInvisible()) {
            String string = ChatFormatting.stripFormatting(nutling.getName().getString());
            int overlay = LivingEntityRenderer.getOverlayCoords(nutling, 0.0F);
            getParentModel().prepareMobModel(nutling, limbSwing, limbSwingAmount, partialTick);
            if ("Friend".equals(string)) {
                var vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(TEXTURE_FRIEND));
                getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, overlay);
            } else {
                var vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));
                getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, overlay);
            }
        }
    }
}