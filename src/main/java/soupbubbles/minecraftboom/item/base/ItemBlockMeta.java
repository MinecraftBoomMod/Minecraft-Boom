package soupbubbles.minecraftboom.item.base;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import soupbubbles.minecraftboom.block.base.IBlockMeta;

public class ItemBlockMeta extends ItemBlock
{
    private final String[] VARIANTS = new String[((IBlockMeta) block).getVariants().getAllowedValues().size()];

    public ItemBlockMeta(Block block) 
    {
        super(block);
        
        if (!(block instanceof IBlockMeta))
        {
        	throw new IllegalArgumentException(block.getUnlocalizedName() + " must implement IBlockMeta");
        }
        
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
    
    public String getRegistryPrefix()
    {
    	return "";
    }

    public String[] getVariants()
    {
        return VARIANTS;
    }
}