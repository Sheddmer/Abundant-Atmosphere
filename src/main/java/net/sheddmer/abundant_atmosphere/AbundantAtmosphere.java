package net.sheddmer.abundant_atmosphere;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;
import net.sheddmer.abundant_atmosphere.common.entity.frogvariant.AAFrogVariants;
import net.sheddmer.abundant_atmosphere.common.integration.boatload.BLIntegration;
import net.sheddmer.abundant_atmosphere.common.world.generation.AABiomePlacements;
import net.sheddmer.abundant_atmosphere.common.world.generation.AASurfaceRules;
import net.sheddmer.abundant_atmosphere.common.init.AAFoliagePlacers;
import net.sheddmer.abundant_atmosphere.common.init.AATrunkPlacers;
import net.sheddmer.abundant_atmosphere.common.init.*;
import net.sheddmer.abundant_atmosphere.common.integration.*;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(AbundantAtmosphere.MODID)
public class AbundantAtmosphere {
    public static final String MODID = "abundant_atmosphere";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AbundantAtmosphere(IEventBus bus, ModContainer modContainer) {
        AABlocks.BLOCKS.register(bus);
        AABlockEntities.BLOCK_ENTITIES.register(bus);
        AAEntities.ENTITIES.register(bus);
        AAFrogVariants.FROG_VARIANTS.register(bus);
        AAItems.ITEMS.register(bus);
        AAParticles.PARTICLES.register(bus);
        AASounds.SOUND_EVENTS.register(bus);
        AATrunkPlacers.TRUNK_PLACER.register(bus);
        AAFoliagePlacers.FOLIAGE_PLACER.register(bus);
        AAFeatures.FEATURES.register(bus);
        AACreativeTabs.CREATIVE_TABS.register(bus);
        AAConditions.CONDITION_CODECS.register(bus);

        if (AAModCompats.BLOCKBOX.isLoaded()) BBIntegration.register();
        if (AAModCompats.BOATLOAD.isLoaded()) BLIntegration.register();
        if (AAModCompats.FARMERSDELIGHT.isLoaded()) {
            FDIntegration.register();
            bus.addListener(FDIntegration::addBlockEntities);
        }
        if (AAModCompats.NOMANSLAND.isLoaded()) NMLIntegration.register();

        bus.addListener(AAItems::addCreative);
        bus.addListener(AABlockEntities::addBlockEntities);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, AAConfig.COMMON_CONFIG);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}