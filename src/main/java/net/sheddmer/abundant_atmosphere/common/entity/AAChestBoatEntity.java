package net.sheddmer.abundant_atmosphere.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.sheddmer.abundant_atmosphere.init.AABlocks;
import net.sheddmer.abundant_atmosphere.init.AAEntityTypes;
import net.sheddmer.abundant_atmosphere.init.AAItems;

import java.util.function.IntFunction;

public class AAChestBoatEntity extends ChestBoat {

    public static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(AAChestBoatEntity.class, EntityDataSerializers.INT);
    public AAChestBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public AAChestBoatEntity(Level level, double pX, double pY, double pZ) {
        this(AAEntityTypes.CHEST_BOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch(getModVariant()) {
            case ASHROOT -> AAItems.ASHROOT_CHEST_BOAT.get();
            case GOURDROT -> AAItems.GOURDROT_CHEST_BOAT.get();
        };
    }

    public void setVariant(AABoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public AABoatEntity.Type getModVariant() {
        return AABoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        this.entityData.set(DATA_ID_TYPE, AABoatEntity.Type.ASHROOT.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(AABoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public static enum Type implements StringRepresentable {
        ASHROOT(AABlocks.ASHROOT_PLANKS.get(), "ashroot"),
        GOURDROT(AABlocks.GOURDROT_PLANKS.get(), "gourdrot");


        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<AAChestBoatEntity.Type> CODEC = StringRepresentable.fromEnum(AAChestBoatEntity.Type::values);
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
        public static AAChestBoatEntity.Type byId(int pId) {
            return BY_ID.apply(pId);
        }

        public static AAChestBoatEntity.Type byName(String pName) {
            return CODEC.byName(pName, ASHROOT);
        }
    }
}