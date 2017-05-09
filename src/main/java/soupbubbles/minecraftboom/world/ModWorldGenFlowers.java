package soupbubbles.minecraftboom.world;

import java.util.Random;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;
import soupbubbles.minecraftboom.block.BlockModFlower;
import soupbubbles.minecraftboom.init.ModBlocks;

public class ModWorldGenFlowers implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		final Biome biome = world.getBiomeForCoordsBody(new BlockPos(chunkX, 0, chunkZ));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST))
		{
			this.runGenerator(world, random, chunkX, chunkZ);
		}
	}
	
	private void runGenerator(World world, Random random, int chunk_X, int chunk_Z) 
	{
        int xGen = random.nextInt(16) + chunk_X;
        int zGen = random.nextInt(16) + chunk_Z;
        BlockPos genPos = world.getHeight(new BlockPos(xGen, 0, zGen));
        BlockModFlower flower = ModBlocks.BLOCK_ROSE;
        if (world.isAirBlock(genPos) && !world.provider.hasNoSky() && genPos.getY() < 255)
            {
              BlockPos dirtPos = genPos;
              dirtPos.offset(EnumFacing.DOWN);
              if (flower.canBlockStay(world, dirtPos, flower.getDefaultState())) {
                world.setBlockState(genPos, flower.getDefaultState());
              }
        }
	}
}
