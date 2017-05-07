package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockColored;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.reference.Names;

public class BlockWool extends BlockColored
{
    public BlockWool()
    {
        super(Material.CLOTH);
        setHardness(0.8F);
        setSoundType(SoundType.CLOTH);
        setUnlocalizedName(Names.CLOTH);
    }
    
    @Override
    public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance)
    {
        entity.fall(fallDistance, 0.2F);
    }
}
