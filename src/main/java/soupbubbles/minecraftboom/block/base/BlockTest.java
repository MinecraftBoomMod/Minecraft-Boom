package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockTest extends BlockSlab
{
    private final IBlockState STATE;
    protected final String BASE_NAME;
    protected boolean isDouble;
    private boolean isVanilla;

    public BlockTest(IBlockState state, String name, boolean isDouble, boolean isVanilla)
    {
        super(state.getMaterial());
        name = "slab_" + name;
        STATE = state;
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_STAIRS_AND_SLABS_TAB);
        setHardness(STATE.getBlockHardness(null, null));
        setResistance(STATE.getBlock().getExplosionResistance(null, null, null, null) * 5.0F);
        setSoundType(STATE.getBlock().getSoundType());
        
        useNeighborBrightness = true;
        BASE_NAME = name;
        this.isDouble = isDouble;
        this.isVanilla = isVanilla;
    }

    @Override
    public String getUnlocalizedName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return EnumBlockHalf.BOTTOM;
    }
    
    @Override
    public boolean isDouble()
    {
        return isDouble;
    }

    public IBlockState getSlabBlockState()
    {
        return STATE;
    }

    public boolean isVanilla()
    {
        return isVanilla;
    }
}
