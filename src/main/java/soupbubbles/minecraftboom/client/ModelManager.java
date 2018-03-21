package soupbubbles.minecraftboom.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.item.base.ItemBase;
import soupbubbles.minecraftboom.item.base.ItemBlockMeta;
import soupbubbles.minecraftboom.reference.Assets;
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
        if (item instanceof ItemBase)
        {
            ItemBase itemBase = (ItemBase) item;

            if (item.getHasSubtypes() && itemBase.getVariants().length > 0)
            {
                List<ModelResourceLocation> modelResources = new ArrayList<>();

                for (int i = 0; i < itemBase.getVariants().length; i++)
                {
                    modelResources.add(new ModelResourceLocation(Assets.TEXTURE_PREFIX + itemBase.getVariants()[i]));
                }

                ModelBakery.registerItemVariants(item, modelResources.toArray(new ModelResourceLocation[0]));
                ModelLoader.setCustomMeshDefinition(item, itemStack -> modelResources.get(itemStack.getMetadata()));
            }
            else
            {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString()));
            }
        }
        else
        {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString()));
        }

        itemsRegistered.add(item);
    }

    private void initBlockModels(Block block)
    {
        Item item = Item.getItemFromBlock(block);

        if (item instanceof ItemBlockMeta)
        {
            ItemBlockMeta itemBlock = (ItemBlockMeta) item;

            if (item.getHasSubtypes() && itemBlock.getVariants().length > 0)
            {
                List<ModelResourceLocation> modelResources = new ArrayList<>();
                
                for (int i = 0; i < itemBlock.getVariants().length; i++)
                {
                    String name = itemBlock.getVariantName() + "=" + itemBlock.getVariants()[i];
                    
                    if (block instanceof BlockSlabBase)
                    {
                        if (((BlockSlabBase)block).isDouble())
                        {
                            ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), name.replace("variant", "half=top,variant")));
                        }
                        else
                        {
                            ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), name));
                        }

                    }
                    else
                    {
                        ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), name));
                    }
                }
            }
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