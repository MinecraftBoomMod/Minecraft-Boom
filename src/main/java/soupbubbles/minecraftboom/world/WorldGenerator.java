package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;
import soupbubbles.minecraftboom.block.BlockRose;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Assets;

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

        if (ConfigurationHandler.Settings.generateEndPiles)
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

        if (ConfigurationHandler.Settings.generateRoses)
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

        if (ConfigurationHandler.Settings.generatePumpkins)
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

        if (ConfigurationHandler.Settings.generateFallenTrees)
        {
            generateFallenTrees(world, rand, x, z);
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
            int chance = 1;
            int length = 5;
            boolean flag = true;

            if (biome.getBiomeName() == "Plains" || biome.getBiomeName() == "Sunflower Plains" || biome.getBiomeName() == "Extreme Hills" || biome.getBiomeName() == "Extreme Hills M")
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
                chance = 20;
            }
            else if (biome.getBiomeName() == "Forest" || biome.getBiomeName() == "ForestHills" || biome.getBiomeName() == "Flower Forest")
            {
                state = state.withProperty(BlockOldLog.VARIANT, rand.nextInt(10) < 2 ? BlockPlanks.EnumType.BIRCH : BlockPlanks.EnumType.OAK);
                chance = 2;
            }
            else if (biome.getBiomeName() == "Taiga" || biome.getBiomeName() == "TaigaHills" || biome.getBiomeName() == "Cold Taiga" || biome.getBiomeName() == "Cold Taiga Hills" || biome.getBiomeName() == "Mega Taiga" || biome.getBiomeName() == "Mega Taiga Hills" || biome.getBiomeName() == "Taiga M" || biome.getBiomeName() == "Cold Taiga M" || biome.getBiomeName() == "Mega Spruce Taiga" || biome.getBiomeName() == "Redwood Taiga Hills M")
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
                chance = 3;
                length = 8;
            }
            else if (biome.getBiomeName() == "Swampland" || biome.getBiomeName() == "Swampland M")
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
                chance = 5;
                length = 7;
            }
            else if (biome.getBiomeName() == "Jungle" || biome.getBiomeName() == "JungleHills" || biome.getBiomeName() == "JungleEdge" || biome.getBiomeName() == "Jungle M" || biome.getBiomeName() == "JungleEdge M")
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
                chance = 1;
                length = 9;
            }
            else if (biome.getBiomeName() == "Birch Forest" || biome.getBiomeName() == "Birch Forest Hills" || biome.getBiomeName() == "Birch Forest M" || biome.getBiomeName() == "Birch Forest Hills M")
            {
                state = state.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
                chance = 2;
            }
            else if (biome.getBiomeName() == "Roofed Forest" || biome.getBiomeName() == "Roofed Forest M")
            {
                state = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
                chance = 4;
            }
            else if (biome.getBiomeName() == "Extreme Hills+" || biome.getBiomeName() == "Extreme Hills+ M")
            {
                state = state.withProperty(BlockOldLog.VARIANT, rand.nextInt(10) < 2 ? BlockPlanks.EnumType.OAK : BlockPlanks.EnumType.SPRUCE);
                chance = 8;
            }
            else if (biome.getBiomeName() == "Savanna" || biome.getBiomeName() == "Savanna Plateau" || biome.getBiomeName() == "Savanna M" || biome.getBiomeName() == "Savanna Plateau M")
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
