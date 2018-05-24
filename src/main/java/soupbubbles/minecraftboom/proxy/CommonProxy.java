package soupbubbles.minecraftboom.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.handler.BlockEventHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.EntityEventHandler;
import soupbubbles.minecraftboom.handler.FuelHandler;
import soupbubbles.minecraftboom.handler.LootTableEventHandler;
import soupbubbles.minecraftboom.handler.PlayerEventHandler;
import soupbubbles.minecraftboom.handler.WorldGenEventHandler;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModEntities;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.init.ModRecipes;
import soupbubbles.minecraftboom.util.Compatibility;
import soupbubbles.minecraftboom.world.WorldGenerator;

public abstract class CommonProxy implements IProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.initConfiguation(event.getSuggestedConfigurationFile());

        if (ConfigurationHandler.compat)
        {
            Compatibility.preInit();
        }

        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModEntities.initEntities();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new BlockEventHandler());
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
        MinecraftForge.EVENT_BUS.register(new LootTableEventHandler());
        MinecraftForge.TERRAIN_GEN_BUS.register(new WorldGenEventHandler());
        GameRegistry.registerWorldGenerator(new WorldGenerator(), 0);

        ModRecipes.init();
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
