package soupbubbles.minecraftboom.creativetab;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Reference;

public class CreativeTab extends CreativeTabs
{
    public static final CreativeTabs MINECRAFTBOOM_TAB = new CreativeTab(Reference.MOD_ID);
    
    public CreativeTab(String label)
    {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(Blocks.GRASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> stack)
    {
        if (ConfigurationHandler.Settings.replaceCraftingTable)
        {
            stack.add(new ItemStack(Blocks.CRAFTING_TABLE));
        }
        
        if (ConfigurationHandler.Settings.replacePumpkin)
        {
            stack.add(new ItemStack(Blocks.PUMPKIN, 1, 0));
            stack.add(new ItemStack(Blocks.PUMPKIN, 1, 1));
        }

        super.displayAllRelevantItems(stack);
    }
}