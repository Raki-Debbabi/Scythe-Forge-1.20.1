package com.scythemod.item;

import com.scythemod.Scythe;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static final DeferredRegister<Item> Items= DeferredRegister.create(
            ForgeRegistries.ITEMS, Scythe.MODID
    );
    public static final RegistryObject<Item> scythe = Items.register("scythe",
            () -> new ScytheItem(new Item.Properties()));
    public static final RegistryObject<Item> diamond_scythe = Items.register(
            "diamond_scythe",
            () -> new ScytheItem(new Item.Properties())
    );
    public static void register(IEventBus bus) {
        Items.register(bus);
    }
}
