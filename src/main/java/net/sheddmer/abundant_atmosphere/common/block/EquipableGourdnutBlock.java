package net.sheddmer.abundant_atmosphere.common.block;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;

public class EquipableGourdnutBlock extends CarvedGourdnutBlock implements Equipable {

    public EquipableGourdnutBlock(Properties properties) {
        super(properties);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}