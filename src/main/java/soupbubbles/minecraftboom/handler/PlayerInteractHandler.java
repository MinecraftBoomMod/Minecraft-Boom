package soupbubbles.minecraftboom.handler;

import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PlayerInteractHandler {
	
	@SubscribeEvent
	public static void PlayerInteract(PlayerInteractEvent event)
	{
		final PropertyBool EXTENDED = PropertyBool.create("extended");
		final PropertyDirection FACING = PropertyDirection.create("facing");
		
		
		IBlockState blockstate = event.getWorld().getBlockState(event.getPos());
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		ItemStack item = event.getItemStack();
		World world = event.getWorld();
		
		if (!world.isRemote)
		{
//			if(item.getUnlocalizedName().matches(".*shovel.*") && block.equals(Blocks.STICKY_PISTON))
			if(item.getItem() instanceof ItemSpade && block.equals(Blocks.STICKY_PISTON))
			{
				world.setBlockState(event.getPos(), Blocks.PISTON.getBlockState().getBaseState().withProperty(FACING, (EnumFacing) blockstate.getProperties().get(FACING)).withProperty(EXTENDED, (Boolean) blockstate.getProperties().get(EXTENDED)));
				event.getEntityPlayer().entityDropItem(new ItemStack(Items.SLIME_BALL), 0F);
			}
			
		}
	}
}
