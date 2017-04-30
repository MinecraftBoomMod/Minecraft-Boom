package soupbubbles.minecraftboom.item.base;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import soupbubbles.minecraftboom.block.base.IBlockMeta;

public abstract class ItemBlockMeta extends ItemBlock
{
    public ItemBlockMeta(Block block) 
    {
        super(block);
        
        if (!(block instanceof IBlockMeta))
        {
        	throw new IllegalArgumentException(block.getUnlocalizedName() + " must implement IBlockMeta");
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

    public abstract String[] getVariants();
}