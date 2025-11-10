package net.sheddmer.abundant_atmosphere.common.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CreepieSproutItem extends Item implements ProjectileItem {
    protected static final int DEFAULT_THROW_TIME = 15;

    public CreepieSproutItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingTicks) {
        int timeUsed = this.getUseDuration(stack, entity) - remainingTicks;
        if (timeUsed >= DEFAULT_THROW_TIME && !entity.isShiftKeyDown()) entity.releaseUsingItem();
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 7200;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack arg) {
        return UseAnim.SPEAR;
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        return null;
    }
}