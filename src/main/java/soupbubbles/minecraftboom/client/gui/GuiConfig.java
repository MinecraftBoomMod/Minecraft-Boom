package soupbubbles.minecraftboom.client.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;
import soupbubbles.minecraftboom.reference.Assets;

public class GuiConfig extends GuiBase
{
    public GuiConfig(GuiScreen myParent)
    {
        super(myParent);
    }

    @Override
    public void initGui()
    {
        super.initGui();

        for (int i = 0; i < ConfigurationHandler.CATEGORY_LIST.length; i++)
        {
            buttonList.add(new GuiButtonCategory(i + 1, (width / 2 - 155) + i % 2 * 160, (height / 6) + i / 2 * 24, ConfigurationHandler.CATEGORY_LIST[i]));
            buttonList.add(new GuiButtonEnable(i + ConfigurationHandler.CATEGORY_LIST.length + 2, (width / 2 - 25) + i % 2 * 160, (height / 6) + i / 2 * 24, ConfigurationHandler.CATEGORY_LIST[i]));
        }
        
        buttonList.add(new GuiButton(25, width / 2 - 100, backButton.y - 24, 95, 20, "Reset all"));
        buttonList.add(new GuiButton(26, width / 2 + 5, backButton.y - 24, 95, 20, ""));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
        
        for (int i = 0; i < buttonList.size(); i++)
        {
            if (buttonList.get(i) instanceof GuiButtonEnable)
            {
                GuiButtonEnable button = (GuiButtonEnable) buttonList.get(i);
                
                if (mouseX > button.x && mouseX < button.x + button.width && mouseY > button.y && mouseY < button.y + button.height)
                {
                    String s = !button.isEnabled() ? "enableall" : "disableall";
                    
                    drawHoveringText(I18n.format(Assets.CONFIG_GUI_PREFIX + s + ".name"), mouseX, mouseY);
                }
            }
        }
    }
    
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);

        if (button.id > 0 && button.id <= ConfigurationHandler.CATEGORY_LIST.length)
        {
            if (button instanceof GuiButtonCategory)
            {
                mc.displayGuiScreen(new GuiCategory(this, ConfigurationHandler.CATEGORY_LIST[button.id - 1]));
            }
        }
        else if (button.id > ConfigurationHandler.CATEGORY_LIST.length && button.id <= (ConfigurationHandler.CATEGORY_LIST.length * 2) + 2)
        {
            if (button instanceof GuiButtonEnable)
            {
                Category cat = ConfigurationHandler.CATEGORY_LIST[(button.id - 2) - ConfigurationHandler.CATEGORY_LIST.length];
                GuiButtonEnable guibutton = (GuiButtonEnable) button;

                if (guibutton.isEnabled())
                {
                    for (int i = 0; i < cat.getList().size(); i++)
                    {
                        ConfigurationHandler.configuration.get(cat.getName(), cat.getProp(i).getName(), cat.getProp(i).getDefault()).set(false);
                    }
                }
                else
                {
                    for (int i = 0; i < cat.getList().size(); i++)
                    {
                        ConfigurationHandler.configuration.get(cat.getName(), cat.getProp(i).getName(), cat.getProp(i).getDefault()).set(true);
                    }
                }
                ConfigurationHandler.loadConfiguration();
            }
        }
        else if (button.id == 25)
        {
            for (int i = 0; i < ConfigurationHandler.CATEGORY_LIST.length; i++)
            {
                Category cat = ConfigurationHandler.CATEGORY_LIST[i];

                for (int j = 0; j < cat.getList().size(); j++)
                {
                    ConfigurationHandler.configuration.get(cat.getName(), cat.getProp(j).getName(), cat.getProp(j).getDefault()).set(cat.getProp(j).getDefault());
                }
            }
            ConfigurationHandler.loadConfiguration();
        }
    }
}
