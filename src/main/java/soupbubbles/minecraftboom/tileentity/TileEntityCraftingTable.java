package soupbubbles.minecraftboom.tileentity;

import soupbubbles.minecraftboom.reference.Names;

public class TileEntityCraftingTable extends TileEntityInventory
{
    public TileEntityCraftingTable()
    {
        super(10, Names.BLOCK_CRAFTING_TABLE);
    }
}