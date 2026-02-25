package com.scythemod.item.ability;

import com.scythemod.Scythe;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Scythe.MODID);

    public static final RegistryObject<EntityType<SlashProjectileEntity>> SLASH =
            ENTITIES.register("slash",
                    () -> EntityType.Builder
                            .<SlashProjectileEntity>of(SlashProjectileEntity::new, MobCategory.MISC)
                            .sized(1.0f, 0.2f)
                            .build("slash"));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
