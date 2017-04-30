package soupbubbles.minecraftboom.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
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
}