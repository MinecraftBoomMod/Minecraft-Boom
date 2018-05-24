package soupbubbles.minecraftboom.handler;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import soupbubbles.minecraftboom.init.ModBlocks;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class WorldGenEventHandler
{
    @SubscribeEvent
    public void onDecorateBiome(DecorateBiomeEvent.Decorate event)
    {
        if (ConfigurationHandler.worldgen)
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
}
