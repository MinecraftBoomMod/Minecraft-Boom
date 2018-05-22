package soupbubbles.minecraftboom.client.gui.config;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiListExtended.IGuiListEntry;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;
import soupbubbles.minecraftboom.util.Compatibility;

public class GuiCategory extends GuiBase
{
    private ConfigCategory category;
    private GuiCategory.GuiConfigList list;
    private boolean isSpecial = false;

    public GuiCategory(GuiScreen parent, String category)
    {
        super(parent);
        this.category = ConfigurationHandler.configuration.getCategory(category);
        title = Reference.MOD_NAME + ": " + category;
        drawBackround = false;

        if (category.equals("Items") || category.equals("Blocks"))
        {
            isSpecial = true;
            bottomText = category.equals("Items") ? "Disabling " + category.toLowerCase() + " have no affect yet. This page is only used for " + category.toLowerCase() + " settings." : "Under Construction";
            red = true;
        }
    }

    @Override
    public void initGui()
    {
        super.initGui();

        buttonList.add(backButton = new GuiButton(200, width / 2 - 100, height - 42, 200, 20, I18n.format("gui.done")));
        list = new GuiCategory.GuiConfigList(this, mc, category);
        list.registerScrollButtons(201, 202);
    }

    @Override
    public void handleMouseInput() throws IOException
    {
        super.handleMouseInput();
        list.handleMouseInput();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        list.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        super.mouseReleased(mouseX, mouseY, state);
        list.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        list.drawScreen(mouseX, mouseY, partialTicks);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void drawTooltips(int mouseX, int mouseY)
    {
        for (IGuiListEntry entry : list.listEntries)
        {
            if (entry instanceof GuiConfigList.ConfigEntry)
            {
                GuiConfigList.ConfigEntry e = (GuiConfigList.ConfigEntry) entry;
                String enabled = Compatibility.getActualName(e.prop.getName()) + " is not installed";

                if (mouseOverButton(mouseX, mouseY, e.configButton))
                {
                    String s = isSpecial ? !e.configButton.prop.getBoolean() ? "enable" : "disable" : e.configButton.prop.getBoolean() + "";
                    drawHoveringText(!e.configButton.enabled ? enabled : I18n.format(Assets.CONFIG_GUI_PREFIX + s + ".name"), mouseX, mouseY);
                }

                if (e.settingsButton != null)
                {
                    if (mouseOverButton(mouseX, mouseY, e.settingsButton))
                    {
                        drawHoveringText(!e.settingsButton.enabled ? enabled : I18n.format(Assets.CONFIG_GUI_PREFIX + "settings.name"), mouseX, mouseY);
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public class GuiConfigList extends GuiListExtended
    {
        protected final GuiListExtended.IGuiListEntry[] listEntries;
        protected final GuiCategory parent;

        public GuiConfigList(GuiCategory parent, Minecraft mc, ConfigCategory category)
        {
            super(mc, parent.width, parent.height, 32, parent.height - 52, 28);
            this.parent = parent;
            listEntries = new GuiListExtended.IGuiListEntry[getSize()];
            int i = 0;

            for (ConfigCategory cat : category.getChildren())
            {
                for (Property p : cat.getOrderedValues())
                {
                    if (p.getName().equals(cat.getName()))
                    {
                        listEntries[i] = new ConfigEntry(i, p, cat);
                        i++;
                    }
                }
            }
        }

        @Override
        protected int getSize()
        {
            int size = 0;
            for (ConfigCategory cat : category.getChildren())
            {
                for (Property p : cat.getOrderedValues())
                {
                    if (p.getName().equals(cat.getName()))
                    {
                        size++;
                    }
                }
            }

            return size;
        }

        @Override
        public IGuiListEntry getListEntry(int index)
        {
            return listEntries[index];
        }

        @Override
        protected int getScrollBarX()
        {
            return super.getScrollBarX() + 32;
        }

        @Override
        public int getListWidth()
        {
            return super.getListWidth() + 100;
        }

        @SideOnly(Side.CLIENT)
        public class ConfigEntry implements GuiListExtended.IGuiListEntry
        {
            protected final GuiButtonConfig configButton;
            protected GuiButtonSettings settingsButton;
            private final Property prop;

            private ConfigEntry(int index, Property prop, ConfigCategory category)
            {
                configButton = new GuiButtonConfig(0, 0, 0, prop);

                if (category.getOrderedValues().size() > 1)
                {
                    settingsButton = new GuiButtonSettings(0, 0, 0, category);
                }

                this.prop = prop;

                if (category.getName().contains("Compatibility"))
                {
                    if (!Compatibility.isModInstalled(category.getName()))
                    {
                        configButton.enabled = false;

                        if (settingsButton != null)
                        {
                            settingsButton.enabled = false;
                        }
                    }
                }
            }

            @Override
            public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected, float partialTicks)
            {
                configButton.x = (width / 2 + 106);
                configButton.y = y;
                configButton.drawButton(mc, mouseX, mouseY, partialTicks);

                if (settingsButton != null)
                {
                    settingsButton.x = (width / 2 + 106) + 22;
                    settingsButton.y = y;
                    settingsButton.drawButton(mc, mouseX, mouseY, partialTicks);
                }

                String s = isSpecial ? I18n.format(category.getName().replaceAll("Items", "item.").replace("Blocks", "tile.") + Assets.ASSET_PREFIX + "." + prop.getName() + ".name") : prop.getName();
                mc.fontRenderer.drawString(s, width / 2 - 120, configButton.y + 8, 0xFFFFFF);
            }

            @Override
            public boolean mousePressed(int slotIndex, int mouseX, int mouseY, int mouseEvent, int relativeX, int relativeY)
            {
                if (configButton.mousePressed(mc, mouseX, mouseY))
                {
                    try
                    {
                        parent.actionPerformed(configButton);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    configButton.playPressSound(mc.getSoundHandler());

                    return true;
                }
                else if (settingsButton != null)
                {
                    if (settingsButton.mousePressed(mc, mouseX, mouseY))
                    {
                        mc.displayGuiScreen(new GuiSettings(parent, settingsButton.getCategory()));
                        settingsButton.playPressSound(mc.getSoundHandler());
                        return true;
                    }
                }

                return false;
            }

            @Override
            public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY)
            {
                configButton.mouseReleased(x, y);

                if (settingsButton != null)
                {
                    settingsButton.mouseReleased(x, y);
                }
            }

            @Override
            public void updatePosition(int slotIndex, int x, int y, float partialTicks)
            {
            }
        }
    }
}