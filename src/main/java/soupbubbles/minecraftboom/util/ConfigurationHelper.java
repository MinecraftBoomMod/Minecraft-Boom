package soupbubbles.minecraftboom.util;

import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;

public class ConfigurationHelper
{
    public static boolean needsRestart;
    public static boolean allNeedRestart = false;
    public static Property lastProp;

    public static int loadPropInt(String propName, Category category, String desc, int default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName(), propName, default_);
        prop.setComment(desc);
        setNeedsRestart(prop);

        lastProp = prop;
        return prop.getInt(default_);
    }

    public static double loadPropDouble(String propName, Category category, String desc, double default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName(), propName, default_);
        prop.setComment(desc);
        setNeedsRestart(prop);

        lastProp = prop;
        return prop.getDouble(default_);
    }

    public static boolean loadPropBool(String propName, Category category, String desc, boolean default_)
    {
        return loadPropBool(propName, category.getName(), desc, default_);
    }
    
    public static boolean loadPropBool(String propName, String category, String desc, boolean default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category, propName, default_);
        prop.setComment(desc);
        setNeedsRestart(prop);

        lastProp = prop;
        return prop.getBoolean(default_);
    }

    public static String loadPropString(String propName, Category category, String desc, String default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName(), propName, default_);
        prop.setComment(desc);
        setNeedsRestart(prop);

        lastProp = prop;
        return prop.getString();
    }

    public static String[] loadPropStringList(String propName, Category category, String desc, String[] default_)
    {
        Property prop = ConfigurationHandler.configuration.get(category.getName(), propName, default_);
        prop.setComment(desc);
        setNeedsRestart(prop);

        lastProp = prop;
        return prop.getStringList();
    }

    private static void setNeedsRestart(Property prop)
    {
        if (needsRestart)
        {
            prop.setRequiresMcRestart(needsRestart);
        }
        
        needsRestart = allNeedRestart;
    }
}
