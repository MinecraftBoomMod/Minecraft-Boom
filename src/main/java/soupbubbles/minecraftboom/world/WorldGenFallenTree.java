package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFallenTree extends WorldGenerator
{
    private IBlockState state;
    private int maximumLength;
    
    public WorldGenFallenTree(IBlockState logState, int length)
    {
        super();
        state = logState;
        maximumLength = length;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        while ((world.isAirBlock(pos) || world.getBlockState(pos).getBlock() instanceof BlockLeaves) && pos.getY() > 40)
        {
            pos = pos.down();
        }
        
        if (world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.GRASS)
        {
            pos = pos.up();
            boolean direction = rand.nextBoolean();
            boolean minus = rand.nextBoolean();
            
            if (world.isAirBlock(pos))
            {
                world.setBlockState(pos, state.withProperty(BlockOldLog.LOG_AXIS, BlockLog.EnumAxis.Y));
                
                for (int j = 0; j < rand.nextInt(8); j++)
                {
                    EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(rand);
                    
                    if (isReplaceable(world, pos.offset(facing)) && rand.nextInt(10) < 7)
                    {
                        world.setBlockState(pos.offset(facing), Blocks.VINE.getDefaultState().withProperty(BlockVine.getPropertyFor(facing.getOpposite()), true));
                    }
                }

                if (rand.nextInt(200) == 0)
                {
                    //Rarely generates just a stump
                    return true;
                }
                
                int length = rand.nextInt(maximumLength - 3) + 4;
                
                for (int i = 0; i <= length; i++)
                {
                    BlockPos blockpos;
                    EnumAxis axis;
                    
                    if(direction)
                    {
                        if(minus)
                        {
                            blockpos = new BlockPos(pos.getX() - i, pos.getY(), pos.getZ());
                        }
                        else
                        {
                            blockpos = new BlockPos(pos.getX() + i, pos.getY(), pos.getZ());
                        }
                        
                        axis = EnumAxis.X;
                    }
                    else
                    {
                        if(minus)
                        {
                            blockpos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - i);
                        }
                        else
                        {
                            blockpos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + i);
                        }
                        
                        axis = EnumAxis.Z;
                    }
                    
                    if (i > 1 || i < -1)
                    {
                        if (world.isAirBlock(blockpos.down()) || isReplaceable(world, blockpos.down()))
                        {
                            while (world.isAirBlock(blockpos.down()) || isReplaceable(world, blockpos.down()))
                            {
                                blockpos = blockpos.down();
                            }
                            
                            blockpos.up();
                        }
                        
                        if (isReplaceable(world, blockpos))
                        {
                            world.setBlockState(blockpos, state.withProperty(BlockOldLog.LOG_AXIS, axis));
                        }
                        else if (world.isAirBlock(blockpos.up()))
                        {
                            world.setBlockState(blockpos, state.withProperty(BlockOldLog.LOG_AXIS, axis));
                        }
                        else
                        {
                            return true;
                        }
                    }
                }
            }
            
            return true;
        }

        return false;
    }
    
    private boolean isReplaceable(World world, BlockPos pos)
    {
        if (world.isAirBlock(pos) || world.getBlockState(pos).getMaterial() == Material.PLANTS || world.getBlockState(pos).getMaterial() == Material.VINE || world.getBlockState(pos).getMaterial() == Material.SNOW || world.getBlockState(pos).getMaterial() == Material.WATER)
        {
            return true;
        }
        
        return false;
    }
}
