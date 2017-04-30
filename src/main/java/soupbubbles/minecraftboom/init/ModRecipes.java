package soupbubbles.minecraftboom.init;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.BlockPolished;
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
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_PRISMARINE.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.EnumType.ROUGH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.EnumType.DARK.getMetadata()));
        //GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.END_STONE));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_NETHERRACK.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.NETHERRACK));
        
        addStairRecipe(BlockStone.EnumType.STONE.getMetadata(), ModBlocks.BLOCK_STAIRS_STONE);
        addStairRecipe(BlockStone.EnumType.GRANITE_SMOOTH.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_GRANITE);
        addStairRecipe(BlockStone.EnumType.DIORITE_SMOOTH.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_DIORITE);
        addStairRecipe(BlockStone.EnumType.ANDESITE_SMOOTH.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_ANDESITE);
        addStairRecipe(BlockPrismarine.EnumType.BRICKS.getMetadata(), ModBlocks.BLOCK_STAIRS_PRISMARINE_BRICKS);
        addStairRecipe(BlockPrismarine.EnumType.DARK.getMetadata(), ModBlocks.BLOCK_STAIRS_DARK_PRISMARINE);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_END_BRICKS);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_RED_NETHER_BRICK);
        addStairRecipe(BlockPolished.EnumType.SMOOTH_PRISMARINE.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_PRISMARINE);
        addStairRecipe(BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE);
        addStairRecipe(BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_END_STONE);
        addStairRecipe(BlockPolished.EnumType.SMOOTH_NETHERRACK.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_NETHERRACK);

        addStairSlabRecipe(Blocks.STONE_SLAB, 0, ModBlocks.BLOCK_STAIRS_STONE);
    }

    private static void replaceVanillaStairRecipe()
    {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> ir = recipes.iterator();

        while (ir.hasNext())
        {
            ItemStack outputStack = ir.next().getRecipeOutput();

            if (outputStack != null && Block.getBlockFromItem(outputStack.getItem()) instanceof BlockStairs)
            {
                ir.remove();
            }
        }
        
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.OAK.getMetadata(), Blocks.OAK_STAIRS);
        addStairRecipe(Blocks.COBBLESTONE, Blocks.STONE_STAIRS);
        addStairRecipe(Blocks.BRICK_BLOCK, Blocks.BRICK_STAIRS);
        addStairRecipe(Blocks.STONEBRICK, BlockStoneBrick.DEFAULT_META, Blocks.STONE_BRICK_STAIRS);
        addStairRecipe(Blocks.STONEBRICK, BlockStoneBrick.CRACKED_META, Blocks.STONE_BRICK_STAIRS);
        addStairRecipe(Blocks.STONEBRICK, BlockStoneBrick.MOSSY_META, Blocks.STONE_BRICK_STAIRS);
        addStairRecipe(Blocks.STONEBRICK, BlockStoneBrick.CHISELED_META, Blocks.STONE_BRICK_STAIRS);
        addStairRecipe(Blocks.NETHER_BRICK, Blocks.NETHER_BRICK_STAIRS);
        addStairRecipe(Blocks.SANDSTONE, BlockSandStone.EnumType.DEFAULT.getMetadata(), Blocks.SANDSTONE_STAIRS);
        addStairRecipe(Blocks.SANDSTONE, BlockSandStone.EnumType.CHISELED.getMetadata(), Blocks.SANDSTONE_STAIRS);
        addStairRecipe(Blocks.SANDSTONE, BlockSandStone.EnumType.SMOOTH.getMetadata(), Blocks.SANDSTONE_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.SPRUCE.getMetadata(), Blocks.SPRUCE_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.BIRCH.getMetadata(), Blocks.BIRCH_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.JUNGLE.getMetadata(), Blocks.JUNGLE_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.ACACIA.getMetadata(), Blocks.ACACIA_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.DARK_OAK.getMetadata(), Blocks.DARK_OAK_STAIRS);
        addStairRecipe(Blocks.RED_SANDSTONE, BlockSandStone.EnumType.DEFAULT.getMetadata(), Blocks.RED_SANDSTONE_STAIRS);
        addStairRecipe(Blocks.RED_SANDSTONE, BlockSandStone.EnumType.CHISELED.getMetadata(), Blocks.RED_SANDSTONE_STAIRS);
        addStairRecipe(Blocks.RED_SANDSTONE, BlockSandStone.EnumType.SMOOTH.getMetadata(), Blocks.RED_SANDSTONE_STAIRS);
        addStairRecipe(Blocks.PURPUR_BLOCK, Blocks.PURPUR_STAIRS);
    }

    private static void addStairRecipe(BlockStairBase output)
    {
        addStairRecipe(0, output);
    }

    private static void addStairRecipe(Block input, Block output)
    {
        addStairRecipe(input, 0, output);
    }
    
    private static void addStairRecipe(int inputMeta, BlockStairBase output)
    {
        addStairRecipe(output.getStairBlockState().getBlock(), inputMeta, output);
    }

    private static void addStairRecipe(Block input, int inputMeta, Block output)
    {
        addStairRecipe(input, inputMeta, output, stairOutputAmount);
    }

    private static void addStairSlabRecipe(Block input, int inputMeta, Block output)
    {
        addStairRecipe(input, inputMeta, output, stairOutputAmount / 2);
    }

    private static void addStairRecipe(Block input, int inputMeta, Block output, int outputAmount)
    {
        addStairRecipe(new ItemStack(input, 1, inputMeta), new ItemStack(output, outputAmount, 0));
    }
    
    private static void addStairRecipe(ItemStack input, ItemStack output)
    {
        GameRegistry.addShapedRecipe(output, "x  ", "xx ", "xxx", 'x', input);
        GameRegistry.addShapedRecipe(output, "  x", " xx", "xxx", 'x', input);
    }
}
