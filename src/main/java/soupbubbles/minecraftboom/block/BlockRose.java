package soupbubbles.minecraftboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import soupbubbles.minecraftboom.block.base.BlockCrossBase;
import soupbubbles.minecraftboom.lib.Assets;
import soupbubbles.minecraftboom.lib.BlockValues;
import soupbubbles.minecraftboom.lib.Names;

public class BlockRose extends BlockCrossBase
{
    private final String BASE_NAME = Names.BLOCK_ROSE;

    public BlockRose()
    {
        super();
        setRegistryName(BASE_NAME);
        setUnlocalizedName(BASE_NAME);
        setHardness(BlockValues.FLOWER_HARDNESS);
        setResistance(BlockValues.FLOWER_RESISTANCE);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return super.getBoundingBox(state, world, pos).offset(state.getOffset(world, pos));
    }

    @Override
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }
}
