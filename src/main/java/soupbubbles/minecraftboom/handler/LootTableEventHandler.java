package soupbubbles.minecraftboom.handler;

import java.util.Arrays;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;
import soupbubbles.minecraftboom.util.Utils;

@Mod.EventBusSubscriber
public class LootTableEventHandler
{
    @SubscribeEvent
    public void onLootTableLoad(LootTableLoadEvent event)
    {
        String name = event.getName().toString();
        List<String> addPool = Arrays.asList("wither_skeleton", "silverfish", "polar_bear", "elder_guardian", "simple_dungeon", "jungle_temple");
        List<String> telescope = Arrays.asList("simple_dungeon", "jungle_temple", "abandoned_mineshaft", "desert_pyramid", "nether_bridge");

        try
        {
            for (String actual : addPool)
            {
                if (name.matches("minecraft:.*/" + actual))
                {
                    event.getTable().addPool(getAdditivePool(Assets.TEXTURE_PREFIX + actual));
                }
            }

            if (Utils.getConfigValue(ConfigurationHandler.telescopeLoot, ConfigurationHandler.items))
            {
                for (String actual : telescope)
                {
                    if (name.matches("minecraft:.*/" + actual))
                    {
                        event.getTable().addPool(getAdditivePool(Assets.TEXTURE_PREFIX + actual));
                    }
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private LootPool getAdditivePool(String entryName)
    {
        return new LootPool(new LootEntry[] {getAdditiveEntry(entryName, 1)}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "Additive_pool");
    }

    private LootEntryTable getAdditiveEntry(String name, int weight)
    {
        return new LootEntryTable(new ResourceLocation(name), weight, 0, new LootCondition[0], Assets.TEXTURE_PREFIX + name);
    }
}