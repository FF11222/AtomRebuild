package com.patrickchang.atomrebuild.common.world.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB_ATOM_REBUILD = new CreativeModeTab("atomRebuild") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.ATOM_REBUILDER_BLOCK);
        }
    };
}
