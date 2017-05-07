package soupbubbles.minecraftboom.handler;

import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
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
		
//		if(item.getUnlocalizedName().matches(".*shovel.*") && block.equals(Blocks.STICKY_PISTON))
		if(item.getItem() instanceof ItemSpade && block.equals(Blocks.STICKY_PISTON))
		{
			EnumFacing facing = EnumFacing.UP;
			Boolean extended = Boolean.valueOf(false);

			if(blockstate.getProperties().get(FACING)==EnumFacing.NORTH)facing = EnumFacing.NORTH;
			if(blockstate.getProperties().get(FACING)==EnumFacing.WEST) facing = EnumFacing.WEST;
			if(blockstate.getProperties().get(FACING)==EnumFacing.SOUTH) facing = EnumFacing.SOUTH;
			if(blockstate.getProperties().get(FACING)==EnumFacing.EAST) facing = EnumFacing.EAST;
			if(blockstate.getProperties().get(FACING)==EnumFacing.UP) facing = EnumFacing.UP;
			if(blockstate.getProperties().get(FACING)==EnumFacing.DOWN) facing = EnumFacing.DOWN;
			
			if(blockstate.getProperties().get(EXTENDED)==Boolean.valueOf(true)) extended = Boolean.valueOf(true);
				
			
			event.getWorld().setBlockState(event.getPos(), Blocks.PISTON.getBlockState().getBaseState().withProperty(FACING, facing).withProperty(EXTENDED, extended));
			
		}
	}
}
