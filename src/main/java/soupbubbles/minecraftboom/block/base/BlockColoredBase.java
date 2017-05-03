package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockColored;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockColoredBase extends BlockColored implements IBlockMeta
{
    protected final String BASE_NAME;

    public BlockColoredBase(String name)
    {
        this(Material.ROCK, name, 2.0F, 10.0F, SoundType.STONE);
    }
    
    public BlockColoredBase(Material material, String name, float hardness, float resistance, SoundType sound)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        setHardness(hardness);
        setResistance(resistance);
        setSoundType(sound);

        BASE_NAME = name;
    }

    @Override
    public String getSpecialName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, getUnlocalizedName() + "_" + EnumDyeColor.byMetadata(meta).getName());
    }

    @Override
    public PropertyEnum getVariants()
    {
        return COLOR;
    }
}
