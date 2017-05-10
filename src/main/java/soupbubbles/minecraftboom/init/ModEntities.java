package soupbubbles.minecraftboom.init;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.client.renderer.RenderGenericItem;
import soupbubbles.minecraftboom.client.renderer.RenderPrismarineArrow;
import soupbubbles.minecraftboom.entity.EntityGrenade;
import soupbubbles.minecraftboom.entity.EntityPrismarineArrow;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.reference.Reference;

public class ModEntities
{
    public static void initEntities()
    {
        int id = -1;
        
        registerEntity(EntityGrenade.class, Names.ENTITY_POPPED_CHORUS_GRENADE, id++, 80, 3, true);
        registerEntity(EntityPrismarineArrow.class, Names.ITEM_PRISMARINE_ARROW, id++, 80, 1, true);
    }

    public static void registerEntityRenderers()
    {
    	RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, renderManager -> new RenderGenericItem(renderManager, ModItems.ITEM_POPPED_CHORUS_GRENADE, Minecraft.getMinecraft().getRenderItem()));
    	RenderingRegistry.registerEntityRenderingHandler(EntityPrismarineArrow.class, renderManager -> new RenderPrismarineArrow(renderManager));
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