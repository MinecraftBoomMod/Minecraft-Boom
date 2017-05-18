package soupbubbles.minecraftboom.block.slab;

import soupbubbles.minecraftboom.reference.Names;

public class BlockModSlabDouble extends BlockModSlab
{
    public BlockModSlabDouble()
    {
        super(Names.BLOCK_DOUBLE_SLAB_MOD);
    }

    @Override
    public boolean isDouble()
    {
        return true;
    }
}
