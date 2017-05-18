package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockWoodenLadder extends BlockLadder
{
    protected final String BASE_NAME;
    public static final IProperty<Boolean> ITEM = PropertyBool.create("item"); 

    public BlockWoodenLadder(String name)
    {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ITEM, false));
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
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, ITEM});
    }
}
