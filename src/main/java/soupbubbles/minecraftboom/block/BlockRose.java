package soupbubbles.minecraftboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public class BlockRose extends BlockBush
{
    private final String BASE_NAME = Names.BLOCK_ROSE;

    public BlockRose()
    {
        super();
        setRegistryName(BASE_NAME);
        setUnlocalizedName(BASE_NAME);
        setHardness(0.0F);
        setSoundType(SoundType.PLANT);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_BLOCK_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return super.getBoundingBox(state, world, pos).move(state.getOffset(world, pos));
    }

    @Override
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }
}
