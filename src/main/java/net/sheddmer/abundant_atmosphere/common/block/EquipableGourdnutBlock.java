package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import org.jetbrains.annotations.NotNull;

public class EquipableGourdnutBlock extends CarvedGourdnutBlock implements Equipable {

    public EquipableGourdnutBlock(Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}