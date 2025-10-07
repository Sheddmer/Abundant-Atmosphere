package net.sheddmer.abundant_atmosphere.common.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FireflyParticle extends SimpleAnimatedParticle {
    public FireflyParticle(ClientLevel level, double x, double y, double z, double vX, double vY, double vZ, SpriteSet set) {
        super(level, x, y, z, set, 0.0125f);
        this.xd = vX + (Math.random() * 1.05D - 0.5D) * (double)0.01F;
        this.yd = vY + (Math.random() * 1.05D - 0.5D) * (double)0.01F;
        this.zd = vZ + (Math.random() * 1.05D - 0.5D) * (double)0.01F;
        this.quadSize *= 0.7F;
        this.lifetime = Mth.randomBetweenInclusive(level.random, 40, 70);
        this.gravity = 0.0F;
        this.friction = 1.0F;
        this.hasPhysics = true;
        this.setFadeColor(7512064);
        this.setSpriteFromAge(set);
    }

    public void move(double x, double y, double z) {
        this.setBoundingBox(this.getBoundingBox().move(x, y, z));
        this.setLocationFromBoundingbox();
    }

    @Override
    public void tick() {
        super.tick();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.yd -= 0.04D * (double)this.gravity;
            this.move(this.xd, this.yd, this.zd);
            if (this.speedUpWhenYMotionIsBlocked && this.y == this.yo) {
                this.xd *= 1.1D;
                this.zd *= 1.1D;
            }

            this.xd *= (double)this.friction;
            this.yd *= (double)this.friction;
            this.zd *= (double)this.friction;
            if (this.onGround) {
                this.xd *= (double)0.7F;
                this.zd *= (double)0.7F;
            }
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet spriteProvider) {
            this.sprite = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double d, double e, double f, double g, double h, double i) {
            return new FireflyParticle(level, d, e, f, g, h, i, this.sprite);
        }
    }
}
