package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import soupbubbles.minecraftboom.block.base.IBlockMeta;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public class BlockStainedSoulGlassPane extends BlockStainedGlassPane implements IBlockMeta
{
	private final String BASE_NAME = Names.BLOCK_STAINED_SOUL_GLASS_PANE;
	
    public BlockStainedSoulGlassPane()
    {
        super();
        setUnlocalizedName(BASE_NAME);
        setRegistryName(BASE_NAME);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_BLOCK_TAB);
    }
    
    @Override
    public String getSpecialName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, EnumDyeColor.byMetadata(meta).getName() + "_" + BASE_NAME);
    }

    @Override
    public PropertyEnum getVariants()
    {
        return COLOR;
    }
    
    @Override
    public String getVariantName()
    {
        return "color";
    }
}
