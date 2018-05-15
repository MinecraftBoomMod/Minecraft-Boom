package soupbubbles.minecraftboom.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import soupbubbles.minecraftboom.client.ModelManager;
import soupbubbles.minecraftboom.handler.ClientEventHandler;
import soupbubbles.minecraftboom.handler.GuiEventHandler;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModEntities;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        
        ModelManager.INSTANCE.registerAllModels();
        ModBlocks.registerTileEntityRenderers();
        ModEntities.registerEntityRenderers();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        
        MinecraftForge.EVENT_BUS.register(GuiEventHandler.class);
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
