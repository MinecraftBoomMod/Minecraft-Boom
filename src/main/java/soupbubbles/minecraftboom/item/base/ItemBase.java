package soupbubbles.minecraftboom.item.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.util.IDisableable;

public class ItemBase extends Item implements IDisableable
{
    protected final String BASE_NAME;
    public final String[] VARIANTS;

    public ItemBase(String name, String... variants)
    {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setHasSubtypes(variants.length > 0);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);

        BASE_NAME = name;

        if (hasSubtypes)
        {
            VARIANTS = new String[variants.length + 1];
            VARIANTS[0] = name;

            for (int i = 0; i < variants.length; i++)
            {
                VARIANTS[i + 1] = variants[i];
            }
        }
        else
        {
            VARIANTS = new String[0];
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        if (hasSubtypes && stack.getMetadata() < VARIANTS.length)
        {
            return String.format(Assets.ITEM_PREFIX, Assets.ASSET_PREFIX, VARIANTS[Math.abs(stack.getMetadata() % VARIANTS.length)]);
        }
        else
        {
            return String.format(Assets.ITEM_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (getHasSubtypes() && VARIANTS.length > 0)
        {
            for (int meta = 0; meta < VARIANTS.length; ++meta)
            {
                items.add(new ItemStack(this, 1, meta));
            }
        }
        else
        {
            super.getSubItems(tab, items);
        }
    }

    public String[] getVariants()
    {
        return VARIANTS;
    }

    @Override
    public void registerConfig()
    {
        ConfigurationHandler.allowedItems.add(ConfigurationHandler.loadPropBool(BASE_NAME, ConfigurationHandler.CATEGORY_ITEMS, "", true));
        ConfigurationHandler.saveConfiguration();
    }

    @Override
    public boolean isEnabled()
    {
        return ConfigurationHandler.configuration.get(ConfigurationHandler.CATEGORY_ITEMS + "." + BASE_NAME, BASE_NAME, true).getBoolean();
    }
}