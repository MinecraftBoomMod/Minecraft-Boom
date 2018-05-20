package soupbubbles.minecraftboom.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;
import soupbubbles.minecraftboom.util.ConfigurationHelper;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean firstLoad = false;

    public static final List<Category> CATEGORY_LIST = new ArrayList<Category>();

    public static final Category CATEGORY_WORLD_GEN = addCategory("worldgen", new ItemStack(ModBlocks.BLOCK_ROSE));
    public static final Category CATEGORY_TWEAKS = addCategory("tweaks", new ItemStack(Items.WRITABLE_BOOK));
    public static final Category CATEGORY_COMPAT = addCategory("compatibility", new ItemStack(Items.IRON_PICKAXE));
    public static final Category CATEGORY_BLOCKS = addCategory("blocks", new ItemStack(ModBlocks.BLOCK_COBBLESTONE_BRICKS));
    public static final Category CATEGORY_ITEMS = addCategory("items", new ItemStack(Items.IRON_INGOT));
    public static final Category CATEGORY_MOBS = addCategory("mobs", new ItemStack(Items.WHEAT));
    
    public static boolean worldgen;
    public static boolean tweaks;
    public static boolean compat;
    public static boolean blocks;
    public static boolean items;
    public static boolean mobs;

    //General
    public static boolean minecraftBoomButton;
    public static boolean replaceLoadingScreen;

    //Worldgen
    public static boolean generateRoses;
    public static boolean generatePumpkins;
    public static boolean generateFallenTrees;
    public static boolean generateNetherWells;
    public static boolean generateEndPiles;

    //Tweaks
    public static boolean smeltPumpkin;
    public static boolean blazeBonemeal;
    public static boolean removeSlimeBall;
    public static boolean leavesDropSticks;
    public static boolean spruceDropsPinecones;

    //Compat
    public static boolean removeRose;
    public static boolean tryGenerateRoses;
    public static boolean preventFallenTrees;

    public static void initConfiguation(File configFile)
    {
        if (!configFile.exists() || configuration == null)
        {
            configuration = new Configuration(configFile, true);
            firstLoad = true;
            MinecraftBoom.instance.logger.log(Level.INFO, "No configuration file for Minecraft Boom was found, creating new one");
        }

        worldgen = ConfigurationHelper.loadPropBool("worldgen", configuration.CATEGORY_GENERAL, "", true);
        tweaks = ConfigurationHelper.loadPropBool("tweaks", configuration.CATEGORY_GENERAL, "", true);
        compat = ConfigurationHelper.loadPropBool("compat", configuration.CATEGORY_GENERAL, "", true);
        blocks = ConfigurationHelper.loadPropBool("blocks", configuration.CATEGORY_GENERAL, "", true);
        items = ConfigurationHelper.loadPropBool("items", configuration.CATEGORY_GENERAL, "", true);
        mobs = ConfigurationHelper.loadPropBool("mobs", configuration.CATEGORY_GENERAL, "", true);
        minecraftBoomButton = ConfigurationHelper.loadPropBool("minecraftBoomButton", configuration.CATEGORY_GENERAL, "", true);

        generateRoses = ConfigurationHelper.loadPropBool("generateRoses", CATEGORY_WORLD_GEN, "", true);
        generatePumpkins = ConfigurationHelper.loadPropBool("generatePumpkins", CATEGORY_WORLD_GEN, "", true);
        generateFallenTrees = ConfigurationHelper.loadPropBool("generateFallenTrees", CATEGORY_WORLD_GEN, "", true);
        generateNetherWells = ConfigurationHelper.loadPropBool("generateNetherWells", CATEGORY_WORLD_GEN, "", true);
        generateEndPiles = ConfigurationHelper.loadPropBool("generateEndPiles", CATEGORY_WORLD_GEN, "", true);

        smeltPumpkin = ConfigurationHelper.loadPropBool("smeltPumpkin", CATEGORY_TWEAKS, "", true);
        blazeBonemeal = ConfigurationHelper.loadPropBool("blazeBonemeal", CATEGORY_TWEAKS, "", true);
        removeSlimeBall = ConfigurationHelper.loadPropBool("removeSlimeBall", CATEGORY_TWEAKS, "", true);
        leavesDropSticks = ConfigurationHelper.loadPropBool("leavesDropSticks", CATEGORY_TWEAKS, "", true);
        leavesDropSticks = ConfigurationHelper.loadPropBool("spruceDropsPinecones", CATEGORY_TWEAKS, "", true);
        replaceLoadingScreen = ConfigurationHelper.loadPropBool("replaceLoadingScreen", CATEGORY_TWEAKS, "", true);

        removeRose = ConfigurationHelper.loadPropBool("removeRose", CATEGORY_COMPAT, "", true);
        tryGenerateRoses = ConfigurationHelper.loadPropBool("tryGenerateRoses", CATEGORY_COMPAT, "", true);
        preventFallenTrees = ConfigurationHelper.loadPropBool("preventFallenTrees", CATEGORY_COMPAT, "", true);

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

    private static Category addCategory(String name, ItemStack displayStack)
    {
        Category category = new Category(name, displayStack);
        CATEGORY_LIST.add(category);

        return category;
    }

    public static class Category
    {
        private String name;
        private ItemStack displayStack;

        public Category(String categoryName, ItemStack stack)
        {
            name = "category." + categoryName;
            displayStack = stack;
        }

        public String getName()
        {
            return name;
        }

        public String getLocalizedName()
        {
            return Assets.CONFIG_PREFIX + getName() + ".name";
        }

        public ItemStack getDisplayStack()
        {
            return displayStack;
        }
    }
}