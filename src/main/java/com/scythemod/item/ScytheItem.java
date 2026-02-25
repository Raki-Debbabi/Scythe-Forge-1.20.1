package com.scythemod.item;

import com.scythemod.item.ability.ModEntities;
import com.scythemod.item.ability.SlashProjectileEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ScytheItem extends Item {

    public ScytheItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide) {

            SlashProjectileEntity slash =
                    new SlashProjectileEntity(ModEntities.SLASH.get(), level);

            slash.setPos(
                    player.getX(),
                    player.getEyeY() - 2D,
                    player.getZ()
            );

            Vec3 look = player.getLookAngle();
            slash.setDeltaMovement(look.scale(1.5));

            level.addFreshEntity(slash);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}