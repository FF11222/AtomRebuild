package com.patrickchang.atomrebuild.client.gui.screens;

import com.patrickchang.atomrebuild.client.gui.screens.inventory.AtomRebuilderScreen;
import com.patrickchang.atomrebuild.common.world.inventory.ModMenuType;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModMenuScreens {
    @SuppressWarnings("ConstantConditions")
    public static void registerScreens() {
        MenuScreens.register(ModMenuType.ATOM_REBUILDER, AtomRebuilderScreen::new);
    }
}
