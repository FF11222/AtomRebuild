package com.patrickchang.atomrebuild.client.handler;

import com.patrickchang.atomrebuild.AtomRebuild;
import com.patrickchang.atomrebuild.client.gui.screens.inventory.AtomRebuilderScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ContainerScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = AtomRebuild.MOD_ID)
public class ContainerScreenHandler {
    @SubscribeEvent
    public static void onDrawForeground(final ContainerScreenEvent.DrawForeground event) {
        if (event.getContainerScreen() instanceof AtomRebuilderScreen screen) {
            screen.renderAlchemyTable(screen.getMenu().alchemyTable);
        }
    }
}
