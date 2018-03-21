package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import soupbubbles.minecraftboom.block.BlockRose;
import soupbubbles.minecraftboom.init.ModBlocks;

public class WorldGenRoses extends WorldGenerator
{
    private IBlockState state;

    public WorldGenRoses(IBlockState blockstate)
    {
        state = blockstate;
    }
    
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        if (state.getBlock() instanceof BlockBush)
        {
            for (int i = 0; i < 64; ++i)
            {
                BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

                if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && Blocks.RED_FLOWER.canBlockStay(worldIn, blockpos, state))
                {
                    worldIn.setBlockState(blockpos, state, 2);
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
