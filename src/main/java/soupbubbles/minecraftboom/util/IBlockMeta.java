package soupbubbles.minecraftboom.util;

import net.minecraft.block.properties.PropertyEnum;

public interface IBlockMeta
{
    public String getSpecialName(int meta);
    
    public Enum byMetadata(int meta);
    
    public PropertyEnum getVariants();
    
    public String getVariantName();
}
