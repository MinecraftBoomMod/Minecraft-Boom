package soupbubbles.minecraftboom.tileentities;


import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileBase extends TileEntity
{
    @Override
    public final void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        deserializeBase(compound);
        deserialize(compound);
    }

    @Override
    public final NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        serializeBase(compound);
        return serialize(compound);
    }

    public void deserialize(NBTTagCompound tagCompound)
    {

    }

    void deserializeBase(NBTTagCompound tagCompound)
    {

    }

    public NBTTagCompound serialize(NBTTagCompound tagCompound)
    {
        return tagCompound;
    }


    NBTTagCompound serializeBase(NBTTagCompound tagCompound)
    {
        return tagCompound;
    }

    public void notifyUpdate() {
        getWorld().notifyBlockUpdate(getPos(), getWorld().getBlockState(getPos()), getWorld().getBlockState(getPos()), 3);
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
    {
        return oldState.getBlock() != newState.getBlock();
    }

    @Override
    public final SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(getPos(), -999, writeToNBT(new NBTTagCompound()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public final void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
        super.onDataPacket(net, pkt);
        readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public final NBTTagCompound getUpdateTag()
    {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public final void handleUpdateTag(NBTTagCompound tag)
    {
        readFromNBT(tag);
    }
}