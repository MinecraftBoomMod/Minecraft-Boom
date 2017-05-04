package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.MinecraftBoom;
import soupbubbles.minecraftboom.handler.GuiHandler;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.tileentity.TileEntityCraftingTable;

public class BlockCraftingTable extends BlockWorkbench
{

    public BlockCraftingTable()
    {
        super();
        setHardness(2.5F);
        setSoundType(SoundType.WOOD);
        setUnlocalizedName(Names.BLOCK_CRAFTING_TABLE_UNLOCALIZED);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            player.openGui(MinecraftBoom.instance, GuiHandler.CRAFTING_TABLE_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
    }

    public void breakBlock(World world, BlockPos blockPos, IBlockState blockState)
    {
        TileEntityCraftingTable tile = (TileEntityCraftingTable) world.getTileEntity(blockPos);
        
        if (tile != null)
        {
            tile.dropItems();
        }

        super.breakBlock(world, blockPos, blockState);
    }

    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityCraftingTable();
    }
}