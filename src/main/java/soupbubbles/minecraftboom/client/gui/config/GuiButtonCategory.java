package soupbubbles.minecraftboom.client.gui.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;

public class GuiButtonCategory extends GuiButton
{
    private Category category;

    public GuiButtonCategory(int id, int x, int y, Category category)
    {
        super(id, x, y, 128, 20, I18n.format(category.getLocalizedName()));
        this.category = category;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        super.drawButton(mc, mouseX, mouseY, partialTicks);

        if (visible)
        {
            ItemStack stack = category.getDisplayStack();
            
            if (stack == null || stack.getItem() == null)
            {
                stack = new ItemStack(Blocks.SAPLING);
            }
            
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.enableDepth();
            
            int y1 = y + (category == ConfigurationHandler.CATEGORY_WORLD_GEN ? 0 : 2); 
            
            mc.getRenderItem().renderItemIntoGUI(stack, x + 2, y1);
            mc.getRenderItem().renderItemIntoGUI(stack, x + width - 18, y1);
        }
    }
}