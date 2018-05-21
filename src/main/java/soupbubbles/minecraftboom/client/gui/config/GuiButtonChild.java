package soupbubbles.minecraftboom.client.gui.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.ConfigCategory;

public class GuiButtonChild extends GuiButton
{
    private ConfigCategory category;

    public GuiButtonChild(int id, int x, int y, ConfigCategory cat)
    {
        super(id, x, y, 20, 20, "");
        category = cat;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        super.drawButton(mc, mouseX, mouseY, partialTicks);

        if (visible)
        {
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.enableDepth();
            mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.IRON_PICKAXE), x + 2, y + 2);
        }
    }

    public ConfigCategory getCategory()
    {
        return category;
    }
}