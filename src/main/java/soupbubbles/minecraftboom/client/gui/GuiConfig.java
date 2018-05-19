package soupbubbles.minecraftboom.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;
import soupbubbles.minecraftboom.reference.Assets;

public class GuiConfig extends GuiBase
{
    private static final int CATEGORY_SIZE = ConfigurationHandler.CATEGORY_LIST.size();

    public GuiConfig(GuiScreen myParent)
    {
        super(myParent);
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int i = 0;

        for (Category cat : ConfigurationHandler.CATEGORY_LIST)
        {
            buttonList.add(new GuiButtonCategory(i + 1, (width / 2 - 155) + i % 2 * 160, (height / 6) + i / 2 * 24, cat));
            buttonList.add(new GuiButtonConfig(i + CATEGORY_SIZE + 2, (width / 2 - 25) + i % 2 * 160, (height / 6) + i / 2 * 24, ConfigurationHandler.configuration.get(ConfigurationHandler.configuration.CATEGORY_GENERAL, cat.getName().replace("category.", ""), true)));
            i++;
        }

        buttonList.add(new GuiButton(24, (width / 2 - 155) + 6 % 2 * 160, (height / 6) + 6 / 2 * 24, 150, 20, "General Settings"));
        buttonList.add(new GuiButton(25, (width / 2 - 155) + 7 % 2 * 160, (height / 6) + 7 / 2 * 24, 150, 20, "Reset all"));
        buttonList.add(backButton = new GuiButton(0, width / 2 - 100, (height / 6) + 8 / 2 * 26, 200, 20, I18n.format("gui.done")));

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);

        if (button.id > 0 && button.id <= CATEGORY_SIZE)
        {
            if (button instanceof GuiButtonCategory)
            {
                mc.displayGuiScreen(new GuiCategory(this, ConfigurationHandler.CATEGORY_LIST.get(button.id - 1)));
            }
        }
        else if (button.id == 25)
        {
            // RESET ALL
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

                if (mouseX > button.x && mouseX < button.x + button.width && mouseY > button.y && mouseY < button.y + button.height)
                {
                    String s = !button.prop.getBoolean() ? "enableall" : "disableall";

                    drawHoveringText(I18n.format(Assets.CONFIG_GUI_PREFIX + s + ".name"), mouseX, mouseY);
                }
            }
        }
    }
}
