package net.sheddmer.abundant_atmosphere.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.client.AAModelLayers;
import net.sheddmer.abundant_atmosphere.common.block.StoneChestBlock;
import net.sheddmer.abundant_atmosphere.common.blockentity.StoneChestBlockEntity;

import java.util.Calendar;

@OnlyIn(Dist.CLIENT)
public class StoneChestRenderer implements BlockEntityRenderer<StoneChestBlockEntity> {
    public static final Material NORMAL_STONE_LOCATION = new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"entity/stone_chest/normal.png"));
    public static final Material LEFT_STONE_LOCATION = new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"entity/stone_chest/normal_left.png"));
    public static final Material RIGHT_STONE_LOCATION = new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(AbundantAtmosphere.MODID,"entity/stone_chest/normal_right.png"));

    private final ModelPart body;
    private final ModelPart lid;
    private boolean halloweenTextures;


    public StoneChestRenderer(BlockEntityRendererProvider.Context context) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            this.halloweenTextures = true;
        }

        ModelPart root = context.bakeLayer(AAModelLayers.STONE_CHEST);
        this.body = root.getChild("body");
        this.lid = root.getChild("lid");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-8.0F, -10.0F, -7.0F, 16.0F, 10.0F, 14.0F), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -4.0F, -10.0F, 16.0F, 4.0F, 14.0F), PartPose.offset(0.0F, 14.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void render(StoneChestBlockEntity entity, float particleTick, PoseStack stack, MultiBufferSource source, int packedLight, int packedOverlay) {
        stack.translate(0.5, 1.5, 0.5);
        stack.mulPose(Axis.XP.rotation((float) Math.PI));

        BlockState blockState = entity.getBlockState();
        if (blockState.getBlock() instanceof StoneChestBlock) {
            float f1 = blockState.getValue(StoneChestBlock.FACING).toYRot();
            stack.mulPose(Axis.YP.rotationDegrees(-f1));
        }

        VertexConsumer vertexconsumer = NORMAL_STONE_LOCATION.buffer(source, RenderType::entitySolid);
        this.body.render(stack, vertexconsumer, packedLight, packedOverlay);
        this.lid.render(stack, vertexconsumer, packedLight, packedOverlay);
    }
}