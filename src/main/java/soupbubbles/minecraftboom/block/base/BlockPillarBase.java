package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockPillarBase extends BlockRotatedPillar
{
    private final String BASE_NAME;

    public BlockPillarBase(String name)
    {
        this(Material.ROCK, name);
    }

    public BlockPillarBase(Material material, String name)
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

    public BlockPillarBase setSound(SoundType sound)
    {
        setSoundType(sound);
        return this;
    }
}
