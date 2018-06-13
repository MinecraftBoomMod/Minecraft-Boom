package soupbubbles.minecraftboom.block;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.reference.BlockValues;

public class BlockBookShelf extends BlockBase
{
    protected final String BASE_NAME;

    public BlockBookShelf(String name)
    {
        super(Material.WOOD, name, SoundType.WOOD);
        setHardness(BlockValues.BOOKSHELF_HARDNESS);
        setResistance(BlockValues.BOOKSHELF_RESISTANCE);
        
        BASE_NAME = name; 
    }

	@Override
	public float getEnchantPowerBonus(World world, BlockPos pos) 
	{
		return 1;
	}
	
	@Override
    public int quantityDropped(Random random)
    {
        return 3;
    }

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.BOOK;
    }
}
