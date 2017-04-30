package soupbubbles.minecraftboom.block;

import soupbubbles.minecraftboom.reference.Names;

public class BlockVanillaSlabDouble extends BlockVanillaSlab
{
    public BlockVanillaSlabDouble()
    {
        super(Names.BLOCK_DOUBLE_SLAB_VANILLA);
    }

    @Override
    public boolean isDouble()
    {
        return true;
    }

}
