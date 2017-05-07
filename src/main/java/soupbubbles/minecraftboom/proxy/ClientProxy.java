package soupbubbles.minecraftboom.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import soupbubbles.minecraftboom.client.ClientEventHandler;
import soupbubbles.minecraftboom.client.ModelManager;
import soupbubbles.minecraftboom.init.ModEntities;
import soupbubbles.minecraftboom.init.ModItems;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        
        ModelManager.INSTANCE.registerAllModels();
        ModEntities.registerEntityRenderers();;
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());

        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
