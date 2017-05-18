package soupbubbles.minecraftboom.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.block.base.BlockFallingBase;
import soupbubbles.minecraftboom.reference.Names;

public class BlockGunpowder extends BlockFallingBase
{
    public BlockGunpowder()
    {
        super(Names.BLOCK_GUNPOWDER);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = player.getHeldItem(hand);

        if (stack != null && stack.getItem() instanceof ItemFlintAndSteel)
        {
            explode(world, pos, player);
            stack.damageItem(1, player);

            return true;
        }

        return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        if (entity instanceof EntityArrow && entity.isBurning())
        {
            explode(world, pos, ((EntityArrow) entity).shootingEntity);
            
            if (!world.isRemote)
            {
                entity.setDead();
            }
        }
    }

    private void explode(World world, BlockPos pos, Entity entity)
    {
        if (!world.isRemote)
        {
            world.createExplosion(entity, pos.getX(), pos.getY(), pos.getZ(), 1.0F, true);
        }
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosion)
    {
        return false;
    }
}
