package soupbubbles.minecraftboom.handler;

import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
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
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        IBlockState state = world.getBlockState(pos);
        ItemStack stack = event.getItemStack();
        
        if(event.isCanceled() || !ConfigurationHandler.tweaks)
        {
            return;
        }

        if (stack != null)
        {
            if (stack.getItem() == Items.BLAZE_POWDER && state.getBlock() == Blocks.NETHER_WART && ConfigurationHandler.blazeBonemeal)
            {
                int i = ((Integer) state.getValue(BlockNetherWart.AGE)).intValue();

                if (i < 3)
                {
                    state = state.withProperty(BlockNetherWart.AGE, Integer.valueOf(i + 1));
                    world.setBlockState(pos, state, 2);
                    spawnGrowParticles(world, pos, 10);

                    if (!event.getEntityPlayer().capabilities.isCreativeMode)
                    {
                        stack.shrink(1);
                    }
                }
            }
            else if (stack.getItem() instanceof ItemSpade && event.getEntityPlayer().isSneaking() && ConfigurationHandler.removeSlimeBall)
            {
                if (state.getBlock() == Blocks.STICKY_PISTON)
                {
                    Utils.spawnEntityItem(world, pos.add(updatePiston(world, pos, state, stack, event.getEntityPlayer()).getDirectionVec()), Items.SLIME_BALL);
                }
                else if (state.getBlock() == Blocks.PISTON_HEAD)
                {
                    EnumFacing facing = (EnumFacing) state.getProperties().get(BlockPistonExtension.FACING);
                    BlockPistonExtension.EnumPistonType type = (BlockPistonExtension.EnumPistonType) state.getProperties().get(BlockPistonExtension.TYPE);
                    pos = pos.add(facing.getOpposite().getDirectionVec());

                    if (type == BlockPistonExtension.EnumPistonType.STICKY)
                    {
                        Utils.spawnEntityItem(world, pos.add(updatePiston(world, pos, world.getBlockState(pos), stack, event.getEntityPlayer()).getDirectionVec()), Items.SLIME_BALL);
                    }
                }
            }
        }
    }

    private static EnumFacing updatePiston(World world, BlockPos pos, IBlockState state, ItemStack stack, EntityPlayer player)
    {
        if (state.getBlock() == Blocks.STICKY_PISTON)
        {
            EnumFacing facing = (EnumFacing) state.getProperties().get(BlockPistonBase.FACING);
            Boolean extended = (Boolean) state.getProperties().get(BlockPistonBase.EXTENDED);

            world.setBlockState(pos, Blocks.PISTON.getBlockState().getBaseState().withProperty(BlockPistonBase.FACING, facing).withProperty(BlockPistonBase.EXTENDED, extended));

            if (extended)
            {
                world.setBlockState(pos.add(facing.getDirectionVec()), Blocks.PISTON_HEAD.getBlockState().getBaseState().withProperty(BlockPistonBase.FACING, (EnumFacing) state.getProperties().get(BlockPistonBase.FACING)).withProperty(BlockPistonExtension.SHORT, (Boolean) false).withProperty(BlockPistonExtension.TYPE, BlockPistonExtension.EnumPistonType.DEFAULT));
            }

            if (!player.capabilities.isCreativeMode)
            {
                stack.damageItem(1, player);
            }

            return facing;
        }

        return null;
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
