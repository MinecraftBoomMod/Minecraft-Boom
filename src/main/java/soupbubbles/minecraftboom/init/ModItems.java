package soupbubbles.minecraftboom.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.item.ItemGrenade;
import soupbubbles.minecraftboom.item.ItemTelescope;
import soupbubbles.minecraftboom.item.base.ItemBase;
import soupbubbles.minecraftboom.item.base.ItemFoodBase;
import soupbubbles.minecraftboom.reference.Names;

public class ModItems
{
    public static final Set<Item> ITEMS = new HashSet<>();

    public static final Item ITEM_ELDER_GUARDIAN_SPIKE;
    public static final Item ITEM_PINECONE;
    public static final Item ITEM_PUMPKIN_SLICE;
    public static final Item ITEM_WITHER_BONE;
    public static final Item ITEM_POPPED_CHORUS_GRENADE;
    public static final Item ITEM_TELESCOPE;

    static
    {
        ITEM_ELDER_GUARDIAN_SPIKE = registerItem(new ItemBase(Names.ITEM_ELDER_GUARDIAN_SPIKE));
        ITEM_PINECONE = registerItem(new ItemFoodBase(Names.ITEM_PINECONE, 3, 2.4F, false));
        ITEM_WITHER_BONE = registerItem(new ItemBase(Names.ITEM_WITHER_BONE));
        ITEM_POPPED_CHORUS_GRENADE = registerItem(new ItemGrenade(Names.ITEM_POPPED_CHORUS_GRENADE));
        ITEM_TELESCOPE = registerItem(new ItemTelescope());

        if (ConfigurationHandler.Settings.replacePumpkin)
        {
            ITEM_PUMPKIN_SLICE = registerItem(new ItemFoodBase(Names.ITEM_PUMPKIN_SLICE, 2, 1.2F, false));
        }
        else
        {
            ITEM_PUMPKIN_SLICE = null;
        }
    }

    public static void registerItems()
    {
    }

    private static <T extends Item> T registerItem(T item)
    {
        GameRegistry.register(item);
        ITEMS.add(item);

        return item;
    }
}
