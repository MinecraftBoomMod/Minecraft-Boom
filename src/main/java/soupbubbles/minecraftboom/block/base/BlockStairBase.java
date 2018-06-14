package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.lib.Assets;

public class BlockStairBase extends BlockStairs
{
    private final IBlockState STATE;
    private final String BASE_NAME;
    private boolean isVanilla;

    public BlockStairBase(IBlockState modelState, String name, boolean vanilla)
    {
        super(modelState);
        name = "stairs_" + name;
        STATE = modelState;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_STAIRS_AND_SLABS_TAB);

        BASE_NAME = name;
        isVanilla = vanilla;
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
    
    public boolean isVanilla()
    {
        return isVanilla;
    }
}
