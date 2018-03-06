package soupbubbles.minecraftboom.block.slab;

import soupbubbles.minecraftboom.reference.Names;

public class BlockTerracottaSlabDouble extends BlockTerracottaSlab
{
    public BlockTerracottaSlabDouble()
    {
        super(Names.BLOCK_DOUBLE_SLAB_TERRACOTTA);
    }

    @Override
    public boolean isDouble()
    {
        return true;
    }
}
