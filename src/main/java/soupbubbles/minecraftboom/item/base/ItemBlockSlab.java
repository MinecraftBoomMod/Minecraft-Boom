package soupbubbles.minecraftboom.item.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;

public class ItemBlockSlab extends ItemBlock
{
    public ItemBlockSlab(BlockSlabBase block)
    {
        super(block);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!itemstack.isEmpty() && player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            IBlockState iblockstate = world.getBlockState(pos);

            if (iblockstate.getBlock() == block)
            {
                BlockSlabBase.EnumBlockSlab type = iblockstate.getValue(BlockSlabBase.TYPE);

                if ((facing == EnumFacing.UP && type == BlockSlabBase.EnumBlockSlab.BOTTOM || facing == EnumFacing.DOWN && type == BlockSlabBase.EnumBlockSlab.TOP))
                {
                    IBlockState iblockstate1 = block.getDefaultState().withProperty(BlockSlabBase.TYPE, BlockSlabBase.EnumBlockSlab.DOUBLE);
                    AxisAlignedBB axisalignedbb = iblockstate1.getCollisionBoundingBox(world, pos);

                    if (axisalignedbb != Block.NULL_AABB && world.checkNoEntityCollision(axisalignedbb.offset(pos)) && world.setBlockState(pos, iblockstate1, 11))
                    {
                        SoundType soundtype = block.getSoundType(iblockstate1, world, pos, player);
                        world.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                        itemstack.shrink(1);
                    }

                    return EnumActionResult.SUCCESS;
                }
            }

            return tryPlace(player, itemstack, world, pos.offset(facing)) ? EnumActionResult.SUCCESS : super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }

    private boolean tryPlace(EntityPlayer player, ItemStack stack, World world, BlockPos pos)
    {
        IBlockState iblockstate = world.getBlockState(pos);

        if (iblockstate.getBlock() == block)
        {
            IBlockState iblockstate1 = block.getDefaultState().withProperty(BlockSlabBase.TYPE, BlockSlabBase.EnumBlockSlab.DOUBLE);
            AxisAlignedBB axisalignedbb = iblockstate1.getCollisionBoundingBox(world, pos);

            if (axisalignedbb != Block.NULL_AABB && world.checkNoEntityCollision(axisalignedbb.offset(pos)) && world.setBlockState(pos, iblockstate1, 11))
            {
                SoundType soundtype = block.getSoundType(iblockstate1, world, pos, player);
                world.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                stack.shrink(1);
            }

            return true;
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
    {
        BlockPos blockpos = pos;
        IBlockState iblockstate = world.getBlockState(pos);

        if (iblockstate.getBlock() == block)
        {
            boolean flag = iblockstate.getValue(BlockSlabBase.TYPE) == BlockSlabBase.EnumBlockSlab.TOP;

            if ((side == EnumFacing.UP && !flag || side == EnumFacing.DOWN && flag))
            {
                return true;
            }
        }

        pos = pos.offset(side);
        IBlockState iblockstate1 = world.getBlockState(pos);
        return iblockstate1.getBlock() == block ? true : super.canPlaceBlockOnSide(world, blockpos, side, player, stack);
    }
}
