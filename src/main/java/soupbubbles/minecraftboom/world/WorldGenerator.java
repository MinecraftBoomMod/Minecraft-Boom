package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.fml.common.IWorldGenerator;
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

        if (ConfigurationHandler.generateEndPiles)
        {
            if (rand.nextInt(40) == 0)
            {
                new WorldGenEndPiles().generate(world, rand, pos.add(rand.nextInt(16) + 8, rand.nextInt(120) + 4, rand.nextInt(16) + 8));
            }
        }
    }

    private void generateSurface(World world, Random rand, int x, int z)
    {
        if (world.getWorldType() == WorldType.FLAT)
        {
            return;
        }
        
        BlockPos pos = new BlockPos(x, 0, z);

        if (ConfigurationHandler.generateRoses)
        {
            for (int l2 = 0; l2 < 2; ++l2)
            {
                int x1 = rand.nextInt(16) + 8;
                int z1 = rand.nextInt(16) + 8;
                int y = world.getHeight(pos.add(x1, 0, z1)).getY() + 32;

                if (y > 0)
                {
                    int y1 = rand.nextInt(y);
                    BlockPos blockpos1 = pos.add(x1, y1, z1);

                    if (ModBlocks.BLOCK_ROSE != null)
                    {
                        if (ModBlocks.BLOCK_ROSE.getDefaultState().getMaterial() != Material.AIR)
                        {
                            new WorldGenRoses(ModBlocks.BLOCK_ROSE.getDefaultState()).generate(world, rand, blockpos1);
                        }
                    }
                    else if (ConfigurationHandler.tryGenerateRose)
                    {
                    }
                }
            }
        }

        if (ConfigurationHandler.generatePumpkins)
        {
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

        if (ConfigurationHandler.generateFallenTrees)
        {
            generateFallenTrees(world, rand, x, z);
        }

        if (ConfigurationHandler.generateFineGravel)
        {
            new WorldGenSand(ModBlocks.BLOCK_FINE_GRAVEL, 4).generate(world, rand, world.getTopSolidOrLiquidBlock(pos));
            new WorldGenMinable(ModBlocks.BLOCK_FINE_GRAVEL.getDefaultState(), 25).generate(world, rand, pos.add(rand.nextInt(16), rand.nextInt(60), rand.nextInt(16)));
        }
    }

    private void generateNether(World world, Random rand, int x, int z)
    {
        BlockPos pos = new BlockPos(x, 0, z);

        if (ConfigurationHandler.generateNetherWells)
        {
            if (rand.nextInt(300) == 0)
            {
                new WorldGenNetherWell(rand.nextInt(5) == 0).generate(world, rand, pos.add(rand.nextInt(16) + 8, rand.nextInt(120) + 4, rand.nextInt(16) + 8));
            }
        }
    }

    private void generateFallenTrees(World world, Random rand, int x, int z)
    {
        BlockPos pos = new BlockPos(x, 0, z);

        int x1 = rand.nextInt(16) + 8;
        int z1 = rand.nextInt(16) + 8;
        int y = world.getHeight(pos.add(x1, 0, z1)).getY() * 2;

        if (y > 0)
        {
            int y1 = rand.nextInt(y);

            BlockPos position = pos.add(x1, y1, z1);

            Biome biome = world.getBiome(position);
            IBlockState state = Blocks.LOG.getDefaultState();
            int id = Biome.getIdForBiome(biome);
            int chance = 1;
            int length = 5;
            boolean flag = true;

            if (biome.equals(Biomes.PLAINS) || biome.equals(Biomes.MUTATED_PLAINS) || biome.equals(Biomes.EXTREME_HILLS) || biome.equals(Biomes.MUTATED_EXTREME_HILLS) || biome.equals(Biomes.EXTREME_HILLS_EDGE))
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
                chance = 20;
            }
            else if (biome.equals(Biomes.FOREST) || biome.equals(Biomes.FOREST_HILLS) || biome.equals(Biomes.MUTATED_FOREST))
            {
                state = state.withProperty(BlockOldLog.VARIANT, rand.nextInt(10) < 2 ? BlockPlanks.EnumType.BIRCH : BlockPlanks.EnumType.OAK);
                chance = 2;
            }
            else if (biome.equals(Biomes.TAIGA) || biome == (Biomes.TAIGA_HILLS) || biome.equals(Biomes.COLD_TAIGA) || biome.equals(Biomes.COLD_TAIGA_HILLS) || biome.equals(Biomes.MUTATED_TAIGA) || biome.equals(Biomes.MUTATED_TAIGA_COLD) || biome.equals(Biomes.MUTATED_REDWOOD_TAIGA) || biome.equals(Biomes.MUTATED_REDWOOD_TAIGA_HILLS) || biome.equals(Biomes.REDWOOD_TAIGA) || biome.equals(Biomes.REDWOOD_TAIGA_HILLS))
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
                chance = 3;
                length = 8;
            }
            else if (biome.equals(Biomes.SWAMPLAND) || biome.equals(Biomes.MUTATED_SWAMPLAND))
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
                chance = 5;
                length = 7;
            }
            else if (biome.equals(Biomes.JUNGLE) || biome.equals(Biomes.JUNGLE_HILLS) || biome.equals(Biomes.JUNGLE_EDGE) || biome.equals(Biomes.MUTATED_JUNGLE) || biome.equals(Biomes.MUTATED_JUNGLE_EDGE))
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
                chance = 1;
                length = 9;
            }
            else if (biome.equals(Biomes.BIRCH_FOREST) || biome.equals(Biomes.BIRCH_FOREST_HILLS) || biome.equals(Biomes.MUTATED_BIRCH_FOREST) || biome.equals(Biomes.MUTATED_BIRCH_FOREST_HILLS))
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
                chance = 2;
            }
            else if (biome.equals(Biomes.ROOFED_FOREST) || biome.equals(Biomes.MUTATED_ROOFED_FOREST))
            {
                state = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
                chance = 4;
            }
            else if (biome.equals(Biomes.EXTREME_HILLS_WITH_TREES) || biome.equals(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES))
            {
                state = state.withProperty(BlockOldLog.VARIANT, rand.nextInt(10) < 2 ? BlockPlanks.EnumType.OAK : BlockPlanks.EnumType.SPRUCE);
                chance = 8;
            }
            else if (biome.equals(Biomes.SAVANNA) || biome.equals(Biomes.SAVANNA_PLATEAU) || biome.equals(Biomes.MUTATED_SAVANNA) || biome.equals(Biomes.MUTATED_SAVANNA_ROCK))
            {
                state = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA);
                chance = 5;
            }
            else
            {
                flag = false;
            }

            if (rand.nextInt(chance) == 0 && flag)
            {
                new WorldGenFallenTree(state, length).generate(world, rand, position);
            }
        }
    }
}
