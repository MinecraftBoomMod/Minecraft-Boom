package soupbubbles.minecraftboom.util;

import java.util.Random;

import org.apache.logging.log4j.Level;

//import knightminer.inspirations.building.InspirationsBuilding;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Reference;
import soupbubbles.minecraftboom.world.WorldGenRoses;

public class Compatibility
{
    public static final boolean IS_INSPIRATIONS_INSTALLED = Loader.isModLoaded(Reference.INSPIRATIONS_MOD_ID);
    public static final boolean IS_QUARK_INSTALLED = Loader.isModLoaded(Reference.INSPIRATIONS_MOD_ID);
    public static final boolean IS_NETHER_EX_INSTALLED = Loader.isModLoaded(Reference.INSPIRATIONS_MOD_ID);
    public static final boolean IS_CHOP_DOWN_UPDATED_INSTALLED = Loader.isModLoaded(Reference.CHOP_DOWN_UPDATED_MOD_ID);

    public static void initCompat()
    {
        if (ConfigurationHandler.compat)
        {
            if (IS_INSPIRATIONS_INSTALLED && ConfigurationHandler.inspirations)
            {
                log("Inspirations");
            }
            
            if (IS_QUARK_INSTALLED && ConfigurationHandler.quark)
            {
                log("Quark");
            }
            
            if (IS_NETHER_EX_INSTALLED && ConfigurationHandler.netherex)
            {
                log("Nether Ex");
            }
            
            if (IS_CHOP_DOWN_UPDATED_INSTALLED && ConfigurationHandler.chopDownUpdated)
            {
                log("Chop Down Updated");
            }
        }
    }
    
    private static void log(String modname)
    {
        MinecraftBoom.instance.logger.log(Level.INFO, "Found " + modname + " installed, Minecraft Boom will be altered. Check config file for more");
    }
}
