package net.sheddmer.abundant_atmosphere.common.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.sheddmer.abundant_atmosphere.AAConfig;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.entity.Nutling;
import net.sheddmer.abundant_atmosphere.common.init.AAEntities;
import net.sheddmer.abundant_atmosphere.common.init.AAFlammables;
import net.sheddmer.abundant_atmosphere.common.init.AAPottables;
import net.sheddmer.abundant_atmosphere.common.world.generation.AABiomePlacements;
import net.sheddmer.abundant_atmosphere.common.world.generation.AASurfaceRules;

@EventBusSubscriber(modid = AbundantAtmosphere.MODID)
public class AACommonSetupEvents {

    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event) {
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
    public static void createEntityAttributes(final EntityAttributeCreationEvent event) {
        event.put(AAEntities.NUTLING.get(), Nutling.createAttributes().build());
    }
}
