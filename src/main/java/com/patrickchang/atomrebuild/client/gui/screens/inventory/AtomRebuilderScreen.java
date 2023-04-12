package com.patrickchang.atomrebuild.client.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.patrickchang.atomrebuild.AtomRebuild;
import com.patrickchang.atomrebuild.common.world.inventory.AlchemyTable;
import com.patrickchang.atomrebuild.common.world.inventory.AtomRebuilderMenu;
import com.patrickchang.atomrebuild.common.world.item.SubstanceItem;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class AtomRebuilderScreen extends AbstractContainerScreen<AtomRebuilderMenu> {
    private static final ResourceLocation ATOM_REBUILDER_LOCATION = new ResourceLocation(AtomRebuild.MOD_ID, "textures/gui/container/atom_rebuilder.png");

    public AtomRebuilderScreen(AtomRebuilderMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    public void renderAlchemyTable(AlchemyTable alchemyTable) {
        if (this.minecraft == null || this.minecraft.player == null) return;
        alchemyTable.substances.forEach((stack, coordinate2i) -> {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            this.setBlitOffset(100);
            this.itemRenderer.blitOffset = 100.0f;
            RenderSystem.enableDepthTest();
            this.itemRenderer.renderAndDecorateItem(this.minecraft.player, stack, coordinate2i.x, coordinate2i.y, coordinate2i.x + coordinate2i.y * this.imageWidth);
            this.itemRenderer.renderGuiItemDecorations(this.font, stack, coordinate2i.x, coordinate2i.y, null);
            this.itemRenderer.blitOffset = 0.0f;
            this.setBlitOffset(0);
        });
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, ATOM_REBUILDER_LOCATION);
        int yPos = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, this.leftPos, yPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
        ItemStack carried = this.menu.getCarried();
        if (button == 0 && !carried.isEmpty() && carried.getItem() instanceof SubstanceItem) {
            AlchemyTable alchemyTable = this.findAlchemyTable(mouseX, mouseY);
            int mouseX1 = (int) (mouseX - this.leftPos);
            int mouseY1 = (int) (mouseY - this.topPos);
            if (alchemyTable != null) this.menu.onPlaceAlchemyTable(mouseX1, mouseY1);
        }

        return true;
    }

    @Nullable
    private AlchemyTable findAlchemyTable(double mouseX, double mouseY) {
        AlchemyTable alchemyTable = this.menu.alchemyTable;
        return this.isHovering(alchemyTable, mouseX, mouseY) ? alchemyTable : null;
    }

    private boolean isHovering(AlchemyTable alchemyTable, double mouseX, double mouseY) {
        return this.isHovering(alchemyTable.x, alchemyTable.y, alchemyTable.width, alchemyTable.height, mouseX, mouseY);
    }
}
