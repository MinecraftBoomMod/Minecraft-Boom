package soupbubbles.minecraftboom.item.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.entity.EntityGrenade;
import soupbubbles.minecraftboom.reference.Assets;

public class ItemGrenadeBase extends ItemBase 
{	
	public ItemGrenadeBase(String name,  String... variants) 
	{
		super(name, variants);
	}   
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) 
	{
		
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
        {
        	EntityGrenade entityGrenade = new EntityGrenade(world, player);
            entityGrenade.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(entityGrenade);
        }

        player.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);

	}
	
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		return true;
	}
}
