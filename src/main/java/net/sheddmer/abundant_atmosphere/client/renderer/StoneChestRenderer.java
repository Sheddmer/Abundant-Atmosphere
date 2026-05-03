package net.sheddmer.abundant_atmosphere.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.neoforged.neoforge.client.RenderTypeHelper;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.block.StoneChestBlock;
import net.sheddmer.abundant_atmosphere.common.blockentity.StoneChestBlockEntity;

public class StoneChestRenderer<T extends StoneChestBlockEntity> implements BlockEntityRenderer<T> {
    public static final ModelResourceLocation BODY_MODEL = ModelResourceLocation.standalone(AbundantAtmosphere.location("block/functional/stone_chest_body_single"));
    public static final ModelResourceLocation LID_MODEL = ModelResourceLocation.standalone(AbundantAtmosphere.location("block/functional/stone_chest_lid_single"));
    public static final ModelResourceLocation LEFT_BODY_MODEL = ModelResourceLocation.standalone(AbundantAtmosphere.location("block/functional/stone_chest_body_left"));
    public static final ModelResourceLocation LEFT_LID_MODEL = ModelResourceLocation.standalone(AbundantAtmosphere.location("block/functional/stone_chest_lid_left"));
    public static final ModelResourceLocation RIGHT_BODY_MODEL = ModelResourceLocation.standalone(AbundantAtmosphere.location("block/functional/stone_chest_body_right"));
    public static final ModelResourceLocation RIGHT_LID_MODEL = ModelResourceLocation.standalone(AbundantAtmosphere.location("block/functional/stone_chest_lid_right"));

    private final BlockRenderDispatcher blockRenderer;

    public StoneChestRenderer(final BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }


    @Override
    public void render(final T chest, final float partialTick, final PoseStack poseStack, final MultiBufferSource bufferSource, final int packedLight, final int packedOverlay) {
        poseStack.pushPose();
        poseStack.rotateAround(Axis.YP.rotationDegrees(180 - chest.getBlockState().getValue(StoneChestBlock.FACING).toYRot()), 0.5f, 0.5f, 0.5f);

        poseStack.pushPose();


        BakedModel model = this.blockRenderer.getBlockModelShaper().getModelManager().getModel(BODY_MODEL);
        this.renderModel(chest, poseStack, bufferSource, packedLight, packedOverlay, model);
        model = this.blockRenderer.getBlockModelShaper().getModelManager().getModel(LID_MODEL);
        this.renderModel(chest, poseStack, bufferSource, packedLight, packedOverlay, model);
        poseStack.popPose();
        poseStack.popPose();
    }

    private void renderModel(final T chest, final PoseStack poseStack, final MultiBufferSource multiBufferSource, final int packedLight, final int packedOverlay, final BakedModel model) {
        for (final RenderType renderType : model.getRenderTypes(chest.getBlockState(), RandomSource.create(), ModelData.EMPTY)) {
            this.blockRenderer.getModelRenderer().renderModel(poseStack.last(), multiBufferSource.getBuffer(RenderTypeHelper.getEntityRenderType(renderType, true)), chest.getBlockState(), model, 1, 1, 1, packedLight, packedOverlay);
        }
    }
}