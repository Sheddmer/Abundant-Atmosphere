package net.sheddmer.abundant_atmosphere.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;
import net.sheddmer.abundant_atmosphere.common.init.AAEntityTypes;
import net.sheddmer.abundant_atmosphere.common.init.AAItems;

import java.util.function.IntFunction;

public class AABoatEntity extends Boat {
    public static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(AABoatEntity.class, EntityDataSerializers.INT);

    public AABoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.entityData.set(DATA_ID_TYPE, Type.ASHROOT.ordinal());
    }

    public AABoatEntity(Level level, double pX, double pY, double pZ) {
        this(AAEntityTypes.BOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
        float f = this.getSinglePassengerXOffset();
        if (this.getPassengers().size() > 1) {
            int i = this.getPassengers().indexOf(entity);
            if (i == 0) {
                f = 0.2F;
            } else {
                f = -0.6F;
            }

            if (entity instanceof Animal) {
                f += 0.2F;
            }
        }

        return new Vec3(0.0, this.getModVariant().isRaft() ? (double)(dimensions.height() * 0.8888889F) : (double)(dimensions.height() / 3.0F), (double)f)
                .yRot(-this.getYRot() * (float) (Math.PI / 180.0));
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case ASHROOT -> AAItems.ASHROOT_BOAT.get();
            case GOURDROT -> AAItems.GOURDROT_BOAT.get();
            case RED_BAMBOO -> AAItems.RED_BAMBOO_RAFT.get();
        };
    }

    public void setVariant(Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, 0);
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(Type.byName(pCompound.getString("Type")));
        }
    }

    public enum Type implements StringRepresentable {
        ASHROOT(AABlocks.ASHROOT_PLANKS.get(), "ashroot", false),
        GOURDROT(AABlocks.GOURDROT_PLANKS.get(), "gourdrot", false),
        RED_BAMBOO(AABlocks.RED_BAMBOO_PLANKS.get(), "red_bamboo", true);

        public static final StringRepresentable.EnumCodec<AABoatEntity.Type> CODEC = StringRepresentable.fromEnum(AABoatEntity.Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        private final String name;
        private final Block planks;
        private final boolean raft;

        Type(Block pPlanks, String pName, boolean raft) {
            this.name = pName;
            this.planks = pPlanks;
            this.raft = raft;
        }

        public static AABoatEntity.Type byId(int pId) {
            return BY_ID.apply(pId);
        }

        public static AABoatEntity.Type byName(String pName) {
            return CODEC.byName(pName, ASHROOT);
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public boolean isRaft() {
            return this.raft;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }
    }
}