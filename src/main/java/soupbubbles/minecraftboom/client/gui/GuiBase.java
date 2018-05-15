package soupbubbles.minecraftboom.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;

public class GuiBase extends GuiScreen
{
    protected String title;
    protected GuiScreen parent;
    protected GuiButton backButton;
    protected boolean requiresRestart;

    public GuiBase(GuiScreen myParent)
    {
        parent = myParent;
        title =  Reference.MOD_NAME;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        buttonList.clear();
        
        buttonList.add(backButton = new GuiButton(0, width / 2 - 100, height / 6 + 168 - 20, 200, 20, I18n.format("gui.done")));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, title, width / 2, 15, 0xFFFFFF);
        drawCenteredString(fontRenderer, I18n.format(Assets.CONFIG_GUI_PREFIX + "restart.name"), width / 2, backButton.y + 26, 0xFFFFFF);
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void confirmClicked(boolean result, int id)
    {
        mc.displayGuiScreen(this);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (keyCode == 1)
        {
            returnToParent();
        }
    }

    protected void returnToParent()
    {
        mc.displayGuiScreen(parent);

        if (mc.currentScreen == null)
        {
            mc.setIngameFocus();
        }
    }

    
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);

        if (backButton != null && button == backButton)
        {
            returnToParent();
        }
    }
}
