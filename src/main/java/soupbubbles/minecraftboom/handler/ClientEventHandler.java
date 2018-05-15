package soupbubbles.minecraftboom.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.client.gui.GuiTelescope;
import soupbubbles.minecraftboom.init.ModItems;

public class ClientEventHandler
{
    private Minecraft mc;

    public ClientEventHandler()
    {
        mc = Minecraft.getMinecraft();
    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event)
    {
        ItemStack stack = mc.player.getHeldItemMainhand();
        int useCount = mc.player.getItemInUseCount();

        if (event.getType() != ElementType.CROSSHAIRS)
        {
            return;
        }

        if (stack != null && mc.gameSettings.thirdPersonView == 0)
        {
            if (stack.getItem() == ModItems.ITEM_TELESCOPE && useCount > 0 && useCount < stack.getItem().getMaxItemUseDuration(stack))
            {
                new GuiTelescope(mc);
            }
        }
    }

    @SubscribeEvent
    public void onFOVUpdate(FOVUpdateEvent event)
    {
        ItemStack stack = event.getEntity().getHeldItemMainhand();
        int useCount = event.getEntity().getItemInUseCount();

        if (stack != null && mc.gameSettings.thirdPersonView == 0)
        {
            if (stack.getItem() == ModItems.ITEM_TELESCOPE && useCount > 0 && useCount < stack.getItem().getMaxItemUseDuration(stack))
            {
                event.setNewfov(-4.0F);
            }
        }
    }
}
