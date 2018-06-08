package soupbubbles.minecraftboom.client.gui.config;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.util.Compatibility;

public class GuiConfig extends GuiBase
{
    protected GuiButton resetAll;
    
    public GuiConfig(GuiScreen myParent)
    {
        super(myParent);
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int i = 0;

        for (String category : ConfigurationHandler.CATEGORY_LIST)
        {
            buttonList.add(new GuiButtonCategory(i, (width / 2 - 155) + i % 2 * 160, (height / 6) + i / 2 * 24, category));
            i++;
        }

        buttonList.add(new GuiButton(24, (width / 2 - 155) + (CATEGORY_SIZE) % 2 * 160, (height / 6) + (CATEGORY_SIZE) / 2 * 24, 150, 20, "General Settings"));
        buttonList.add(resetAll = new GuiButton(25, (width / 2 - 155) + (CATEGORY_SIZE + 1) % 2 * 160, (height / 6) + (CATEGORY_SIZE + 1) / 2 * 24, 150, 20, I18n.format(Assets.CONFIG_GUI_PREFIX + "resetAll.name")));
        buttonList.add(backButton = new GuiButton(200, width / 2 - 100, height / 6 + 158, 200, 20, I18n.format("gui.done")));
        resetAll.enabled = false;
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);

        if (button instanceof GuiButtonCategory)
        {
            mc.displayGuiScreen(new GuiCategory(this, ConfigurationHandler.CATEGORY_LIST.get(button.id)));
        }
        else if(button.id == 24)
        {
            mc.displayGuiScreen(new GuiSettings(this, ConfigurationHandler.configuration.getCategory("general")));
        }
        else if (button == resetAll)
        {
        }
    }
}