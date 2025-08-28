package net.sheddmer.abundant_atmosphere.common.init;

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

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABUNDANT_ATMOSPHERE_TAB = CREATIVE_TABS.register(AbundantAtmosphere.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.abundant_atmosphere")).icon(AABlocks.ASHROOT_SAPLING::toStack)
            .displayItems((parameters, output) -> {
                output.accept(AABlocks.ASHROOT_LOG);
                output.accept(AABlocks.STRIPPED_ASHROOT_LOG);
                output.accept(AABlocks.ASHROOT_WOOD);
                output.accept(AABlocks.STRIPPED_ASHROOT_WOOD);

                output.accept(AAItems.ROASTED_GOURDNUT);
            }).build());

}
