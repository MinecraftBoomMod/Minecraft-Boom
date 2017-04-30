package soupbubbles.minecraftboom.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    public static final Set<Item> ITEMS = new HashSet<>();

    static
    {
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
