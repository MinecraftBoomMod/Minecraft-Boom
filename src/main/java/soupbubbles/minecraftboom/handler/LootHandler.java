package soupbubbles.minecraftboom.handler;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.reference.Reference;

@Mod.EventBusSubscriber
public class LootHandler
{
  @SubscribeEvent
  public static void lootTableLoad(LootTableLoadEvent event)
  {
/*	  
 * main --> rare loot, like horse armor and golden apples
 * pool1 --> uncommon loot, like pumpkin seeds and bread
 * pool2 --> garbage, like rotten flesh
 *
 */
	  if (event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST))
	  {
		  final LootPool pool = event.getTable().getPool("pool2"); 
	        if (pool != null) {
	        	pool.addEntry(new LootEntryItem(ModItems.ITEM_TELESCOPE, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":telescope_starter"));
	        }
	  }
	  if (event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON))
	  {
		  final LootPool pool = event.getTable().getPool("main"); 
	        if (pool != null) {
	        	pool.addEntry(new LootEntryItem(ModItems.ITEM_TELESCOPE, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":telescope_main"));
	        }
	  }
	  if (event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_END_CITY_TREASURE))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_IGLOO_CHEST))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_STRONGHOLD_CROSSING))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.CHESTS_WOODLAND_MANSION))
	  {
		  
	  }
	  if (event.getName().equals(LootTableList.ENTITIES_WITHER_SKELETON))
	  {
		  final LootPool pool = event.getTable().getPool("main"); 
	        if (pool != null) {
	        	pool.addEntry(new LootEntryItem(ModItems.ITEM_WITHER_BONE, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":" + Names.ITEM_WITHER_BONE));
	        }
	  }
	  if (event.getName().equals(LootTableList.ENTITIES_SHULKER))
	  {
		  final LootPool pool = event.getTable().getPool("main"); 
	        if (pool != null) {
	        	pool.addEntry(new LootEntryItem(ModItems.ITEM_LEVITATION_DUST, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":" + Names.ITEM_LEVITATION_DUST));
	        }
	  }
	  if (event.getName().equals(LootTableList.ENTITIES_SILVERFISH))
	  {
		  ArrayList<LootCondition> conditions = new ArrayList<LootCondition>();
		  conditions.add(new RandomChance(0.5F));
		  LootPool test = new LootPool( new LootEntry[0], conditions.toArray(new LootCondition[0]), new RandomValueRange(1.0F, 1.0F), new RandomValueRange(1.0F, 1.0F), "main");
		  event.setTable(new LootTable(new LootPool[0]));
		  event.getTable().addPool(test);
		  event.getTable().getPool("main").addEntry(new LootEntryItem(Items.IRON_INGOT, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":Iron"));
	      
	  }
	  
  }
}
