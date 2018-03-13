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
        Settings.generateRoses = configuration.getBoolean(Settings.GENERATE_ROSES_NAME, configuration.CATEGORY_GENERAL, Settings.GENERATE_ROSES_DEFAULT, Settings.GENERATE_ROSES_COMMENT, Settings.GENERATE_ROSES_LABEL);
        Settings.generatePumpkins = configuration.getBoolean(Settings.GENERATE_PUMPKINS_NAME, configuration.CATEGORY_GENERAL, Settings.GENERATE_PUMPKINS_DEFAULT, Settings.GENERATE_PUMPKINS_COMMENT, Settings.GENERATE_PUMPKINS_LABEL);
        Settings.generateFallenTrees = configuration.getBoolean(Settings.GENERATE_FALLEN_TREES_NAME, configuration.CATEGORY_GENERAL, Settings.GENERATE_FALLEN_TREES_DEFAULT, Settings.GENERATE_FALLEN_TREES_COMMENT, Settings.GENERATE_FALLEN_TREES_LABEL);
        Settings.generateNetherWells = configuration.getBoolean(Settings.GENERATE_NETHER_WELLS_NAME, configuration.CATEGORY_GENERAL, Settings.GENERATE_NETHER_WELLS_DEFAULT, Settings.GENERATE_NETHER_WELLS_COMMENT, Settings.GENERATE_NETHER_WELLS_LABEL);
        Settings.generateEndPiles = configuration.getBoolean(Settings.GENERATE_END_PILES_NAME, configuration.CATEGORY_GENERAL, Settings.GENERATE_END_PILES_DEFAULT, Settings.GENERATE_END_PILES_COMMENT, Settings.GENERATE_END_PILES_LABEL);
 
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

        public static boolean generateRoses;
        private static final String GENERATE_ROSES_NAME = "Generate Roses";
        private static final String GENERATE_ROSES_LABEL = "generate_roses.label";
        private static final String GENERATE_ROSES_COMMENT = "Return true if Roses should be generated in the Overworld";
        private static final boolean GENERATE_ROSES_DEFAULT = true;
        
        public static boolean generatePumpkins;
        private static final String GENERATE_PUMPKINS_NAME = "Generate new Pumpkin patches";
        private static final String GENERATE_PUMPKINS_LABEL = "generate_pumpkins.label";
        private static final String GENERATE_PUMPKINS_COMMENT = "Return true if the old Pumpkin patches should be replaced by new ones that will generated Faceless Pumkins instead of Hollowed ones";
        private static final boolean GENERATE_PUMPKINS_DEFAULT = true;
        
        public static boolean generateFallenTrees;
        private static final String GENERATE_FALLEN_TREES_NAME = "Generate Fallen Trees";
        private static final String GENERATE_FALLEN_TREES_LABEL = "generate_fallen_trees.label";
        private static final String GENERATE_FALLEN_TREES_COMMENT = "Return true if Fallen Trees should randomly generate in the Overworld";
        private static final boolean GENERATE_FALLEN_TREES_DEFAULT = true;
        
        public static boolean generateNetherWells;
        private static final String GENERATE_NETHER_WELLS_NAME = "Generate Nether Wells";
        private static final String GENERATE_NETHER_WELLS_LABEL = "generate_nether_wells.label";
        private static final String GENERATE_NETHER_WELLS_COMMENT = "Return true if Nether Wells should be generated in the Nether";
        private static final boolean GENERATE_NETHER_WELLS_DEFAULT = true;
        
        public static boolean generateEndPiles;
        private static final String GENERATE_END_PILES_NAME = "Generate End Piles";
        private static final String GENERATE_END_PILES_LABEL = "generate_end_piles.label";
        private static final String GENERATE_END_PILES_COMMENT = "Return true if piles of miscellaneous blocks should be generated in the End to represent stolen blocks by the Endermen";
        private static final boolean GENERATE_END_PILES_DEFAULT = true;
    }
}