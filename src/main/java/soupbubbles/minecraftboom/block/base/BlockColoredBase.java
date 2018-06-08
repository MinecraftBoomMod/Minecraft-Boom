package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.util.IBlockMeta;

public class BlockColoredBase extends BlockColored implements IBlockMeta
{
    protected final String BASE_NAME;

    public BlockColoredBase(Material material, String name)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);    

        BASE_NAME = name;
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
}
