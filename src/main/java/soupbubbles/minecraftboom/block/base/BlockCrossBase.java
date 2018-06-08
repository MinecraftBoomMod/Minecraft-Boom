package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.util.IRenderItem;

public class BlockCrossBase extends BlockBush implements IRenderItem
{
    public BlockCrossBase()
    {
        super();
        setDefaultState(blockState.getBaseState().withProperty(ITEM, false));
        setSoundType(SoundType.PLANT);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
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

    @Override
    public PropertyEnum getVariants()
    {
        return (PropertyEnum) ITEM;
    }
}
