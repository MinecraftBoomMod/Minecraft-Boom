package soupbubbles.minecraftboom.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import soupbubbles.minecraftboom.block.base.BlockColoredBase;
import soupbubbles.minecraftboom.reference.Names;

public class BlockDye extends BlockColoredBase
{
	public BlockDye() 
	{
		super(Names.BLOCK_DYE);
	}
	
	@Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        for (EnumDyeColor enumdyecolor : EnumDyeColor.values())
        {
        	if (enumdyecolor.getMetadata() != EnumDyeColor.BLUE.getMetadata())
        	{
                items.add(new ItemStack(this, 1, enumdyecolor.getMetadata()));
        	}
        }
    }
}
