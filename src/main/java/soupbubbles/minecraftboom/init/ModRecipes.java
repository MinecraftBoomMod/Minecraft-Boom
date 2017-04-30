package soupbubbles.minecraftboom.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.base.BlockStairBase;

public class ModRecipes
{

    public static void initRecipes()
    {
        addStairRecipe(ModBlocks.BLOCK_STAIRS_STONE, Blocks.STONE_SLAB, 3);

        addStairRecipe(ModBlocks.BLOCK_STAIRS_SMOOTH_GRANITE, 2);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_SMOOTH_DIORITE, 4);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_SMOOTH_ANDESITE, 6);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_PRISMARINE_BRICKS, 1);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_DARK_PRISMARINE, 2);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_END_BRICKS);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_RED_NETHER_BRICK);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_SMOOTH_PRISMARINE, 0);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE, 1);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_SMOOTH_END_STONE, 2);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_SMOOTH_NETHERRACK, 3);
    }

    private static void addStairRecipe(BlockStairBase output)
    {
        addStairRecipe(output, 6, 0);
    }

    private static void addStairRecipe(BlockStairBase output, int meta)
    {
        addStairRecipe(output, 6, meta);
    }

    private static void addStairRecipe(BlockStairBase output, int amount, int meta)
    {
        addStairRecipe(output, Item.getItemFromBlock(output.getStairBlockState().getBlock()), amount, meta);
    }

    private static void addStairRecipe(BlockStairBase output, Block input, int amount)
    {
        addStairRecipe(output, Item.getItemFromBlock(input), amount, 0);
    }

    private static void addStairRecipe(BlockStairBase output, Item input, int amount, int meta)
    {
        GameRegistry.addShapedRecipe(new ItemStack(output, amount, 0), "x  ", "xx ", "xxx", 'x', new ItemStack(input, 1, meta));
        GameRegistry.addShapedRecipe(new ItemStack(output, amount, 0), "  x", " xx", "xxx", 'x', new ItemStack(input, 1, meta));
    }
}
