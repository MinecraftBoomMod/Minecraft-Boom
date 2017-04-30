package soupbubbles.minecraftboom.item;

import soupbubbles.minecraftboom.block.BlockVanillaSlab;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.item.base.ItemSlabBase;

public class ItemVanillaSlab extends ItemSlabBase
{
    private final String[] VARIANTS = new String[BlockVanillaSlab.EnumType.values().length];

    public ItemVanillaSlab(BlockSlabBase block)
    {
        super(block, ModBlocks.BLOCK_HALF_SLAB_VANILLA, ModBlocks.BLOCK_DOUBLE_SLAB_VANILLA);

        for (int i = 0; i < VARIANTS.length; i++)
        {
            VARIANTS[i] = BlockVanillaSlab.EnumType.byMetadata(i).getName();
        }
    }

    @Override
    public String[] getVariants()
    {
        return VARIANTS;
    }
}
