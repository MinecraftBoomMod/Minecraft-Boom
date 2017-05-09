package soupbubbles.minecraftboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Names;

public class BlockModFlower extends BlockBush
{
	
    public BlockModFlower(String name)
    {
    	setHardness(0.0F);
    	setRegistryName(name);
    	setUnlocalizedName(name);
    	setCreativeTab(CreativeTab.MINECRAFTBOOM_ITEM_TAB);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return super.getBoundingBox(state, source, pos).move(state.getOffset(source, pos));
    }

    /**
     * Get the OffsetType for this Block. Determines if the model is rendered slightly offset.
     */
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

}
