package soupbubbles.minecraftboom.block.slab;

import soupbubbles.minecraftboom.reference.Names;

public class BlockConcreteSlabHalf extends BlockConcreteSlab
{
    public BlockConcreteSlabHalf()
    {
        super(Names.BLOCK_HALF_SLAB_CONCRETE);
    }

    @Override
    public boolean isDouble()
    {
        return false;
    }
}
