package soupbubbles.minecraftboom.client.gui;

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

        Iterator ir = category.getValues().entrySet().iterator();
        int size = 0;

        while (ir.hasNext())
        {
            Map.Entry e = (Map.Entry) ir.next();
            buttonList.add(new GuiButtonConfig(size + 1, (width / 2 + 106), (height / 6) + size * 24, ((Property) e.getValue())));
            size++;
        }

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);

        for (int i = 0; i < category.size(); i++)
        {
            GuiButtonConfig button = (GuiButtonConfig) buttonList.get(i + 1);

            drawString(mc.fontRenderer, I18n.format(button.prop.getName()), width / 2 - 120, button.y + 8, 0xFFFFFF);
        }
    }
}
