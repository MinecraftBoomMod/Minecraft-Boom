package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockSign;
import net.minecraft.block.SoundType;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockWoodenSign extends BlockSign
{
    protected final String BASE_NAME;

    public BlockWoodenSign(String name)
    {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(0.5F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_DECORATION_ITEM_TAB);
        
        BASE_NAME = name;
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}
