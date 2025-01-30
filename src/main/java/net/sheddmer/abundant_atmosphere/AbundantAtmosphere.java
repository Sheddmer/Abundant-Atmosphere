package net.sheddmer.abundant_atmosphere;


import net.sheddmer.abundant_atmosphere.common.entity.frogvariant.AAFrogVariants;
import net.sheddmer.abundant_atmosphere.init.AAFoliagePlacerTypes;
import net.sheddmer.abundant_atmosphere.init.AATrunkPlacerTypes;
import net.sheddmer.abundant_atmosphere.init.*;
import net.sheddmer.abundant_atmosphere.integration.biolith.AABiomeIntegration;
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
        AAEffects.MOB_EFFECTS.register(bus);
        AAItems.ITEMS.register(bus);
        AAParticleTypes.PARTICLE_TYPES.register(bus);
        AASounds.SOUND_EVENTS.register(bus);
        AATrunkPlacerTypes.TRUNK_PLACER.register(bus);
        AAFoliagePlacerTypes.FOLIAGE_PLACER.register(bus);
        AABiomeIntegration.registerBiomes();

        bus.addListener(AAItems::addCreative);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, AAConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}