package soupbubbles.minecraftboom.init;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockStoneSlabNew;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.BlockBookShelf;
import soupbubbles.minecraftboom.block.BlockNewPumpkin;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.block.slab.BlockModSlab;
import soupbubbles.minecraftboom.block.slab.BlockVanillaStoneSlab;
import soupbubbles.minecraftboom.block.slab.BlockVanillaStoneSlab2;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;

public class ModRecipes
{
    /*private static final List<IRecipe> RECIPES = CraftingManager.REGISTRY.getRecipeList();

    private static int stairOutputAmount = 4;*/

    public static void init()
    {
    	/*removeVanillaRecipes();

        if (ConfigurationHandler.Settings.replaceVanillaStairRecipe)
        {
            stairOutputAmount = 6;
            replaceVanillaStairRecipe();
        }
        */
    }

    private static void initRecipes()
    {
    	/*
        //Soul glass
        for (int meta = 0; meta < EnumDyeColor.values().length; meta++)
        {
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_STAINED_SOUL_GLASS, 1, meta), "xxx", "xyx", "xxx", 'x', ModBlocks.BLOCK_SOUL_GLASS, 'y', new ItemStack(Items.DYE, 1, EnumDyeColor.byMetadata(meta).getDyeDamage()));
        }

        if (ConfigurationHandler.Settings.replacePumpkin)
        {
            GameRegistry.addShapedRecipe(new ItemStack(Blocks.LIT_PUMPKIN), "x", "y", 'x', new ItemStack(ModBlocks.BLOCK_PUMPKIN, 1, BlockNewPumpkin.EnumType.CARVED.getMetadata()), 'y', Blocks.TORCH);
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BLOCK_PUMPKIN, 1, BlockNewPumpkin.EnumType.DEFAULT.getMetadata()), "xxx", "xxx", "xxx", 'x', ModItems.ITEM_PUMPKIN_SLICE);
            GameRegistry.addShapelessRecipe(new ItemStack(Items.PUMPKIN_PIE), Items.SUGAR, Items.EGG, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE, ModItems.ITEM_PUMPKIN_SLICE);
            //GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.BLOCK_PUMPKIN, 1, BlockNewPumpkin.EnumType.CARVED.getMetadata()), new ItemStack(Items.SHEARS.setContainerItem(Items.SHEARS), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ModBlocks.BLOCK_PUMPKIN, 1, BlockNewPumpkin.EnumType.DEFAULT.getMetadata()));
        }
        */
    }
}
