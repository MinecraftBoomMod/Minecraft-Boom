package soupbubbles.minecraftboom.handler;

import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class WorldGenEventHandler
{
    @SubscribeEvent
    public void onDecorateBiome(DecorateBiomeEvent.Decorate event)
    {
        if (ConfigurationHandler.generatePumpkins)
        {
            if (event.getType() == DecorateBiomeEvent.Decorate.EventType.PUMPKIN)
            {
                event.setResult(Result.DENY);
            }
        }
    }
}
