package soupbubbles.minecraftboom.block.slab;

import soupbubbles.minecraftboom.reference.Names;

public class BlockTerracottaBricksSlabDouble extends BlockTerracottaBricksSlab
{
    public BlockTerracottaBricksSlabDouble()
    {
        super(Names.BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS);
    }

    @Override
    public boolean isDouble()
    {
        return true;
    }
}
