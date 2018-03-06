package soupbubbles.minecraftboom.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.reference.Reference;

public class ConfigurationHandler
{
    public static Configuration configuration;


    public static void init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile, true);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        Settings.replaceVanillaStairRecipe = configuration.getBoolean(Settings.REPLACE_VANILLA_STAIR_RECIPE_NAME, configuration.CATEGORY_GENERAL, Settings.REPLACE_VANILLA_STAIR_RECIPE_DEFAULT, Settings.REPLACE_VANILLA_STAIR_RECIPE_COMMENT, Settings.REPLACE_VANILLA_STAIR_RECIPES_LABEL);
        Settings.replacePurplePillarRecipe = configuration.getBoolean(Settings.REPLACE_PURPUR_PILLAR_RECIPE_NAME, configuration.CATEGORY_GENERAL, Settings.REPLACE_PURPUR_PILLAR_RECIPE_DEFAULT, Settings.REPLACE_PURPUR_PILLAR_RECIPE_COMMENT, Settings.REPLACE_PURPUR_PILLAR_RECIPES_LABEL);
        Settings.replaceCraftingTable = configuration.getBoolean(Settings.REPLACE_CRAFTING_TABLE_NAME, configuration.CATEGORY_GENERAL, Settings.REPLACE_CRAFTING_TABLE_DEFAULT, Settings.REPLACE_CRAFTING_TABLE_COMMENT, Settings.REPLACE_CRAFTING_TABLE_LABEL);
        Settings.replacePumpkin = configuration.getBoolean(Settings.REPLACE_PUMPKIN_NAME, configuration.CATEGORY_GENERAL, Settings.REPLACE_PUMPKIN_DEFAULT, Settings.REPLACE_PUMPKIN_COMMENT, Settings.REPLACE_PUMPKIN_LABEL);
        Settings.replaceWool = configuration.getBoolean(Settings.REPLACE_WOOL_NAME, configuration.CATEGORY_GENERAL, Settings.REPLACE_WOOL_DEFAULT, Settings.REPLACE_WOOL_COMMENT, Settings.REPLACE_WOOL_LABEL);
        Settings.replaceLoadingScreen = configuration.getBoolean(Settings.REPLACE_LOADING_SCREEN_NAME, configuration.CATEGORY_GENERAL, Settings.REPLACE_LOADING_SCREEN_DEFAULT, Settings.REPLACE_LOADING_SCREEN_COMMENT, Settings.REPLACE_LOADING_SCREEN_LABEL);
  
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

    public static class Settings
    {
        public static boolean replaceVanillaStairRecipe;
        private static final String REPLACE_VANILLA_STAIR_RECIPE_NAME = "Replace Vanilla Stair Recipe";
        private static final String REPLACE_VANILLA_STAIR_RECIPES_LABEL = "replace_vanilla_stair_recipe.label";
        private static final String REPLACE_VANILLA_STAIR_RECIPE_COMMENT = "Return true if the mod should override the default recipe for stairs. The new crafting recipe will yield 6 stair blocks instead of 4.";
        private static final boolean REPLACE_VANILLA_STAIR_RECIPE_DEFAULT = true;
        
        public static boolean replacePurplePillarRecipe;
        private static final String REPLACE_PURPUR_PILLAR_RECIPE_NAME = "Replace Purple Pillar Recipe";
        private static final String REPLACE_PURPUR_PILLAR_RECIPES_LABEL = "replace_purpur_pillar_recipe.label";
        private static final String REPLACE_PURPUR_PILLAR_RECIPE_COMMENT = "Return true if the mod should override the default recipe for Purple Pillars. The new crafting precipe will use 2 Purple Blocks instead of Purple Slabs";
        private static final boolean REPLACE_PURPUR_PILLAR_RECIPE_DEFAULT = true;
        
        public static boolean replaceCraftingTable;
        private static final String REPLACE_CRAFTING_TABLE_NAME = "Replace Crafting Table";
        private static final String REPLACE_CRAFTING_TABLE_LABEL = "replace_crafting_table.label";
        private static final String REPLACE_CRAFTING_TABLE_COMMENT = "Return true if the mod should override the vanilla version of the Crafting Table. The new version will save items in its inventory and not drop them when you close the GUI";
        private static final boolean REPLACE_CRAFTING_TABLE_DEFAULT = true;
        
        public static boolean replacePumpkin;
        private static final String REPLACE_PUMPKIN_NAME = "Replace Pumpkins";
        private static final String REPLACE_PUMPKIN_LABEL = "replace_pumpkins.label";
        private static final String REPLACE_PUMPKIN_COMMENT = "Return true if the mod should override the vanilla version of Pumpkins. The new version will include a Faceless Pumpkin, Pumpkin Slices and updated recipes";
        private static final boolean REPLACE_PUMPKIN_DEFAULT = true;
        
        public static boolean replaceWool;
        private static final String REPLACE_WOOL_NAME = "Replace Wool";
        private static final String REPLACE_WOOL_LABEL = "replace_wool.label";
        private static final String REPLACE_WOOL_COMMENT = "Return true if the mod should override the vanilla version of Wool. The new version will make Wool reduce fall damage";
        private static final boolean REPLACE_WOOL_DEFAULT = true;
        
        public static boolean replaceLoadingScreen;
        private static final String REPLACE_LOADING_SCREEN_NAME = "Replace Loading Screen";
        private static final String REPLACE_LOADING_SCREEN_LABEL = "replace_loading_screen.label";
        private static final String REPLACE_LOADING_SCREEN_COMMENT = "Return true if the mod should replace the default loading screens for traveling to dimensions with respective block backgrounds";
        private static final boolean REPLACE_LOADING_SCREEN_DEFAULT = true;
    }
}