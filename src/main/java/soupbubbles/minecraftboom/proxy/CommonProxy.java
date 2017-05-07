package soupbubbles.minecraftboom.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.client.ClientHandler;
import soupbubbles.minecraftboom.handler.BlockEventHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.FuelHandler;
import soupbubbles.minecraftboom.handler.GuiHandler;
import soupbubbles.minecraftboom.handler.LivingEventHandler;
import soupbubbles.minecraftboom.handler.LootHandler;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModEntities;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.init.ModPotions;
import soupbubbles.minecraftboom.init.ModRecipes;

public abstract class CommonProxy implements IProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        ModBlocks.registerBlocks();
        ModBlocks.registerTileEntities();
        ModPotions.init();
        ModItems.registerItems();
        ModEntities.initEntities();

        NetworkRegistry.INSTANCE.registerGuiHandler(MinecraftBoom.instance, new GuiHandler());

    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        ModRecipes.init();

        MinecraftForge.EVENT_BUS.register(new BlockEventHandler());
        MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
        MinecraftForge.EVENT_BUS.register(new LootHandler());
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
