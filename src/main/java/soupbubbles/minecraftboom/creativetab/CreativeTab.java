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
    public static final CreativeTabs MINECRAFTBOOM_BLOCK_TAB = new CreativeTabs(Reference.MOD_ID + "_block")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModBlocks.BLOCK_MOSSY_COBBLESTONE_BRICKS);
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> stack)
        {
            if (ConfigurationHandler.Settings.replacePumpkin)
            {
                stack.add(new ItemStack(Blocks.PUMPKIN, 1, 0));
                stack.add(new ItemStack(Blocks.PUMPKIN, 1, 1));
            }

            super.displayAllRelevantItems(stack);
        }
    };
    
    public static final CreativeTabs MINECRAFTBOOM_DECORATION_ITEM_TAB = new CreativeTabs(Reference.MOD_ID + "_decoration_item")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.ITEM_LEVITATION_DUST);
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> stack)
        {
            if (ConfigurationHandler.Settings.replaceCraftingTable)
            {
                stack.add(new ItemStack(Blocks.CRAFTING_TABLE));
                
                super.displayAllRelevantItems(stack);
            }
        }
    };
}