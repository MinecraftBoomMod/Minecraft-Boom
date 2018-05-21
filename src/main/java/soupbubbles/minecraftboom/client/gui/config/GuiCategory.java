package soupbubbles.minecraftboom.client.gui.config;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.handler.ConfigurationHandler.Category;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;
import soupbubbles.minecraftboom.util.ConfigurationHelper;

public class GuiCategory extends GuiBase
{
    private ConfigCategory category;

    private static final ResourceLocation ICONS = new ResourceLocation(Assets.ASSET_PREFIX, Assets.TEXTURE_GUI_DIR + "icons.png");

    public GuiCategory(GuiScreen parent, Category category)
    {
        super(parent);
        this.category = ConfigurationHandler.configuration.getCategory(category.getName());
        title = Reference.MOD_NAME + ": " + I18n.format(category.getLocalizedName());
    }

    @Override
    public void initGui()
    {
        super.initGui();

        buttonList.add(backButton = new GuiButton(0, width / 2 - 100, height / 6 + 168 - 16, 200, 20, I18n.format("gui.done")));

        int size = 0;

        for (ConfigCategory cat : category.getChildren())
        {
            for (Property p : cat.getOrderedValues())
            {
                if (p.getName().equals(cat.getName()))
                {
                    buttonList.add(new GuiButtonConfig(size + 1, (width / 2 + 106), (height / 6) + size * 24, p));
                }
            }
            
            size++;
        }

        for (ConfigCategory cat : category.getChildren())
        {
            if (cat.getOrderedValues().size() > 1)
            {
                buttonList.add(new GuiButtonChild(size + 1, (width / 2 + 106 + 22), ((height / 6) + size / 2 * 24) - 24, cat));
            }
            size++;
        }

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);

        if (button instanceof GuiButtonChild)
        {
            GuiButtonChild b = (GuiButtonChild) button;

            mc.displayGuiScreen(new GuiChild(this, b.getCategory()));
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);

        for (GuiButton button : buttonList)
        {
            if (button instanceof GuiButtonConfig)
            {
                GuiButtonConfig b = (GuiButtonConfig) button;

                drawString(mc.fontRenderer, I18n.format(Assets.CONFIG_PREFIX + b.prop.getName() + ".name"), width / 2 - 120, b.y + 8, 0xFFFFFF);
            }
        }
    }
}
