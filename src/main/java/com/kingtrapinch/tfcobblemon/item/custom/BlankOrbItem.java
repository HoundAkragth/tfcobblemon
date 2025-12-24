package com.kingtrapinch.tfcobblemon.item.custom;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class BlankOrbItem extends Item {

    public BlankOrbItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.tfcobblemon.blank_orb"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
