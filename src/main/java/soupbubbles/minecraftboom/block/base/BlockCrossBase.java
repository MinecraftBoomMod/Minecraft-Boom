package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.creativetab.CreativeTab;

public class BlockCrossBase extends BlockBush
{
    public static final IProperty<Boolean> ITEM = PropertyBool.create("item");

    public BlockCrossBase()
    {
        super();
        setDefaultState(blockState.getBaseState().withProperty(ITEM, false));
        setHardness(0.0F);
        setSoundType(SoundType.PLANT);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_DECORATION_ITEM_TAB);
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {ITEM});
    }
}
