package soupbubbles.minecraftboom.handler;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class LivingEventHandler
{

    @SubscribeEvent
    public void onLivingSpawn(LivingSpawnEvent.CheckSpawn event)
    {
        if (event.getEntityLiving() instanceof EntitySlime && !event.getWorld().isRemote)
        {
            
        }
    }
}
