package soupbubbles.minecraftboom.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.util.JsonRecipeGenerator;

public class ModRecipes
{

    public static void init()
    {
        JsonRecipeGenerator.init();
        
        initFurnaceRecipes();
        initBrewingRecipes();
    }

    private static void initFurnaceRecipes()
    {
        GameRegistry.addSmelting(Blocks.SOUL_SAND, new ItemStack(ModBlocks.BLOCK_SOUL_GLASS), 0.1F);
        GameRegistry.addSmelting(Blocks.MAGMA, new ItemStack(ModItems.ITEM_MAGMA_BRICK), 0.1F);

        if (ConfigurationHandler.smeltPumpkin && ConfigurationHandler.tweaks)
        {
            GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
            GameRegistry.addSmelting(ModBlocks.BLOCK_FACELESS_PUMPKIN, new ItemStack(Items.DYE, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0.1F);
        }
    }

    private static void initBrewingRecipes()
    {
    }
}
