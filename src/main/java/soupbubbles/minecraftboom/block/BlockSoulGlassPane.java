package soupbubbles.minecraftboom.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockPaneBase;
import soupbubbles.minecraftboom.reference.BlockValues;
import soupbubbles.minecraftboom.reference.Names;

public class BlockSoulGlassPane extends BlockPaneBase
{
    public BlockSoulGlassPane()
    {
        super(Material.GLASS, Names.BLOCK_SOUL_GLASS_PANE, SoundType.GLASS, false);
        setHardness(BlockValues.GLASS_HARDNESS);
        setResistance(BlockValues.GLASS_RESISTANCE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
