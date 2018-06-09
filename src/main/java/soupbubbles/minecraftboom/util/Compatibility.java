package soupbubbles.minecraftboom.util;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Reference;

public class Compatibility
{
    public static void preInit()
    {
        load("Inspirations");
    }

    private static void load(String modname)
    {
        String s = modname + " Compatibility";
        Property prop = ConfigurationHandler.configuration.get(ConfigurationHandler.CATEGORY_COMPAT + "." + s, s, true);

        if (!isModInstalled(modname))
        {
            prop.set(false);
            ConfigurationHandler.saveConfiguration();
        }
        else
        {
            if (!prop.getBoolean())
            {
                prop.set(true);
                ConfigurationHandler.saveConfiguration();
            }

            MinecraftBoom.instance.logger.log(Level.INFO, "Found " + modname + " installed, Minecraft Boom will be altered. Check config file for more");
        }
    }

    public static boolean isModInstalled(String modName)
    {
        return Loader.isModLoaded(getModID(modName));
    }

    public static String getModID(String modname)
    {
        switch (getActualName(modname))
        {
            case "Inspirations":
            {
                return Reference.INSPIRATIONS_MOD_ID;
            }
            case "The Between Lands":
            {
                return Reference.THE_BETWEEN_LANDS_MOD_ID;
            }
            default:
            {
                throw new IllegalArgumentException("Invalid mod name: " + modname);
            }
        }
    }

    public static String getActualName(String modname)
    {
        return modname.replace(" Compatibility", "");
    }
}
