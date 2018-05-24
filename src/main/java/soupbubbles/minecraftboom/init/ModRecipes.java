package soupbubbles.minecraftboom.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import soupbubbles.minecraftboom.block.BlockGravelStone;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.util.JsonRecipeGenerator;
import soupbubbles.minecraftboom.util.Utils;

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
        if (ModItems.ITEM_WITHER_BONE != null)
        {
            OreDictionary.registerOre("boneWithered", ModItems.ITEM_WITHER_BONE);
        }
        
        OreDictionary.registerOre("ingotBrickMagma", ModItems.ITEM_MAGMA_BRICK);
        OreDictionary.registerOre("pinecone", ModItems.ITEM_PINECONE);
        OreDictionary.registerOre("slicePumpkin", ModItems.ITEM_PUMPKIN_SLICE);

        OreDictionary.registerOre("blockCharcoal", ModBlocks.BLOCK_CHARCOAL);
        OreDictionary.registerOre("blockSugarCane", ModBlocks.BLOCK_SUGAR_CANE);
        OreDictionary.registerOre("blockReed", ModBlocks.BLOCK_SUGAR_CANE);
        OreDictionary.registerOre("blockSugar", ModBlocks.BLOCK_SUGAR);
        OreDictionary.registerOre("blockGunPowder", ModBlocks.BLOCK_GUNPOWDER);
        OreDictionary.registerOre("blockBlazePowder", ModBlocks.BLOCK_BLAZE_POWDER);

    }

    private static void initFurnaceRecipes()
    {
        GameRegistry.addSmelting(Blocks.SOUL_SAND, new ItemStack(ModBlocks.BLOCK_SOUL_GLASS), 0.1F);
        GameRegistry.addSmelting(Blocks.MAGMA, new ItemStack(ModItems.ITEM_MAGMA_BRICK), 0.1F);
        GameRegistry.addSmelting(Blocks.GRAVEL, new ItemStack(ModBlocks.BLOCK_GRAVEL_STONE, 1, BlockGravelStone.EnumType.GRAVEL_STONE.getMetadata()), 0.1F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BLOCK_FINE_GRAVEL), new ItemStack(ModBlocks.BLOCK_GRAVEL_STONE, 1, BlockGravelStone.EnumType.FINE_GRAVEL_STONE.getMetadata()), 0.1F);

        if (Utils.getConfigValue(ConfigurationHandler.smeltPumpkin, ConfigurationHandler.tweaks))
        {
            GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
            GameRegistry.addSmelting(ModBlocks.BLOCK_FACELESS_PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
        }
    }

    private static void initBrewingRecipes()
    {
    }
}
