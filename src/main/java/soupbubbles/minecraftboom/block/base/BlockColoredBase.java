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
    private boolean hasStairSlab = false;
    private BlockStairBase stair;
    private BlockSlabBase slab;
    
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

    @Override
    public Block addStairSlab()
    {
        ModBlocks.STAIRSLAB_LIST.add(this);
        hasStairSlab = true;
        
        return this;
    }

    @Override
    public boolean hasStairSlab()
    {
        return hasStairSlab;
    }

    @Override
    public BlockStairBase getStair()
    {
        return stair;
    }

    @Override
    public BlockSlabBase getSlab()
    {
        return slab;
    }

    @Override
    public BlockStairBase setStair(BlockStairBase stair)
    {
        return this.stair = stair;
    }

    @Override
    public BlockSlabBase setSlab(BlockSlabBase slab)
    {
        return this.slab = slab;
    }
}
