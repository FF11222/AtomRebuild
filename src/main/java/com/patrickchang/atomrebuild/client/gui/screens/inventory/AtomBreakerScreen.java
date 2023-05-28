package com.patrickchang.atomrebuild.client.gui.screens.inventory;

import com.patrickchang.atomrebuild.AtomRebuild;
import com.patrickchang.atomrebuild.common.world.inventory.AtomBreakerMenu;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AtomBreakerScreen extends AbstractFurnaceScreen<AtomBreakerMenu> {
    private static final ResourceLocation ATOM_Breaker_LOCATION = new ResourceLocation(AtomRebuild.MOD_ID, "textures/gui/container/atom_breaker.png");
    public AtomBreakerScreen(AtomBreakerMenu menu, Inventory inventory, Component component) {
        super(menu, new SmeltingRecipeBookComponent(), inventory, component, ATOM_Breaker_LOCATION);
    }
}
