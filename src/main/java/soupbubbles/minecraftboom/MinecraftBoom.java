package soupbubbles.minecraftboom;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import soupbubbles.minecraftboom.handler.ModGuiHandler;
import soupbubbles.minecraftboom.proxy.IProxy;
import soupbubbles.minecraftboom.reference.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class MinecraftBoom
{
    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static IProxy proxy;

    @Instance(Reference.MOD_ID)
    public static MinecraftBoom instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void posInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
