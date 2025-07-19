package net.sheddmer.abundant_atmosphere.common.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.sheddmer.abundant_atmosphere.common.init.AAItems;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Frog.class)
public abstract class AAFrogBucketMixin extends Animal implements Bucketable {

    @Shadow
    public abstract Holder<FrogVariant> getVariant();
    @Shadow
    public abstract void setVariant(Holder<FrogVariant> variant);
    @Unique
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(Frog.class, EntityDataSerializers.BOOLEAN);

    protected AAFrogBucketMixin(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }
        /*

    @Inject(at = @At("TAIL"), method = "defineSynchedData")
    protected void defineSynchedData(SynchedEntityData.Builder builder, CallbackInfo cir) {
        builder.define(FROM_BUCKET, false);
    }
    @Inject(at = @At("TAIL"), method = "addAdditionalSaveData")
    public void addAdditionalSaveData(CompoundTag compound, CallbackInfo cir) {
        compound.putBoolean("FromBucket", this.fromBucket());
    }
    @Inject(at = @At("TAIL"), method = "readAdditionalSaveData")
    public void readAdditionalSaveData(CompoundTag compound, CallbackInfo cir) {
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean fromBucket) {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    @NotNull
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return Bucketable.bucketMobPickup(player, hand, this).orElse(super.mobInteract(player, hand));
    }

    @Override
    public void saveToBucketTag(ItemStack stack) {
        Bucketable.saveDefaultDataToBucketTag(this, stack);
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack, tag -> {tag.putString("Variant", this.getVariant().unwrapKey().orElse(FrogVariant.TEMPERATE).location().toString());});
    }

    @Override
    public void loadFromBucketTag(CompoundTag tag) {
        Bucketable.loadDefaultDataFromBucketTag(this, tag);
    }

    @Override
    @NotNull
    public ItemStack getBucketItemStack() {
        return new ItemStack(AAItems.FROG_BUCKET.asItem());
    }

    @Override
    @NotNull
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_TADPOLE;
    }

    @Override
    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.fromBucket();
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !this.fromBucket() && !this.hasCustomName();
    }
     */

}