package com.patrickchang.atomrebuild.common.world.level.block;

import com.patrickchang.atomrebuild.common.world.inventory.AtomRebuilderMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class AtomRebuilderBlock extends Block {
    private static final Component CONTAINER_TITLE = new TranslatableComponent("container.atom_rebuilder");

    public AtomRebuilderBlock() {
        super(Properties.of(Material.METAL));
    }

    @SuppressWarnings("CodeBlock2Expr")
    public MenuProvider getMenuProvider(Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((counter, inventory, player) -> {
            return new AtomRebuilderMenu(counter, inventory, ContainerLevelAccess.create(level, blockPos));
        }, CONTAINER_TITLE);
    }
}
