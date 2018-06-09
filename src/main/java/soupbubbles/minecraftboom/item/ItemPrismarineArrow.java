package soupbubbles.minecraftboom.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.entity.EntityPrismarineArrow;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.util.IDisableable;

public class ItemPrismarineArrow extends ItemArrow implements IDisableable
{
    public ItemPrismarineArrow()
    {
        setRegistryName(Names.ITEM_PRISMARINE_ARROW);
        setUnlocalizedName(Names.ITEM_PRISMARINE_ARROW);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return String.format(Assets.ITEM_PREFIX, Assets.ASSET_PREFIX, Names.ITEM_PRISMARINE_ARROW);
    }

    @Override
    public EntityArrow createArrow(World world, ItemStack stack, EntityLivingBase shooter)
    {
        return new EntityPrismarineArrow(world, shooter);
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == ItemPrismarineArrow.class;
    }
    
    @Override
    public void registerConfig()
    {
        ConfigurationHandler.allowedItems.add(ConfigurationHandler.loadPropBool(Names.ITEM_PRISMARINE_ARROW, ConfigurationHandler.CATEGORY_ITEMS, "", true));
        ConfigurationHandler.saveConfiguration();
    }

    @Override
    public boolean isEnabled()
    {
        return ConfigurationHandler.configuration.get(ConfigurationHandler.CATEGORY_ITEMS + "." + Names.ITEM_PRISMARINE_ARROW, Names.ITEM_PRISMARINE_ARROW, true).getBoolean();
    }
}
