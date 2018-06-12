package soupbubbles.minecraftboom.util;

import net.minecraft.block.Block;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.block.base.BlockStairBase;

public interface IStairSlab
{
    public Block addStairSlab();
    
    public boolean hasStairSlab();

    public BlockStairBase setStair(BlockStairBase stair);
    
    public BlockSlabBase setSlab(BlockSlabBase slab);
    
    public BlockStairBase getStair();
    
    public BlockSlabBase getSlab();
}
