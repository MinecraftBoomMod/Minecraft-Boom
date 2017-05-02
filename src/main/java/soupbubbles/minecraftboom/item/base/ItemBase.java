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
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class ItemBase extends Item
{
    //The first name of the item
    private final String BASE_NAME;
    
    //If the item has subitems, the names will be stored here
    public final String[] VARIANTS;

    //Only true if the item has a tooltip (most cases false)
    private boolean toolTip;

    
    //Takes the unlocalized name of the item, and subitem names
    public ItemBase(String name, String... variants)
    {
        super();
        //sets the registry name
        setRegistryName(name);
        //sets the unlocalized name
        setUnlocalizedName(name);
        //puts it in our creativetab
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        //tooltip
        setToolTip(false);
        //if there is more than 1 name the item has subtypes!
        setHasSubtypes(variants.length > 0);
        
        BASE_NAME = name;

        //stores the subitem names in the VARIANTS array of strings
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

    //sets the unlocalized name and add the MOD_ID in front so it won't get mixed up with other mods
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

    //adds the subitems to our creative tab (if the item has subitems)
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

    //tool tip method, only used if tooltip is set to true
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        if (toolTip)
        {
            tooltip.add(I18n.translateToLocal(getUnlocalizedName(stack) + ".tooltip"));
        }
    }

    //gets the variant names for registring the item models
    public String[] getVariants()
    {
        return VARIANTS;
    }

    //useless method there just in case
    public boolean hasToolTip()
    {
        return toolTip;
    }
    
    //this method I will probably remove or change (doesn't do much)
    public ItemBase setToolTip(boolean shouldHaveToolTip)
    {
        toolTip = shouldHaveToolTip;

        return this;
    }
}