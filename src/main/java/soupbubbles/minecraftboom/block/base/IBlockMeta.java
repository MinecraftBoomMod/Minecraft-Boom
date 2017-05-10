package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.properties.PropertyEnum;

public interface IBlockMeta
{
    public String getSpecialName(int meta);
    
    public PropertyEnum getVariants();
    
    public String getVariantName();
}
