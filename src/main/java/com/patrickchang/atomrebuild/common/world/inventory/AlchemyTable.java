package com.patrickchang.atomrebuild.common.world.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import com.patrickchang.atomrebuild.common.util.math.Coordinate2i;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AlchemyTable {
    public final Map<ItemStack, Coordinate2i> substances = new HashMap<>();
    public final int x;
    public final int y;
    public final int width;
    public final int height;

    public AlchemyTable(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Optional<ItemStack> tryRemove(int mouseX, int mouseY) {
        return Optional.empty();
    }

    public ItemStack safeInsert(ItemStack stack, int mouseX, int mouseY) {
        LogUtils.getLogger().debug("{}, {}", mouseX, mouseY);
        substances.put(stack, new Coordinate2i(mouseX, mouseY));
        return ItemStack.EMPTY;
    }

    public ItemStack safeTake(int mouseX, int mouseY) {
        return ItemStack.EMPTY;
    }

    public ItemStack getItem(int mouseX, int mouseY) {
        return ItemStack.EMPTY;
    }
}
