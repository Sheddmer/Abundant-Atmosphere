package net.sheddmer.abundant_atmosphere.integration;

import net.neoforged.fml.ModList;

public enum AAModCompats {
    BLOCKBOX,
    CREATE,
    FARMERSDELIGHT,
    NOMANSLAND;

    private final String id;

    AAModCompats() {
        id = name().toLowerCase();
    }

    public boolean isLoaded() {
        return ModList.get().isLoaded(id);
    }
}