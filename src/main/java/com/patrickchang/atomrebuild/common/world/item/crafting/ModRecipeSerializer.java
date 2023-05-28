package com.patrickchang.atomrebuild.common.world.item.crafting;

import com.patrickchang.atomrebuild.AtomRebuild;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AtomRebuild.MOD_ID)
public class ModRecipeSerializer {
    @ObjectHolder("breaking_substance")
    public static final RecipeSerializer<BreakingRecipe> BREAKING_RECIPE = null;
}
