package com.kingtrapinch.tfcobblemon.mixin;


import com.cobblemon.mod.common.item.CobblemonItem;
import com.cobblemon.mod.common.item.interactive.PotionItem;
import com.cobblemon.mod.common.util.PlayerExtensionsKt;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PotionItem.class)
public class PotionItemMixin extends CobblemonItem {
    public PotionItemMixin(@NotNull Item.Properties settings) {
        super(settings);
    }

    @WrapOperation(
            method = "applyToPokemon",
            at= @At(value="INVOKE", target="Lcom/cobblemon/mod/common/util/PlayerExtensionsKt;giveOrDropItemStack$default(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;ZILjava/lang/Object;)V")
    )
    private void wrapBottleGive(Player player, ItemStack itemStack, boolean b, int i, Object o, Operation<Void> original) {

    }

}
