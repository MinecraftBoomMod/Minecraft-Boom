package soupbubbles.minecraftboom.handler;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.util.Utils;

@Mod.EventBusSubscriber
public class PlayerEventHandler
{
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        IBlockState blockstate = event.getWorld().getBlockState(event.getPos());
        ItemStack stack = event.getItemStack();
        World world = event.getWorld();
        BlockPos pos = event.getPos();

        if (stack != null)
        {
            if (stack.getItem() instanceof ItemSpade && blockstate.getBlock() == Blocks.STICKY_PISTON)
            {
                PropertyBool EXTENDED = PropertyBool.create("extended");
                PropertyDirection FACING = PropertyDirection.create("facing");
                boolean extended =  (boolean) blockstate.getProperties().get(EXTENDED);
                EnumFacing facing = (EnumFacing) blockstate.getProperties().get(FACING);
                
                blockstate = Blocks.PISTON.getBlockState().getBaseState().withProperty(FACING, facing).withProperty(EXTENDED, extended);
                world.setBlockState(event.getPos(), blockstate);
                Utils.spawnEntityItem(world, pos.add(facing.getDirectionVec()), Items.SLIME_BALL);
                
                if(!event.getEntityPlayer().capabilities.isCreativeMode)
                {
                    stack.damageItem(1, event.getEntityPlayer());
                }
            }
            else if (stack.getItem() == Items.BLAZE_POWDER && blockstate.getBlock() == Blocks.NETHER_WART)
            {
                PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
                int i = ((Integer) blockstate.getValue(AGE)).intValue();

                if (i < 3)
                {
                    blockstate = blockstate.withProperty(AGE, Integer.valueOf(i + 1));
                    world.setBlockState(pos, blockstate, 2);
                    spawnGrowParticles(world, pos, 10);
                    
                    if(!event.getEntityPlayer().capabilities.isCreativeMode)
                    {
                        stack.shrink(1);
                    }
                }
            }
        }
        
        event.setResult(Result.ALLOW);
    }

    @SideOnly(Side.CLIENT)
    public static void spawnGrowParticles(World world, BlockPos pos, int amount)
    {
        if (amount == 0)
        {
            amount = 15;
        }

        IBlockState iblockstate = world.getBlockState(pos);

        if (iblockstate.getMaterial() != Material.AIR)
        {
            for (int i = 0; i < amount; ++i)
            {
                double d0 = world.rand.nextGaussian() * 0.02D;
                double d1 = world.rand.nextGaussian() * 0.02D;
                double d2 = world.rand.nextGaussian() * 0.02D;
                world.spawnParticle(EnumParticleTypes.FLAME, (double) ((float) pos.getX() + world.rand.nextFloat()), (double) pos.getY() + (double) world.rand.nextFloat() * iblockstate.getBoundingBox(world, pos).maxY, (double) ((float) pos.getZ() + world.rand.nextFloat()), d0, d1, d2, new int[0]);
            }
        }
        else
        {
            for (int i1 = 0; i1 < amount; ++i1)
            {
                double d0 = world.rand.nextGaussian() * 0.02D;
                double d1 = world.rand.nextGaussian() * 0.02D;
                double d2 = world.rand.nextGaussian() * 0.02D;
                world.spawnParticle(EnumParticleTypes.FLAME, (double) ((float) pos.getX() + world.rand.nextFloat()), (double) pos.getY() + (double) world.rand.nextFloat() * 1.0f, (double) ((float) pos.getZ() + world.rand.nextFloat()), d0, d1, d2, new int[0]);
            }
        }
    }

}
