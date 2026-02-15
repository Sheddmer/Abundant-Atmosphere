package net.sheddmer.abundant_atmosphere.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.IShearable;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AASounds;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class Nutling extends AbstractGolem implements IShearable {

    private static final EntityDataAccessor<Byte> DATA_GOURDNUT = SynchedEntityData.defineId(Nutling.class, EntityDataSerializers.BYTE);

    public Nutling(EntityType<? extends AbstractGolem> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 1.0f));
        goalSelector.addGoal(1, new FollowMobGoal(this, 1.0f, 6.0f, 8.0f));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 4.0f));
        goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0).add(Attributes.JUMP_STRENGTH, 0.45).add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_GOURDNUT, (byte)16);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Gourdnut", this.hasGourdnut());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Gourdnut")) {
            this.setGourdnut(compound.getBoolean("Gourdnut"));
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.getDeltaMovement().length() > 0.09 && this.level().isClientSide) {
            if (!this.isInvisible()) this.level().addParticle(ParticleTypes.SNOWFLAKE, this.getX(), this.getY() + 0.05, this.getZ(), (Mth.randomBetween(RandomSource.create(), -1.0F, 1.0F) * 0.08F), 0.05F, (Mth.randomBetween(RandomSource.create(), -1.0F, 1.0F) * 0.08F));
        }
        if (!this.level().isClientSide) {
            if (this.level().getBiome(this.blockPosition()).is(BiomeTags.SNOW_GOLEM_MELTS)) {
                this.hurt(this.damageSources().onFire(), 1.0F);
            }
        }
    }

    @Override
    public boolean isSensitiveToWater() {
        return true;
    }

    @Override
    public boolean isShearable(Player player, ItemStack stack, Level level, BlockPos pos) {
        return this.isAlive() && this.hasGourdnut();
    }

    @Override
    public List<ItemStack> onSheared(Player player, ItemStack item, Level level, BlockPos pos) {
        level.playSound(null, this, SoundEvents.SNOW_GOLEM_SHEAR, SoundSource.PLAYERS, 1.0f, 1.0f);
        this.setGourdnut(false);
        goalSelector.addGoal(0, new PanicGoal(this, 1.6F));
        return List.of(AABlocks.CARVED_GOURDNUT.toStack());
    }

    public boolean hasGourdnut() {
        return (entityData.get(DATA_GOURDNUT) & 16) != 0;
    }

    public void setGourdnut(boolean gourdnutEquipped) {
        byte b0 = this.entityData.get(DATA_GOURDNUT);
        if (gourdnutEquipped) {
            this.entityData.set(DATA_GOURDNUT, (byte)(b0 | 16));
        } else {
            this.entityData.set(DATA_GOURDNUT, (byte)(b0 & -17));
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AASounds.NUTLING_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return AASounds.NUTLING_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AASounds.NUTLING_DEATH.get();
    }

    @Override
    public @NotNull Vec3 getLeashOffset() {
        return new Vec3(0.0, this.getEyeHeight() - 0.2, this.getBbWidth() * 0.43F);
    }
}
