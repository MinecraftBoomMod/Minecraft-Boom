package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.SoundType;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.lib.Assets;

public class BlockWoodenButton extends BlockButtonWood
{
    protected final String BASE_NAME;

    public BlockWoodenButton(String name)
    {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(0.5F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        
        BASE_NAME = name;
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}
