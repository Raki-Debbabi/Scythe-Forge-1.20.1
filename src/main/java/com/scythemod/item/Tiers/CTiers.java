package com.scythemod.item.Tiers;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class CTiers implements Tier {
    @Override
    public int getUses() {
        return 1024;
    }
    @Override
    public float getSpeed() {
        return 3.1f;
    }
    @Override
    public float getAttackDamageBonus(){
        return 3.5f;
    }
    @Override
    public int getLevel() {
        return 2;
    }
    @Override
    public int getEnchantmentValue() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.EMERALD);
    }

}
