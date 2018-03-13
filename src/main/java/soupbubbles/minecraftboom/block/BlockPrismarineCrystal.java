package soupbubbles.minecraftboom.block;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.reference.BlockValues;
import soupbubbles.minecraftboom.reference.Names;

public class BlockPrismarineCrystal extends BlockBase
{
    public BlockPrismarineCrystal()
    {
        super(Material.GLASS, Names.BLOCK_PRISMARINE_CRYSTAL, SoundType.GLASS);
        setHardness(BlockValues.GLASS_HARDNESS);
        setResistance(BlockValues.GLASS_RESISTANCE);
        setLightLevel(0.2F);
    }
    
    @Override
    public boolean canSilkHarvest()
    {
        return true;
    }
    
    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(3);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.PRISMARINE_CRYSTALS;
    }
}
