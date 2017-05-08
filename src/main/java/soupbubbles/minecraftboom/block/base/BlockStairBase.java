package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockStairBase extends BlockStairs
{
    private final IBlockState STATE;
    private final String BASE_NAME;

    public BlockStairBase(IBlockState modelState, String name)
    {
        this(modelState, name, 2.0F, 10.0F, SoundType.STONE);
    }
    
    public BlockStairBase(IBlockState modelState, String name, float hardness, float resistance, SoundType sound)
    {
        super(modelState);
        name = "stairs_" + name;
        STATE = modelState;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_BLOCK_TAB);
        setHardness(hardness);
        setResistance(resistance);
        setSoundType(sound);

        BASE_NAME = name;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }

    public IBlockState getStairBlockState()
    {
        return STATE;
    }
}
