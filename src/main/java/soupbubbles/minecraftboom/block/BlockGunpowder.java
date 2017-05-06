package soupbubbles.minecraftboom.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
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
            if (!world.isRemote)
            {
                world.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 1.0F, true);
            }
            
            stack.damageItem(1, player);
            
            return true;
        }

        return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
    }
    
    @Override
    public boolean canDropFromExplosion(Explosion explosion)
    {
        return false;
    }
}
