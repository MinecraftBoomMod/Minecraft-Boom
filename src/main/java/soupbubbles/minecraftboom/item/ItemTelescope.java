package soupbubbles.minecraftboom.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.item.base.ItemBase;
import soupbubbles.minecraftboom.lib.Names;

public class ItemTelescope extends ItemBase
{
    public ItemTelescope()
    {
        super(Names.ITEM_TELESCOPE);
        setMaxStackSize(1);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        
        if (stack != null)
        {
            player.setActiveHand(hand);
            
            return new ActionResult(EnumActionResult.SUCCESS, stack);
        }
        
        return new ActionResult(EnumActionResult.FAIL, stack);
    }
}
