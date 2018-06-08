package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNetherWell extends WorldGenerator
{
    private boolean isSpecial;

    private static final BlockStateMatcher IS_NETHERRACK = BlockStateMatcher.forBlock(Blocks.NETHERRACK);

    private static final IBlockState NETHER_BRICK = Blocks.NETHER_BRICK.getDefaultState();
    private static final IBlockState NETHER_BRICK_SLAB = Blocks.STONE_SLAB.getDefaultState().withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.NETHERBRICK).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
    private static final IBlockState NETHER_BRICK_STAIRS = Blocks.NETHER_BRICK_STAIRS.getDefaultState();
    private static final IBlockState NETHER_BRICK_FENCE = Blocks.NETHER_BRICK_FENCE.getDefaultState();
    private static final IBlockState LAVA = Blocks.LAVA.getDefaultState();

    public WorldGenNetherWell(boolean special)
    {
        isSpecial = special;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        while (world.isAirBlock(pos) && pos.getY() > 2)
        {
            pos = pos.down();
        }

        if (!IS_NETHERRACK.apply(world.getBlockState(pos)))
        {
            return false;
        }
        else
        {
            for (int x = -1; x <= 1; ++x)
            {
                for (int y = 1; y <= 4; ++y)
                {
                    for (int z = -1; z <= 1; ++z)
                    {
                        if (!world.isAirBlock(pos.add(x, y, z)))
                        {
                            return false;
                        }
                    }
                }
            }

            if (isSpecial)
            {
                for (int x = -1; x <= 1; ++x)
                {
                    for (int y = -10; y <= 0; ++y)
                    {
                        for (int z = -1; z <= 1; ++z)
                        {
                            if (world.isAirBlock(pos.add(x, y, z)))
                            {
                                return false;
                            }
                        }
                    }
                }
            }
            else
            {
                for (int x = -1; x <= 1; ++x)
                {
                    for (int z = -1; z <= 1; ++z)
                    {
                        if (world.isAirBlock(pos.add(x, 0, z)) && world.isAirBlock(pos.add(x, -1, z)))
                        {
                            return false;
                        }
                    }
                }
            }

            System.out.println("Generating well, special: " + isSpecial + ". At: x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ());

            if (isSpecial)
            {
                for (int x = -1; x <= 1; ++x)
                {
                    for (int y = -10; y <= 0; ++y)
                    {
                        for (int z = -1; z <= 1; ++z)
                        {
                            world.setBlockState(pos.add(x, y, z), NETHER_BRICK, 2);
                        }
                    }
                }

                for (int y = -9; y <= 0; ++y)
                {
                    world.setBlockToAir(pos.add(0, y, 0));
                }
            }
            else
            {
                for (int x = -1; x <= 1; ++x)
                {
                    for (int y = -1; y <= 0; ++y)
                    {
                        for (int z = -1; z <= 1; ++z)
                        {
                            world.setBlockState(pos.add(x, y, z), NETHER_BRICK, 2);
                        }
                    }
                }

                world.setBlockState(pos, LAVA, 2);
            }

            world.setBlockState(pos.add(0, 1, 1), NETHER_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(BlockStairs.FACING, EnumFacing.SOUTH).withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.STRAIGHT), 2); // north
            world.setBlockState(pos.add(0, 1, -1), NETHER_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(BlockStairs.FACING, EnumFacing.NORTH).withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.STRAIGHT), 2); // south
            world.setBlockState(pos.add(-1, 1, 0), NETHER_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(BlockStairs.FACING, EnumFacing.WEST).withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.STRAIGHT), 2); // east
            world.setBlockState(pos.add(1, 1, 0), NETHER_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(BlockStairs.FACING, EnumFacing.EAST).withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.STRAIGHT), 2); // west

            world.setBlockState(pos.add(-1, 1, 1), NETHER_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(BlockStairs.FACING, EnumFacing.WEST).withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.INNER_RIGHT), 2); // north-east
            world.setBlockState(pos.add(1, 1, 1), NETHER_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(BlockStairs.FACING, EnumFacing.EAST).withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.INNER_LEFT), 2); // north-west
            world.setBlockState(pos.add(-1, 1, -1), NETHER_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(BlockStairs.FACING, EnumFacing.WEST).withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.INNER_LEFT), 2); // north-west
            world.setBlockState(pos.add(1, 1, -1), NETHER_BRICK_STAIRS.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(BlockStairs.FACING, EnumFacing.EAST).withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.INNER_RIGHT), 2); // south-west

            for (int x = -1; x <= 1; ++x)
            {
                for (int z = -1; z <= 1; ++z)
                {
                    world.setBlockState(pos.add(x, 4, z), NETHER_BRICK_SLAB, 2);
                }
            }

            for (int k1 = 2; k1 <= 3; ++k1)
            {
                world.setBlockState(pos.add(-1, k1, -1), NETHER_BRICK_FENCE, 2);
                world.setBlockState(pos.add(-1, k1, 1), NETHER_BRICK_FENCE, 2);
                world.setBlockState(pos.add(1, k1, -1), NETHER_BRICK_FENCE, 2);
                world.setBlockState(pos.add(1, k1, 1), NETHER_BRICK_FENCE, 2);
            }

            if (isSpecial)
            {
                world.setBlockState(pos.add(0, 2, 0), Blocks.CAULDRON.getDefaultState(), 2);
                world.setBlockState(pos.add(0, 3, 0), NETHER_BRICK_FENCE, 2);
            }

            return true;
        }
    }
}