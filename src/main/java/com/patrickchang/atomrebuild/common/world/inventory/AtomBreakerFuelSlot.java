package com.patrickchang.atomrebuild.common.world.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;

public class AtomBreakerFuelSlot extends Slot {
    private final AbstractFurnaceMenu menu;
    private final RecipeType<? extends AbstractCookingRecipe> recipeType;

    public AtomBreakerFuelSlot(AbstractFurnaceMenu furnaceMenu, Container container, int slot, int x, int y) {
        super(container, slot, x, y);
        this.menu = furnaceMenu;
        this.recipeType = null;
    }

    public boolean mayPlace(ItemStack itemStack) {
        return this.isFuel(itemStack) || isBucket(itemStack);
    }

    public int getMaxStackSize(ItemStack itemStack) {
        return isBucket(itemStack) ? 1 : super.getMaxStackSize(itemStack);
    }

    public static boolean isBucket(ItemStack itemStack) {
        return itemStack.is(Items.BUCKET);
    }

    protected boolean isFuel(ItemStack p_38989_) {
        return net.minecraftforge.common.ForgeHooks.getBurnTime(p_38989_, this.recipeType) > 0;
    }
}
