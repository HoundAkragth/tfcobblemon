package com.kingtrapinch.tfcobblemon.item;

import com.kingtrapinch.tfcobblemon.TFCobblemon;
import com.kingtrapinch.tfcobblemon.item.custom.BlankOrbItem;
import com.kingtrapinch.tfcobblemon.item.custom.GolettItem;
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

    public static final DeferredItem<Item> GOLETT = ITEMS.registerItem("golett", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_BLACK = ITEMS.registerItem("golett_black", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_BLUE = ITEMS.registerItem("golett_blue", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_CYAN = ITEMS.registerItem("golett_cyan", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_GRAY = ITEMS.registerItem("golett_gray", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_GREEN = ITEMS.registerItem("golett_green", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_LIGHTBLUE = ITEMS.registerItem("golett_lightblue", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_LIME = ITEMS.registerItem("golett_lime", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_MAGENTA = ITEMS.registerItem("golett_magenta", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_ORANGE = ITEMS.registerItem("golett_orange", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_PINK = ITEMS.registerItem("golett_pink", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_PURPLE = ITEMS.registerItem("golett_purple", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_RED = ITEMS.registerItem("golett_red", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_WHITE = ITEMS.registerItem("golett_white", GolettItem::new);
    public static final DeferredItem<Item> GOLETT_YELLOW = ITEMS.registerItem("golett_yellow", GolettItem::new);

    public static final DeferredItem<Item> LIFE_ORB_CHARGING = ITEMS.registerItem("life_orb_charging", LifeOrbItem::new);

    public static final DeferredItem<Item> RAW_PROTECTOR = ITEMS.registerItem("raw_protector",
            (properties) -> new Item(properties.stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
