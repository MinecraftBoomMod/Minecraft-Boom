package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import soupbubbles.minecraftboom.init.ModBlocks;

public class WorldGenPumpkin extends WorldGenerator
{
    @Override
    public boolean generate(World world, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (world.isAirBlock(blockpos) && world.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS && Blocks.PUMPKIN.canPlaceBlockAt(world, blockpos))
            {
                world.setBlockState(blockpos, ModBlocks.BLOCK_FACELESS_PUMPKIN.getDefaultState(), 2);
            }
        }

        return true;
    }
}