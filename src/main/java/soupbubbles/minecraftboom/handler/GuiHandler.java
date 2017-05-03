package soupbubbles.minecraftboom.handler;

import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import soupbubbles.minecraftboom.inventory.ContainerCraftingTable;
import soupbubbles.minecraftboom.tileentity.TileEntityCraftingTable;

public class GuiHandler implements IGuiHandler
{
    public static final int CRAFTING_TABLE_ID = 0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case CRAFTING_TABLE_ID:
                return new ContainerCraftingTable(player.inventory, world, new BlockPos(x, y, z), (TileEntityCraftingTable) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case CRAFTING_TABLE_ID:
                return new GuiCrafting(player.inventory, world, new BlockPos(x, y, z));
            default:
                return null;
        }
    }

}