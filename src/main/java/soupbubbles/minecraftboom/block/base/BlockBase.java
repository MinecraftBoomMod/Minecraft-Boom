package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockBase extends Block
{
    protected final String BASE_NAME;

    public BlockBase(String name)
    {
        this(Material.ROCK, name);
    }

    public BlockBase(Material material, String name)
    {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        setSoundType(SoundType.STONE);

        BASE_NAME = name;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }

    public BlockBase setSound(SoundType sound)
    {
        setSoundType(sound);
        return this;
    }
}