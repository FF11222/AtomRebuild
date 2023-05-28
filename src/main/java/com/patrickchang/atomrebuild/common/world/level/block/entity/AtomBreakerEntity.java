package com.patrickchang.atomrebuild.common.world.level.block.entity;

import com.patrickchang.atomrebuild.common.world.inventory.AtomBreakerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AtomBreakerEntity extends AbstractFurnaceBlockEntity {
    public AtomBreakerEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityType.ATOM_BREAKER, blockPos, blockState, RecipeType.SMELTING);
        super.items = NonNullList.withSize(8, ItemStack.EMPTY);
    }

    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerID, Inventory inventory) {
        return new AtomBreakerMenu(containerID, inventory, this, this.dataAccess);
    }
}
