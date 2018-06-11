package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumDyeColor;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.util.IBlockMeta;

public abstract class BlockSlabBase extends BlockSlab implements IBlockMeta
{
    protected final String BASE_NAME;
    protected boolean isDouble;

    public BlockSlabBase(Material material, String name, boolean isDouble)
    {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_STAIRS_AND_SLABS_TAB);

        useNeighborBrightness = true;
        BASE_NAME = name;
        this.isDouble = isDouble;
    }
    
    @Override
    public boolean isDouble()
    {
        return isDouble;
    }

    @Override
    public String getSpecialName(int meta)
    {
        return getUnlocalizedName(meta);
    }

    @Override
    public String getVariantName()
    {
        return Assets.VARIANT_NAME_VARIANT;
    }
    
    @Override
    public Enum byMetadata(int meta)
    {
        return null;
    }
}
