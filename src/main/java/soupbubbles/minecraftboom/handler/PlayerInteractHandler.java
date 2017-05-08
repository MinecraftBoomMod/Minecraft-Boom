package soupbubbles.minecraftboom.handler;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PlayerInteractHandler {
	
	@SubscribeEvent
	public static void PlayerInteract(PlayerInteractEvent event)
	{	
		IBlockState blockstate = event.getWorld().getBlockState(event.getPos());
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		ItemStack item = event.getItemStack();
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		WorldServer worldServer;
		
		final PropertyBool EXTENDED = PropertyBool.create("extended");
		final PropertyDirection FACING = PropertyDirection.create("facing");
		final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
		
		
		//On rightclick not on both musst added
		
		if (!world.isRemote)
		{
			worldServer = (WorldServer) world;
//all about Shovel and Sticky Pistons
			//if(item.getUnlocalizedName().matches(".*shovel.*") && block.equals(Blocks.STICKY_PISTON))
			if(item.getItem() instanceof ItemSpade && block.equals(Blocks.STICKY_PISTON))
			{
				blockstate = Blocks.PISTON.getBlockState().getBaseState().withProperty(FACING, (EnumFacing) blockstate.getProperties().get(FACING)).withProperty(EXTENDED, (Boolean) blockstate.getProperties().get(EXTENDED));
				worldServer.setBlockState(event.getPos(), blockstate);
				event.getEntityPlayer().entityDropItem(new ItemStack(Items.SLIME_BALL), 0F);
			}
//end about Shovel and Sticky Pistons
			
//all about NETHER_WART and blaze powder
			if(item.getUnlocalizedName().matches("item.blazePowder")  && block.equals(Blocks.NETHER_WART))
			{
//				block.updateTick(world, event.getPos(), blockstate, world.rand);
				
		        int i = ((Integer)blockstate.getValue(AGE)).intValue();
		        if (i < 3)
		        {
		        	blockstate = blockstate.withProperty(AGE, Integer.valueOf(i + 1));
		        	worldServer.setBlockState(pos, blockstate, 2);
		            worldServer.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,  (double) pos.getX()+0.5F, (double) pos.getY(), (double) pos.getZ()+0.5F, 30, 0.2F, 0.4F, 0.2F, 5F);
		            
		            
//		            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, blockstate, world.getBlockState(pos));
		        }
			}
//end about netherwarth and blaze powder		
			
		}
	}
}
