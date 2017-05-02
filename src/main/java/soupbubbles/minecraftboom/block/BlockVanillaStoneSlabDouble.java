package soupbubbles.minecraftboom.block;

import soupbubbles.minecraftboom.reference.Names;

public class BlockVanillaStoneSlabDouble extends BlockVanillaStoneSlab
{
    public BlockVanillaStoneSlabDouble()
    {
        super(Names.BLOCK_DOUBLE_SLAB_VANILLA_STONE);
    }

    @Override
    public boolean isDouble()
    {
        return true;
    }

}
