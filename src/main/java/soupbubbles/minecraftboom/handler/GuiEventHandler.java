package soupbubbles.minecraftboom.handler;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.client.gui.config.GuiButtonConfigMenu;
import soupbubbles.minecraftboom.client.gui.config.GuiConfig;

public class GuiEventHandler
{

    @SubscribeEvent
    public static void onGuiInit(GuiScreenEvent.InitGuiEvent event)
    {
        GuiScreen gui = event.getGui();

        if (gui instanceof GuiOptions && ConfigurationHandler.minecraftBoomButton)
        {
            List<GuiButton> buttons = event.getButtonList();

            for (GuiButton b : buttons)
            {
                GuiButton button = new GuiButtonConfigMenu(b.x, b.y);
                buttons.add(button);
                return;
            }
        }
    }

    @SubscribeEvent
    public static void onButtonClick(GuiScreenEvent.ActionPerformedEvent event)
    {
        if (event.getButton() instanceof GuiButtonConfigMenu)
        {
            Minecraft.getMinecraft().displayGuiScreen(new GuiConfig(event.getGui()));
        }
    }
}
