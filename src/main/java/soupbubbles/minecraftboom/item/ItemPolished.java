package soupbubbles.minecraftboom.item;

import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.item.base.ItemBlockMeta;

public class ItemPolished extends ItemBlockMeta
{
    private final String[] VARIANTS = new String[BlockPolished.EnumType.values().length];

    public ItemPolished()
    {
        super(ModBlocks.BLOCK_POLISHED);

        for (int i = 0; i < VARIANTS.length; i++)
        {
            VARIANTS[i] = BlockPolished.EnumType.byMetadata(i).getName();
        }
    }

    @Override
    public String[] getVariants()
    {
        return VARIANTS;
    }
}
