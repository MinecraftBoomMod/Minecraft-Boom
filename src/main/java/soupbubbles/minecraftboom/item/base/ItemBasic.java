package soupbubbles.minecraftboom.item.base;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import soupbubbles.minecraftboom.reference.Reference;

public class ItemBasic extends Item 
{

	public ItemBasic(String unlocalizedName)
	{
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	}
}
