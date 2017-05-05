package soupbubbles.minecraftboom.init;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import soupbubbles.minecraftboom.block.BlockBookShelf;
import soupbubbles.minecraftboom.block.BlockNewPumpkin;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;

public class ModRecipes
{
    private static final List<IRecipe> RECIPES = CraftingManager.getInstance().getRecipeList();

    public static final Item[] REMOVE_ITEM_RECIPE_LIST = {};

    public static final Block[] REMOVE_BLOCK_RECIPE_LIST = {Blocks.STONE_BRICK_STAIRS, Blocks.SANDSTONE_STAIRS, Blocks.RED_SANDSTONE_STAIRS, Blocks.LADDER, Blocks.BOOKSHELF};

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
        initFurnaceRecipes();
    }

    private static void initRecipes()
    {
        //Bricks
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_COBBLESTONE_BRICKS, 4), "xx", "xx", 'x', Blocks.COBBLESTONE);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_MOSSY_COBBLESTONE_BRICKS, 4), "xx", "xx", 'x', Blocks.MOSSY_COBBLESTONE);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_HARDENED_CLAY_BRICKS, 4), "xx", "xx", 'x', Blocks.HARDENED_CLAY);
        
        for (int meta = 0; meta < EnumDyeColor.values().length; meta++)
        {
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_STAINED_CLAY_BRICKS, 4, meta), "xx", "xx", 'x', new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, meta));
        }
        
        //Bookshelves
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.BOOKSHELF), "xxx", "yyy", "xxx", 'x', new ItemStack(Blocks.PLANKS, 1, BlockPlanks.EnumType.OAK.getMetadata()), 'y', new ItemStack(Items.BOOK));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_BOOKSHELF, 1, BlockBookShelf.EnumType.SPRUCE.getMetadata()), "xxx", "yyy", "xxx", 'x', new ItemStack(Blocks.PLANKS, 1, BlockPlanks.EnumType.SPRUCE.getMetadata()), 'y', Items.BOOK);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_BOOKSHELF, 1, BlockBookShelf.EnumType.BIRCH.getMetadata()), "xxx", "yyy", "xxx", 'x', new ItemStack(Blocks.PLANKS, 1, BlockPlanks.EnumType.BIRCH.getMetadata()), 'y', Items.BOOK);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_BOOKSHELF, 1, BlockBookShelf.EnumType.JUNGLE.getMetadata()), "xxx", "yyy", "xxx", 'x', new ItemStack(Blocks.PLANKS, 1, BlockPlanks.EnumType.JUNGLE.getMetadata()), 'y', Items.BOOK);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_BOOKSHELF, 1, BlockBookShelf.EnumType.ACACIA.getMetadata()), "xxx", "yyy", "xxx", 'x', new ItemStack(Blocks.PLANKS, 1, BlockPlanks.EnumType.ACACIA.getMetadata()), 'y', Items.BOOK);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_BOOKSHELF, 1, BlockBookShelf.EnumType.DARK_OAK.getMetadata()), "xxx", "yyy", "xxx", 'x', new ItemStack(Blocks.PLANKS, 1, BlockPlanks.EnumType.DARK_OAK.getMetadata()), 'y', Items.BOOK);
        
        //Storage Blocks
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_CHARCOAL), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.COAL, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.COAL, 9, 1), ModBlocks.BLOCK_CHARCOAL);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_SUGAR), "xxx", "xxx", "xxx", 'x', Items.SUGAR);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.SUGAR, 9), ModBlocks.BLOCK_SUGAR);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_SUGAR_CANE), "xxx", "xxx", "xxx", 'x', Items.REEDS);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.REEDS, 9), ModBlocks.BLOCK_SUGAR_CANE);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_GUNPOWDER), "xxx", "xxx", "xxx", 'x', Items.GUNPOWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.GUNPOWDER, 9), ModBlocks.BLOCK_GUNPOWDER);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_BLAZE_POWDER), "xxx", "xxx", "xxx", 'x', Items.BLAZE_POWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.BLAZE_POWDER, 9), ModBlocks.BLOCK_BLAZE_POWDER);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_MAGMA_CREAM), "xxx", "xxx", "xxx", 'x', Items.MAGMA_CREAM);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.MAGMA_CREAM, 9), ModBlocks.BLOCK_MAGMA_CREAM);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PRISMARINE_CRYSTAL), "xxx", "xxx", "xxx", 'x', Items.PRISMARINE_CRYSTALS);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS, 9), ModBlocks.BLOCK_PRISMARINE_CRYSTAL);

        // Polished Blocks
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_PRISMARINE.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.EnumType.ROUGH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE.getMetadata()), "xx", "xx", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.EnumType.DARK.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata()), "xx", "xx", 'x', Blocks.END_BRICKS);
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.END_BRICKS, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_POLISHED, 4, BlockPolished.EnumType.SMOOTH_NETHERRACK.getMetadata()), "xx", "xx", 'x', Blocks.NETHERRACK);

        // Pillars
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_GRANITE), "x", "x", 'x', new ItemStack(Blocks.STONE, 1, BlockStone.EnumType.GRANITE_SMOOTH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_DIORITE), "x", "x", 'x', new ItemStack(Blocks.STONE, 1, BlockStone.EnumType.DIORITE_SMOOTH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_ANDESITE), "x", "x", 'x', new ItemStack(Blocks.STONE, 1, BlockStone.EnumType.ANDESITE_SMOOTH.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_PRISMARINE), "x", "x", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.BRICKS_META));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_PRISMARINE), "x", "x", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_PRISMARINE.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_DARK_PRISMARINE), "x", "x", 'x', new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.DARK_META));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_DARK_PRISMARINE), "x", "x", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_END_STONE), "x", "x", 'x', Blocks.END_BRICKS);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_END_STONE), "x", "x", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_END_STONE.getMetadata()));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PILLAR_SMOOTH_NETHERRACK), "x", "x", 'x', new ItemStack(ModBlocks.BLOCK_POLISHED, 1, BlockPolished.EnumType.SMOOTH_NETHERRACK.getMetadata()));

        if (ConfigurationHandler.Settings.replacePurplePillarRecipe)
        {
            GameRegistry.addShapedRecipe(new ItemStack(Blocks.PURPUR_PILLAR), "x", "x", 'x', Blocks.PURPUR_BLOCK);
            GameRegistry.addShapedRecipe(new ItemStack(Blocks.PURPUR_BLOCK), "x", "x", 'x', Blocks.PURPUR_SLAB);
        }
        
        if (ConfigurationHandler.Settings.replacePumpkin)
        {
            GameRegistry.addShapedRecipe(new ItemStack(Blocks.LIT_PUMPKIN), "x", "y", 'x', new ItemStack(ModBlocks.BLOCK_PUMPKIN, 1, BlockNewPumpkin.EnumType.CARVED.getMetadata()), 'y', Blocks.TORCH);
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PUMPKIN, 1, BlockNewPumpkin.EnumType.DEFAULT.getMetadata()), "xxx", "xxx", "xxx", 'x', ModItems.ITEM_PUMPKIN_SLICE);
            GameRegistry.addShapelessRecipe(new ItemStack(Items.PUMPKIN_PIE), Items.SUGAR, Items.EGG, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE);
            //GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.BLOCK_PUMPKIN, 1, BlockNewPumpkin.EnumType.CARVED.getMetadata()), new ItemStack(Items.SHEARS.setContainerItem(Items.SHEARS), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ModBlocks.BLOCK_PUMPKIN, 1, BlockNewPumpkin.EnumType.DEFAULT.getMetadata()));
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

        //Items
        
        //Vanilla Recipes
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_PICKAXE), "xxx", " y ", " y ", 'x', Blocks.STONE, 'y', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_AXE), " xx", " yx", " y ", 'x', Blocks.STONE, 'y', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_AXE), "xx ", "xy ", " y ", 'x', Blocks.STONE, 'y', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_HOE), " xx", " y ", " y ", 'x', Blocks.STONE, 'y', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_HOE), "xx ", " y ", " y ", 'x', Blocks.STONE, 'y', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_SHOVEL), " x ", " y ", " y ", 'x', Blocks.STONE, 'y', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_SWORD), " x ", " x ", " y ", 'x', Blocks.STONE, 'y', Items.STICK);
       
        GameRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_WART, 9), Blocks.NETHER_WART_BLOCK);
    }
    
    private static void initFurnaceRecipes()
    {
        if (ConfigurationHandler.Settings.replacePumpkin)
        {
            GameRegistry.addSmelting(ModBlocks.BLOCK_PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
        }
        else
        {
            GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
        }
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
            else if (outputStack != null && ConfigurationHandler.Settings.replacePumpkin)
            {
                if(outputStack.getItem() == Item.getItemFromBlock(Blocks.LIT_PUMPKIN) || outputStack.getItem() == Items.PUMPKIN_PIE)
                {
                    ir.remove();
                }
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
