package soupbubbles.minecraftboom.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.reference.Reference;
import soupbubbles.minecraftboom.util.Compatibility;

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

    public static boolean worldgen;
    public static boolean tweaks;
    public static boolean compat;
    public static boolean blocks;
    public static boolean items;
    public static boolean mobs;

    //General
    public static boolean minecraftBoomButton;

    //Worldgen
    public static boolean generateRoses;
    public static boolean generatePumpkins;
    public static boolean generateFallenTrees;
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

    //Compat
    public static boolean inspirations;
    public static boolean removeRose;
    public static boolean tryGenerateRose;
    public static boolean removeWitherBone;

    public static boolean quark;

    public static boolean netherex;
    public static boolean chopDownUpdated;

    //Blocks
    public static List<Boolean> allowedBlocks = new ArrayList<Boolean>();

    //Items
    public static List<Boolean> allowedItems = new ArrayList<Boolean>();
    public static int pineconeBurnTime;
    public static int witherBoneBurnTime;

    public static void initConfiguation(File configFile)
    {
        if (!configFile.exists() || configuration == null)
        {
            configuration = new Configuration(configFile, true);
            firstLoad = true;
            MinecraftBoom.instance.logger.log(Level.INFO, "No configuration file for Minecraft Boom was found, creating new one");
        }

        worldgen = loadCategory("World Generation", configuration.CATEGORY_GENERAL, "", true);
        tweaks = loadCategory("Tweaks", configuration.CATEGORY_GENERAL, "", true);
        compat = loadCategory("Compatibility", configuration.CATEGORY_GENERAL, "", true);
        blocks = loadCategory("Blocks", configuration.CATEGORY_GENERAL, "", true);
        items = loadCategory("Items", configuration.CATEGORY_GENERAL, "", true);
        mobs = loadCategory("Mobs", configuration.CATEGORY_GENERAL, "", true);
        minecraftBoomButton = loadCategory("Enable Minecraft Boom Button", configuration.CATEGORY_GENERAL, "Enabling allows the Minecraft Boom button to appear in the Options menu. The Minecraft Boom configuration can always be reached through Mods -> Minecraft Boom -> Config.", true);

        generateRoses = loadPropBool("Generate Roses", CATEGORY_WORLD_GEN, "Enabling allows Roses to naturally spawn in the Overworld.", true);
        generatePumpkins = loadPropBool("Generate Pumpkins", CATEGORY_WORLD_GEN, "Enabling allows Faceless Pumpkin Patches to naturally spawn in the Overworld.", true);
        generateFallenTrees = loadPropBool("Generate Fallen Trees", CATEGORY_WORLD_GEN, "Enabling allows Fallen Trees to naturally spawn in the Overworld.", true);
        generateNetherWells = loadPropBool("Generate Nether Wells", CATEGORY_WORLD_GEN, "Enabling allows Nether Wells to spawn in the Nether.", true);
        generateEndPiles = loadPropBool("Generate End Piles", CATEGORY_WORLD_GEN, "Enabling allows End Piles to spawn in the End.", true);

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

        inspirations = loadPropBool("Inspirations Compatibility", CATEGORY_COMPAT, "Enabling allows compatibility with the mod Inspirations.", true);
        removeRose = loadPropBool("Remove Minecraft Boom Rose", CATEGORY_COMPAT, "Enabling will remove the Rose added by Minecraft Boom since Inspirations adds Roses.", true, "Inspirations Compatibility");
        tryGenerateRose = loadPropBool("Try Generating Inspiration Roses", CATEGORY_COMPAT, "Enabling will allow Minecraft Boom to generate the Rose from Inspiration since the mod doesn't add worldgen.", true, "Inspirations Compatibility");
        removeWitherBone = loadPropBool("Remove Minecraft Boom Wither Bone", CATEGORY_COMPAT, "Enabling will remove the Wither Bone added by Minecraft Boom since Inspirations adds Withered Bones.", true, "Inspirations Compatibility");

        quark = loadPropBool("Quark Compatibility", CATEGORY_COMPAT, "Enabling allows compatibility with the mod Quark.", true);
        netherex = loadPropBool("Nether Ex Compatibility", CATEGORY_COMPAT, "Enabling allows compatibility with the mod Nether Ex.", true);
        chopDownUpdated = loadPropBool("Chop Down Updated Compatibility", CATEGORY_COMPAT, "Enabling allows compatibility with the mod Chop Down Updated.", true);

        pineconeBurnTime = loadPropInt("Pinecone Burn Time", CATEGORY_ITEMS, "", 300, "pinecone");
        witherBoneBurnTime = loadPropInt("Wither Bone Burn Time", CATEGORY_ITEMS, "", 500, "wither_bone");

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