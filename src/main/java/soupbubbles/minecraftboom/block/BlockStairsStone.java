package soupbubbles.minecraftboom.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import soupbubbles.minecraftboom.block.base.BlockStairBase;

public class BlockStairsStone extends BlockStairBase
{
    public BlockStairsStone(IBlockState modelState, String name)
    {
        super(modelState, name);

        setHardness(2.0F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
    }
}
