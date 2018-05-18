package soupbubbles.minecraftboom.client.gui;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfigEntries.IConfigEntry;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;

public class GuiCategoryList extends GuiListExtended
{
    protected GuiScreen parent;
    protected Minecraft mc;
    protected Category category;

    public GuiCategoryList(Minecraft mcIn, GuiScreen parent, Category category)
    {
        super(mcIn, parent.width, parent.height, 23, parent.height - 32, 20);
        this.parent = parent;
        mc = mcIn;
        this.category = category;
    }

    @Override
    public IGuiListEntry getListEntry(int index)
    {
        return null;
    }

    @Override
    protected int getSize()
    {
        return category.getSize();
    }

}
