package net.sheddmer.abundant_atmosphere.common.integration.boatload;

import com.teamabnormals.boatload.core.api.BoatloadBoatType;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.init.AAItems;

public class AABoatTypes {

    public static final BoatloadBoatType ASHROOT = BoatloadBoatType.register(BoatloadBoatType.create(AbundantAtmosphere.location("ashroot"),
            AAItems.CHROMATIC_FROGLIGHT,
            AAItems.ASHROOT_BOAT,
            AAItems.ASHROOT_CHEST_BOAT,
            BLIntegration.ASHROOT_FURNACE_BOAT,
            BLIntegration.LARGE_ASHROOT_BOAT
    ));
    public static final BoatloadBoatType GOURDROT = BoatloadBoatType.register(BoatloadBoatType.create(AbundantAtmosphere.location("gourdrot"),
            AAItems.CHROMATIC_FROGLIGHT,
            AAItems.GOURDROT_BOAT,
            AAItems.GOURDROT_CHEST_BOAT,
            BLIntegration.GOURDROT_FURNACE_BOAT,
            BLIntegration.LARGE_GOURDROT_BOAT
    ));
    public static final BoatloadBoatType RED_BAMBOO = BoatloadBoatType.register(BoatloadBoatType.create(AbundantAtmosphere.location("red_bamboo"),
            AAItems.CHROMATIC_FROGLIGHT,
            AAItems.RED_BAMBOO_RAFT,
            AAItems.RED_BAMBOO_CHEST_RAFT,
            BLIntegration.RED_BAMBOO_FURNACE_RAFT,
            BLIntegration.WIDE_RED_BAMBOO_RAFT,
            false,
            true
    ));
}