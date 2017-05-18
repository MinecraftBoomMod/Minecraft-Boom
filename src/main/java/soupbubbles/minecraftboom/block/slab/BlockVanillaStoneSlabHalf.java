package soupbubbles.minecraftboom.block.slab;

import soupbubbles.minecraftboom.reference.Names;

public class BlockVanillaStoneSlabHalf extends BlockVanillaStoneSlab
{
    public BlockVanillaStoneSlabHalf()
    {
        super(Names.BLOCK_HALF_SLAB_VANILLA_STONE);
    }

    @Override
    public boolean isDouble()
    {
        return false;
    }
}
