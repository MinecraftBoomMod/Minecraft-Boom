package soupbubbles.minecraftboom.client.gui.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.lib.Reference;

public class GuiSettings extends GuiConfig
{
    public GuiSettings(GuiScreen parentScreen, ConfigCategory category)
    {
        super(parentScreen, getAllElements(category), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }

    public static List<IConfigElement> getAllElements(ConfigCategory category)
    {
        List<IConfigElement> list = new ArrayList();
        
        for (IConfigElement element: new ConfigElement(category).getChildElements())
        {
            if (!element.getName().equals(category.getName()))
            {
                list.add(element);
            }
        }
        
        return list;
    }
}