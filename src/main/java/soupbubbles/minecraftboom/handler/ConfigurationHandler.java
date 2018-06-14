package soupbubbles.minecraftboom.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.lib.Reference;
import soupbubbles.minecraftboom.util.IStairSlab;
import soupbubbles.minecraftboom.util.Utils;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean firstLoad = false;

    public static final List<String> CATEGORY_LIST = new ArrayList<String>();

    public static final String CATEGORY_WORLD_GEN = addCategory("World Generation");
    public static final String CATEGORY_TWEAKS = addCategory("Tweaks");
    public static final String CATEGORY_COMPAT = addCategory("Compatibility");
    public static final String CATEGORY_BLOCKS = addCategory("Blocks");
    public static final String CATEGORY_ITEMS = addCategory("Items");
    public static final String CATEGORY_MOBS = addCategory("Mobs");

    //General
    public static boolean minecraftBoomButton;
    public static boolean removeBlockChildren;

    //Worldgen
    public static boolean generateRoses;
    public static boolean generatePumpkins;
    public static boolean generateFallenTrees;
    public static boolean generateFineGravel;
    public static boolean generateNetherWells;
    public static boolean generateEndPiles;

    //Tweaks
    public static boolean smeltPumpkin;
    public static boolean blazeBonemeal;
    public static boolean blazeFuel;
    public static int blazeBurnTime;
    public static boolean removeSlimeBall;
    public static boolean leavesDropSticks;
    public static double stickDropRate;
    public static boolean spruceDropsPinecones;
    public static double pineconeDropRate;
    public static boolean replaceLoadingScreen;
    public static boolean silverfishDrop;
    public static boolean polarBearDrop;
    public static boolean witherSkeletonDrop;
    public static boolean elderGuardianDrop;

    //Compat
    public static boolean inspirations;
    public static boolean tryGenerateRose;

    //Blocks
    public static List<Boolean> allowedBlocks = new ArrayList<Boolean>();
    public static boolean vanillaBlocks;
    public static boolean charcoalBlockFuel;
    public static int charcoalBlockBurnTime;
    public static boolean blazeBlockFuel;
    public static int blazeBlockBurnTime;
    public static boolean witherBoneBlockFuel;
    public static int witherBoneBlockBurnTime;

    //Items
    public static List<Boolean> allowedItems = new ArrayList<Boolean>();
    public static boolean pineconeFuel;
    public static int pineconeBurnTime;
    public static boolean witherBoneFuel;
    public static int witherBoneBurnTime;
    public static boolean telescopeLoot;

    public static void initConfiguation(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile, true);
            firstLoad = true;
            MinecraftBoom.instance.logger.log(Level.INFO, "No configuration file for Minecraft Boom was found, creating new one");
        }

        //General
        minecraftBoomButton = loadCategory("Enable Minecraft Boom Button", Configuration.CATEGORY_GENERAL, "Enabling allows the Minecraft Boom button to appear in the Options menu. The Minecraft Boom configuration can always be reached through Mods -> Minecraft Boom -> Config.", true);
        removeBlockChildren = loadCategory("Disable block children if the parent block is disabled", Configuration.CATEGORY_GENERAL, "If this returns true the children blocks (stairs and slabs) will be disabled if their parent block is disabled", true);

        //Worldgen
        generateRoses = loadPropBool("Generate Roses", CATEGORY_WORLD_GEN, "Enabling allows Roses to naturally spawn in the Overworld.", true);
        generatePumpkins = loadPropBool("Generate Pumpkins", CATEGORY_WORLD_GEN, "Enabling allows Faceless Pumpkin Patches to naturally spawn in the Overworld.", true);
        generateFallenTrees = loadPropBool("Generate Fallen Trees", CATEGORY_WORLD_GEN, "Enabling allows Fallen Trees to naturally spawn in the Overworld.", true);
        generateFineGravel = loadPropBool("Generate Fine Gravel", CATEGORY_WORLD_GEN, "Enabling allows Fine Gravel Patches to naturally spawn in the Overworld.", true);
        generateNetherWells = loadPropBool("Generate Nether Wells", CATEGORY_WORLD_GEN, "Enabling allows Nether Wells to spawn in the Nether.", true);
        generateEndPiles = loadPropBool("Generate End Piles", CATEGORY_WORLD_GEN, "Enabling allows End Piles to spawn in the End.", true);

        //Tweaks
        smeltPumpkin = loadPropBool("Pumpking smelts into Orange Dye", CATEGORY_TWEAKS, "Enabling allows Pumpkins (Faceless and Hollowed) to smelt into Orange Dye in a Furnace.", true);
        blazeBonemeal = loadPropBool("Use Blaze Powder as Bonemeal", CATEGORY_TWEAKS, "Enabling allows Blaze Powder to be used as a Bonemeal on Nether Wart.", true);
        blazeFuel = loadPropBool("Use Blaze Powder as fuel in a Furnace", CATEGORY_TWEAKS, "Enabling allows Blaze Powder to be used as a fuel in a Furnace.", true);
        blazeBurnTime = loadPropInt("Blaze Powder Burn Time", CATEGORY_TWEAKS, "", 1200, "Use Blaze Powder as fuel in a Furnace");
        removeSlimeBall = loadPropBool("Remove Slime Balls from Sticky Pistons", CATEGORY_TWEAKS, "Enabling allows the Slime Ball being removed from Sticky Pistons by sneaking and right-clicking with a shovel.", true);
        leavesDropSticks = loadPropBool("Leaves drop Sticks", CATEGORY_TWEAKS, "Enabling allows a small chance of Sticks dropping when destroying Leaves.", true);
        stickDropRate = loadPropDouble("Stick Drop Rate", CATEGORY_TWEAKS, "", 0.2, "Leaves drop Sticks");
        spruceDropsPinecones = loadPropBool("Spruce Leaves drop Pinecones", CATEGORY_TWEAKS, "Enabling allows a small chance of Spruce Leaves to drop Pinecones", true);
        pineconeDropRate = loadPropDouble("Pinecone Drop Rate", CATEGORY_TWEAKS, "", 0.02, "Spruce Leaves drop Pinecones");
        replaceLoadingScreen = loadPropBool("Replace Default Loading Screen", CATEGORY_TWEAKS, "Enabling allows the background in the loading screens to be more appropriate for dimension travel.", true);
        silverfishDrop = loadPropBool("Silverfish drop Iron Nuggets", CATEGORY_TWEAKS, "", true);
        polarBearDrop = loadPropBool("Polar Bears drop Polar Bear Fur", CATEGORY_TWEAKS, "", true);
        witherSkeletonDrop = loadPropBool("Wither Skeletons drop Wither Bones", CATEGORY_TWEAKS, "", true);
        elderGuardianDrop = loadPropBool("Elder Guardians drop Elder Guardian Spikes", CATEGORY_TWEAKS, "", true);

        //Compat
        inspirations = loadPropBool("Inspirations Compatibility", CATEGORY_COMPAT, "Enabling allows compatibility with the mod Inspirations.", true);
        tryGenerateRose = loadPropBool("Try Generating Inspiration Roses", CATEGORY_COMPAT, "Enabling will allow Minecraft Boom to generate the Rose from Inspiration since the mod doesn't add worldgen.", false, "Inspirations Compatibility");

        //Blocks
        vanillaBlocks = loadPropBool("Vanilla Stairs and Slabs", CATEGORY_BLOCKS, "", true);
        charcoalBlockFuel = loadPropBool("Use Charcoal Blocks as fuel in a Furnace", CATEGORY_BLOCKS, "", true, "Charcoal Block");
        charcoalBlockBurnTime = loadPropInt("Charcoal Block Burn Time", CATEGORY_BLOCKS, "", TileEntityFurnace.getItemBurnTime(new ItemStack(Blocks.COAL_BLOCK)), "Charcoal Block");
        blazeBlockFuel = loadPropBool("Use Blaze Powder Blocks as fuel in a Furnace", CATEGORY_BLOCKS, "", true, "Blaze Powder Block");
        blazeBlockBurnTime = loadPropInt("Blaze Powder Block Burn Time", CATEGORY_BLOCKS, "", 12000, "Blaze Powder Block");
        witherBoneBlockFuel = loadPropBool("Use Charred Bone Blocks as fuel in a Furnace", CATEGORY_BLOCKS, "", true, "Charred Bone Block");
        witherBoneBlockBurnTime = loadPropInt("Charred Bone Block Burn Time", CATEGORY_BLOCKS, "", 2000, "Charred Bone Block");

        //Items
        pineconeFuel = loadPropBool("Use Pinecones as fuel in a Furnace", CATEGORY_ITEMS, "", true, "Pinecone");
        pineconeBurnTime = loadPropInt("Pinecone Burn Time", CATEGORY_ITEMS, "", 300, "Pinecone");
        witherBoneFuel = loadPropBool("Use Wither Bones as fuel in a Furnace", CATEGORY_ITEMS, "", true, "Wither Bone");
        witherBoneBurnTime = loadPropInt("Wither Bone Burn Time", CATEGORY_ITEMS, "", 500, "Wither Bone");
        telescopeLoot = loadPropBool("Spawn Telescopes in Dungeon Loot", CATEGORY_ITEMS, "", true, "Telescope");

        saveConfiguration();

        MinecraftForge.EVENT_BUS.register(configuration);
    }

    public static void saveConfiguration()
    {
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID))
        {
            saveConfiguration();
        }
    }

    private static String addCategory(String name)
    {
        CATEGORY_LIST.add(name);
        return name;
    }

    public static void createItemConfig(Item item)
    {
        allowedItems.add(loadPropBool(Utils.getConfigName(item), CATEGORY_ITEMS, "", true));
        saveConfiguration();
    }

    public static void createBlockConfig(Block block)
    {
        allowedBlocks.add(loadPropBool(Utils.getConfigName(block), CATEGORY_BLOCKS, "", true));

        if (block instanceof IStairSlab && ((IStairSlab) block).hasStairSlab())
        {
            loadPropBool(Utils.getStairSlabConfigName(Utils.getConfigName(block), block), CATEGORY_BLOCKS, "", true, Utils.getConfigName(block));
        }

        saveConfiguration();
    }

    public static void createVanillaConfig(Block block)
    {
        loadPropBool(Utils.getStairSlabConfigName(Utils.getConfigName(block), block), CATEGORY_BLOCKS, "", true, "Vanilla Stairs and Slabs");
        saveConfiguration();
    }

    public static int loadPropInt(String name, String category, String comment, int default_)
    {
        return loadPropInt(name, category, comment, default_, name);
    }

    public static int loadPropInt(String name, String category, String comment, int default_, String parent)
    {
        Property prop = configuration.get(category + "." + parent, name, default_);
        prop.setComment(comment);

        return prop.getInt(default_);
    }

    public static double loadPropDouble(String name, String category, String comment, double default_)
    {
        return loadPropDouble(name, category, comment, default_, name);
    }

    public static double loadPropDouble(String name, String category, String comment, double default_, String parent)
    {
        Property prop = configuration.get(category + "." + parent, name, default_);
        prop.setComment(comment);

        return prop.getDouble(default_);
    }

    public static boolean loadPropBool(String name, String category, String comment, boolean default_)
    {
        return loadPropBool(name, category, comment, default_, name);
    }

    public static boolean loadPropBool(String name, String category, String comment, boolean default_, String parent)
    {
        Property prop = configuration.get(category + "." + parent, name, default_);
        prop.setComment(comment);

        return prop.getBoolean(default_);
    }

    public static String loadPropString(String name, String category, String comment, String default_)
    {
        return loadPropString(name, category, comment, default_, name);
    }

    public static String loadPropString(String name, String category, String comment, String default_, String parent)
    {
        Property prop = configuration.get(category + "." + parent, name, default_);
        prop.setComment(comment);

        return prop.getString();
    }

    public static String[] loadPropStringList(String name, String category, String comment, String[] default_)
    {
        return loadPropStringList(name, category, comment, default_, name);
    }

    public static String[] loadPropStringList(String name, String category, String comment, String[] default_, String parent)
    {
        Property prop = configuration.get(category, name, default_);
        prop.setComment(comment);

        return prop.getStringList();
    }

    public static boolean loadCategory(String name, String category, String comment, boolean default_)
    {
        Property prop = configuration.get(category, name, default_);
        prop.setComment(comment);

        return prop.getBoolean(default_);
    }
}