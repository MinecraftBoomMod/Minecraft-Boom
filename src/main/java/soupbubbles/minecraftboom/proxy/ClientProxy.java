package soupbubbles.minecraftboom.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import soupbubbles.minecraftboom.client.ModelManager;
import soupbubbles.minecraftboom.init.ModItems;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        
        //Register all our item models and block models automatically
        //We don't have to add any code
        ModelManager.INSTANCE.registerAllModels();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
