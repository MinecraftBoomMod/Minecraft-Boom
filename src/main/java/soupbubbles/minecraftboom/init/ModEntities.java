package soupbubbles.minecraftboom.init;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.client.renderer.RenderGenericItem;
import soupbubbles.minecraftboom.entity.EntityGrenade;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.reference.Reference;

public class ModEntities
{
    public static void initEntities()
    {
        registerEntity(EntityGrenade.class, Names.ENTITY_POPPED_CHORUS_GRENADE, 0, 80, 3, true);
    }

    public static void registerEntityRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, renderManager -> new RenderGenericItem(renderManager, ModItems.ITEM_POPPED_CHORUS_GRENADE, Minecraft.getMinecraft().getRenderItem()));
    }

    private static void registerEntity(Class<? extends Entity> clazz, String name, int id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), clazz, Reference.MOD_ID + "." + name, id, MinecraftBoom.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
    }

    private static void registerEntity(Class<? extends Entity> clazz, String name, int id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int primaryColor, int secondaryColor)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), clazz, Reference.MOD_ID + "." + name, id, MinecraftBoom.instance, trackingRange, updateFrequency, sendsVelocityUpdates, primaryColor, secondaryColor);
    }
}