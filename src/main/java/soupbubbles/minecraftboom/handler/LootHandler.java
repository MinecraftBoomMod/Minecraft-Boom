package soupbubbles.minecraftboom.handler;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
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
        //Main, pool1, pool2

        /*
         * Implementation in source file. No JSon needed. For Implementation
         * with JSon scroll down.
         */
        if (event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST))
        {
            final LootPool pool = event.getTable().getPool("pool2");
            if (pool != null)
            {
                pool.addEntry(new LootEntryItem(ModItems.ITEM_TELESCOPE, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":telescope_starter"));
            }
        }

        if (event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON))
        {
            final LootPool pool = event.getTable().getPool("main");
            pool.getName();
            if (pool != null)
            {
                pool.addEntry(new LootEntryItem(ModItems.ITEM_TELESCOPE, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":telescope_main"));
            }
        }
        if (event.getName().equals(LootTableList.ENTITIES_SHULKER))
        {
            //		  ArrayList<LootCondition> conditions = new ArrayList<LootCondition>();
            //		  conditions.add(new RandomChance(0.10F));
            //		  event.getTable().addPool(new LootPool( new LootEntry[0], conditions.toArray(new LootCondition[0]), new RandomValueRange(1.0F, 1.0F), new RandomValueRange(1.0F, 1.0F), Reference.MOD_ID + ":pool1"));
            //		  event.getTable().getPool(Reference.MOD_ID + ":pool1").addEntry(new LootEntryItem(ModItems.ITEM_LEVITATION_DUST, 10, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + ":" + Names.ITEM_LEVITATION_DUST));
        }
        if (event.getName().equals(LootTableList.ENTITIES_SILVERFISH))
        {
            //		  ArrayList<LootCondition> conditions = new ArrayList<LootCondition>();
            //		  conditions.add(new RandomChance(0.35F));
            //		  event.setTable(new LootTable(new LootPool[0]));
            //		  event.getTable().addPool(new LootPool( new LootEntry[0], new LootCondition[0], new RandomValueRange(1.0F, 1.0F), new RandomValueRange(1.0F, 1.0F), Reference.MOD_ID + "main"));
            //		  //field_191525_da = Iron Nuggets
            //		  event.getTable().getPool(Reference.MOD_ID + "main").addEntry(new LootEntryItem(Items.field_191525_da, 10, 0, new LootFunction[0], conditions.toArray(new LootCondition[0]), Reference.MOD_ID + ":Iron"));

        }
    }

    @SubscribeEvent
    public void Table_Additives(LootTableLoadEvent event)
    {
        String name = event.getName().toString();

        try
        {
            switch (name)
            {
                case "minecraft:entities/shulker":
                    event.getTable().addPool(getAdditivePool(Reference.MOD_ID + ":shulker"));
                    break;
                case "minecraft:entities/wither_skeleton":
                    event.getTable().addPool(getAdditivePool(Reference.MOD_ID + ":wither_skeleton"));
                    break;
                case "minecraft:entities/silverfish":
                    event.getTable().addPool(getAdditivePool(Reference.MOD_ID + ":silverfish"));
                    break;
            }

            System.out.println(name);

        }
        catch (Exception exc)
        {
        }
    }

    private LootPool getAdditivePool(String entryName)
    {
        return new LootPool(new LootEntry[] {getAdditiveEntry(entryName, 1)}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "Additive_pool");
    }

    private LootEntryTable getAdditiveEntry(String name, int weight)
    {
        return new LootEntryTable(new ResourceLocation(name), weight, 0, new LootCondition[0], Reference.MOD_ID + ":" + name);
    }
}
