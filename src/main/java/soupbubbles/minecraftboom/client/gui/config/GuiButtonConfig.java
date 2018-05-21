package soupbubbles.minecraftboom.client.gui.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;

public class GuiButtonConfig extends GuiButton
{
    private static final ResourceLocation ICONS = new ResourceLocation(Assets.ASSET_PREFIX, Assets.TEXTURE_GUI_DIR + "icons.png");
    public Property prop;

    public GuiButtonConfig(int id, int x, int y, Property prop)
    {
        super(id, x, y, 20, 20, "");
        this.prop = prop;
    }

    @Override
    public void drawCenteredString(FontRenderer fontRenderer, String text, int x, int y, int color)
    {
        Minecraft mc = Minecraft.getMinecraft();
        mc.getTextureManager().bindTexture(ICONS);
        drawTexturedModalRect(this.x + 2, this.y, prop.getBoolean() ? 0 : 16, 0, 16, 16);
    }
}