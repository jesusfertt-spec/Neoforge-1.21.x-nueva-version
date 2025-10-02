package net.jfgz3000.tutorialmod.item;

import net.jfgz3000.tutorialmod.Tutorialmod;
import net.jfgz3000.tutorialmod.item.custom.ChisellItem;
import net.jfgz3000.tutorialmod.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Moditems {


    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Tutorialmod.MOD_ID);

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            ()-> new Item(new Item.Properties()));


    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            ()-> new Item(new Item.Properties()));


    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChisellItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)));

    public static final DeferredItem<Item> GRANADA = ITEMS.register("granada",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GRANADA)));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new FuelItem(new Item.Properties(),1500));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

