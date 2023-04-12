package com.patrickchang.atomrebuild.client.handler;

import com.patrickchang.atomrebuild.AtomRebuild;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = AtomRebuild.MOD_ID)
public class ScreenHandler {
    @SubscribeEvent
    public static void onMouseClicked$Pre(final ScreenEvent.MouseClickedEvent.Pre event) {

    }
}
