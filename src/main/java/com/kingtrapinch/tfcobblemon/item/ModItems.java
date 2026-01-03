package com.kingtrapinch.tfcobblemon.item;

import com.kingtrapinch.tfcobblemon.TFCobblemon;
import com.kingtrapinch.tfcobblemon.item.custom.BlankOrbItem;
import com.kingtrapinch.tfcobblemon.item.custom.LifeOrbItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TFCobblemon.MODID);

    public static final DeferredItem<Item> BLANK_ORB = ITEMS.registerItem("blank_orb",
            BlankOrbItem::new,
            new Item.Properties().stacksTo(1).fireResistant());

    public static final DeferredItem<Item> LIFE_ORB_CHARGING = ITEMS.registerItem("life_orb_charging", LifeOrbItem::new);

    public static final DeferredItem<Item> RAW_PROTECTOR = ITEMS.registerItem("raw_protector",
            (properties) -> new Item(properties.stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
