package net.sheddmer.abundant_atmosphere;

import net.minecraft.resources.ResourceLocation;
import net.sheddmer.abundant_atmosphere.common.entity.frogvariant.AAFrogVariants;
import net.sheddmer.abundant_atmosphere.common.integration.boatload.BLIntegration;
import net.sheddmer.abundant_atmosphere.common.world.generation.AABiomePlacements;
import net.sheddmer.abundant_atmosphere.common.world.generation.AASurfaceRules;
import net.sheddmer.abundant_atmosphere.common.init.AAFoliagePlacerTypes;
import net.sheddmer.abundant_atmosphere.common.init.AATrunkPlacerTypes;
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
        bus.addListener(this::commonSetup);

        AABlocks.BLOCKS.register(bus);
        AABlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        AAEntityTypes.ENTITY_TYPES.register(bus);
        AAFrogVariants.FROG_VARIANTS.register(bus);
        AAItems.ITEMS.register(bus);
        AAParticleTypes.PARTICLE_TYPES.register(bus);
        AASounds.SOUND_EVENTS.register(bus);
        AATrunkPlacerTypes.TRUNK_PLACER.register(bus);
        AAFoliagePlacerTypes.FOLIAGE_PLACER.register(bus);
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
        bus.addListener(AABlockEntityTypes::addBlockEntities);
        bus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, AAConfig.COMMON_CONFIG);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            if (AAConfig.BIOMES.get()) {
                AABiomePlacements.register();
                AASurfaceRules.register();
            }
            AAFlammables.register();
            AAPottables.register();
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}