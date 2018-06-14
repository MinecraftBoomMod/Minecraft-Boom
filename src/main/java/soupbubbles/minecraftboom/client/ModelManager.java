package soupbubbles.minecraftboom.client;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.lib.Assets;
import soupbubbles.minecraftboom.util.IRenderItem;

@SideOnly(Side.CLIENT)
public class ModelManager
{
    public static final ModelManager INSTANCE = new ModelManager();
    private final Set<Item> itemsRegistered = new HashSet<>();

    private ModelManager()
    {
    }

    public void registerAllModels()
    {
        registerBlockModels();
        registerItemModels();
    }

    private void registerBlockModels()
    {
        ModBlocks.BLOCKS.stream().filter(block -> !itemsRegistered.contains(Item.getItemFromBlock(block))).forEach(this::initBlockModels);
    }

    private void registerItemModels()
    {
        ModItems.ITEMS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::initItemModels);
    }

    private void initItemModels(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString()));
        itemsRegistered.add(item);
    }

    private void initBlockModels(Block block)
    {
        Item item = Item.getItemFromBlock(block);

        if (block instanceof BlockSlabBase)
        {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName().toString(), "type=bottom"));
        }
        else if (block instanceof IRenderItem)
        {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName().toString(), Assets.VARIANT_NAME_ITEM + "=true"));
        }
        else
        {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName().toString()));
        }

        itemsRegistered.add(item);
    }
}