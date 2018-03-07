package soupbubbles.minecraftboom.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.reference.Reference;

public class CreativeTab
{
    public static final CreativeTabs MINECRAFTBOOM_TAB = new CreativeTabs(Reference.MOD_ID + "_tab")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModBlocks.BLOCK_TERRACOTTA_BRICKS);
        }
        
        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> stack)
        {
            super.displayAllRelevantItems(stack);
        }
    };
    
    public static final CreativeTabs MINECRAFTBOOM_STAIRS_AND_SLABS_TAB = new CreativeTabs(Reference.MOD_ID + "_stairs_and_slabs_tab")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModBlocks.BLOCK_STAIRS_DARK_PRISMARINE);
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> stack)
        {
            super.displayAllRelevantItems(stack);
        }
    };
}