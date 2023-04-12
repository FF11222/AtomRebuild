package com.patrickchang.atomrebuild.common.world.inventory;

import com.mojang.logging.LogUtils;
import com.patrickchang.atomrebuild.common.world.level.block.ModBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AtomRebuilderMenu extends AbstractContainerMenu {
    public final AlchemyTable alchemyTable;
    private final ContainerLevelAccess access;

    public AtomRebuilderMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public AtomRebuilderMenu(int containerId, Inventory inventory, ContainerLevelAccess access) {
        super(ModMenuType.ATOM_REBUILDER, containerId);
        this.alchemyTable = new AlchemyTable(8, 18, 160, 52);
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

    @Override
    public void clicked(int p_150400_, int p_150401_, ClickType p_150402_, Player p_150403_) {
        super.clicked(p_150400_, p_150401_, p_150402_, p_150403_);
        LogUtils.getLogger().debug("{}", p_150402_);
    }

    public void onPlaceAlchemyTable(int mouseX, int mouseY) {
        ItemStack stack = alchemyTable.getItem(mouseX, mouseY);
        LogUtils.getLogger().debug("{}, {}", mouseX, mouseY);
        if (stack.isEmpty()) {
            this.setCarried(alchemyTable.safeInsert(this.getCarried(), mouseX, mouseY));
        } else {
            Optional<ItemStack> optional = alchemyTable.tryRemove(mouseX, mouseY);
            optional.ifPresent(this::setCarried);
        }
    }
}
