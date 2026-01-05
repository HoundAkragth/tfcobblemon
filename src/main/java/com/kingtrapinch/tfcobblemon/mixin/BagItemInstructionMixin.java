package com.kingtrapinch.tfcobblemon.mixin;


import com.cobblemon.mod.common.battles.interpreter.instructions.BagItemInstruction;
import com.cobblemon.mod.common.item.battle.BagItem;
import com.cobblemon.mod.common.item.interactive.PotionType;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BagItemInstruction.class)
public class BagItemInstructionMixin {

    @WrapOperation(
            method = "invoke$lambda$0",
            at= @At(value="INVOKE", target="Lcom/cobblemon/mod/common/item/battle/BagItem;getReturnItem()Lnet/minecraft/world/item/Item;")
    )
    private static Item wrapBottleGive(BagItem instance, Operation<Item> original) {
        if (!instance.getReturnItem().equals(Items.GLASS_BOTTLE)) return original.call(instance);
        if (instance instanceof PotionType) return Items.AIR;
        if (instance.getItemName().contains("elixir") || instance.getItemName().contains("ether")) return Items.AIR;
        return original.call(instance);
    }

}
