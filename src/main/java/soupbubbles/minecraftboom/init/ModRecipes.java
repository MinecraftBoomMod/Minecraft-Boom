package soupbubbles.minecraftboom.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;

public class ModRecipes
{
    private static int stairOutputAmount = 4;
    
    public static void init()
    {
        if (ConfigurationHandler.Settings.replaceVanillaStairRecipe)
        {
            stairOutputAmount = 6;
            replaceVanillaStairRecipe();
        }
        
        initRecipes();
    }
    
    private static void initRecipes()
    {
        addStairRecipe(Blocks.STONE, 0, ModBlocks.BLOCK_STAIRS_STONE);
        addStairRecipe(2, ModBlocks.BLOCK_STAIRS_SMOOTH_GRANITE);
        addStairRecipe(4, ModBlocks.BLOCK_STAIRS_SMOOTH_DIORITE);
        addStairRecipe(6, ModBlocks.BLOCK_STAIRS_SMOOTH_ANDESITE);
        addStairRecipe(1, ModBlocks.BLOCK_STAIRS_PRISMARINE_BRICKS);
        addStairRecipe(2, ModBlocks.BLOCK_STAIRS_DARK_PRISMARINE);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_END_BRICKS);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_RED_NETHER_BRICK);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_SMOOTH_PRISMARINE);
        addStairRecipe(1, ModBlocks.BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE);
        addStairRecipe(2, ModBlocks.BLOCK_STAIRS_SMOOTH_END_STONE);
        addStairRecipe(3, ModBlocks.BLOCK_STAIRS_SMOOTH_NETHERRACK);
        
        addStairSlabRecipe(Blocks.STONE_SLAB, 0, ModBlocks.BLOCK_STAIRS_STONE);
    }

    private static void replaceVanillaStairRecipe()
    {
    }
    
    private static void addStairRecipe(BlockStairBase output)
    {
        addStairRecipe(0, output);
    }
    
    private static void addStairRecipe(int inputMeta, BlockStairBase output)
    {
        addStairRecipe(output.getStairBlockState().getBlock(), inputMeta, output);
    }

    private static void addStairRecipe(Block input, int inputMeta, BlockStairBase output)
    {
        addStairRecipe(input, inputMeta, output, stairOutputAmount);
    }
    
    private static void addStairSlabRecipe(Block input, int inputMeta, BlockStairBase output)
    {
        addStairRecipe(input, inputMeta, output, stairOutputAmount / 2);
    }

    private static void addStairRecipe(Block input, int inputMeta, BlockStairBase output, int outputAmount)
    {
        addStairRecipe(new ItemStack(input, 1, inputMeta), new ItemStack(output, outputAmount, 0));
    }
    
    private static void addStairRecipe(ItemStack input, ItemStack output)
    {
        GameRegistry.addShapedRecipe(output, "x  ", "xx ", "xxx", 'x', input);
        GameRegistry.addShapedRecipe(output, "  x", " xx", "xxx", 'x', input);
    }
}
