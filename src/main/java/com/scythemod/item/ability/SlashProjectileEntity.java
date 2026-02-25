package com.scythemod.item.ability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SlashProjectileEntity extends Entity {

    public SlashProjectileEntity(EntityType<? extends SlashProjectileEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {}

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {}

    @Override
    public void tick() {
        super.tick();

        // Move forward
        this.setPos(
                this.getX() + this.getDeltaMovement().x,
                this.getEyeY() + this.getDeltaMovement().y,
                this.getZ() + this.getDeltaMovement().z
        );
        if (this.tickCount > 20) {
            this.discard();
        }
    }
}