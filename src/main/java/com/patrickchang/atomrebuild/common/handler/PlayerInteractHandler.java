package com.patrickchang.atomrebuild.common.handler;

import com.patrickchang.atomrebuild.AtomRebuild;
import com.patrickchang.atomrebuild.common.world.level.block.AtomRebuilderBlock;
import com.patrickchang.atomrebuild.common.world.level.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = AtomRebuild.MOD_ID)
public class PlayerInteractHandler {
    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent
    public static void onRightClickBlock(final PlayerInteractEvent.@NotNull RightClickBlock event) {
        if (event.getSide() == LogicalSide.SERVER) {
            Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
            if (block == ModBlocks.ATOM_REBUILDER_BLOCK) {
                event.getPlayer().openMenu(((AtomRebuilderBlock) block).getMenuProvider(event.getWorld(), event.getPos()));
            }
        }
    }
}
