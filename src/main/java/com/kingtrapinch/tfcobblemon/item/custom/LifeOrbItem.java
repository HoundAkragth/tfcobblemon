package com.kingtrapinch.tfcobblemon.item.custom;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class LifeOrbItem extends Item {

    public LifeOrbItem(Properties properties) {
        super(properties.stacksTo(1).fireResistant().durability(100));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.tfcobblemon.life_orb_charging"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0xE347C1;
    }

    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
