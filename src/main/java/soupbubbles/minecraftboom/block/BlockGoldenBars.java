package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public class BlockGoldenBars extends BlockPane 
{
	protected final String BASE_NAME = Names.BLOCK_GOLDEN_BARS;

	public BlockGoldenBars() 
	{
		super(Material.IRON, true);
		setUnlocalizedName(BASE_NAME);
        setRegistryName(BASE_NAME);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_BLOCK_TAB);
	}
	
    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}