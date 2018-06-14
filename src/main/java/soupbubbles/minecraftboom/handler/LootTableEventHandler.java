package soupbubbles.minecraftboom.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.lib.Assets;
import soupbubbles.minecraftboom.util.Utils;

@Mod.EventBusSubscriber
public class LootTableEventHandler
{
    @SubscribeEvent
    public void onLootTableLoad(LootTableLoadEvent event)
    {
        String name = event.getName().toString();
        List<String> pools = new ArrayList<String>();
        
        if (ConfigurationHandler.silverfishDrop)
        {
            pools.add("silverfish");
        }
        
        if (ConfigurationHandler.polarBearDrop && Utils.isItemEnabled(ModItems.ITEM_POLAR_BEAR_FUR))
        {
            pools.add("polar_bear");
        }
        
        if (ConfigurationHandler.witherSkeletonDrop && Utils.isItemEnabled(ModItems.ITEM_WITHER_BONE))
        {
            pools.add("wither_skeleton");
        }
        
        if (ConfigurationHandler.elderGuardianDrop && Utils.isItemEnabled(ModItems.ITEM_ELDER_GUARDIAN_SPIKE))
        {
            pools.add("elder_guardian");
        }
        
        if (ConfigurationHandler.telescopeLoot && Utils.isItemEnabled(ModItems.ITEM_TELESCOPE))
        {
            pools.add("simple_dungeon");
        }
        
        try
        {
            for (String poolName : pools)
            {
                if (name.matches("minecraft:.*/" + poolName))
                {
                    event.getTable().addPool(getAdditivePool(Assets.TEXTURE_PREFIX + poolName));
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