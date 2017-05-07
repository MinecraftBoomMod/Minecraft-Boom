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
import soupbubbles.minecraftboom.reference.Reference;

@Mod.EventBusSubscriber
public class LootHandler
{
  @SubscribeEvent
  public static void lootTableLoad(LootTableLoadEvent event)
  {
	  //Main, pool1, pool2
	  
/*
 * Implementation in source file. No JSon needed.
 * For Implementation with JSon scroll down.
 */ 
	  if (event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST))
	  {
		  final LootPool pool = event.getTable().getPool("main"); 
	        if (pool != null) {
	        	pool.addEntry(new LootEntryItem(ModItems.ITEM_TELESCOPE, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":telescope_starter"));
	        }
	  }
  }
  
  
  
	@SubscribeEvent
	public void Table_Additives(LootTableLoadEvent event) 
	{

		String name = event.getName().toString();
		List<String> addPool = Arrays.asList("shulker", "wither_skeleton", "silverfish", "polar_bear", "elder_guardian", "simple_dungeon");

		try {
			
			for(String actual : addPool)
			{
				if (name.matches("minecraft:.*/" + actual))
				{
					event.getTable().addPool(getAdditivePool(Reference.MOD_ID + ":" + actual));
				}
			}
			System.out.println(name);

		} 
		catch (Exception exc) 
		{
		}
	}

	private LootPool getAdditivePool(String entryName) 
	{
		return new LootPool(new LootEntry[] { getAdditiveEntry(entryName, 1) }, new LootCondition[0],
				new RandomValueRange(1), new RandomValueRange(0, 1), "Additive_pool");
	}

	private LootEntryTable getAdditiveEntry(String name, int weight) 
	{
		return new LootEntryTable(new ResourceLocation(name), weight, 0, new LootCondition[0], Reference.MOD_ID + ":" + name);
	}
}
