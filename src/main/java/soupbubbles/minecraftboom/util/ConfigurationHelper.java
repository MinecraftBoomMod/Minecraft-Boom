package soupbubbles.minecraftboom.util;

import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;

public class ConfigurationHelper
{

    public static int loadPropInt(String name, Category category, String comment, int default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName(), name, default_);
        prop.setComment(comment);

        return prop.getInt(default_);
    }

    public static double loadPropDouble(String name, Category category, String comment, double default_)
    {
        return loadPropDouble(name, category, comment, default_, name);
        
    }
    public static double loadPropDouble(String name, Category category, String comment, double default_, String parent)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName() + "." + parent, name, default_);
        prop.setComment(comment);

        return prop.getDouble(default_);
    }

    public static boolean loadPropBool(String name, Category category, String comment, boolean default_)
    {
        return loadPropBool(name, category, comment, default_, name);
    }
    
    public static boolean loadPropBool(String name, Category category, String comment, boolean default_, String parent)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName() + "." + parent, name, default_);
        prop.setComment(comment);

        return prop.getBoolean(default_);
    }

    public static boolean loadCategory(String name, String category, String comment, boolean default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category, name, default_);
        prop.setComment(comment);

        return prop.getBoolean(default_);
    }

    public static String loadPropString(String name, Category category, String comment, String default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName(), name, default_);
        prop.setComment(comment);

        return prop.getString();
    }

    public static String[] loadPropStringList(String name, Category category, String comment, String[] default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName(), name, default_);
        prop.setComment(comment);

        return prop.getStringList();
    }
}
