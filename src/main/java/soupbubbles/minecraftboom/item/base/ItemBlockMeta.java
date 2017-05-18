package soupbubbles.minecraftboom.item.base;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.util.IBlockMeta;

public class ItemBlockMeta extends ItemBlock
{
    protected final String[] VARIANTS = new String[((IBlockMeta) block).getVariants().getAllowedValues().size()];
    private String variantName;
    
    public ItemBlockMeta(Block block, String name) 
    {
        super(block);
        
        for (int i = 0; i < VARIANTS.length; i++)
        {
            VARIANTS[i] = ((IStringSerializable) block.getStateFromMeta(i).getValue(((IBlockMeta) block).getVariants())).getName();
        }
        
        setRegistryName(block.getRegistryName());
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return ((IBlockMeta)block).getSpecialName(stack.getItemDamage());
    }
    
    public String getVariantName()
    {
    	return ((IBlockMeta) block).getVariantName();
    }

    public String[] getVariants()
    {
        return VARIANTS;
    }
}