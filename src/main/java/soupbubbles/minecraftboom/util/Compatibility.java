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
        if (IS_INSPIRATIONS_INSTALLED)
        {
            MinecraftBoom.instance.logger.log(Level.INFO, "Found Inspirations installed, Minecraft Boom will be altered. Check config file for more");
            
            if (ConfigurationHandler.removeRose)
            {
                MinecraftBoom.instance.logger.log(Level.INFO, "Removing Minecraft Boom rose and replacing it with Inspiration Rose");
            }
        }
        
        if (IS_CHOP_DOWN_UPDATED_INSTALLED)
        {
            MinecraftBoom.instance.logger.log(Level.INFO, "Found Chop Down Updated installed, Minecraft Boom will be altered. Check config file for more");
        }
        
    }
    
    /*public static void genrateInspirationRoses(World world, Random rand, BlockPos pos)
    {
        if (InspirationsBuilding.flower.getDefaultState().getMaterial() != Material.AIR)
        {
            new WorldGenRoses(InspirationsBuilding.flower.getDefaultState()).generate(world, rand, pos);
        }
    }*/
}
