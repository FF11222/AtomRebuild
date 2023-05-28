package com.patrickchang.atomrebuild.common.world.inventory;

import com.patrickchang.atomrebuild.common.world.item.crafting.ModRecipeType;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;

public class AtomBreakerMenu extends AbstractFurnaceMenu {
    public AtomBreakerMenu(int containerID, Inventory inventory) {
        super(ModMenuType.ATOM_BREAKER, ModRecipeType.BREAKING, RecipeBookType.FURNACE, containerID, inventory);
    }

    public AtomBreakerMenu(int containerID, Inventory inventory, Container container, ContainerData containerData) {
        super(ModMenuType.ATOM_BREAKER, ModRecipeType.BREAKING, RecipeBookType.FURNACE, containerID, inventory, container, containerData);
    }
}