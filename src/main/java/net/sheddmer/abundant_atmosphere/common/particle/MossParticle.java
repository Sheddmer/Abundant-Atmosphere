package net.sheddmer.abundant_atmosphere.common.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;

public class MossParticle extends TextureSheetParticle {
    private final float rotSpeed;

    protected MossParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z, 0.0, 0.0, 0.0);
        this.setSprite(spriteSet.get(this.random.nextInt(12), 12));
        this.gravity = 1.0F;
        this.friction = 1.0F;
        this.rotSpeed = (float)Math.toRadians(this.random.nextBoolean() ? -90.0 : 90.0);
        float f = this.random.nextBoolean() ? 0.1F : 0.15F;
        this.lifetime = Mth.randomBetweenInclusive(level.random, 25, 40);
        this.quadSize = f;
        this.setSize(f, f);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        super.tick();
        this.oRoll = this.roll;
        if (!this.onGround) {
            this.roll = this.roll + this.rotSpeed / 10.0F;
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet spriteProvider) {
            this.sprite = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double d, double e, double f, double g, double h, double i) {
            return new MossParticle(level, d, e, f, this.sprite);
        }
    }
}
