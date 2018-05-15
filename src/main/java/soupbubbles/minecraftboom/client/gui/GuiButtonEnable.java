package soupbubbles.minecraftboom.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;
import soupbubbles.minecraftboom.reference.Reference;

public class GuiButtonEnable extends GuiButton
{
    private static final ResourceLocation ICONS = new ResourceLocation(Reference.MOD_ID, "textures/gui/icons.png");
    private Category category;

    public GuiButtonEnable(int id, int x, int y, Category categoryIn)
    {
        super(id, x, y, 20, 20, "");
        category = categoryIn;
    }

    @Override
    public void drawCenteredString(FontRenderer fontRenderer, String text, int x, int y, int color)
    {
        Minecraft mc = Minecraft.getMinecraft();
        mc.getTextureManager().bindTexture(ICONS);

        drawTexturedModalRect(this.x + 2, this.y, isEnabled() ? 0 : 16, 0, 16, 16);
    }
    
    public boolean isEnabled()
    {
        boolean flag = false;
        
        for (int i = 0; i < category.getList().size(); i++)
        {
            if (category.getProp(i).getBoolean())
            {
                flag = true;
            }
        }
        
        return flag;
    }
}