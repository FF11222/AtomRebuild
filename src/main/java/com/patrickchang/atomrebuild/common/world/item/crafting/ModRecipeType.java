package com.patrickchang.atomrebuild.common.world.item.crafting;

import com.patrickchang.atomrebuild.AtomRebuild;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AtomRebuild.MOD_ID)
public class ModRecipeType {
    public static final RecipeType<BreakingRecipe> BREAKING = register("substance_breaking");

    private static <T extends Recipe<?>> RecipeType<T> register(final String name) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(name), new RecipeType<T>() {
            public String toString() {
                return name;
            }
        });
    }
}
