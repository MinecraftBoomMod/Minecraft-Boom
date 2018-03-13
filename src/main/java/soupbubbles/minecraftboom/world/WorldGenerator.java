package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;
import soupbubbles.minecraftboom.block.BlockRose;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.init.ModBlocks;

public class WorldGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.getDimension())
        {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateEnd(World world, Random rand, int x, int z)
    {
        BlockPos pos = new BlockPos(x, 0, z);

        if(ConfigurationHandler.Settings.generateEndPiles)
        {
            if (rand.nextInt(40) == 0)
            {
                new WorldGenEndPiles().generate(world, rand, pos.add(rand.nextInt(16) + 8, rand.nextInt(120) + 4, rand.nextInt(16) + 8));
            }
        }
    }

    private void generateSurface(World world, Random rand, int x, int z)
    {
        BlockPos pos;

        if(ConfigurationHandler.Settings.generateRoses)
        {
            pos = new BlockPos(x, 0, z);
                    
            for (int l2 = 0; l2 < 2; ++l2)
            {
                int x1 = rand.nextInt(16) + 8;
                int z1 = rand.nextInt(16) + 8;
                int y = world.getHeight(pos.add(x1, 0, z1)).getY() + 32;

                if (y > 0)
                {
                    int y1 = rand.nextInt(y);
                    BlockPos blockpos1 = pos.add(x1, y1, z1);

                    if (ModBlocks.BLOCK_ROSE.getDefaultState().getMaterial() != Material.AIR)
                    {
                        new WorldGenRoses().generate(world, rand, blockpos1);
                    }
                }
            }
        }

        if(ConfigurationHandler.Settings.generatePumpkins)
        {
            pos = new BlockPos(x, 0, z);
                    
            if (rand.nextInt(32) == 0)
            {
                int x1 = rand.nextInt(16) + 8;
                int z1 = rand.nextInt(16) + 8;
                int y = world.getHeight(pos.add(x1, 0, z1)).getY() * 2;

                if (y > 0)
                {
                    int y1 = rand.nextInt(y);
                    new WorldGenPumpkin().generate(world, rand, pos.add(x1, y1, z1));
                }
            }
        }
    }

    private void generateNether(World world, Random rand, int x, int z)
    {
        BlockPos pos = new BlockPos(x, 0, z);

        if (ConfigurationHandler.Settings.generateNetherWells)
        {
            if (rand.nextInt(300) == 0)
            {
                new WorldGenNetherWell(rand.nextInt(5) == 0).generate(world, rand, pos.add(rand.nextInt(16) + 8, rand.nextInt(120) + 4, rand.nextInt(16) + 8));
            }
        }
    }
}
