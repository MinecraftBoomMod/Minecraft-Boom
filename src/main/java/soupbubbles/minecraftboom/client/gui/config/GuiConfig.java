package soupbubbles.minecraftboom.client.gui.config;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Assets;

public class GuiConfig extends GuiBase
{
    public GuiConfig(GuiScreen myParent)
    {
        super(myParent);
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int i = 0;

        for (String category : ConfigurationHandler.CATEGORY_LIST)
        {
            buttonList.add(new GuiButtonCategory(i, (width / 2 - 155) + i % 2 * 160, (height / 6) + i / 2 * 24, category));
            buttonList.add(new GuiButtonConfig(i + CATEGORY_SIZE + 1, (width / 2 - 25) + i % 2 * 160, (height / 6) + i / 2 * 24, ConfigurationHandler.configuration.get(ConfigurationHandler.configuration.CATEGORY_GENERAL, category, true)));
            i++;
        }

        buttonList.add(new GuiButton(24, (width / 2 - 155) + (CATEGORY_SIZE) % 2 * 160, (height / 6) + (CATEGORY_SIZE) / 2 * 24, 150, 20, "General Settings"));
        buttonList.add(new GuiButton(25, (width / 2 - 155) + (CATEGORY_SIZE + 1) % 2 * 160, (height / 6) + (CATEGORY_SIZE + 1) / 2 * 24, 150, 20, "Reset all"));
        buttonList.add(backButton = new GuiButton(200, width / 2 - 100, height / 6 + 162, 200, 20, I18n.format("gui.done")));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);

        if (button instanceof GuiButtonCategory)
        {
            mc.displayGuiScreen(new GuiCategory(this, ConfigurationHandler.CATEGORY_LIST.get(button.id)));
        }
        else if (button.id == 25)
        {
        }
    }

    @Override
    public void drawTooltips(int mouseX, int mouseY)
    {
        for (int i = 0; i < buttonList.size(); i++)
        {
            if (buttonList.get(i) instanceof GuiButtonConfig)
            {
                GuiButtonConfig button = (GuiButtonConfig) buttonList.get(i);

                if (mouseOverButton(mouseX, mouseY, button))
                {
                    String s = !button.prop.getBoolean() ? "enable" : "disable";

                    drawHoveringText(I18n.format(Assets.CONFIG_GUI_PREFIX + s + ".name") + " " + I18n.format(button.prop.getName()), mouseX, mouseY);
                }
            }
        }
    }
}