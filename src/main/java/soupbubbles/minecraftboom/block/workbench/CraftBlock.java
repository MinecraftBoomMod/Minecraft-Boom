package soupbubbles.minecraftboom.block.workbench;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.handler.ModGuiHandler;

public class CraftBlock extends BlockWorkbench {

	public CraftBlock() {
		super();
		setUnlocalizedName("workbench");
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else {
			playerIn.openGui(MinecraftBoom.instance, ModGuiHandler.CRAFT, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
	}
	
    public void breakBlock(World world, BlockPos blockPos, IBlockState blockState)
    {
    	TileEntityCraft tileCraft = (TileEntityCraft) world.getTileEntity(blockPos);
        if (tileCraft != null)
        	tileCraft.dropItems();

        super.breakBlock(world, blockPos, blockState);
    }

    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityCraft();
    }
}