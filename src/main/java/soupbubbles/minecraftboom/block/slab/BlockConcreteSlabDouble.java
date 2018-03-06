package soupbubbles.minecraftboom.block.slab;

import soupbubbles.minecraftboom.reference.Names;

public class BlockConcreteSlabDouble extends BlockConcreteSlab
{
    public BlockConcreteSlabDouble()
    {
        super(Names.BLOCK_DOUBLE_SLAB_CONCRETE);
    }

    @Override
    public boolean isDouble()
    {
        return true;
    }
}
