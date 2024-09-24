package net.sheddmer.abundant_atmosphere.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.sheddmer.abundant_atmosphere.init.AABlocks;
import net.sheddmer.abundant_atmosphere.init.AAEntityTypes;
import net.sheddmer.abundant_atmosphere.init.AAItems;

import java.util.function.IntFunction;

public class AABoatEntity extends Boat{
    public static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(AABoatEntity.class, EntityDataSerializers.INT);
    public AABoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public AABoatEntity(Level level, double pX, double pY,double pZ) {
        this(AAEntityTypes.BOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch(getModVariant()) {
            case ASHROOT -> AAItems.ASHROOT_BOAT.get();
            case GOURDROT -> AAItems.GOURDROT_BOAT.get();
        };
    }

    public void setVariant(Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }


    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        this.entityData.set(DATA_ID_TYPE, Type.ASHROOT.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(Type.byName(pCompound.getString("Type")));
        }
    }

    public static enum Type implements StringRepresentable {
        ASHROOT(AABlocks.ASHROOT_PLANKS.get(), "ashroot"),
        GOURDROT(AABlocks.GOURDROT_PLANKS.get(), "gourdrot");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<AABoatEntity.Type> CODEC = StringRepresentable.fromEnum(AABoatEntity.Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        private Type(Block pPlanks, String pName) {
            this.name = pName;
            this.planks = pPlanks;
        }
        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }
        public static AABoatEntity.Type byId(int pId) {
            return BY_ID.apply(pId);
        }

        public static AABoatEntity.Type byName(String pName) {
            return CODEC.byName(pName, ASHROOT);
        }
    }
}