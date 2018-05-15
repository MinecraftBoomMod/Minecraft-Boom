package soupbubbles.minecraftboom.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;

public class GuiCategory extends GuiBase
{
    private Category category;
    
    private static final ResourceLocation ICONS = new ResourceLocation(Assets.ASSET_PREFIX, Assets.TEXTURE_GUI_DIR + "icons.png");

    public GuiCategory(GuiScreen parent, Category category)
    {
        super(parent);
        this.category = category;
        title = Reference.MOD_NAME + ": " + category.getLocalizedName();
    }

    @Override
    public void initGui()
    {
        super.initGui();

        for (int i = 0; i < category.getList().size(); i++)
        {
            buttonList.add(new GuiButtonConfig(i + 1, (width / 2 + 106), (height / 6) + i * 24, category.getProp(i)));
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);

        if (button.id > 0 && button.id <= ConfigurationHandler.CATEGORY_LIST.length)
        {
            int index = button.id - 1;
            ConfigurationHandler.configuration.get(category.getName(), category.getProp(index).getName(), category.getProp(index).getDefault()).set(!category.getProp(index).getBoolean());
            ConfigurationHandler.loadConfiguration();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);

        for (int i = 0; i < category.getList().size(); i++)
        {
            drawString(mc.fontRenderer, I18n.format(ConfigurationHandler.getConfigName(category.getProp(i).getName())), width / 2 - 120, buttonList.get(i + 1).y + 8, 0xFFFFFF);
            boolean flag = mouseX > buttonList.get(i + 1).x + 22 && mouseX < buttonList.get(i + 1).x + 42 && mouseY > buttonList.get(i + 1).y && mouseY < buttonList.get(i + 1).y + 20;
            mc.getTextureManager().bindTexture(ICONS);
            drawTexturedModalRect(buttonList.get(i + 1).x + 22, buttonList.get(i + 1).y, flag ? 20 : 0, 16, 20, 20);
            
            if (flag)
            {
                String comment = I18n.format(Assets.CONFIG_PREFIX + category.getProp(i).getName() + ".comment.name");
                drawHoveringText(comment, mouseX, mouseY);
            }
        }
    }
}
