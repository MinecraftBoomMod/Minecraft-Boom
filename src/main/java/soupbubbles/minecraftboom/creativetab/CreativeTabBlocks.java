package soupbubbles.minecraftboom.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Reference;

public class CreativeTabBlocks extends CreativeTabs
{
    public static final CreativeTabs MINECRAFTBOOM_BLOCKS_TAB = new CreativeTabBlocks(Reference.MOD_ID + "_blocks");
    
    public CreativeTabBlocks(String label)
    {
        super(label);
    }

    
    @Override
    public ItemStack getTabIconItem()
    {
    	//Icon block can be changed later just did a not vanilla block
        return new ItemStack(ModBlocks.BLOCK_MAGMA_CREAM);
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