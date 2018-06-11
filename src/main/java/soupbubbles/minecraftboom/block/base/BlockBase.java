package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.util.IStairSlab;

public class BlockBase extends Block implements IStairSlab
{
    protected final String BASE_NAME;
    private boolean stair = false;

    public BlockBase(String name)
    {
        this(Material.ROCK, name, SoundType.STONE);
    }

    public BlockBase(Material material, String name, SoundType sound)
    {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        setSoundType(sound);

        BASE_NAME = name;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, getBaseName());
    }
    
    public String getBaseName()
    {
        return BASE_NAME;
    }
    
    public Block setSound(SoundType sound)
    {
        setSoundType(sound);
        return this;
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