package net.sheddmer.abundant_atmosphere.init;

import com.google.common.collect.Sets;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AACreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AbundantAtmosphere.MODID);

    private static final Sets.SetView<DeferredHolder<Item, ? extends Item>> CREATIVE_TAB_ITEMS = Sets.union(AAItems.CREATIVE_TAB_ITEMS, AABlocks.CREATIVE_TAB_ITEMS);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABUNDANT_ATMOSPHERE_TAB = CREATIVE_TABS.register(AbundantAtmosphere.MODID, () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.abundant_atmosphere")).icon(AABlocks.ASHROOT_SAPLING::toStack)
            .displayItems((parameters, output) -> CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get()))).build());

}
