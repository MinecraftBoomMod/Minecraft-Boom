package soupbubbles.minecraftboom.handler;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class DebugHandler {
	
	@SubscribeEvent
    public static void getHurt (LivingHurtEvent event)
    {
		//No Damage
		System.out.println(event.getAmount());
		event.setAmount(0F);
    }
}
