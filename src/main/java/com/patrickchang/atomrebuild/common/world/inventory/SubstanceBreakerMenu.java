package com.patrickchang.atomrebuild.common.world.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;

public class AtomBreakerMenu extends AbstractFurnaceMenu {
    protected AtomBreakerMenu(MenuType<?> p_38960_, RecipeType<? extends AbstractCookingRecipe> p_38961_, RecipeBookType p_38962_, int p_38963_, Inventory p_38964_) {
        super(p_38960_, p_38961_, p_38962_, p_38963_, p_38964_);
    }

    protected AtomBreakerMenu(MenuType<?> p_38966_, RecipeType<? extends AbstractCookingRecipe> p_38967_, RecipeBookType p_38968_, int p_38969_, Inventory p_38970_, Container p_38971_, ContainerData p_38972_) {
        super(p_38966_, p_38967_, p_38968_, p_38969_, p_38970_, p_38971_, p_38972_);
    }
}
