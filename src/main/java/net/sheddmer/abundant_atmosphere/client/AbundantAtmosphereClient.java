package net.sheddmer.abundant_atmosphere.client;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.client.renderer.StoneChestRenderer;
import net.sheddmer.abundant_atmosphere.common.init.*;
import net.sheddmer.abundant_atmosphere.common.particle.DriedLeafParticle;
import net.sheddmer.abundant_atmosphere.common.particle.MossParticle;
import net.sheddmer.abundant_atmosphere.common.particle.FireflyParticle;
import net.sheddmer.abundant_atmosphere.common.particle.WispFlameParticle;

@EventBusSubscriber(modid = AbundantAtmosphere.MODID, value = Dist.CLIENT)
public class AbundantAtmosphereClient {

    @SubscribeEvent
    public static void registerBlockEntities(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AABlockEntityTypes.STONE_CHEST.get(), StoneChestRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AAModelLayers.STONE_CHEST, StoneChestRenderer::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(AAParticleTypes.FIREFLY.get(), FireflyParticle.Provider::new);
        event.registerSpriteSet(AAParticleTypes.WISP_FLAME.get(), WispFlameParticle.Provider::new);
        event.registerSpriteSet(AAParticleTypes.DRIED_LEAF.get(), DriedLeafParticle.Provider::new);
        event.registerSpriteSet(AAParticleTypes.FALLING_MOSS.get(), MossParticle.Provider::new);
        event.registerSpriteSet(AAParticleTypes.FALLING_RUST_MOSS.get(), MossParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        event.register((state, tintIndex) -> GrassColor.get(0.5D, 1)

        );
        event.register((stack, index) -> FoliageColor.get(0.5D, 1)

        );
        event.register(((stack, tintIndex) -> -9321636), AAItems.SMALL_LILY_PAD, Items.LILY_PAD);
    }

    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.get(0.5D, 1)

        );
        event.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : GrassColor.get(0.5D, 1)

        );
        event.register(((state, level, pos, tintIndex) -> -9321636), AABlocks.SMALL_LILY_PAD.get(), Blocks.LILY_PAD);
    }
}
