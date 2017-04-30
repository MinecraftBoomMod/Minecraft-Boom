package soupbubbles.minecraftboom.item;

import soupbubbles.minecraftboom.block.BlockModSlab;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.item.base.ItemSlabBase;

public class ItemModSlab extends ItemSlabBase
{
    private final String[] VARIANTS = new String[BlockModSlab.EnumType.values().length];

    public ItemModSlab(BlockSlabBase block)
    {
        super(block, ModBlocks.BLOCK_HALF_SLAB_MOD, ModBlocks.BLOCK_DOUBLE_SLAB_MOD);

        for (int i = 0; i < VARIANTS.length; i++)
        {
            VARIANTS[i] = BlockModSlab.EnumType.byMetadata(i).getName();
        }
    }

    @Override
    public String[] getVariants()
    {
        return VARIANTS;
    }
}
