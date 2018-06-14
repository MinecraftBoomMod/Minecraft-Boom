package soupbubbles.minecraftboom.client.gui.config;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import soupbubbles.minecraftboom.lib.Reference;

public class GuiButtonConfigMenu extends GuiButton
{
    public GuiButtonConfigMenu(int x, int y)
    {
        super(-800000, x, y + 150, 150, 20, Reference.MOD_NAME + "...");
    }

    @Override
    public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int color)
    {
        super.drawCenteredString(fontRendererIn, text, x, y, 0xffffff);
    }
}