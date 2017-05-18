package soupbubbles.minecraftboom.tileentity;

import soupbubbles.minecraftboom.block.base.BlockChestBase;
import soupbubbles.minecraftboom.reference.Assets;

public class TileEntityChestBase extends TileEntityInventory
{
    protected final BlockChestBase block;

    public TileEntityChestBase()
    {
        super(27, "");

        block = (BlockChestBase) blockType;
    }

    @Override
    public String getName()
    {
        return hasCustomName() ? "customname" : String.format(Assets.CONATINER_PREFIX, Assets.ASSET_PREFIX, block.getType().getName());
    }
}
