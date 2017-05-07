package soupbubbles.minecraftboom.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockColoredBase;
import soupbubbles.minecraftboom.reference.Names;

public class BlockDye extends BlockColoredBase
{
    public BlockDye()
    {
        super(Names.BLOCK_DYE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for (EnumDyeColor enumdyecolor : EnumDyeColor.values())
        {
            if (enumdyecolor.getMetadata() != EnumDyeColor.BLUE.getMetadata())
            {
                list.add(new ItemStack(itemIn, 1, enumdyecolor.getMetadata()));
            }
        }
    }
}
