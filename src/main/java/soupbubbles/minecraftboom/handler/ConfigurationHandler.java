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
        Settings.replaceLoadingScreen = configuration.getBoolean(Settings.REPLACE_LOADING_SCREEN_NAME, configuration.CATEGORY_GENERAL, Settings.REPLACE_LOADING_SCREEN_DEFAULT, Settings.REPLACE_LOADING_SCREEN_COMMENT, Settings.REPLACE_LOADING_SCREEN_LABEL);
        Settings.generateNetherWells = configuration.getBoolean(Settings.GENERATE_NETHER_WELLS_NAME, configuration.CATEGORY_GENERAL, Settings.GENERATE_NETHER_WELLS_DEFAULT, Settings.GENERATE_NETHER_WELLS_COMMENT, Settings.GENERATE_NETHER_WELLS_LABEL);
        
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
        public static boolean replaceLoadingScreen;
        private static final String REPLACE_LOADING_SCREEN_NAME = "Replace Loading Screen";
        private static final String REPLACE_LOADING_SCREEN_LABEL = "replace_loading_screen.label";
        private static final String REPLACE_LOADING_SCREEN_COMMENT = "Return true if the mod should replace the default loading screens for traveling to dimensions with respective block backgrounds";
        private static final boolean REPLACE_LOADING_SCREEN_DEFAULT = true;

        public static boolean generateNetherWells;
        private static final String GENERATE_NETHER_WELLS_NAME = "Generate Nether Wells";
        private static final String GENERATE_NETHER_WELLS_LABEL = "generate_nether_wells.label";
        private static final String GENERATE_NETHER_WELLS_COMMENT = "Return true if Nether Wells should be generated in the Nether";
        private static final boolean GENERATE_NETHER_WELLS_DEFAULT = true;
    }
}