package com.patrickchang.atomrebuild.common.handler;

import com.patrickchang.atomrebuild.AtomRebuild;
import com.patrickchang.atomrebuild.common.world.inventory.AtomRebuilderMenu;
import com.patrickchang.atomrebuild.common.world.item.ModCreativeModeTab;
import com.patrickchang.atomrebuild.common.world.item.SubstanceItem;
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
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("test_substance"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("hydrogen"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("helium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("lithium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("beryllium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("boron"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("carbon"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("nitrogen"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("oxygen"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("fluorine"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("neon"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("sodium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("magnesium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("aluminum"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("silicon"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("phosphorus"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("sulfur"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("chlorine"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("argon"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("potassium "));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("calcium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("scandium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("titanium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("vanadium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("chromium"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("manganese"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("iron"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("cobalt"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("nickel"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("copper"));
        event.getRegistry().register(new SubstanceItem(new Item.Properties()
                .tab(ModCreativeModeTab.TAB_ATOM_REBUILD)).setRegistryName("zinc"));
        
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
