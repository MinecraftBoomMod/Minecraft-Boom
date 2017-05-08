package soupbubbles.minecraftboom.item.base;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.creativetab.CreativeTabBlocks;
import soupbubbles.minecraftboom.creativetab.CreativeTabItems;
import soupbubbles.minecraftboom.reference.Assets;

public class ItemBase extends Item
{
    protected final String BASE_NAME;
    public final String[] VARIANTS;
    private boolean toolTip;

    public ItemBase(String name, String... variants)
    {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabItems.MINECRAFTBOOM_ITEMS_TAB);
        setToolTip(false);
        setHasSubtypes(variants.length > 0);
        
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
    public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> list)
    {
        if (getHasSubtypes() && VARIANTS.length > 0)
        {
            for (int meta = 0; meta < VARIANTS.length; ++meta)
            {
                list.add(new ItemStack(this, 1, meta));
            }
        }
        else
        {
            super.getSubItems(item, tab, list);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        if (toolTip)
        {
            tooltip.add(I18n.translateToLocal(getUnlocalizedName(stack) + ".tooltip"));
        }
    }

    public String[] getVariants()
    {
        return VARIANTS;
    }

    public boolean hasToolTip()
    {
        return toolTip;
    }
    
    public ItemBase setToolTip(boolean shouldHaveToolTip)
    {
        toolTip = shouldHaveToolTip;

        return this;
    }
}