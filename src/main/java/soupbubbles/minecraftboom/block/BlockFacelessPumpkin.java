package soupbubbles.minecraftboom.block;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.reference.BlockValues;
import soupbubbles.minecraftboom.reference.Names;

public class BlockFacelessPumpkin extends BlockBase
{

    public BlockFacelessPumpkin()
    {
        super(Material.GROUND, Names.BLOCK_FACELESS_PUMPKIN, SoundType.WOOD);
        setHardness(BlockValues.PUMPKIN_HARDENESS);
        setResistance(BlockValues.PUMPKIN_RESISTANCE);
        setTickRandomly(true);
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        return world.getBlockState(pos).getBlock().isReplaceable(world, pos) && world.isSideSolid(pos.down(), EnumFacing.UP);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.ITEM_PUMPKIN_SLICE;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(5);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return Math.min(9, this.quantityDropped(random) + random.nextInt(1 + fortune));
    }
}