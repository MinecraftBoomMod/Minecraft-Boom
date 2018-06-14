package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.lib.Assets;
import soupbubbles.minecraftboom.util.IStairSlab;

public class BlockBase extends Block implements IStairSlab
{
    protected final String BASE_NAME;
    private boolean hasStairSlab = false;
    private BlockStairBase stair;
    private BlockSlabBase slab;

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