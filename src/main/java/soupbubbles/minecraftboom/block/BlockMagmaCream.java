package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockSlime;
import net.minecraft.block.SoundType;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public class BlockMagmaCream extends BlockSlime
{
    protected final String BASE_NAME = Names.BLOCK_MAGMA_CREAM;

    public BlockMagmaCream()
    {
        super();
        setRegistryName(BASE_NAME);
        setUnlocalizedName(BASE_NAME);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_BLOCK_TAB);
        setSoundType(SoundType.SLIME);
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}
