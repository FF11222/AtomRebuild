package com.patrickchang.atomrebuild.common.world.inventory;

import com.patrickchang.atomrebuild.common.world.level.block.ModBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AtomRebuilderMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;

    public AtomRebuilderMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public AtomRebuilderMenu(int containerId, Inventory inventory, ContainerLevelAccess access) {
        super(ModMenuType.ATOM_REBUILDER, containerId);
        this.access = access;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(this.access, player, ModBlocks.ATOM_REBUILDER_BLOCK);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player p_38941_, int p_38942_) {
        return super.quickMoveStack(p_38941_, p_38942_);
    }
}
