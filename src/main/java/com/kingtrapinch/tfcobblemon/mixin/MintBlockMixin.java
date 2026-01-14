package com.kingtrapinch.tfcobblemon.mixin;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.block.MintBlock;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.util.Helpers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.ParametersAreNonnullByDefault;

@Mixin(MintBlock.class)
public abstract class MintBlockMixin extends CropBlock {

    public MintBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
        return super.mayPlaceOn(p_51042_, p_51043_, p_51044_) || p_51042_.is(TagKey.create(Registries.BLOCK, ResourceLocation.parse("tfc:farmlands")));
    }
}
