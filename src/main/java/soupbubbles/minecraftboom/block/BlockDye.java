package soupbubbles.minecraftboom.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import soupbubbles.minecraftboom.block.base.BlockColoredBase;
import soupbubbles.minecraftboom.reference.BlockValues;
import soupbubbles.minecraftboom.reference.Names;

public class BlockDye extends BlockColoredBase
{
	public BlockDye() 
	{
		super(Material.ROCK, Names.BLOCK_DYE);
        setHardness(BlockValues.DYE_BLOCK_HARDENESS);
        setResistance(BlockValues.DYE_BLOCK_RESISTANCE);
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
