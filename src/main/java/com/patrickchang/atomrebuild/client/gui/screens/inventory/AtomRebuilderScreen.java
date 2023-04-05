package com.patrickchang.atomrebuild.client.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.patrickchang.atomrebuild.AtomRebuild;
import com.patrickchang.atomrebuild.common.world.inventory.AtomRebuilderMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

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

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, ATOM_REBUILDER_LOCATION);
        int yPos = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, this.leftPos, yPos, 0, 0, this.imageWidth, this.imageHeight);
    }
}
