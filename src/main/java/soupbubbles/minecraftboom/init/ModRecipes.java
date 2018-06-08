package soupbubbles.minecraftboom.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import soupbubbles.minecraftboom.block.BlockGravelStone;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.util.JsonRecipeGenerator;

public class ModRecipes
{

    public static void init()
    {
        JsonRecipeGenerator.init();

        initOreDict();
        initFurnaceRecipes();
        initBrewingRecipes();
    }

    private static void initOreDict()
    {
        addOreDict("boneWithered", ModItems.ITEM_WITHER_BONE);
        addOreDict("ingotBrickMagma", ModItems.ITEM_MAGMA_BRICK);
        addOreDict("pinecone", ModItems.ITEM_PINECONE);
        addOreDict("slicePumpkin", ModItems.ITEM_PUMPKIN_SLICE);
        addOreDict("blockCharcoal", ModBlocks.BLOCK_CHARCOAL);
        addOreDict("blockSugarCane", ModBlocks.BLOCK_SUGAR_CANE);
        addOreDict("blockReed", ModBlocks.BLOCK_SUGAR_CANE);
        addOreDict("blockSugar", ModBlocks.BLOCK_SUGAR);
        addOreDict("blockGunPowder", ModBlocks.BLOCK_GUNPOWDER);
        addOreDict("blockBlazePowder", ModBlocks.BLOCK_BLAZE_POWDER);
    }

    private static void addOreDict(String name, Block block)
    {
        if (block != null)
        {
            OreDictionary.registerOre(name, block);
        }
    }

    private static void addOreDict(String name, Item item)
    {
        if (item != null)
        {
            OreDictionary.registerOre(name, item);
        }
    }

    private static void initFurnaceRecipes()
    {
        GameRegistry.addSmelting(Blocks.SOUL_SAND, new ItemStack(ModBlocks.BLOCK_SOUL_GLASS), 0.1F);
        GameRegistry.addSmelting(Blocks.MAGMA, new ItemStack(ModItems.ITEM_MAGMA_BRICK), 0.1F);
        GameRegistry.addSmelting(Blocks.GRAVEL, new ItemStack(ModBlocks.BLOCK_GRAVEL_STONE, 1, BlockGravelStone.EnumType.GRAVEL_STONE.getMetadata()), 0.1F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_FINE_GRAVEL), new ItemStack(ModBlocks.BLOCK_GRAVEL_STONE, 1, BlockGravelStone.EnumType.FINE_GRAVEL_STONE.getMetadata()), 0.1F);

        if (ConfigurationHandler.smeltPumpkin)
        {
            GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
            GameRegistry.addSmelting(ModBlocks.BLOCK_FACELESS_PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
        }
    }

    private static void initBrewingRecipes()
    {
    }
}
