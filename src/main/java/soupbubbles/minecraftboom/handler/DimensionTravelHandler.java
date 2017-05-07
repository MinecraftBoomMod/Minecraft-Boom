package soupbubbles.minecraftboom.handler;

import java.lang.reflect.Field;

import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class DimensionTravelHandler 
{
	
	@SubscribeEvent
	public static void lootTableLoad(EntityTravelToDimensionEvent event) 
	{
		Field optionsBackground = null;
		ResourceLocation newBackground;
        try
        {
        	optionsBackground = Gui.class.getField("OPTIONS_BACKGROUND");
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        System.out.println(event.getDimension());
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
