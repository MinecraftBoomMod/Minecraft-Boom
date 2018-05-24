package soupbubbles.minecraftboom.handler;

import java.lang.reflect.Field;

import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EntityEventHandler
{

    @SubscribeEvent
    public static void onDimensionTravel(EntityTravelToDimensionEvent event)
    {
        if(event.isCanceled() || !ConfigurationHandler.tweaks)
        {
            return;
        }
        
        Field optionsBackground = null;
        ResourceLocation newBackground;
        
        if (ConfigurationHandler.replaceLoadingScreen)
        {
            try
            {
                optionsBackground = Gui.class.getField("OPTIONS_BACKGROUND");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            if (event.getDimension() == -1)
            {
                newBackground = new ResourceLocation("textures/blocks/netherrack.png");
            }
            else if (event.getDimension() == 1)
            {
                newBackground = new ResourceLocation("textures/blocks/end_stone.png");
            }
            else
            {
                newBackground = new ResourceLocation("textures/blocks/dirt.png");
            }
            
            setBackground(newBackground, optionsBackground);
        }
        else
        {
            try
            {
                optionsBackground = Gui.class.getField("OPTIONS_BACKGROUND");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            setBackground(new ResourceLocation("textures/blocks/dirt.png"), optionsBackground);
        }
    }

    private static void setBackground(ResourceLocation rl, Field optionsBackground)
    {
        try
        {
            setFinalStatic(optionsBackground, rl);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void setFinalStatic(Field field, Object newValue) throws Exception
    {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & 0xFFFFFFEF);
        field.set(null, newValue);
    }
}
