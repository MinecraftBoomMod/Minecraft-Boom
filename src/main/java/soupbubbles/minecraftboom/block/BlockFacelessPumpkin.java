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
import soupbubbles.minecraftboom.lib.BlockValues;
import soupbubbles.minecraftboom.lib.Names;
import soupbubbles.minecraftboom.util.Utils;

public class BlockFacelessPumpkin extends BlockBase
{
    public BlockFacelessPumpkin()
    {
        super(Material.GROUND, Names.BLOCK_FACELESS_PUMPKIN, SoundType.WOOD);
        setHardness(BlockValues.PUMPKIN_HARDNESS);
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
        if (Utils.isItemEnabled(ModItems.ITEM_PUMPKIN_SLICE))
        {
            return ModItems.ITEM_PUMPKIN_SLICE;
        }
        
        return super.getItemDropped(state, rand, fortune);
    }

    @Override
    public int quantityDropped(Random rand)
    {
        if (Utils.isItemEnabled(ModItems.ITEM_PUMPKIN_SLICE))
        {
            return 3 + rand.nextInt(5);
        }
        
        return super.quantityDropped(rand);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return Math.min(9, this.quantityDropped(random) + random.nextInt(1 + fortune));
    }
}