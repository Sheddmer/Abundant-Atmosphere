package net.sheddmer.abundant_atmosphere.common.entity;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.sheddmer.abundant_atmosphere.init.AAEntityTypes;
import net.sheddmer.abundant_atmosphere.init.AAItems;

public class MudBall extends ThrowableItemProjectile {
    public MudBall(EntityType<? extends MudBall> type, Level level) {
        super(type, level);
    }

    public MudBall(Level level, LivingEntity shooter) {
        super(AAEntityTypes.MUD_BALL.get(), shooter, level);
    }

    public MudBall(Level level, double x, double y, double z) {
        super(AAEntityTypes.MUD_BALL.get(), x, y, z, level);
    }

    @Override
    protected Item getDefaultItem() {
        return AAItems.MUD_BALL.asItem();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItem();
        return (ParticleOptions)(!itemstack.isEmpty() && !itemstack.is(this.getDefaultItem()) ? new ItemParticleOption(ParticleTypes.ITEM, itemstack) : ParticleTypes.ITEM_SNOWBALL);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for (int i = 0; i < 8; i++) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected double getDefaultGravity() {
        return 0.06;
    }
}
