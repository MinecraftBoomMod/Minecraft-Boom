package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public class BlockPaneBase extends BlockPane 
{
	protected final String BASE_NAME;

	public BlockPaneBase(Material material, String name, SoundType sound, boolean canDrop) 
	{
		super(material, canDrop);
		setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(sound);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        
        BASE_NAME = name;
	}
	
    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}