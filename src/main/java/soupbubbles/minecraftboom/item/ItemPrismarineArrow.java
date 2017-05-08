package soupbubbles.minecraftboom.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.entity.EntityPrismarineArrow;
import soupbubbles.minecraftboom.reference.Names;

public class ItemPrismarineArrow extends ItemArrow
{
	public ItemPrismarineArrow ()
	{
        setRegistryName(Names.ITEM_PRISMARINE_ARROW);
        setUnlocalizedName(Names.ITEM_PRISMARINE_ARROW);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_ITEM_TAB);
	}
	
	@Override
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
    	return new EntityPrismarineArrow(worldIn, shooter);
    }
    
	@Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == ItemPrismarineArrow.class;
    }
}
