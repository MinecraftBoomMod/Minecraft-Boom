package soupbubbles.minecraftboom.handler;

import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import soupbubbles.minecraftboom.block.workbench.ContainerNewWorkbench;
import soupbubbles.minecraftboom.block.workbench.TileEntityCraft;

public class ModGuiHandler implements IGuiHandler {

	public static final int CRAFT = 0;

	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case CRAFT:
			System.out.println("getServerGuiElement");
			return new ContainerNewWorkbench(player.inventory, world, new BlockPos(x, y, z), (TileEntityCraft) world.getTileEntity(new BlockPos(x, y, z)));
		default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case CRAFT:
			System.out.println("getClientGuiElement");
			return new GuiCrafting(player.inventory, world, new BlockPos(x, y, z));
		default:
				return null;
		}
	}
	

}