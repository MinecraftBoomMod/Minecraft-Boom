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
    }
}