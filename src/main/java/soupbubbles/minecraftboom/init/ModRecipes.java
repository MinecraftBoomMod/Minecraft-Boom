package soupbubbles.minecraftboom.init;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;

public class ModRecipes
{
    private static final List<IRecipe> RECIPES = CraftingManager.getInstance().getRecipeList();

    public static final Item[] REMOVE_ITEM_RECIPE_LIST = {};

    public static final Block[] REMOVE_BLOCK_RECIPE_LIST = {Blocks.STONE_BRICK_STAIRS, Blocks.SANDSTONE_STAIRS, Blocks.RED_SANDSTONE_STAIRS, Blocks.LADDER};

    private static int stairOutputAmount = 4;

    public static void init()
    {
        removeVanillaRecipes();

        if (ConfigurationHandler.Settings.replaceVanillaStairRecipe)
        {
            stairOutputAmount = 6;
            replaceVanillaStairRecipe();
        }

        initRecipes();
    }

    private static void initRecipes()
    {
        //Bricks
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_HARDENED_CLAY_BRICKS, 4), "xx", "xx", 'x', new ItemStack(Blocks.HARDENED_CLAY, 1));
        
        for (int i = 0; i < EnumDyeColor.values().length; i++)
        {
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_STAINED_CLAY_BRICKS, 4, i), "xx", "xx", 'x', new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, i));
        }
       
        
        // Polished Block
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_PRISMARINE.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.EnumType.ROUGH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.EnumType.DARK.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.END_BRICKS));
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.END_BRICKS, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_NETHERRACK.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.NETHERRACK));

        // Pillars
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_GRANITE), "x", "x", 'x', new ItemStack(Blocks.STONE, 1, BlockStone.EnumType.GRANITE_SMOOTH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_DIORITE), "x", "x", 'x', new ItemStack(Blocks.STONE, 1, BlockStone.EnumType.DIORITE_SMOOTH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_ANDESITE), "x", "x", 'x', new ItemStack(Blocks.STONE, 1, BlockStone.EnumType.ANDESITE_SMOOTH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_PRISMARINE), "x", "x", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.BRICKS_META));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_PRISMARINE), "x", "x", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_PRISMARINE.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_DARK_PRISMARINE), "x", "x", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.DARK_META));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_DARK_PRISMARINE), "x", "x", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_END_STONE), "x", "x", 'x', new ItemStack(Blocks.END_BRICKS));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_END_STONE), "x", "x", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_NETHERRACK), "x", "x", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_NETHERRACK.getMetadata()));

        if (ConfigurationHandler.Settings.replacePurplePillarRecipe)
        {
            GameRegistry.addShapedRecipe(new ItemStack(Blocks.PURPUR_PILLAR), "x", "x", 'x', new ItemStack(Blocks.PURPUR_BLOCK));
            GameRegistry.addShapedRecipe(new ItemStack(Blocks.PURPUR_BLOCK), "x", "x", 'x', new ItemStack(Blocks.PURPUR_SLAB));
        }

        // Stairs
        addStairRecipe(BlockStone.EnumType.STONE.getMetadata(), ModBlocks.BLOCK_STAIRS_STONE);
        addStairRecipe(BlockStone.EnumType.GRANITE_SMOOTH.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_GRANITE);
        addStairRecipe(BlockStone.EnumType.DIORITE_SMOOTH.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_DIORITE);
        addStairRecipe(BlockStone.EnumType.ANDESITE_SMOOTH.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_ANDESITE);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_MOSSY_COBBLESTONE);
        addStairRecipe(BlockStoneBrick.MOSSY_META, ModBlocks.BLOCK_STAIRS_MOSSY_STONEBRICK);
        addStairRecipe(BlockStoneBrick.CRACKED_META, ModBlocks.BLOCK_STAIRS_CRACKED_STONEBRICK);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_HARDENED_CLAY);
        addStairRecipe(BlockSandStone.EnumType.CHISELED.getMetadata(), ModBlocks.BLOCK_STAIRS_CHISELED_SANDSTONE);
        addStairRecipe(BlockSandStone.EnumType.SMOOTH.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_SANDSTONE);
        addStairRecipe(BlockRedSandstone.EnumType.CHISELED.getMetadata(), ModBlocks.BLOCK_STAIRS_CHISELED_RED_SANDSTONE);
        addStairRecipe(BlockRedSandstone.EnumType.SMOOTH.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_RED_SANDSTONE);
        addStairRecipe(BlockPrismarine.EnumType.BRICKS.getMetadata(), ModBlocks.BLOCK_STAIRS_PRISMARINE_BRICKS);
        addStairRecipe(BlockPrismarine.EnumType.DARK.getMetadata(), ModBlocks.BLOCK_STAIRS_DARK_PRISMARINE);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_END_BRICKS);
        addStairRecipe(ModBlocks.BLOCK_STAIRS_RED_NETHER_BRICK);
        addStairRecipe(BlockPolished.EnumType.SMOOTH_PRISMARINE.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_PRISMARINE);
        addStairRecipe(BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE);
        addStairRecipe(BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_END_STONE);
        addStairRecipe(BlockPolished.EnumType.SMOOTH_NETHERRACK.getMetadata(), ModBlocks.BLOCK_STAIRS_SMOOTH_NETHERRACK);

        addStairSlabRecipe(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.STONE.getMetadata(), ModBlocks.BLOCK_STAIRS_STONE);

        //Ladders
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.LADDER, 4), "x x", "xyx", "x x", 'x', new ItemStack(Items.STICK), 'y', new ItemStack(Blocks.WOODEN_SLAB, 1, BlockPlanks.EnumType.OAK.getMetadata()));

        //Vanilla Recipes
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_PICKAXE), "SSS", " T ", " T ", 'S', Blocks.STONE, 'T', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_AXE), " SS", " TS", " T ", 'S', Blocks.STONE, 'T', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_AXE), "SS ", "ST ", " T ", 'S', Blocks.STONE, 'T', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_HOE), " SS", " T ", " T ", 'S', Blocks.STONE, 'T', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_HOE), "SS ", " T ", " T ", 'S', Blocks.STONE, 'T', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_SHOVEL), " S ", " T ", " T ", 'S', Blocks.STONE, 'T', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_SWORD), " S ", " S ", " T ", 'S', Blocks.STONE, 'T', Items.STICK);
        
        GameRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_WART, 9), Blocks.NETHER_WART_BLOCK);

    }
    
    private static void removeVanillaRecipes()
    {
        Iterator<IRecipe> ir = RECIPES.iterator();

        while (ir.hasNext())
        {
            ItemStack outputStack = ir.next().getRecipeOutput();

            for (Item item : REMOVE_ITEM_RECIPE_LIST)
            {
                if (outputStack != null && outputStack.getItem() == item)
                {
                    ir.remove();
                }
            }

            for (Block block : REMOVE_BLOCK_RECIPE_LIST)
            {
                if (outputStack != null)
                {
                    if (outputStack.getItem() == Item.getItemFromBlock(block))
                    {
                        ir.remove();
                    }
                }
            }

            if (outputStack != null && outputStack.getItem() == Item.getItemFromBlock(Blocks.PURPUR_PILLAR) && ConfigurationHandler.Settings.replacePurplePillarRecipe)
            {
                ir.remove();
            }
        }
    }

    private static void replaceVanillaStairRecipe()
    {
        Iterator<IRecipe> ir = RECIPES.iterator();

        while (ir.hasNext())
        {
            ItemStack outputStack = ir.next().getRecipeOutput();

            if (outputStack != null && Block.getBlockFromItem(outputStack.getItem()) instanceof BlockStairs)
            {
                ir.remove();
            }
        }

        // Vanilla stair recipe replacements
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.OAK.getMetadata(), Blocks.OAK_STAIRS);
        addStairRecipe(Blocks.COBBLESTONE, Blocks.STONE_STAIRS);
        addStairRecipe(Blocks.BRICK_BLOCK, Blocks.BRICK_STAIRS);
        addStairRecipe(Blocks.STONEBRICK, BlockStoneBrick.DEFAULT_META, Blocks.STONE_BRICK_STAIRS);
        addStairRecipe(Blocks.STONEBRICK, BlockStoneBrick.CHISELED_META, Blocks.STONE_BRICK_STAIRS);
        addStairRecipe(Blocks.NETHER_BRICK, Blocks.NETHER_BRICK_STAIRS);
        addStairRecipe(Blocks.SANDSTONE, BlockSandStone.EnumType.DEFAULT.getMetadata(), Blocks.SANDSTONE_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.SPRUCE.getMetadata(), Blocks.SPRUCE_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.BIRCH.getMetadata(), Blocks.BIRCH_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.JUNGLE.getMetadata(), Blocks.JUNGLE_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.ACACIA.getMetadata(), Blocks.ACACIA_STAIRS);
        addStairRecipe(Blocks.PLANKS, BlockPlanks.EnumType.DARK_OAK.getMetadata(), Blocks.DARK_OAK_STAIRS);
        addStairRecipe(Blocks.RED_SANDSTONE, BlockSandStone.EnumType.DEFAULT.getMetadata(), Blocks.RED_SANDSTONE_STAIRS);
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

    private static void addStairSlabRecipe(BlockSlab input, int inputMeta, Block output)
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

    private static void addSlabRecipe(ItemStack input, ItemStack output)
    {
        GameRegistry.addShapedRecipe(output, "xxx", 'x', input);
    }
}
