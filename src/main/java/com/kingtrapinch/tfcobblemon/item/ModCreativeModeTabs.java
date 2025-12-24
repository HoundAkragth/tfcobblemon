package com.kingtrapinch.tfcobblemon.item;

import com.kingtrapinch.tfcobblemon.TFCobblemon;
import com.kingtrapinch.tfcobblemon.item.custom.GolettItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TFCobblemon.MODID);

    public static final Supplier<CreativeModeTab> TFCOBBLEMON_TAB = CREATIVE_MODE_TAB.register("tfcobblemon_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GOLETT.get()))
                    .title(Component.translatable("creativetab.tfcobblemon_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLANK_ORB.get());
                        pOutput.accept(ModItems.LIFE_ORB_CHARGING.get());
                        pOutput.accept(ModItems.RAW_PROTECTOR.get());

                        pOutput.accept(ModItems.GOLETT.get());
                        pOutput.accept(ModItems.GOLETT_BLACK.get());
                        pOutput.accept(ModItems.GOLETT_BLUE.get());
                        pOutput.accept(ModItems.GOLETT_CYAN.get());
                        pOutput.accept(ModItems.GOLETT_GRAY.get());
                        pOutput.accept(ModItems.GOLETT_GREEN.get());
                        pOutput.accept(ModItems.GOLETT_LIGHTBLUE.get());
                        pOutput.accept(ModItems.GOLETT_LIME.get());
                        pOutput.accept(ModItems.GOLETT_MAGENTA.get());
                        pOutput.accept(ModItems.GOLETT_ORANGE.get());
                        pOutput.accept(ModItems.GOLETT_PINK.get());
                        pOutput.accept(ModItems.GOLETT_PURPLE.get());
                        pOutput.accept(ModItems.GOLETT_RED.get());
                        pOutput.accept(ModItems.GOLETT_WHITE.get());
                        pOutput.accept(ModItems.GOLETT_YELLOW.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
