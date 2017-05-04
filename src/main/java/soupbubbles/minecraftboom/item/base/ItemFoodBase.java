package soupbubbles.minecraftboom.item.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.creativetab.CreativeTab;

public class ItemFoodBase extends ItemFood
{
	private PotionEffect[] effects;

	public ItemFoodBase(String name, int amount, boolean isWolfFood, PotionEffect...potionEffects)
	{
		super(amount, isWolfFood);
		this.effects = potionEffects;
		
		//sets the registry name
        setRegistryName(name);
        //sets the unlocalized name
        setUnlocalizedName(name);
        //puts it in our creativetab
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
	}

	public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects)
	{
		super(amount, saturation, isWolfFood);
		this.effects = potionEffects;
		
		//sets the registry name
        setRegistryName(name);
        //sets the unlocalized name
        setUnlocalizedName(name);
        //puts it in our creativetab
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		//Adds all the potion effects specified
		for (PotionEffect effect : effects) {
			player.addPotionEffect(effect);
		}
	}

}
