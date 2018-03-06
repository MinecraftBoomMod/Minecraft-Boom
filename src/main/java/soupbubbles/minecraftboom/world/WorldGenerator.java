package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;
import soupbubbles.minecraftboom.init.ModBlocks;

public class WorldGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        Biome biome = world.getBiomeForCoordsBody(new BlockPos(chunkX, 0, chunkZ));

        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST))
        {
            generateRoses(world, random, chunkX, chunkZ);
        }
    }

    private void generateRoses(World world, Random random, int chunkX, int chunkZ)
    {
        int xGen = random.nextInt(16) + chunkX;
        int zGen = random.nextInt(16) + chunkZ;
        BlockPos genPos = world.getHeight(new BlockPos(xGen, 0, zGen));
        IBlockState state = ModBlocks.BLOCK_ROSE.getDefaultState();

        if (world.isAirBlock(genPos) && world.provider.hasSkyLight() && genPos.getY() < 255)
        {
            if (((BlockBush) state.getBlock()).canBlockStay(world, genPos.offset(EnumFacing.DOWN), state))
            {
                world.setBlockState(genPos, state);
            }
        }
    }
}
