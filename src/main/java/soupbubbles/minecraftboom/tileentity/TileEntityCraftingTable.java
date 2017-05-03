package soupbubbles.minecraftboom.tileentity;

import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.tileentities.TileInventory;

public class TileEntityCraftingTable extends TileInventory
{

    public TileEntityCraftingTable()
    {
        super(10, Names.BLOCK_CRAFTING_TABLE);
    }
}