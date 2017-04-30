package soupbubbles.minecraftboom.block;

import soupbubbles.minecraftboom.reference.Names;

public class BlockVanillaSlabHalf extends BlockVanillaSlab
{
    public BlockVanillaSlabHalf()
    {
        super(Names.BLOCK_HALF_SLAB_VANILLA);
    }

    @Override
    public boolean isDouble()
    {
        return false;
    }
}
