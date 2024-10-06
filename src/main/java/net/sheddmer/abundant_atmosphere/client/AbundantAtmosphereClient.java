package net.sheddmer.abundant_atmosphere.client;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.client.renderer.AABoatRenderer;
import net.sheddmer.abundant_atmosphere.client.renderer.StoneChestRenderer;
import net.sheddmer.abundant_atmosphere.common.particle.FireflyParticle;
import net.sheddmer.abundant_atmosphere.common.particle.WispFlameParticle;
import net.sheddmer.abundant_atmosphere.init.AABlockEntityTypes;
import net.sheddmer.abundant_atmosphere.init.AAEntityTypes;
import net.sheddmer.abundant_atmosphere.init.AAParticleTypes;

@EventBusSubscriber(modid = AbundantAtmosphere.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AbundantAtmosphereClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(AAEntityTypes.BOAT.get(), context -> new  AABoatRenderer(context, false));
        EntityRenderers.register(AAEntityTypes.CHEST_BOAT.get(), context -> new  AABoatRenderer(context, true));
    }

    @SubscribeEvent
    public static void registerBlockEntities(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AABlockEntityTypes.AA_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(AABlockEntityTypes.AA_HANGING_SIGN.get(), HangingSignRenderer::new);

        event.registerBlockEntityRenderer(AABlockEntityTypes.STONE_CHEST.get(), StoneChestRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AAModelLayers.ASHROOT_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(AAModelLayers.ASHROOT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

        event.registerLayerDefinition(AAModelLayers.GOURDROT_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(AAModelLayers.GOURDROT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

        event.registerLayerDefinition(StoneChestRenderer.STONE_CHEST, StoneChestRenderer::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(AAParticleTypes.FIREFLY.get(), FireflyParticle.Provider::new);
        event.registerSpriteSet(AAParticleTypes.WISP_FLAME.get(), WispFlameParticle.Provider::new);
    }

}
