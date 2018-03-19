package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEndPiles extends WorldGenerator
{
    private static final BlockStateMatcher IS_END_STONE = BlockStateMatcher.forBlock(Blocks.END_STONE);
    private static final Block[] BLOCK_LIST = {Blocks.GRASS, Blocks.DIRT, Blocks.STONE, Blocks.COBBLESTONE, Blocks.SAND};

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        while (world.isAirBlock(pos) && pos.getY() > 2)
        {
            pos = pos.down();
        }

        if (!IS_END_STONE.apply(world.getBlockState(pos)))
        {
            return false;
        }
        else
        {
            int y = 1;
            
            if (rand.nextInt(3) == 1)
            {
                for (int x = -4; x <= 4; x++)
                {
                    for (int z = -4; z <= 4; z++)
                    {
                        if(Math.sqrt((x * x) + (z * z)) <= 4)
                        {
                            if (world.getBlockState(pos.add(x, y - 1, z)).getBlock() == Blocks.AIR && rand.nextInt(10) > 1 && world.getBlockState(pos.add(x, y - 2, z)).getBlock() != Blocks.AIR)
                            {
                                world.setBlockState(pos.add(x, 1, z), getRandomBlock(rand), 2);
                            }

                            if (rand.nextInt(10) > 2 && world.getBlockState(pos.add(x, y - 1, z)).getBlock() != Blocks.AIR)
                            {
                                world.setBlockState(pos.add(x, y, z), getRandomBlock(rand), 2);
                            }
                        }
                    }
                }
                
                y++;
            }
            
            if (rand.nextInt(2) == 1)
            {
                for (int x = -3; x <= 3; x++)
                {
                    for (int z = -3; z <= 3; z++)
                    {
                        if(Math.sqrt((x * x) + (z * z)) <= 3)
                        {
                            if (rand.nextInt(10) > 2 && world.getBlockState(pos.add(x, y - 1, z)).getBlock() != Blocks.AIR)
                            {
                                world.setBlockState(pos.add(x, y, z), getRandomBlock(rand), 2);
                            }
                        }
                    }
                }
                
                y++;
            }

            if (rand.nextInt(2) == 1)
            {
                for (int x = -2; x <= 2; x++)
                {
                    for (int z = -2; z <= 2; z++)
                    {
                        if(Math.sqrt((x * x) + (z * z)) <= 2)
                        {
                            if (rand.nextInt(10) > 1 && world.getBlockState(pos.add(x, y - 1, z)).getBlock() != Blocks.AIR)
                            {
                                world.setBlockState(pos.add(x, y, z), getRandomBlock(rand), 2);
                            }
                        }
                    }
                }
                
                y++;
            }

            for (int x = -1; x <= 1; x++)
            {
                for (int z = -1; z <= 1; z++)
                {
                    if(Math.sqrt((x * x) + (z * z)) <= 1)
                    {
                        if (rand.nextInt(10) > 1 && world.getBlockState(pos.add(x, y - 1, z)).getBlock() != Blocks.AIR)
                        {
                            world.setBlockState(pos.add(x, y, z), getRandomBlock(rand), 2);
                        }
                    }
                }
            }
        }

        return true;
    }

    private IBlockState getRandomBlock(Random rand)
    {
        if (rand.nextInt(300) == 0)
        {
            return Blocks.DIAMOND_ORE.getDefaultState();
        }
        else if (rand.nextInt(100) == 0)
        {
            return Blocks.GOLD_ORE.getDefaultState();
        }
        else if (rand.nextInt(50) == 0)
        {
            return Blocks.IRON_ORE.getDefaultState();
        }
        else if (rand.nextInt(10) == 0)
        {
            return Blocks.COAL_ORE.getDefaultState();
        }
        
        return BLOCK_LIST[rand.nextInt(BLOCK_LIST.length)].getDefaultState();
    }
    
    private class BlockRarity
    {
        private Block block;
        private int weight;
        
        public BlockRarity(Block blockIn, int weightIn)
        {
            block = blockIn;
            weight = weightIn;
        }
        
        public Block getBlock()
        {
            return block;
        }
        
        public int getWeight()
        {
            return weight;
        }
    }
}
