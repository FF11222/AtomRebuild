package com.patrickchang.atomrebuild.common.handler;

import com.patrickchang.atomrebuild.AtomRebuild;
import com.patrickchang.atomrebuild.common.world.inventory.AtomRebuilderMenu;
import com.patrickchang.atomrebuild.common.world.item.ModCreativeModeTab;
import com.patrickchang.atomrebuild.common.world.level.block.AtomRebuilderBlock;
import com.patrickchang.atomrebuild.common.world.level.block.ModBlocks;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("ConstantConditions")
@Mod.EventBusSubscriber(modid = AtomRebuild.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(ModBlocks.ATOM_REBUILDER_BLOCK
                , new Item.Properties().tab(ModCreativeModeTab.TAB_ATOM_REBUILD))
                .setRegistryName("atom_rebuilder_block"));
    }

    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new AtomRebuilderBlock().setRegistryName("atom_rebuilder_block"));
    }

    @SubscribeEvent
    public static void onMenuTypeRegistry(final RegistryEvent.Register<MenuType<?>> event) {
        event.getRegistry().register(new MenuType<>(AtomRebuilderMenu::new).setRegistryName("atom_rebuilder"));
    }
}
