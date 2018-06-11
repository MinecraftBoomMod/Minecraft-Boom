package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.util.IBlockMeta;
import soupbubbles.minecraftboom.util.IStairSlab;

public class BlockColoredBase extends BlockColored implements IBlockMeta, IStairSlab
{
    protected final String BASE_NAME;
    private boolean stair = false;
    
    public BlockColoredBase(Material material, String name)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);    

        BASE_NAME = name;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }

    @Override
    public String getSpecialName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, EnumDyeColor.byMetadata(meta).getName() + "_" + BASE_NAME);
    }

    @Override
    public PropertyEnum getVariants()
    {
        return COLOR;
    }

    @Override
    public String getVariantName()
    {
        return Assets.VARIANT_NAME_COLOR;
    }
    
    @Override
    public Enum byMetadata(int meta)
    {
        return EnumDyeColor.byMetadata(meta);
    }

    public Block addStair()
    {
        ModBlocks.STAIR_LIST.add(this);
        stair = true;
        
        return this;
    }

    @Override
    public boolean hasStair()
    {
        return stair;
    }
}
