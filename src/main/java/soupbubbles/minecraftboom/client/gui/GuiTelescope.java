package soupbubbles.minecraftboom.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import soupbubbles.minecraftboom.reference.Assets;

public class GuiTelescope extends Gui
{
    protected static final ResourceLocation TEXTURE_OVERLAY = new ResourceLocation(Assets.ASSET_PREFIX, "textures/misc/telescope.png");
    protected static final ResourceLocation TEXTURE_OVERLAY_2 = new ResourceLocation(Assets.ASSET_PREFIX, "textures/misc/black.png");

    private Minecraft mc;

    public GuiTelescope(Minecraft minecraft)
    {
        mc = minecraft;
        ScaledResolution scaled = new ScaledResolution(mc);
        
        renderScopeOverlay(256D);
        renderScopeOverlay(400D);
    }

    protected void renderScopeOverlay(double scale)
    {
        ScaledResolution scaledRes = new ScaledResolution(mc);
        double middleHeight = scaledRes.getScaledHeight_double() / 2;
        double middleWidth = scaledRes.getScaledWidth_double() / 2;
    
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableAlpha();
        mc.getTextureManager().bindTexture(TEXTURE_OVERLAY);
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        vertexbuffer.pos(middleWidth - scale, middleHeight + scale, -90.0D).tex(0.0D, 1.0D).endVertex();
        vertexbuffer.pos(middleWidth + scale, middleHeight + scale, -90.0D).tex(1.0D, 1.0D).endVertex();
        vertexbuffer.pos(middleWidth + scale, middleHeight - scale, -90.0D).tex(1.0D, 0.0D).endVertex();
        vertexbuffer.pos(middleWidth - scale, middleHeight - scale, -90.0D).tex(0.0D, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
}