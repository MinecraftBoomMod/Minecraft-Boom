package soupbubbles.minecraftboom.handler;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

@EventBusSubscriber
public class RegistryHandler
{
    private static String[] override = {"bookshelf", "bone_block", "purpur_pillar", "ladder", "wooden_button", "trapdoor", "wooden_pressure_plate"};

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();

        for (int i = 0; i < override.length; i++)
        {
            modRegistry.remove(new ResourceLocation(Assets.MINECRAFT_PREFIX + override[i]));
        }
    }
}