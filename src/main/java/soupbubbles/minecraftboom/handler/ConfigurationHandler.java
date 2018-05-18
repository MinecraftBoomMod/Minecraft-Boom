package soupbubbles.minecraftboom.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static final Category[] CATEGORY_LIST = new Category[6];
    private static int i = -1;

    public static final Category CATEGORY_WORLD_GEN = new Category("worldgen", new ItemStack(ModBlocks.BLOCK_ROSE), true);
    public static final Category CATEGORY_TWEAKS = new Category("tweaks", new ItemStack(Items.WRITABLE_BOOK), false);
    public static final Category CATEGORY_BLOCKS = new Category("blocks", new ItemStack(ModBlocks.BLOCK_COBBLESTONE_BRICKS), true);
    public static final Category CATEGORY_ITEMS = new Category("items", new ItemStack(Items.IRON_INGOT), true);
    public static final Category CATEGORY_COMPAT = new Category("compatibility", new ItemStack(Items.IRON_PICKAXE), true);
    public static final Category CATEGORY_GENERAL = new Category(configuration.CATEGORY_GENERAL, new ItemStack(Blocks.ANVIL), false);
    
    public static boolean generateRoses;
    public static boolean generatePumpkins;
    public static boolean generateFallenTrees;
    public static boolean generateNetherWells;
    public static boolean generateEndPiles;
    public static boolean smeltPumpkin;
    public static boolean blazeBonemeal;
    public static boolean removeSlimeBall;
    public static boolean leavesDropSticks;
    public static boolean removeRose;
    public static boolean tryGenerateRoses;
    public static boolean preventFallenTrees;
    public static boolean minecraftBoomButton;
    public static boolean replaceLoadingScreen;

    public static void init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile, true);
        }

        loadConfiguration();
    }

    public static void loadConfiguration()
    {
        generateRoses = addConfig(CATEGORY_WORLD_GEN, "generateRoses", true);
        generatePumpkins = addConfig(CATEGORY_WORLD_GEN, "generatePumpkinPatches", true);
        generateFallenTrees = addConfig(CATEGORY_WORLD_GEN, "generateFallenTrees", true);
        generateNetherWells = addConfig(CATEGORY_WORLD_GEN, "generateNetherWells", true);
        generateEndPiles = addConfig(CATEGORY_WORLD_GEN, "generateEndPiles", true);
        smeltPumpkin = addConfig(CATEGORY_TWEAKS, "smeltPumpkin", true);
        blazeBonemeal = addConfig(CATEGORY_TWEAKS, "blazeBonemeal", true);
        removeSlimeBall = addConfig(CATEGORY_TWEAKS, "removeSlimeBall", true);
        leavesDropSticks = addConfig(CATEGORY_TWEAKS, "leavesDropSticks", true);
        removeRose = addConfig(CATEGORY_COMPAT, "removeRose", true);
        tryGenerateRoses = addConfig(CATEGORY_COMPAT, "tryGenerateRoses", true);
        preventFallenTrees = addConfig(CATEGORY_COMPAT, "preventFallenTrees", true);
        minecraftBoomButton = addConfig(CATEGORY_GENERAL, "minecraftBoomButton", true);
        replaceLoadingScreen = addConfig(CATEGORY_GENERAL, "replaceLoadingScreen", true);
        
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
            loadConfiguration();
        }
    }

    public static boolean addConfig(Category category, String name, boolean defaultValue)
    {
        boolean value = configuration.getBoolean(name, category.getName(), defaultValue, Assets.CONFIG_PREFIX + name + ".comment.name");
        boolean flag = true;

        for (int i = 0; i < category.getList().size(); i++)
        {
            if (new String(category.getProp(i).getName()).equals(name))
            {
                flag = false;
            }
        }

        if (flag)
        {
            category.addProp(configuration.get(category.getName(), name, defaultValue));
        }

        return value;
    }

    public static String getConfigName(String name)
    {
        return Assets.CONFIG_PREFIX + name + ".name";
    }

    public static class Category
    {
        private String name;
        private ItemStack displayStack;
        private boolean requiresRestart;
        private List list = new ArrayList();

        public Category(String categoryName, ItemStack stack, boolean restart)
        {
            name = "category." + categoryName;
            displayStack = stack;
            requiresRestart = restart;
            i++;
            CATEGORY_LIST[i] = this;
        }

        public String getName()
        {
            return name;
        }

        @SideOnly(Side.CLIENT)
        public String getLocalizedName()
        {
            return I18n.format(Assets.CONFIG_PREFIX + getName() + ".name");
        }

        public ItemStack getDisplayStack()
        {
            return displayStack;
        }
        
        public boolean requiresRestart()
        {
            return requiresRestart;
        }

        public List getList()
        {
            return list;
        }

        public void addProp(Property property)
        {
            list.add(property);
        }

        public Property getProp(int index)
        {
            return (Property) list.get(index);
        }
        
        public int getSize()
        {
            return list.size();
        }
    }
}