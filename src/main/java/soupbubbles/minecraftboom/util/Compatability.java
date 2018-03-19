package soupbubbles.minecraftboom.util;

import java.util.logging.Logger;

import org.apache.logging.log4j.Level;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.reference.Reference;

public class Compatability
{
    public static final boolean IS_INSPIRATIONS_INSTALLED = Loader.isModLoaded(Reference.INSPIRATIONS_MOD_ID);
    public static final boolean IS_QUARK_INSTALLED = Loader.isModLoaded(Reference.INSPIRATIONS_MOD_ID);
    public static final boolean IS_NETHER_EX_INSTALLED = Loader.isModLoaded(Reference.INSPIRATIONS_MOD_ID);

    public static void initCompat()
    {
        if (IS_INSPIRATIONS_INSTALLED)
        {
            MinecraftBoom.instance.logger.log(Level.INFO, "Found Inspirations installed, Minecraft Boom will be altered. Check config file for more");
        }
        
    }
}
