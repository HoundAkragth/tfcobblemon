package com.kingtrapinch.tfcobblemon.item.custom;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class GolettItem extends Item {

    public GolettItem(Properties properties)
    {
        super(properties.stacksTo(1).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.tfcobblemon.golett"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
